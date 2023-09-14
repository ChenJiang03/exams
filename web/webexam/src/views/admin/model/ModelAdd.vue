<template>
    <div class="msg">
        <h1>添加模板</h1>
        <el-form :model="model" :rules="rules" ref="modelForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="模板标题" prop="title">
                <el-input v-model="model.title" placeholder="请输入模板标题" style="width: 220px"></el-input>
            </el-form-item>
            <el-form-item label="模板详情" prop="description">
                <el-input v-model="model.description" placeholder="请输入模板详情" style="width: 220px"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm">立即添加</el-button>
                <el-button @click="resetForm('modelForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "ModelDetailAdd",
        data(){
            return{
                model:{
                    id:'',
                    title:'',
                    description:'',
                    enable:''
                },
                models:[],
                rules: {
                    title: [
                        { required: true, message: '请输入模板名称', trigger: 'blur' }
                    ],
                    description: [
                        { required: true, message: '请输入模板详情', trigger: 'blur' }
                    ]
                }
            }
        },
        methods:{
            submitForm() {
                this.$refs.modelForm.validate((valid) => {
                    if (valid) {
                        this.$axios.post("manage/model/add",this.model).then(res=>{
                                this.$router.push("/admin/model/list");
                            }
                        )
                    } else {
                        return false;
                    }
                });
            },
            resetForm(modelForm) {
                this.$refs[modelForm].resetFields();
            }
        }
    }
</script>

<style scoped>

</style>