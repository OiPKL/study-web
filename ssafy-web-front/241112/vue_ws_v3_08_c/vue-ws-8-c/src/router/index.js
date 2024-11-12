import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import BoardView from '@/views/BoardView.vue'
import BoardList from '@/components/BoardList.vue'
import BoardCreate from '@/components/BoardCreate.vue'
import BoardUpdate from '@/components/BoardUpdate.vue'
import BoardDetail from '@/components/BoardDetail.vue'
import BoardSearchInput from '@/components/BoardSearchInput.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/board',
      name: 'board',
      component: BoardView,
      children: [
        {
          path: "",
          name: "boardList",
          component: BoardList,
        },
        {
          path: ":id",
          name: "boardDetail",
          component: BoardDetail,
        },
        {
          path: "create",
          name: "boardCreate",
          component: BoardCreate,
        },
        {
          path: "update",
          name: "boardUpdate",
          component: BoardUpdate,
        },
        {
          path: "search",
          name: "boardSearchInput",
          component: BoardSearchInput,
        },
      ]
    },
  ]
})

export default router
