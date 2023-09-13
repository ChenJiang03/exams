<template>
    <div class="all">
        <el-form :inline="true" class="demo-form-inline" ref="question">
            <el-form-item label="题目名称">
                <el-input v-model="question.title" placeholder="请输入想要搜索的关键字"></el-input>
            </el-form-item>
            <el-form-item label="题目类型">
                <el-select v-model="question.questionTypeId" placeholder="题目类型">
                    <el-option
                            v-for="item in questionTypes"
                            :key="item.id"
                            :label="item.type"
                            :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="学科">
                <el-select v-model="question.subjectId" placeholder="科目类型">
                    <el-option
                            v-for="item in subjects"
                            :key="item.id"
                            :label="item.title"
                            :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="难易程度">
                <el-select v-model="question.levelId" placeholder="难易程度">
                    <el-option
                            v-for="item in levels"
                            :key="item.id"
                            :label="item.level"
                            :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="知识点">
                <el-select v-model="knowledge" placeholder="知识点">
                    <el-option
                            v-for="item in knowledges"
                            :key="item.id"
                            :label="item.knowledgePoint"
                            :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="活动时间">
                <el-col :span="11">
                    <el-date-picker type="date" placeholder="选择日期" v-model="startTime" style="width: 100%;" value-format="yyyy-MM-dd hh:mm:ss"></el-date-picker>
                </el-col>
                <el-col class="line" :span="2">-</el-col>
                <el-col :span="11">
                    <el-date-picker type="date" placeholder="选择日期" v-model="endTime" style="width: 100%;" value-format="yyyy-MM-dd hh:mm:ss"></el-date-picker>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">查询</el-button>
                <el-button @click="resetForm">重置</el-button>
            </el-form-item>
        </el-form>
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
                questions:[],
                questionTypes:[],
                levels:[],
                knowledges:[],
                subjects:[],
                question:{
                    title: '',
                    subjectId: '',
                    levelId:'',
                    questionTypeId:'',
                },
                startTime:'',
                endTime:'',
                knowledge:'',

            }
        },
        created() {
            this.initQuestion(1);
            this.initSubjects();
            this.initLevels();
            this.initQuestionTypes();
            this.initKnowledges();
        },
        methods:{
            initQuestion(pageNum){
                this.$axios.post("manage/question/search",this.question,{params:{knowledge: this.knowledge,startTime: this.startTime,endTime: this.endTime,pageNum:pageNum}}).then(res=>{
                    console.log(res);
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
            initSubjects(){
                this.$axios.get("manage/subject/list").then(res=>{
                    this.subjects = res.data.data;
                })
            },
            initLevels(){
                this.$axios.get("manage/levels/list").then(res=>{
                    this.levels = res.data.data;
                })
            },
            initQuestionTypes(){
                this.$axios.get("manage/questionType/list").then(res=>{
                    this.questionTypes = res.data.data;
                })
            },
            initKnowledges() {
                this.$axios.get("manage/knowledgeBullet/findAll").then(res=>{
                    this.knowledges = res.data.data;
                })
            },
            onSubmit(){
                this.$axios.post("manage/question/search",this.question,{params:{knowledge: this.knowledge,startTime: this.startTime,endTime: this.endTime}}).then(res=>{
                    console.log(res);
                    this.questions = res.data.data;
                })
            },
            resetForm(){
                this.question.title = '';
                this.question.levelId = '';
                this.question.subjectId = '';
                this.question.questionTypeId = '';
                this.knowledge = '';
                this.startTime = '';
                this.endTime = '';
                this.$axios.post("manage/question/search",this.question,{params:{knowledge: this.knowledge,startTime: this.startTime,endTime: this.endTime}}).then(res=>{
                    console.log(res);
                    this.questions = res.data.data;
                })
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