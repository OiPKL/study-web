import { createRouter, createWebHistory } from 'vue-router'
import UserView from '../views/UserView.vue'
import Profile from '../components/Profile.vue'
import PostList from '@/components/PostList.vue'
import PostDetail from '@/components/PostDetail.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/user/:username',
      name: 'user',
      component: UserView,
      beforeEnter: (to) => {
        const requestedUsername = to.params.username
        if (requestedUsername !== 'admin') {
          window.alert('현재 프로필 페이지는 admin만 접근 가능합니다.')
          return { path: '/' }
        }
      },
      children: [
        {
          path: 'profile',
          name: 'user-profile',
          component: Profile,
        },
        {
          path: 'posts',
          name: 'user-posts',
          component: PostList,
          children: [
            {
              path: ':id',
              name: 'post-detail',
              component: PostDetail
            }
          ]
        }
      ]
    }
  ]
})

export default router
