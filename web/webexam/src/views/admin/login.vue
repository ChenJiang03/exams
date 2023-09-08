<template>
    <div id="login">
        <div class="bg"></div>
        <el-row class="main-container">
            <el-col :lg="8" :xs="16" :md="10" :span="10">
                <div class="top">
                    <i class="iconfont icon-kaoshi"></i><span class="title">后台管理系统</span>
                </div>
                <div class="bottom">
                    <div class="container">
                        <p class="title">教师登录</p>
                        <el-form :label-position="labelPosition" label-width="80px" :model="teacher" :rules="rules" ref="loginForm" @keyup.enter.native="login()">
                            <el-form-item label="用户名">
                                <el-input v-model.number="teacher.username" placeholder="请输入用户名"></el-input>
                            </el-form-item>
                            <el-form-item label="密码">
                                <el-input v-model="teacher.password" placeholder="请输入密码" type='password'></el-input>
                            </el-form-item>
                            <div class="submit">
                                <el-button type="primary" class="row-login" @click="handleLogin">登录</el-button>
                            </div>
                            <div class="options">
                                <p class="find"><a href="javascript:;">找回密码</a></p>
                                <div class="register">
                                    <span>没有账号?</span>
                                    <span><a href="javascript:;">去注册</a></span>
                                </div>
                            </div>
                        </el-form>
                    </div>
                </div>
            </el-col>
        </el-row>

    </div>
</template>

<script>
    export default {
        name: "login",
        data() {
            return {
                role: 2,
                labelPosition: 'left',
                teacher: {
                    username: '',
                    password: ''
                },
                rules: {
                    username: [
                        { require:true,message:"用户名不能为空", trigger: 'blur' }
                    ],
                    password: [
                        { require:true,message:"密码不能为空", trigger: 'blur' }
                    ],
                }
            }
        },
        methods: {
            handleLogin() {
                this.$refs.loginForm.validate((valid) => {
                    if (valid) {
                        this.$axios.post("manage/login",this.teacher).then(res=>{
                            if(res.data.code==10001){
                                this.$message.error("用户名或密码错误");
                            }else {
                                //获得token和teacher对象，保存在sessionStorage或localStorage中
                                window.localStorage.setItem("teacher",JSON.stringify(res.data.teacher));//json对象转成字符串
                                window.localStorage.setItem("token",res.data.token);
                                this.$router.push({path:"/admin"});
                            }
                        })
                    } else {
                        return false;
                    }
                });
            },
            resetForm() {
                this.$refs.loginForm.resetFields();
            }
        }
    }
</script>

<style scoped>
    .remind {
        border-radius: 4px;
        padding: 10px 20px;
        display: flex;
        position: fixed;
        right: 20px;
        bottom: 50%;
        flex-direction: column;
        color: #606266;
        background-color: #fff;
        border-left: 4px solid #409eff;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)
    }
    .container {
        margin-bottom: 32px;
    }
    .container .el-radio-group {
        margin: 30px 0px;
    }
    a:link {
        color:#0d91f0;
        text-decoration:none;
    }
    #login {
        font-size: 14px;
        color: #000;
        background-color: #fff;
    }
    #login .bg {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        overflow-y: auto;
        height: 100%;
        background: url('../../assets/background.svg') center top / cover no-repeat;
        background-size: cover;
        background-color: #fff !important;
    }
    #login .main-container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 90vh;
    }
    #login .main-container .top {
        font-size: 30px;
        color: #0d91f0;
        display: flex;
        justify-content: center;
        margin-bottom: 40px;
    }
    #login .top .icon-kaoshi {
        font-size: 80px;
    }
    #login .top .title {
        margin-top: 20px;
    }
    #login .bottom {
        display:flex;
        justify-content: center;
        background-color:#fff;
        border-radius: 5px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    }
    #login .bottom .title {
        text-align: center;
        font-size: 30px;
    }
    .bottom .container .title {
        margin: 30px 0px;;
    }
    .bottom .submit .row-login {
        width: 100%;
        background-color: #04468b;
        border-color: #04468b;
        margin: 20px 0px 10px 0px;
        padding: 15px 20px;
    }
    .bottom .submit {
        display: flex;
        justify-content: center;
    }
    .footer {
        text-align: center;
    }
    .footer .msg1 {
        font-size: 18px;
        color: #fff;
        margin-bottom: 15px;
    }
    .footer .msg2 {
        font-size: 14px;
        color: #0d91f0;
        margin-top: 50px;
    }
    .footer .msg2 a{
        font-size: 14px;
        color: #0d91f0;
        margin-top: 50px;
    }
    .footer .msg2 a:hover{
        color: #075c7b;
    }
    .bottom .options {
        margin-bottom: 40px;
        color: #0d91f0;
        display: flex;
        justify-content: space-between;
    }
    .bottom .options > a {
        color: #0d91f0;
    }
    .bottom .options .register span:nth-child(1) {
        color: #8C8C8C;
    }
</style>