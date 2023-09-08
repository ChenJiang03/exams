<template>
    <div>
        <h2>学科列表</h2>
        <el-col>
            <router-link to="/subject/add">添加</router-link>
        </el-col>
        <el-table
                :data="subjects"
                style="width: 100%"
                :router="true"
        >
            <el-table-column prop="id" label="ID" ></el-table-column>
            <el-table-column prop="title" label="标题" ></el-table-column>
            <el-table-column prop="description" label="简介" ></el-table-column>
            <el-table-column prop="sort" label="排序" ></el-table-column>
            <el-table-column prop="startTime" label="开始时间" ></el-table-column>
            <el-table-column prop="isCompleted" label="是否结束" >
                <template slot-scope="scope">
                    <p>{{scope.row.isCompleted==1?"结束":"未结束"}}</p >
                </template>
            </el-table-column>
            <el-table-column label="操作" >
                <template slot-scope="scope">
                    <el-button @click="handleToUpdate(scope.row.id)">修改</el-button>
                    <el-button @click="handleToDelete(scope.$index)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
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
            this.handleRefreshDate();
        },
        methods:{
            handleRefreshDate(){
                this.$axios.get("manage/subject/list")
                    .then(res=>{
                        this.subjects = res.data.data;
                    });
            }
        }
    }
</script>

<style scoped>

</style>