<template>
    <div class="update">
        <el-tabs v-model="activeName">
            <el-tab-pane name="first">
                <span slot="label"><i class="el-icon-circle-plus"></i>修改试题</span>
                <section class="append">
                    <ul>
                        <li>
                            <span>题目类型:</span>
                            <el-select v-model="question.questionTypeId" placeholder="请选择题型" class="w150" disabled>
                                <el-option
                                        v-for="item in options"
                                        :key="item.id"
                                        :label="item.type"
                                        :value="item.id">
                                </el-option>
                            </el-select>
                        </li>
                        <li>
                            <span>所属科目：</span>
                            <el-select v-model="question.subjectId" placeholder="请选择科目" class="w150" @change="handleChange(question.subjectId)">
                                <el-option
                                        v-for="item in subjects"
                                        :key="item.id"
                                        :label="item.title"
                                        :value="item.id">
                                </el-option>
                            </el-select>
                        </li>
                        <li>
                            <span>所属知识点：</span>
                            <el-select v-model="knowledge" placeholder="请选择知识点" class="w150" multiple>
                                <el-option
                                        v-for="item in knowledges"
                                        :key="item.id"
                                        :label="item.knowledgePoint"
                                        :value="item.id">
                                </el-option>
                            </el-select>
                        </li>
                        <li>
                            <span>难易程度：</span>
                            <el-select v-model="question.levelId" placeholder="请选择难易程度" class="w150">
                                <el-option
                                        v-for="item in levels"
                                        :key="item.id"
                                        :label="item.level"
                                        :value="item.id">
                                </el-option>
                            </el-select>
                        </li>
                    </ul>
                    <div class="change">
                        <div class="title">
                            <el-tag>题目:</el-tag>
                            <el-input
                                    type="textarea"
                                    rows="4"
                                    v-model="question.title"
                                    placeholder="请输入题目内容"
                                    resize="none"
                                    class="answer">
                            </el-input>
                        </div>
                        <div class="options">
                            <ul>
                                <template v-for="item in choicesList">
                                    <li>
                                        <el-input
                                                placeholder="请输入选项的内容"
                                                v-model="item.content"
                                                clearable="" >
                                        </el-input>
                                        <el-tag>是否为正确答案:</el-tag>
                                        <el-radio v-model="item.isCorrect" :label="true">是</el-radio>
                                        <el-radio v-model="item.isCorrect" :label="false">否</el-radio>
                                    </li>
                                </template>
                            </ul>

                            <div class="submit">
                                <el-button type="primary" @click="judgeSubmit()">立即修改</el-button>
                            </div>
                        </div>
                    </div>
                </section>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>
    export default {
        name: "questionUpdate",
        data(){
            return {
                activeName:'first',
                question:{},
                options:[],
                subjects:[],
                levels:[],
                knowledges:[],
                knowledge:[],
                choicesList:[],
                show:true
            }
        },
        created() {
            this.initQuestion(this.$route.query.id)
            this.initQuestionType();
            this.initSubjects();
            this.initLevels();
            this.initKnowledge(this.$route.query.id)
            this.initKnowledges();
            this.initChoicesList(this.$route.query.id);
        },
        methods:{
            initQuestion(id){
                this.$axios.get("manage/question/findById",{params:{id:id}}).then(res=>{
                    this.question = res.data.data;
                })
            },
            initQuestionType(){
                this.$axios.get("manage/questionType/list").then(res=>{
                    this.options = res.data.data;
                })
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
            initKnowledge(id){
                this.$axios.get("manage/knowledgeQuestion/findById",{params: {id:id}}).then(res=>{
                    this.knowledge = res.data.list;
                })
            },
            initKnowledges(){
                this.$axios.get("manage/knowledgeBullet/findAll").then(res=>{
                    this.knowledges = res.data.data
                })
            },
            initChoicesList(id){
                this.$axios.get("manage/choices/findById",{params:{id:id}}).then(res=>{
                    this.choicesList = res.data.data;
                })
            },
            handleChange(id){
                console.log(id)
                this.knowledges = [];
                this.$axios.get("manage/knowledgeBullet/findAllById",{params:{id:id}}).then(res=>{
                    console.log(res)
                    this.knowledges = res.data.data;
                })

            },
            judgeSubmit(){
                this.$axios.post("manage/question/update",this.question,{params:{knowledge:this.knowledge.toString()}}).then(res=>{
                    if(res.data.code == 200){
                        return this.$axios.post("manage/choices/update",this.choicesList)
                    }
                })
                .then(response2=>{
                    if(response2.data.code == 200){
                        this.$router.push("/admin/question/list");
                    }
                })
                .catch(error=>{
                    this.$message.error("修改失败")
                })

            }
        },




    }
</script>

<style scoped>
    .update{
        margin: 0px 40px;
    }

    .add .box{
        padding: 0px 20px;
    }
    .add .box ul li{
        margin: 10px 0px;
        display: flex;
        align-items: center;
    }
    .add .box ul li .el-input{
        width: 6%;
    }
    .add .box ul li .w150{
        margin-left: 20px;
        width: 7%;
    }

    .el-icon-circle-plus {
        margin-right: 10px;
    }
    .icon-daoru-tianchong {
        margin-right: 10px;
    }

    .append{
        margin: 0px 20px;
    }
    .append ul{
        display: flex;
        align-items: center;
    }
    .append ul li{
        margin-right: 20px;
    }
    .append .change{
        margin-top: 20px;
        padding: 20px 16px;
        background-color: #E7F6F6;
        border-radius: 4px;
    }
    .append .change .title{
        padding-left: 6px;
        color: #2f4f4f;
    }

    .append .change .title span:nth-child(1){
        margin-right: 6px;
    }

    .append .change .title .answer{
        margin: 20px 0px 20px 8px;
    }

    .append .change .title .el-textarea {
        width: 98% !important;
    }

    .append .change .options ul{
        display: flex;
        flex-direction: column;
    }

    .append .change .options ul li{
        display: flex;
        justify-content: center;
        align-items: center;
        width: 98%;
        margin: 10px 0px;
    }

    .append .change .options ul li span{
        margin-right: 20px;
    }

    .append .change .submit{
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top: 10px;
    }

    .append .fill .fillAnswer{
        display: flex;
        justify-content: center;
        align-items: center;
        margin-bottom: 10px;
    }

    .append .fill .fillAnswer span{
        margin-right: 6px;
    }

    .append .fill .fillAnswer .el-input{
        width: 91% !important;
    }

    .append .fill .analysis{
        margin-top: 20px;
        margin-left: 5px;
    }

    .append .judge .judgeAnswer{
        margin-left: 20px;
        margin-bottom: 20px;
    }

    .append .w150{
        width: 150px;
    }

    .append li:nth-child(2) {
        display: flex;
        align-items: center;
        justify-content: center;
    }
</style>