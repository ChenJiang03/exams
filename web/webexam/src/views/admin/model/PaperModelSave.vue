<template>
    <div class="msg">
    <h1>添加模板</h1>
    <el-form :model="paperModel" :rules="rules" ref="paperModelForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="题目类型" prop="questionTypeId">
            <el-select v-model="paperModel.questionTypeId" filterable remote :remote-method="getQuestionTypes">
                <el-option
                        v-for="questionType in questionTypes"
                        :key="questionType.id"
                        :label="questionType.type"
                        :value="questionType.id"
                ></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="题目数量" prop="questionCount">
            <el-input v-model="paperModel.questionCount" placeholder="请输入题目数量" style="width: 220px"></el-input>
        </el-form-item>
        <el-form-item label="模板id" prop="modelId">
            <el-input v-model="paperModel.modelId" placeholder="请输入模板id" style="width: 220px"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm">立即添加</el-button>
            <el-button @click="resetForm('paperModelForm')">重置</el-button>
        </el-form-item>
    </el-form>
    </div>
</template>

<script>
    export default {
        name: "PaperModelAdd",
        data(){
            return{
                paperModel:{
                    questionTypeId:'',
                    questionCount:'',
                    modelId:''
                },
                questionTypes:[],
                rules: {
                    questionTypeId: [
                        { required: true, message: '请选择题目类型', trigger: 'blur' }
                    ],
                    questionCount: [
                        { required: true, message: '请输入题目数量', trigger: 'blur' }
                    ],
                    modelId: [
                        { required: true, message: '请输入模板id', trigger: 'blur' }
                    ]
                }
            }
        },
        created() {
            this.getQuestionTypes(this.$route.query.id);
        },
        methods:{
            getQuestionTypes(id) {

                this.$axios.get("manage/paperModel/getTypes",{params:{id:id}}).then(res=>{
                    let existTypeIds = res.data.existTypes.map(type=>type.id);
                    this.questionTypes=res.data.data.filter(type=>!existTypeIds.includes(type.id));

                })
            },
            submitForm() {
                this.$refs.paperModelForm.validate((valid) => {
                    console.log(this.paperModel);
                    if (valid) {
                        this.$axios.post("manage/paperModel/add",this.paperModel).then(res=>{
                                this.$router.push("/admin/model/list");
                            }
                        )
                    } else {
                        return false;
                    }
                });
            },
            resetForm(paperModelForm) {
                this.$refs[paperModelForm].resetFields();
            }
        }
    }
</script>

<style scoped>

</style>