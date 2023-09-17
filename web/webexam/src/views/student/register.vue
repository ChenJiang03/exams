<template>
    <div class="box">
        <div class="register">
            <footer>注册</footer>
            <el-form ref="form" :model="student" :rules="rules"  label-width="30px" class="from">
                <el-form-item label="" prop="username">
                    <el-input prefix-icon="el-icon-user" placeholder="注册的账号" v-model="student.username"></el-input>
                </el-form-item>
                <el-form-item label="" prop="name">
                    <el-input prefix-icon="el-icon-user" placeholder="姓名" v-model="student.name"></el-input>
                </el-form-item>
                <el-form-item prop="code">
                    <el-input size="medium" prefix-icon="el-icon-film" placeholder="验证码" class="inputtow" v-model="student.code"></el-input>
                    <div class="code">
                        <valid-code @input="getCode" />
                    </div>
                </el-form-item>
                <el-form-item label="" prop="password">
                    <el-input autocomplete="off" prefix-icon="el-icon-lock" placeholder="密码（至少6位字母和数字）" show-password v-model="student.password"></el-input>
                </el-form-item>
                <el-form-item label="" prop="pswok">
                    <el-input autocomplete="off" prefix-icon="el-icon-lock" placeholder="确认密码" show-password v-model="student.pswok"></el-input>
                </el-form-item>
                <el-form-item label=""  prop="phone">
                    <el-input validate-event prefix-icon="el-icon-phone" placeholder="手机号" v-model.number="student.phone"></el-input>
                </el-form-item>
            </el-form>
            <el-button type="primary" :round=false :plain=false class="buttonres" @click="onSubmit('form')">注册</el-button>
            <div class="login">已有账号，
                <router-link to="/login">登录</router-link>
                <span style="margin-left: 10%; font-size:13px">注册即代表您已阅读并同意《使用协议》</span>
            </div>
        </div>
    </div>
</template>

<script>
    import ValidCode from "@/components/ValidCode";

    export default {
        name: "register",
        components:{
          ValidCode
        },
        data() {
            var validateUser = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入账号'));
                }
                else {
                    callback();
                }
            };
            var validateCode = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入验证码'));
                } else if (value !== this.code) {
                    callback(new Error('验证码错误!'));
                    console.log(this.check);
                } else {
                    callback();
                }
            };
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                }
                else {
                    if (this.student.pswok !== '') {
                        this.$refs.form.validateField('pswok');
                    }
                    callback();
                }
            };
            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else if (value !== this.student.password) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            var validatePhone = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入手机'));
                }
                else {
                    callback();
                }
            };
            var validateName = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入姓名'));
                }
                else {
                    callback();
                }
            };
            return {
                code:'',
                student: {
                    username: '',
                    name:'',
                    password: '',
                    pswok: '',
                    phone: '',
                    code:''
                },
                rules: {
                    username:[
                        { validator: validateUser, trigger: 'blur' },
                        { min: 6, max: 12, message: '长度在 6 到 12 个字符', trigger: 'blur' }
                    ],
                    password: [
                        { validator: validatePass, trigger: 'blur' },
                        { min: 6, max: 12, message: '长度在 6 到 12 个字符', trigger: 'blur' }
                    ],
                    pswok: [
                        { validator: validatePass2, trigger: 'blur' }
                    ],
                    phone:[
                        { validator: validatePhone, trigger: 'blur' },
                        { pattern:/^1[3-9]\d{9}$/,
                            message: '请输入正确的手机号', trigger: 'blur' }
                    ],
                    code:[
                        { validator: validateCode, trigger: 'blur' },
                    ],
                    name:[
                        { validator: validateName, trigger: 'blur' },
                        { pattern:/^[\u4e00-\u9fa5]{2,4}$/,
                            message: '请输入正确的姓名', trigger: 'blur' }
                    ]
                }
            }

        },
        methods: {
            onSubmit(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$axios.post("student/register",this.student)
                            .then(res=>{
                                this.$router.push("/subject/list");
                            });
                        alert('注册完成');
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            getCode(code){
                this.code=code
                console.log(this.code)
            }
        }
    }
</script>

<style scoped>
    .box{
        height: 100%;
        /*background-image: url(../assets/sign.png);*/
        background-repeat: no-repeat;
        background-size: cover;
    }
    .register{
        width: 35%;
        height: 80%;
        background-color: #fff;
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%,-50%);
        border-radius: 5px;
    }
    footer{
        font-family: '宋体';
        font-size: 24px;
        text-align: center;
        padding-top: 50px;
    }
    .from{
        width: 75%;
        margin: 0 auto;
        margin-right: 15%;
        margin-top: 8%;
    }
    .inputtow{
        width: 50%;
    }

    .code{
        float: right;
        width: 50%;
        margin-top: 1%;
    }

    .buttonres{
        width: 70%;
        margin-left: 15%;
        margin-top: 5%;
    }
    .login{
        margin-left: 15%;
        margin-top: 5%;
        color: #ccc;
        font-size: 13px;
    }
</style>