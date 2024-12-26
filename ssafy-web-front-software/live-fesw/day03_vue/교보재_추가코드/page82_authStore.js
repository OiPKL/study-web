// stores/auth.js
import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useAuthStore = defineStore("auth", () => {
  const token = ref(localStorage.getItem("token") || null);

  const isLoggedIn = computed(() => !!token.value);

  const login = (newToken) => {
    token.value = newToken;
    localStorage.setItem("token", newToken);
  };

  const logout = () => {
    token.value = null;
    localStorage.removeItem("token");
  };

  return {
    token,
    isLoggedIn,
    login,
    logout,
  };
});

// 컴포넌트에서 사용
const auth = useAuthStore();

// 로그인
auth.login("your-token-here");

// 토큰 확인
console.log(auth.token);
console.log(auth.isLoggedIn);

// 로그아웃
auth.logout();
