<template>
    <div class="add">
        <el-tabs v-model="activeName">
            <el-tab-pane name="first">
                <span slot="label"><i class="el-icon-circle-plus"></i>添加试题</span>
                <section class="append">
                    <ul>
                        <li>
                            <span>题目类型:</span>
                            <el-select v-model="question.questionType.id" placeholder="请选择题型" class="w150" @change="handleChoose">
                                <el-option
                                        v-for="item in options"
                                        :key="item.id"
                                        :label="item.type"
                                        :value="item.id">
                                </el-option>
                            </el-select>
                        </li>
                        <template v-for="questionType in questionTypes">
                            <li v-if="question.questionType.id == questionType.id">
                                <span>所属科目：</span>
                                <el-select v-model="question.subject.id" placeholder="请选择科目" class="w150" @change="handleChange(question.subject.id)">
                                    <el-option
                                            v-for="item in subjects"
                                            :key="item.id"
                                            :label="item.title"
                                            :value="item.id">
                                    </el-option>
                                </el-select>
                            </li>
                            <li v-if="question.questionType.id == questionType.id">
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
                            <li v-if="question.questionType.id == questionType.id">
                                <span>难易程度：</span>
                                <el-select v-model="question.levels.id" placeholder="请选择难易程度" class="w150">
                                    <el-option
                                            v-for="item in level"
                                            :key="item.id"
                                            :label="item.level"
                                            :value="item.id">
                                    </el-option>
                                </el-select>
                            </li>
                        </template>
                    </ul>


                    <div class="change" v-if="question.questionType.id == 1">
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
                        <el-row>
                            <el-button round @click="addChoices">添加选项内容</el-button>
                        </el-row>
                        <div class="options">
                            <ul>
                                <template v-for="item in choicesList">
                                    <li>
                                        <el-input
                                                placeholder="请输入选项的内容"
                                                v-model="item.content"
                                                clearable="" >
                                        </el-input>

                                        <template>
                                            <el-tag>是否为正确答案:</el-tag>
                                            <el-radio v-model="item.isCorrect" :label="true">是</el-radio>
                                            <el-radio v-model="item.isCorrect" :label="false">否</el-radio>
                                        </template>
                                    </li>
                                </template>

                            </ul>
                        </div>



                        <div class="submit">
                            <el-button type="primary" @click="judgeSubmit()">立即添加</el-button>
                        </div>
                    </div>
                    <!--多选题-->
                    <div class="change" v-if="question.questionType.id == 2">
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
                        <el-row>
                            <el-button round @click="addChoices">添加选项内容</el-button>
                        </el-row>
                        <div class="options">
                            <ul>
                                <template v-for="item in choicesList">
                                    <li>
                                        <el-input
                                                placeholder="请输入选项的内容"
                                                v-model="item.content"
                                                clearable="" >
                                        </el-input>

                                        <template>
                                            <el-tag>是否为正确答案:</el-tag>
                                            <el-radio v-model="item.isCorrect" :label="true">是</el-radio>
                                            <el-radio v-model="item.isCorrect" :label="false">否</el-radio>
                                        </template>
                                    </li>
                                </template>

                            </ul>
                        </div>
                        <div class="submit">
                            <el-button type="primary" @click="judgeSubmit()">立即添加</el-button>
                        </div>
                    </div>
                    <!--判断-->
                    <div class="change" v-if="question.questionType.id == 3">
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
                        <el-row>
                            <el-button round @click="addChoices">添加选项内容</el-button>
                        </el-row>
                        <div class="judgeAnswer">
                            <ul>
                                <template v-for="item in choicesList">
                                    <li>
                                        <el-radio v-model="item.isCorrect" :label="true">正确</el-radio>
                                        <el-radio v-model="item.isCorrect" :label="false">错误</el-radio>
                                    </li>
                                </template>
                            </ul>
                        </div>
                        <div class="submit">
                            <el-button type="primary" @click="judgeSubmit()">立即添加</el-button>
                        </div>
                    </div>

                    <!--主观题-->
                    <div class="change" v-if="(question.questionType.id != 3)&&(question.questionType.id != 2)&&(question.questionType.id != 1)&&(question.questionType.id > 0)">
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

                        <div class="fillAnswer">
                            <el-tag>正确答案:</el-tag>
                            <el-input v-model="choices.content"></el-input>
                        </div>
                        <div class="submit">
                            <el-button type="primary" @click="objectSubmit()">立即添加</el-button>
                        </div>
                    </div>
                </section>

                
            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>
    export default {
        name: "questionAdd",
        data() {
            return {
                choicesList:[],
                questionTypes:[],
                options:[],
                subjects:[],
                knowledges:[],
                level:[],
                question:{
                    title: '',
                    questionType:{
                        id: ''
                    },
                    subject:{
                        id: ''
                    },
                    levels:{
                        id: ''
                    },
                },
                activeName: 'first',  //活动选项卡
                knowledge:[],
                choices:{
                    content:''
                }
            };
        },
        created() {
            this.initOptions();
            this.initSubjects();
            this.initLevels();
            this.initQuestionTypes();
        },

        methods:{
            initOptions(){
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
                    this.level = res.data.data;
                })
            },
            initQuestionTypes(){
                this.$axios.get("manage/questionType/list").then(res=>{
                    this.questionTypes = res.data.data;
                })
            },
            addChoices(){
                this.choicesList.push({content:'',isCorrect:''})

            },
            handleChoose(){
                this.choicesList = [];
                this.question.subject.id = '';
                this.question.levels.id = '';
                this.knowledge = [];
            },
            judgeSubmit(){
                // this.$axios.post("manage/question/add",this.question,{params:{choicesList: this.choicesList.toString()}}).then(res=>{
                // })
                this.$axios.post("manage/question/add",this.question,{params:{knowledge:this.knowledge.toString()}})
                    .then(response1 => {
                        // 第一个请求成功的回调函数
                        // 在第一个请求的回调函数中嵌套第二个请求
                        if(response1.data.code == 200){
                            return this.$axios.post("manage/choices/add",this.choicesList,{params:{id:response1.data.id}});
                        }

                    })
                    .then(response2 => {
                        if(response2.data.code == 200){
                            this.$router.push("/admin/question/list");
                        }
                    })
                    .catch(error => {
                        // 处理错误
                        this.$message.error("添加失败")
                    });


            },
            objectSubmit(){
                this.$axios.post("manage/question/add",this.question,{params:{knowledge:this.knowledge.toString()}})
                    .then(response1 => {
                        // 第一个请求成功的回调函数
                        // 在第一个请求的回调函数中嵌套第二个请求
                        if(response1.data.code == 200){
                            return this.$axios.post("manage/choices/choicesAdd",this.choices,{params:{id:response1.data.id}});
                        }

                    })
                    .then(response2 => {
                        // 第二个请求成功的回调函数
                    })
                    .catch(error => {
                        // 处理错误
                        console.error("请求出错:", error);
                    });
            },
            handleChange(id){
                console.log(id);
                this.$axios.get("manage/knowledgeBullet/findAllById",{params:{id:id}}).then(res=>{
                    console.log(res)
                    this.knowledges = res.data.data;
                })
            }

        }
    }
</script>

<style scoped>
    .add{
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