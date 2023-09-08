<template>

    <div>
        <h2>修改教师</h2>
    <el-form :model="teacher" :rules="rules" ref="teacherForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="用户名" prop="username">
            <el-input v-model="teacher.username" style="width: 800px"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
            <el-input v-model="teacher.name" placeholder="请输入姓名" style="width: 800px"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
            <el-radio-group v-model="teacher.sex">
                <el-radio :label="true" >男</el-radio>
                <el-radio :label="false" >女</el-radio>
            </el-radio-group>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm">立即修改</el-button>
            <el-button @click="resetForm('teacherForm')">重置</el-button>
        </el-form-item>
    </el-form>
    </div>
</template>

<script>
    export default {
        name:'TeacherUpdate',
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
                    name: [
                        { required: true, message: '请输入姓名', trigger: 'blur' },
                        { min: 2, max: 10, message: '长度在 2 到 10 个字符', trigger: 'blur' }
                    ],
                }
            };
        },
        created() {
            this.getTeacher(this.$route.query.id)
        },
        methods: {
            getTeacher(id){
                this.$axios.get("manage/teacher/select?id="+id).then(res=>{
                    this.teacher=res.data.data;
                })
            },
            submitForm() {
                this.$refs.teacherForm.validate((valid) => {
                    if (valid) {
                        this.$axios.post("manage/teacher/update",this.teacher).then(res=>{
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
    *{
        text-align: center;
    }
</style>