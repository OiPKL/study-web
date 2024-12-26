// axios 인스턴스 생성
const instance = axios.create({
  baseURL: "/api" // "https://localhost:5174/api",
  timeout: 5000,
    //   headers: {
    //     Authorization: "Bearer YOUR_TOKEN_HERE",
    //   },
});

// 요청 인터셉터를 추가하여 헤더 설정
instance.interceptors.request.use(config => {
    // 요청을 받을 때 마다 해당 함수가 실행됨
    const token = localStorage.getItem('token');
    if (token){
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
});

// axios 인스턴스 내보내기
export { instance as authApi };


// axios 인스턴스 가져오기
import { authApi } from './api';

// 사용
authApi.get('/users');
authApi.post('/login', { username, password });




import { useAuthStore } from '@/stores/authStore'; 

// 요청 인터셉터를 추가하여 헤더 설정
instance.interceptors.request.use(config => {
    const authStore = useAuthStore();
    const token = authStore.token; // authStore에서 토큰 가져오기
    
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
}, error => {
    return Promise.reject(error);
});