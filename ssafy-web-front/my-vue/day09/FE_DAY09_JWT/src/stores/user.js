import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_API_URL = `http://localhost:8080/api-user`

export const useUserStore = defineStore('user', () => {

  const loginUser = ref(null)

  const userLogin = function (id, password) {
    axios.post(`${REST_API_URL}/login`, {
      id: id,
      password: password,
    })
      .then((response) => {
        console.log(response)
        sessionStorage.setItem('access-token', response.data['access-token'])

        const token = response.data['access-token'].split('.')
        const name = JSON.parse(atob((token[1])))  // => JavaScript 객체 반환

        loginUser.value = name
        router.push({ name: 'boardList' })

        // 로그아웃 => 세션스토리지 비우기
        // 로그인 권한
        // headers 에 'access-token' 전달 필요
        // 1. FE -> navigation guard ~ 버튼 자체를 못 누르게
        // 2. BE -> filter interceptor ~ 데이터 전달을 막기
      })
      .catch((error) => {
        console.log(error)
        router.push({ name: 'home' })
      })
  }

  return { loginUser, userLogin, }
})
