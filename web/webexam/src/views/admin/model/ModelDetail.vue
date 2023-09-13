<template>
    <div>
        <el-row>
            <el-button type="success" plain @click="handleToSave">添加题型及数量</el-button>
        </el-row>
        <el-table
                :data="pageInfo.list"
                style="width: 100%"
                :router="true"
        >
            <el-table-column prop="id" label="Id" ></el-table-column>
            <el-table-column prop="questionType.type" label="题目类型" ></el-table-column>
            <el-table-column prop="questionCount" label="题目数量" ></el-table-column>
            <el-table-column label="操作" >
                <template slot-scope="scope">
                    <el-button type="primary" icon="el-icon-edit" circle @click="handleToUpdateCount(scope.row.id)"></el-button>
                    <el-button type="danger" icon="el-icon-delete" circle @click="handleDelete(scope.row.id)"></el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
                @current-change="handleList"
                background
                layout="prev, pager, next"
                :page-size="pageInfo.pageSize"
                :total="pageInfo.total">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        name: "modelDetail",
        data(){
            return{
                pageInfo:{
                    questionType:''
                },
                paperModels:[]
            }
        },
        created() {
            this.handleList(this.$route.query.id);
        },
        methods:{
            handleToSave(){
                this.$router.push({path:'/admin/model/save',query:{id:this.$route.query.id}});
            },
            handleToUpdateCount(id){
                this.$router.push({path:"/admin/model/update",query: { id: id }});
            },
            handleList(id){
                this.$axios.get("manage/paperModel/select?id="+id)
                    .then(res=>{
                        this.pageInfo = res.data.data;
                    });
            },
            handleDelete(id){
                this.$confirm('此操作将删除该题目模板, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$axios.post("manage/paperModel/delete?id="+id).then(res=>{
                        this.handleList(1);
                    })
                }).catch(() => {
                });

            }
        }
    }
</script>

<style scoped>

</style>