<template>
    <div>
        <h2>修改题目数量</h2>
        <el-form :model="paperModel" :rules="rules" ref="paperModelForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="题目数量" prop="questionCount">
                <el-input v-model="paperModel.questionCount" style="width: 400px"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm">立即修改</el-button>
                <el-button @click="resetForm('paperModelForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "UpdateQuestionCount",
        data(){
            return{
                paperModel:{
                    questionCount:''
                },
                paperModels:[],
                rules:{
                    questionCount:  { required: true, message: '请输入题目数量', trigger: 'blur' }
                }
            }
        },
        created() {
            this.getQuestionCount(this.$route.query.id)
        },
        methods:{
            getQuestionCount(id){
                this.$axios.get("manage/paperModel/find?id="+id).then(res=>{
                    console.log(res.data.data)
                    this.paperModel=res.data.data;
                })
            },
            submitForm() {
                this.$refs.paperModelForm.validate((valid) => {
                    if (valid) {
                        this.$axios.post("manage/paperModel/update",this.paperModel).then(res=>{
                            this.$message("修改成功");
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