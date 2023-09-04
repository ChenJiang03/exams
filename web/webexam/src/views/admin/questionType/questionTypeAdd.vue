<template>
    <div class="add">
        <h1>添加类型</h1>
        <el-form :model="questionType" ref="questionTypeForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="类型" prop="type">
                <el-input v-model="questionType.type" ></el-input>
            </el-form-item>
            <el-form-item label="是否为主观题" prop="isSubjective">
                <el-radio-group v-model="questionType.isSubjective">
                    <el-radio :label="true" >是</el-radio>
                    <el-radio :label="false" >否</el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm">立即添加</el-button>
                <el-button @click="resetForm('questionTypeForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "questionTypeAdd",
        data(){
            return{
                questionType:{
                    type:'',
                    isSubjective:'',

                }
            }
        },
        methods: {
            submitForm() {
                this.$refs.questionTypeForm.validate((valid) => {
                    if (valid) {
                        this.$axios.post("http://localhost:8081/manage/questionType/add",this.questionType).then(res=>{
                                this.$router.push("/admin/questionType/list");
                            }
                        )
                    } else {
                        return false;
                    }
                });
            },
            resetForm(questionTypeForm) {
                this.$refs[questionTypeForm].resetFields();
            }
        }
    }
</script>

<style scoped>
    .add {
        padding: 0px 40px;
        width: 400px;
    }
</style>