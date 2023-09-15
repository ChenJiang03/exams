<template>
    <div>
        <h2>修改</h2>
        <el-form  ref="form" :model="subject" label-width="80px">
            <el-form-item label="学科名称">
                <el-input v-model="subject.title"></el-input>
            </el-form-item>
            <el-form-item label="简介">
                <el-input type="textarea" v-model="subject.description"></el-input>
            </el-form-item>
            <el-form-item label="是否结束" >
                <el-radio-group v-model="subject.isCompleted">
                    <el-radio :label="true" >已结束</el-radio>
                    <el-radio :label="false" >未结束</el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="排序">
                <el-input v-model="subject.sort"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('form')">立即修改</el-button>
                <el-button @click="exit">取消</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "SubjectUpdate",
        data() {
            return {
                subject: {
                    title: '',
                    description: '',
                    sort:'',
                    isCompleted:''
                }
            };
        },
        created() {
            this.getSubject(this.$route.query.id)
        },
        methods: {
            getSubject(){
                var id=this.$route.query.id;
                console.log(id);
                this.$axios.get("manage/subject/update?id="+id).then(res=> {
                    this.subject = res.data.data;
                })
            },
            submitForm(formName){
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$axios.post("manage/subject/update",this.subject)
                            .then(res=>{
                                this.$router.push("/subject/list");
                            });
                        alert('修改完成');
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