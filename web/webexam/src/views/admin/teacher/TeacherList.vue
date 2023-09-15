<template>
    <div>
        <el-table
                :data="pageInfo.list"
                style="width: 100%"
                :router="true"
        >
            <el-table-column prop="id" label="ID" ></el-table-column>
            <el-table-column prop="name" label="姓名" ></el-table-column>
            <el-table-column label="头像" >
                <template slot-scope="scope">
                    <img :src="$baseURL+'static/uploadImages/'+scope.row.pic" style="max-width: 100px">
                </template>
            </el-table-column>
            <el-table-column prop="questionCount" label="出题数量" ></el-table-column>

            <el-table-column label="操作" >
                <template slot-scope="scope">
                    <el-button @click="handleToUpdate(scope.row.id)">修改</el-button>
                    <el-button @click="handleDelete(scope.row.id)">删除</el-button>
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
        name: "TeacherList",
        data(){
            return {
                pageInfo:{},
                teachers:[],
            }
        },
        created() {
            this.handleList(1);
        },
        methods:{
            handleToUpdate(id){
                this.$router.push({path:"/admin/teacher/update",query: { id: id }});
            },
            handleList(pageNum){
                this.$axios.get("manage/teacher/list",{params:{pageNum:pageNum}})
                    .then(res=>{
                        this.pageInfo = res.data.data;
                    });
            },
            handleDelete(id){
                // console.log(id)
                this.$confirm('此操作将删除该教师, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$axios.post("manage/teacher/delete?id="+id).then(res=>{
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