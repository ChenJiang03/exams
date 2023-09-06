<template>
    <div class="msg">
        <h2>添加</h2>
        <el-form :model="levels" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="等级名称" prop="level">
                <el-input v-model="levels.level" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="分值" prop="score">
                <el-input v-model.number="levels.score"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>

    </div>
</template>

<script>
    export default {
        name: "LevelsAdd",
        data() {
            var checkScore = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('分值不能为空'));
                }
                setTimeout(() => {
                    if (!Number.isInteger(value)) {
                        callback(new Error('请输入数字值'));
                    } else {
                        callback();
                    }
                }, 1000);
            };
            var checkLevel = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入等级名称'));
                } else {
                    callback();
                }
            };
            return {
                levels: {
                    level: '',
                    score: ''
                },
                rules: {
                    level: [
                        { validator: checkLevel, trigger: 'blur' }
                    ],
                    score: [
                        { validator: checkScore, trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$axios.post("levels/add",this.levels)
                            .then(res=>{
                                this.$route.push("/levels/list");
                            });
                        alert('添加完成');
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>