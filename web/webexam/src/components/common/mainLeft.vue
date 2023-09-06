<!--左边下拉导航栏-->
<template>
  <div id="left">
    <el-menu
      unique-opened
      active-text-color="#000"
      text-color="#fff"
      :default-active="this.$route.path"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      :collapse="flag"
      background-color="#2f9e9a"
      menu-trigger="click" router>
      <el-submenu v-for="(item,index) in menu" :index='item.index' :key="index">
        <template slot="title">
          <div class="left-width">
            <i class="iconfont"></i>
<!--            :class="item.icon"-->
            <span slot="title" class="title">{{item.title}}</span>
          </div>
        </template>
        <el-menu-item-group v-for="(list,index1) in item.content" :key="index1">
          <el-menu-item @click="handleTitle(item.index)" :index="list.path" v-if="list.item1 != null">{{list.item1}}</el-menu-item>
          <el-menu-item @click="handleTitle(item.index)" :index="list.path" v-if="list.item2 != null">{{list.item2}}</el-menu-item>
          <el-menu-item @click="handleTitle(item.index)" :index="list.path" v-if="list.item3 != null">{{list.item3}}</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>

export default {
  name: "mainLeft",
  data() {
    return {
      menu: [
        {title:'教师管理',index:'1',content:[{item1:'教师列表',path:"/admin/teacher/list"},{item2:'添加教师',path:"/admin/teacher/add"}]},
        {title:'试卷管理',index:'2',content:{item2:''}},
        {title:'学生管理',index:'3',content:{item3:''}},

      ],
    }
  },

}
</script>

<style>
.el-menu-vertical-demo .el-submenu__title {
  overflow: hidden;
}
.left-width .iconfont {
  font-size: 18px;
  color: #fff;
}
.left-width {
  width: 160px;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  min-height: 650px;
}
#left {
  height:92vh;
  background-color: #2f9e9a;
  z-index: 0;
  transition: all 0.5s ease-out;
}
#left .el-menu-vertical-demo .title {
  color: #fff;
  font-size: 16px;
  font-weight: bold;
  margin-left: 14px;
  transition: all 0.5s ease-out;
}
.el-submenu {
  border-bottom: 1px solid #eeeeee0f !important;
}
.el-submenu__title:hover {
  background-color: #fff;
}
.el-submenu__title i {
    color: #fbfbfc !important;
}
</style>
