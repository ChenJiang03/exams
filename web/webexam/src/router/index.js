import Vue from 'vue'
import VueRouter from 'vue-router'
import login from "@/views/login";
import teacherroutes from "./teacher"
import knowledgeBulletRouters from "./knowledgeBullet";
import questionTypeRouters from './questionType'
import levelsroutes from "./levels"
import subjectroutes from "./subject"

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
    component: () => import('../views/admin/index'),
  },
    teacherroutes,
    questionTypeRouters,
    levelsroutes,
    subjectroutes,
  {
    path: '/student/index',
    component: () => import('../views/student/index')
  },
  {
    path: '/student/register',
    component: () => import('../views/student/register')
  },
  knowledgeBulletRouters


]

const router = new VueRouter({
  routes
})

export default router
