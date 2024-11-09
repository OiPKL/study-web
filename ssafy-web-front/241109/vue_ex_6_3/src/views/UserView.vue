<template>
  <div>
    <h2>User</h2>
    <p>Username: {{ username }}</p>
    <RouterLink :to="{ name: 'user-profile', params: { username: username } }">프로필</RouterLink>
    <RouterLink :to="{ name: 'user-posts', params: { username: username } }">작성한 게시글</RouterLink>
    <hr/>
    <RouterView :posts="posts"/>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const username = ref(route.params.username || 'admin')

const posts = ref([
    { id: 1, title: '첫 번째 게시글', content: '첫 번째 게시글 내용' },
    { id: 2, title: '두 번째 게시글', content: '두 번째 게시글 내용' },
    { id: 3, title: '세 번째 게시글', content: '세 번째 게시글 내용' }
])
</script>