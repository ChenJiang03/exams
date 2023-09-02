import Vue from 'vue'
import VueRouter from 'vue-router'
import login from "@/views/login";
import teacherroutes from "./teacher"
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: login
  },

  {
    path: '/admin/login',
    component: () => import('../views/admin/login')
  },

  {
    path: '/admin',
    component: () => import('../views/admin/index')
  },
  teacherroutes,
  {
    path: '/student/index',
    component: () => import('../views/student/index')
  },
  {
    path: '/student/register',
    component: () => import('../views/student/register')
  },


]

const router = new VueRouter({
  routes
})

export default router
