import Vue from 'vue'
import VueRouter from 'vue-router'
import login from "@/views/login";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: login
  },
  {
    path: '/admin/index',
    name: 'index',
    component: () => import('../views/admin/index')
  },
  {
    path: '/student/index',
    name: 'index',
    component: () => import('../views/student/index')
  },


]

const router = new VueRouter({
  routes
})

export default router
