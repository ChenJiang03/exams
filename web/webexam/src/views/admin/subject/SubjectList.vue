<template>
    <div>
        <h2>学科列表</h2>
        <el-col>
            <router-link to="/subject/add">添加</router-link>
        </el-col>
        <el-table
                :data="subject.list"
                style="width: 100%"
                :router="true"
        >
            <el-table-column prop="id" label="ID" ></el-table-column>
            <el-table-column prop="title" label="标题" ></el-table-column>
            <el-table-column prop="description" label="简介" ></el-table-column>
            <el-table-column prop="sort" label="排序" ></el-table-column>
            <el-table-column prop="startTime" label="开始时间" ></el-table-column>
            <el-table-column prop="endTime" label="结束时间" >
                <template slot-scope="scope">
                    <p>{{scope.row.isCompleted==1?scope.row.endTime:"---"}}</p >
                </template>
            </el-table-column>
            <el-table-column prop="isCompleted" label="是否结束" >
                <template slot-scope="scope">
                    <p>{{scope.row.isCompleted==1?"结束":"未结束"}}</p >
                </template>
            </el-table-column>
            <el-table-column label="操作" >
                <template slot-scope="scope">
                    <el-button class="update" @click="handleToUpdate(scope.row.id)">修改</el-button>
                    <el-button class="exit" @click="handleToDelete(scope.$index)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
                @current-change="handleRefreshDate"
                background
                layout="prev, pager, next"
                :page-size="subject.pageSize"
                :total="subject.total">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        name: "SubjectList",
        data(){
            return {
                subject:{},
                subjects:[],
            }
        },
        created() {
            this.handleRefreshDate(1);
        },
        methods:{
            handleRefreshDate(pageNum){
                this.$axios.get("manage/subject/list",{params:{pageNum:pageNum}})
                    .then(res=>{
                        this.subject = res.data.data;
                    });
            },
            handleToUpdate(id){
                this.$router.push({path:"/subject/update",query: { id: id }});
            },
            handleToDelete(index){
                const subjectsId = this.subjects[index].id;// 获取要删除的ID
                this.$confirm('是否删除?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.subjects.splice(index,1);
                    this.$axios.post("manage/subject/delete?id="+subjectsId).then(res=>{
                        this.handleRefreshDate();
                    })
                }).catch(() => {
                });

            }
        }
    }
</script>

<style scoped>
    .exit{
        padding-right: 10px;
        padding-left: 10px;
    }
    .update{
        padding-right: 10px;
        padding-left: 10px;
    }


</style>