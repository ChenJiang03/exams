<template>
    <div>
        <h2>等级列表</h2>
        <el-col>
            <router-link to="/levels/add">添加</router-link>
        </el-col>
        <el-table
                :data="level.list"
                style="width: 100%"
                :router="true"
        >
            <el-table-column prop="id" label="ID" ></el-table-column>
            <el-table-column prop="level" label="等级" ></el-table-column>
            <el-table-column prop="score" label="分值" ></el-table-column>
            <el-table-column label="操作" >
                <template slot-scope="scope">
                    <el-button @click="handleToUpdate(scope.row.id)">修改</el-button>
                    <el-button @click="handleToDelete(scope.$index)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
                @current-change="handleRefreshDate"
                background
                layout="prev, pager, next"
                :page-size="level.pageSize"
                :total="level.total">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        name: "LevelsList",
        data(){
            return {
                level:{},
                levels:[],
            }
        },
        created() {
            this.handleRefreshDate(1);
        },
        methods:{
            handleRefreshDate(pageNum){
                this.$axios.get("levels/list",{params:{pageNum:pageNum}})
                    .then(res=>{
                        this.level = res.data.data;
                    });
            },
            handleToUpdate(id){
                this.$router.push({path:"/levels/update",query: { id: id }});
            },
            handleToDelete(index){
                const levelsId = this.levels[index].id;// 获取要删除的ID
                this.$confirm('是否删除?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.levels.splice(index,1);
                    this.$axios.post("levels/delete?id="+levelsId).then(res=>{
                        this.handleRefreshDate();
                    })
                }).catch(() => {
                });

            }

        }
    }
</script>

<style scoped>

</style>