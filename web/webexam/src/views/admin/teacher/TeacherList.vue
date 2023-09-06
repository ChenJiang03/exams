<template>
    <div>
        <el-table
                :data="teachers"
                style="width: 100%"
                :router="true"
        >
            <el-table-column prop="id" label="ID" ></el-table-column>
            <el-table-column prop="name" label="姓名" ></el-table-column>
            <el-table-column label="头像" >
                <template slot-scope="scope">
                    <img :src="'http://localhost:8081/static/uploadImages/'+scope.row.pic" style="max-width: 100px">
                </template>
            </el-table-column>
            <el-table-column prop="questionCount" label="出题数量" ></el-table-column>

            <el-table-column label="操作" >
                <template slot-scope="scope">
                    <el-button @click="handleToUpdate(scope.row.id)">修改</el-button>
                    <el-button @click="handleDelete(scope.$index)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>

</template>

<script>
    export default {
        name: "TeacherList",
        data(){
            return {
                teacher:{},
                teachers:[],
            }
        },
        created() {
            this.handleList();
        },
        methods:{
            handleToUpdate(id){
                this.$router.push({path:"/admin/teacher/update",query: { id: id }});
            },
            handleList(){
                this.$axios.get("manage/teacher/list")
                    .then(res=>{
                        this.teachers = res.data.data;
                    });
            },
            handleDelete(index){
                const teacherId = this.teachers[index].id;// 获取要删除教师的ID
                this.$confirm('此操作将删除该教师, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.teachers.splice(index,1);
                    this.$axios.post("manage/teacher/delete?id="+teacherId).then(res=>{
                        this.handleList();
                    })
                }).catch(() => {
                });

            }
        }
    }
</script>

<style scoped>
h1{
    margin-left: 600px;
}
</style>