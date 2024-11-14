import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import AboutView from '@/views/AboutView.vue'
import KakaoView from '@/views/KakaoView.vue'
import TmdbView from '@/views/TmdbView.vue'
import WeatherView from '@/views/WeatherView.vue'

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
      path: '/kakao',
      name: 'kakao',
      component: KakaoView,
    },
    {
      path: "/tmdb",
      name: "tmdb",
      component: TmdbView,
      children: [
        {
          path: "popular",
          name: "tmdbPopular",
          component: TmdbPopular
        },
        {
          path: "toprated",
          name: "tmdbTopRated",
          component: TmdbTopRated
        }
      ]
    },
    {
      path: '/weather',
      name: 'weather',
      component: WeatherView,
    },
  ],
})

export default router
