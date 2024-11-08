import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AboutView from '../views/AboutView.vue'
import UserView from '../views/UserView.vue'
import LoginView from '../views/LoginView.vue'
import BoardView from '../views/BoardView.vue'
import BoardList from '../components/board/BoardList.vue'
import BoardCreate from '../components/board/BoardCreate.vue'

const isAuth = true
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/about',
      name: 'about',
      component: AboutView,
    },
    {
      path: '/user/:id',      // 동적라우팅
      name: 'user',
      component: UserView,
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView,
      beforeEnter: (to, from) => {
        if (isAuth) {
          console.log("로그인완료")
          return { name: 'home' }
        }
      }
    },
    {
      path: '/board',
      name: 'board',
      component: BoardView,
      children: [
        {
          path: '',         // '/' X
          name: 'boardList',
          component: BoardList,
        },
        {
          path: 'create',   // '/create' X
          name: 'boardCreate',
          component: BoardCreate,
        },
      ]
    },
  ],
})

router.beforeEach((to, from) => {
  // console.log(to)
  // console.log(from)

  if(!isAuth && to.name !== 'login'){
    console.log("로그인하세요")
    return {name: 'login'}
  }
})

export default router
