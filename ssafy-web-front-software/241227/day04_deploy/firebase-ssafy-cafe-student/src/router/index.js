import { createRouter, createWebHistory } from 'vue-router'
import HomePage from '@/views/HomePage.vue'
import NewCafePage from '@/views/NewCafePage.vue'
import EditCafePage from '@/views/EditCafePage.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomePage,
    },
    {
      path: "/new",
      name: "new",
      component: NewCafePage,
    },
    {
      path: "/cafe/:id",
      name: "edit",
      component: EditCafePage,
    }
  ],
})

export default router
