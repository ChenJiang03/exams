<template>
    <div class="msg">
        <h2>修改</h2>
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
        name: "LevelsUpdate",
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
        created() {
            this.getLevel(this.$route.query.id)
        },
        methods: {
            getLevel(){
                var id=this.$route.query.id;
                console.log(id);
                this.$axios.get("levels/update?id="+id).then(res=> {
                    this.levels = res.data.data;
                })
            },
            submitForm(formName){
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$axios.post("levels/update",this.levels)
                            .then(res=>{
                                this.$router.push("/levels/list");
                            });
                        alert('修改完成');
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