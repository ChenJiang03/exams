<template>
    <div class="all">
        <el-table :data="questions.list" style="width: 100%" height=70vh :cell-style="{'text-align':'center'}" :header-cell-style="{'text-align':'center'}">

                <el-table-column prop="id" label="ID" width="180"></el-table-column>
                <el-table-column prop="title" label="题目" width="200"></el-table-column>
                <el-table-column prop="levels.level" label="难度等级" width="180"></el-table-column>
                <el-table-column prop="subject.title" label="科目" width="200"></el-table-column>
                <el-table-column prop="questionType.type" label="题型" width="180"></el-table-column>
                <el-table-column prop="teacher.name" label="添加老师" width="200"></el-table-column>
                <el-table-column prop="inputTime" label="出题时间" width="180"></el-table-column>
                <el-table-column prop="updateTime" label="修改时间" width="200"></el-table-column>

                <el-table-column label="操作" width="150">
                    <template slot-scope="scope">
                        <el-button @click="update(scope.row.id)" type="primary" size="small">编辑</el-button>
                        <el-button @click="deleteById(scope.row.id)" type="danger" size="small">删除</el-button>
                    </template>
                </el-table-column>
        </el-table>

        <div class="block">
            <el-pagination
                    @current-change="initQuestion"
                    :current-page.sync="currentPage3"
                    :page-size="questions.pageSize"
                    layout="prev, pager, next, jumper"
                    :total="questions.total">
            </el-pagination>
        </div>
    </div>
</template>

<script>
    export default {
        name: "questionList",
        data(){
            return{
                questions:[]
            }
        },
        created() {
            this.initQuestion(1);
        },
        methods:{
            initQuestion(pageNum){
                this.$axios.get("manage/question/list",{params: {pageNum:pageNum}}).then(res=>{
                    console.log(res)
                    this.questions = res.data.data;
                })
            },
            deleteById(id){
                this.$confirm('此操作将删除该类型, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(()=>{
                    this.$axios.get("manage/question/delete",{params:{id:id}}).then(()=>{
                        this.initQuestion();
                    })

                }).catch(()=>{

                })
            },
            update(id){
                this.$router.push({path:'/admin/question/update',query:{id:id}})
            },

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