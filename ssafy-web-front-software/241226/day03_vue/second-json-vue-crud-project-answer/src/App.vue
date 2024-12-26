// App.vue
<template>
  <div class="app">
    <header class="header">
      <nav class="nav">
        <router-link to="/" class="logo">SSAFY Blog</router-link>
        <div class="nav-links">
          <router-link to="/" class="nav-link">홈</router-link>
          <template v-if="isAuthenticated">
            <router-link to="/posts/create" class="nav-link">글쓰기</router-link>
            <button @click="handleLogout" class="nav-link logout-btn">로그아웃</button>
          </template>
          <template v-else>
            <router-link to="/login" class="nav-link">로그인</router-link>
            <router-link to="/register" class="nav-link">회원가입</router-link>
          </template>
        </div>
      </nav>
    </header>

    <main class="main">
      <router-view></router-view>
    </main>

    <footer class="footer">
      <p>&copy; 2024 SSAFY Blog. All rights reserved.</p>
    </footer>
  </div>
</template>

<style>
/* Reset CSS */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: Arial, sans-serif;
  line-height: 1.6;
  color: #333;
  background-color: #f5f5f5;
}

/* Layout */
.app {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

.header {
  background-color: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  padding: 1rem;
}

.nav {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.logo {
  font-size: 1.5rem;
  font-weight: bold;
  color: #2c3e50;
  text-decoration: none;
}

.nav-links {
  display: flex;
  gap: 1rem;
}

.nav-link {
  color: #2c3e50;
  text-decoration: none;
  padding: 0.5rem 1rem;
  border-radius: 4px;
  transition: background-color 0.3s;
}

.nav-link:hover {
  background-color: #f0f0f0;
}

.main {
  flex: 1;
  max-width: 1200px;
  margin: 0 auto;
  padding: 2rem 1rem;
  width: 100%;
}

.footer {
  background-color: #2c3e50;
  color: #fff;
  text-align: center;
  padding: 1rem;
  margin-top: auto;
}

/* Form Styles */
.form-group {
  margin-bottom: 1rem;
}

.form-group label {
  display: block;
  margin-bottom: 0.5rem;
  font-weight: bold;
}

.form-group input,
.form-group textarea {
  width: 100%;
  padding: 0.5rem;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 1rem;
}

.form-group textarea {
  min-height: 150px;
}

/* Button Styles */
button,
.create-btn,
.edit-btn,
.cancel-btn {
  display: inline-block;
  padding: 0.5rem 1rem;
  border: none;
  border-radius: 4px;
  font-size: 1rem;
  cursor: pointer;
  text-decoration: none;
  transition: background-color 0.3s;
}

button,
.create-btn {
  background-color: #42b983;
  color: #fff;
}

button:hover,
.create-btn:hover {
  background-color: #3aa876;
}

.edit-btn {
  background-color: #3498db;
  color: #fff;
}

.edit-btn:hover {
  background-color: #2980b9;
}

.delete-btn {
  background-color: #e74c3c;
  color: #fff;
}

.delete-btn:hover {
  background-color: #c0392b;
}

.cancel-btn {
  background-color: #95a5a6;
  color: #fff;
  margin-left: 0.5rem;
}

.cancel-btn:hover {
  background-color: #7f8c8d;
}

/* Post Styles */
.post-item {
  background-color: #fff;
  padding: 1rem;
  margin-bottom: 1rem;
  border-radius: 4px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.post-item h2 {
  margin-bottom: 0.5rem;
}

.post-item h2 a {
  color: #2c3e50;
  text-decoration: none;
}

.post-item h2 a:hover {
  color: #42b983;
}

.post-meta {
  font-size: 0.9rem;
  color: #666;
  margin-top: 0.5rem;
}

/* Comment Styles */
.comments {
  margin-top: 2rem;
}

.comment-form {
  margin-bottom: 1rem;
}

.comment-form textarea {
  width: 100%;
  padding: 0.5rem;
  border: 1px solid #ddd;
  border-radius: 4px;
  margin-bottom: 0.5rem;
  min-height: 100px;
}

.comment {
  background-color: #f9f9f9;
  padding: 1rem;
  margin-bottom: 1rem;
  border-radius: 4px;
}

.comment-actions {
  margin-top: 0.5rem;
}

/* Responsive Design */
@media (max-width: 768px) {
  .nav {
    flex-direction: column;
    gap: 1rem;
  }

  .nav-links {
    width: 100%;
    justify-content: center;
  }

  .post-actions {
    flex-direction: column;
    gap: 0.5rem;
  }

  .post-actions button,
  .post-actions a {
    width: 100%;
    text-align: center;
  }
}

.auth-form {
  max-width: 400px;
  margin: 2rem auto;
  padding: 2rem;
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.auth-form h1 {
  margin-bottom: 1.5rem;
  text-align: center;
}

.error-message {
  color: #e74c3c;
  margin-bottom: 1rem;
  padding: 0.5rem;
  background-color: #fdf0ef;
  border-radius: 4px;
}

.form-actions {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.link {
  color: #3498db;
  text-decoration: none;
}

.link:hover {
  text-decoration: underline;
}

.logout-btn {
  background: none;
  border: none;
  color: #2c3e50;
  cursor: pointer;
}

.logout-btn:hover {
  background-color: #f0f0f0;
}
</style>

<script setup>
import { storeToRefs } from "pinia";
import { useAuthStore } from "@/stores/auth";
import { useRouter } from "vue-router";

const router = useRouter();
const authStore = useAuthStore();
const { isAuthenticated } = storeToRefs(authStore);

const handleLogout = () => {
  authStore.logout();
  router.push("/login");
};
</script>
