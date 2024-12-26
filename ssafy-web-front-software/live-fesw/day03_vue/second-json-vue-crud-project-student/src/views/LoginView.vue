<template>
  <div class="auth-form">
    <h1>로그인</h1>
    <form @submit.prevent="handleSubmit">
      <div class="form-group">
        <label for="email">이메일</label>
        <input id="email" v-model="form.email" type="email" required />
      </div>

      <div class="form-group">
        <label for="password">비밀번호</label>
        <input id="password" v-model="form.password" type="password" required />
      </div>

      <div v-if="error" class="error-message">{{ error }}</div>

      <div class="form-actions">
        <button type="submit">로그인</button>
        <router-link to="/register" class="link">회원가입</router-link>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { storeToRefs } from "pinia";
import { useAuthStore } from "@/stores/auth";

const router = useRouter();
const authStore = useAuthStore();
const { error } = storeToRefs(authStore);

const form = ref({
  email: "",
  password: "",
});

const handleSubmit = async () => {
  try {
    await authStore.login(form.value);
    router.push("/");
  } catch (err) {
    // Error is handled in the store
  }
};
</script>
