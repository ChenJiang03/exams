<template>
  <div id="nav">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item class="title">{{active.title}}</el-breadcrumb-item>
      <el-breadcrumb-item v-if="active.item1 != null">{{active.item1}}</el-breadcrumb-item>
      <el-breadcrumb-item v-if="active.item2 != null">{{active.item2}}</el-breadcrumb-item>
      <el-breadcrumb-item v-if="active.item3 != null">{{active.item3}}</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>

<script>
export default {
  name: 'navigator',
  data() {
    return {
      active: [],
      index1: null,
    }
  },

}
</script>

<style scoped>
#nav .el-breadcrumb {
  height: 60px;
  line-height: 60px;
  padding-left: 20px;
}
#nav .el-breadcrumb .title{
  font-weight: bold;
}
</style>
