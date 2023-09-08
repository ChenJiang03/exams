<template>
  <div>
    <el-table
        :data="pageInfo.list"
        style="width: 100%"
        v-loading="loadingList"
    >
      <el-table-column prop="id" label="ID"></el-table-column>
      <el-table-column prop="knowledgePoint" label="知识点"></el-table-column>
      <el-table-column prop="subject.title" label="类型"></el-table-column>
      <el-table-column prop="updateTime" label="更新时间"></el-table-column>

      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button @click="handleUpdate(scope.$index)">修改</el-button>
          <el-button @click="handleDelete(scope.$index)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        @current-change="handleRefreshData"
        background
        layout="prev, pager, next"
        :page-size="pageInfo.pageSize"
        :total="pageInfo.total">
    </el-pagination>
  </div>
</template>

<script>
  export default {
    name: "KnowledgeBulletListView",
    data() {
      return {
        pageInfo: {},
        knowledgeList: [],
        loadingList: false,
      }
    },
    created() {
      this.handleRefreshData(1);
    },
    methods: {
      handleRefreshData(pageNum) {
        this.$axios.get("manage/knowledgeBullet/list", {params: {pageNum: pageNum}})
            .then(res => {
              console.log(res);
              this.pageInfo = res.data.data;
            });
      },
      handleDelete(index) {
        //console.log(index);
        this.$confirm('此操作将永久删除该知识点, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          console.log(111);

          this.$axios.get("manage/knowledgeBullet/delete", {params: {id: this.knowledgeList[index].id}})
              .then(res => {
                console.log(res);
                console.log(2222222222);
                this.knowledgeList.splice(index, 1);
                this.handleRefreshData(1);
              })
        }).catch(() => {
        });

      }
    }
  }
</script>

<style scoped>

</style>