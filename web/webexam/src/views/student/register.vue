<template>
    <div class="box">
        <div class="register">
            <footer>注册</footer>
            <el-form ref="form" :model="form" :rules="rules"  label-width="30px" class="from">
                <el-form-item label="">
                    <el-input prefix-icon="el-icon-user" placeholder="注册的账号" v-model.number="form.name"></el-input>
                </el-form-item>
                <el-form-item label="">
                    <el-input maxlength="5" prefix-icon="el-icon-film" placeholder="验证码" v-model.number="form.verify" class="inputtow"></el-input>
                </el-form-item>
                <el-form-item label="" prop="psw">
                    <el-input autocomplete="off" prefix-icon="el-icon-lock" placeholder="至少6位字母和数字" show-password v-model.number="form.psw"></el-input>
                </el-form-item>
                <el-form-item label="" prop="pswok">
                    <el-input autocomplete="off" prefix-icon="el-icon-lock" placeholder="至少6位字母和数字" show-password v-model.number="form.pswok"></el-input>
                </el-form-item>
                <el-form-item label=""  prop="email">
                    <el-input validate-event prefix-icon="el-icon-message" placeholder="邮箱地址" v-model="form.email"></el-input>
                </el-form-item>
            </el-form>
            <div class="buttonVerify">
                <el-button type="primary" :disabled='isforbidden' @click="verificationcode">获取验证码</el-button>
            </div>
            <el-button type="primary" :round=false :plain=false class="buttonres" @click="reg('form')">注册</el-button>
            <div class="login">已有账号，
                <router-link to="/login">登录</router-link>
                <span style="margin-left: 10%; font-size:13px">注册即代表您已阅读并同意《使用协议》</span>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "register",
        data() {
            return {
                isforbidden: false,
                form: {
                    name: '',
                    verify: '',
                    psw: '',
                    pswok: '',
                    email: ""
                },
            }
        },
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
        width: 65%;
    }

    .buttonVerify{
        position: absolute;
        left: 64%;
        top: 31%;
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