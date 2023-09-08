<template>
  <div>
    <el-form :model="knowledgeBullet" :rules="rules" ref="knowledgeBulletForm" label-width="100px" class="demo-ruleForm">

      <el-form-item label="知识点" prop="knowledgePoint">
        <el-input v-model="knowledgeBullet.knowledgePoint"></el-input>
      </el-form-item>
      <el-form-item label="对应科目" prop="subject">
        <el-select v-model="knowledgeBullet.subjectId">
          <el-option :label="subject.title" :value="subject.id"
                     v-for="(subject,index) in subjects"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm">添加</el-button>
        <el-button @click="resetForm('knowledgeBulletForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "QuestionAddView",
  data() {
    return {
      subjects: [],
      knowledgeBullet: {
        subjectId: '',
      },
      rules: {
        knowledgePoint: [
          {required: true, message: '请输入知识点名称', trigger: 'blur'},
          {min: 2, max: 30, message: '长度在 2 到 30 个字符', trigger: 'blur'}
        ]
      }
    };
  },
  created() {
    this.getSubjects();
  },
  methods: {
    getSubjects() {
      this.$axios.get("manage/subject/list")
          .then(res => {
            this.subjects = res.data.data;
            //将添加知识点时候的科目默认值设置为第一个科目
            this.knowledgeBullet.subjectId = this.subjects[0].id;
          });
    },
    submitForm() {
      //this.$refs["questionForm"].validate((valid) => {
      //validate()方法表示对表单进行一遍验证，匿名函数的参数valid为验证的结果，如果所有验证都通过true，有一个不通过false
      this.$refs.knowledgeBulletForm.validate((valid) => {
        if (valid) {
          //axios提交form表单数据
          //this.$axios.post("http://localhost:8080/manage/question/insert",this.question,{params:{}})
          this.$axios.post("manage/knowledgeBullet/add", this.knowledgeBullet)
              .then(res => {
                this.$router.push("list");
              });
        } else {
          console.log("验证失败");
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

<style scoped>

</style>