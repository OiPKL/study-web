import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import DogView from '../views/DogView.vue'
import CatView from '../views/CatView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  //요청에 따른 컴포넌트 매핑
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/dog',
      name: 'dog',
      component: DogView
    },
    {
      path: '/cat',
      name: 'cat',
      component: CatView
    },
  ]
})

export default router
