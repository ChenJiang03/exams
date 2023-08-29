import Vue from 'vue'
import VueRouter from 'vue-router'
import login from "@/views/admin/login";

Vue.use(VueRouter)

const routes = [
  {
    path: '/admin/login',
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
  {
    path: '/',
    name: 'stuLogin',
    component: () => import('../views/stuLogin')
  },

]

const router = new VueRouter({
  routes
})

export default router
