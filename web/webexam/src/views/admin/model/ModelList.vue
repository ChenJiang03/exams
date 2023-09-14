<template>
    <div>
        <el-row>
            <el-button type="success" plain @click="handleToAdd">添加模板</el-button>
        </el-row>
        <el-table
                :data="pageInfo.list"
                style="width: 100%"
                :router="true"
        >
            <el-table-column prop="id" label="Id" ></el-table-column>
            <el-table-column prop="title" label="模板标题" ></el-table-column>
            <el-table-column prop="description" label="模板详情" ></el-table-column>
            <el-table-column label="操作" >
                <template slot-scope="scope">
                    <el-button type="primary" icon="el-icon-search" @click="handleDetail(scope.row.id)">详情</el-button>
                    <el-button type="primary" icon="el-icon-delete" @click="handleDelete(scope.row.id)"></el-button>
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
        name: "modelList",
        data(){
            return{
                pageInfo:{},
                models:[]
            }
        },
        created() {
            this.handleList(1);
        },
        methods:{
            handleToAdd(){
                this.$router.push("add");
            },
            handleDetail(id){
                this.$router.push({path:"/admin/model/detail",query: { id: id }});
            },
            handleList(pageNum){
                this.$axios.get("manage/model/list",{params:{pageNum:pageNum}})
                    .then(res=>{
                        this.pageInfo = res.data.data;
                    });
            },
            handleDelete(id){
                this.$confirm('此操作将删除该模板, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$axios.post("manage/model/delete?id="+id).then(res=>{
                        this.handleList(1);
                    })
                }).catch(() => {
                });

            }
        }

    }
</script>
