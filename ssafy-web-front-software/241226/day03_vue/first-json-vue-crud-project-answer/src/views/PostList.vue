<template>
  <div class="post-list">
    <h1>게시글 목록</h1>
    <router-link to="/posts/create" class="create-btn">새 게시글 작성</router-link>

    <div v-if="loading">로딩 중...</div>
    <div v-else-if="error">에러: {{ error }}</div>
    <div v-else>
      <article v-for="post in posts" :key="post.id" class="post-item">
        <h2>
          <router-link :to="`/posts/${post.id}`">{{ post.title }}</router-link>
        </h2>
        <p>{{ post.content }}</p>
      </article>
    </div>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { storeToRefs } from "pinia";
import { usePostStore } from "@/stores/post";

const postStore = usePostStore();
const { posts, loading, error } = storeToRefs(postStore);

onMounted(() => {
  postStore.fetchPosts();
});
</script>
