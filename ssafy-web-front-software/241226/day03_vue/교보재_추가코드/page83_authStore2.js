// src/stores/auth.js
import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

export const useAuthStore = defineStore('auth', () => {
  // state
  const user = ref(null)
  const token = ref(localStorage.getItem('token') || null)

  // getters
  const isAuthenticated = computed(() => !!token.value)
  const getUser = computed(() => user.value)

  const login = async (credentials) => {
    try {
      const response = await axios.post('/api/login', credentials)
      const { token: newToken, user: userData } = response.data

      // 상태 업데이트
      token.value = newToken
      user.value = userData
      
      // localStorage에 토큰 저장
      localStorage.setItem('token', newToken)
      
      // axios 헤더 설정
      axios.defaults.headers.common['Authorization'] = `Bearer ${newToken}`

      return true
    } catch (error) {
      console.error('Login failed:', error)
      throw error
    }
  }

  const logout = () => {
    // 상태 초기화
    token.value = null
    user.value = null
    localStorage.removeItem('token')
    
    // axios 헤더에서 인증 정보 제거
    delete axios.defaults.headers.common['Authorization']
  }

  const initializeAuth = () => {
    const savedToken = localStorage.getItem('token')
    if (savedToken) {
      token.value = savedToken
      setAuthHeader(savedToken)
    }
  }

  return {
    // state
    user,
    token,
    
    // getters
    isAuthenticated,
    getUser,
    
    // actions
    login,
    logout,
    initializeAuth
  }
})

// src/composables/useAxios.js
import axios from 'axios'
import { useAuthStore } from '../stores/auth'

export const setupAxios = () => {
  // API 기본 URL 설정
  axios.defaults.baseURL = 'http://your-api-url'

  // 응답 인터셉터 설정
  axios.interceptors.response.use(
    response => respo