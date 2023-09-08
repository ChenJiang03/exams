<template>
    <div>
        <h2>学科添加</h2>
        <el-form  ref="form" :model="subject" label-width="80px">
            <el-form-item label="学科名称">
                <el-input v-model="subject.title"></el-input>
            </el-form-item>
            <el-form-item label="简介">
                <el-input type="textarea" v-model="subject.description"></el-input>
            </el-form-item>
            <el-form-item label="排序">
                <el-input v-model="subject.sort"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('form')">立即创建</el-button>
                <el-button @click="exit">取消</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "SubjectAdd",
        data() {
            return {
                subject: {
                    title: '',
                    sort: '',
                    description: ''
                }
            }
        },
        methods: {
            onSubmit(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$axios.post("manage/subject/add",this.subject)
                            .then(res=>{
                                this.$router.push("/subject/list");
                            });
                        alert('添加完成');
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            exit(){
                this.$router.push("/subject/list");
            }
        }
    }
</script>