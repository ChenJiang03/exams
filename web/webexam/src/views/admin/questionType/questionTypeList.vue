<template>
    <div class="all">
        <el-table :data="questionTypes" style="width: 100%" height=70vh :cell-style="cellStyle" :header-cell-style="rowClass">
            <el-table-column prop="id" label="ID" width="180"></el-table-column>
            <el-table-column prop="type" label="类型" width="200"></el-table-column>
            <el-table-column label="操作" width="150">
                <template slot-scope="scope">
                    <el-button @click="update(scope.row.id)" type="primary" size="small">编辑</el-button>
                    <el-button @click="deleteById(scope.row.id)" type="danger" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    export default {
        name: "questionTypeList",
        data(){
            return{
                questionTypes:[],
            }
        },
        created() {
            this.initData()
        },
        methods:{
            initData(){
                this.$axios.get("manage/questionType/list").then(res=>{
                    console.log(res)
                    this.questionTypes = res.data.data;
                })
            },
            deleteById(id){
                this.$confirm('此操作将删除该类型, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(()=>{
                    this.$axios.get("manage/questionType/delete",{params:{id:id}}).then(()=>{
                        this.initData();
                    })

                }).catch(()=>{

                })
            },
            update(id){
                this.$router.push({path:'/admin/questionType/update',query:{id:id}})
            }
        }
    }
</script>

<style scoped>
    .all {
        padding: 0px 40px;
        margin-left: 50px;
    }
    .page {
        margin-top: 20px;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .edit {
        margin-left: 20px;
    }
    .el-table tr {
        background-color: #dd5862 !important;
    }
    .el-table .warning-row {
        background: #000 !important;
    }

    .el-table .success-row {
        background: #dd5862;
    }
</style>