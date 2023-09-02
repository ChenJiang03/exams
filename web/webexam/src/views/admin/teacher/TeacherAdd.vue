<template>
    <div class="msg">
        <h1>添加教师</h1>
    <el-form :model="teacher" :rules="rules" ref="teacherForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="用户名" prop="username">
            <el-input v-model="teacher.username" ></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="teacher.password" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
            <el-input v-model="teacher.name" placeholder="请输入姓名"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
            <el-radio-group v-model="teacher.sex">
                <el-radio :label="true" >男</el-radio>
                <el-radio :label="false" >女</el-radio>
            </el-radio-group>
        </el-form-item>
        <el-form-item label="身份证号" prop="idcard">
            <el-input v-model="teacher.idcard" maxlength="18" show-word-limit placeholder="请输入身份证号码" />
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm">立即添加</el-button>
            <el-button @click="resetForm('teacherForm')">重置</el-button>
        </el-form-item>
    </el-form>
    </div>
</template>

<script>
    export default {
        name:'TeacherAdd',
        data() {
            return {
                teacher: {
                    username: '',
                    password: '',
                    name: '',
                    delivery: false,
                    sex:'',
                    pic:'',
                    idcard:''
                },
                rules: {
                    username: [
                        { required: true, message: '请输入用户名', trigger: 'blur' },
                        { min: 5, max: 20, message: '长度在 5 到 20 个字符', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' },
                        { min: 3, max: 20, message: '长度在 3 到 20 个字符', trigger: 'blur' }
                    ],
                    name: [
                        { required: true, message: '请输入姓名', trigger: 'blur' },
                        { min: 2, max: 10, message: '长度在 2 到 10 个字符', trigger: 'blur' }
                    ],
                    idcard: [
                        {required: true, message: '请输入身份证', trigger: 'blur'},
                        {
                            pattern: /(^\d{8}(0\d|10|11|12)([0-2]\d|30|31)\d{3}$)|(^\d{6}(18|19|20)\d{2}(0\d|10|11|12)([0-2]\d|30|31)\d{3}(\d|X|x)$)/,
                            message: '请输入正确的证件号', trigger: 'blur'
                        }
                    ]
                }
            };
        },
        methods: {
            submitForm() {
                this.$refs.teacherForm.validate((valid) => {
                    if (valid) {
                        this.$axios.post("http://localhost:8081/manage/teacher/add",this.teacher).then(res=>{
                                this.$router.push("/admin/teacher/list");
                            }
                        )
                    } else {
                        return false;
                    }
                });
            },
            resetForm(teacherForm) {
                this.$refs[teacherForm].resetFields();
            }
        }
    }
</script>

<style scoped>
    .msg{
        margin-left: 200px;
    }
    .msg h1{
        margin-left: 200px;
    }
</style>