import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    alias: '/chat',
    name: 'Home',
    component: () => import('../views/Auth.vue'),
  },
  {
    path: '/chat/:id',
    name: 'ChatDetail',
    component: () => import('../views/Home.vue'),
  },
  {
    path: '/about',
    name: 'About',
    component: () => import('../views/About.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Auth.vue'),
    meta: { title: 'Đăng nhập vào zalo' }
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('../views/Auth.vue'),
    meta: { title: 'Đăng ký tài khoản zalo' }
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
