// src/components/CreateArticle.vue
<script setup>
import { ref } from "vue";
import axios from "axios";

const title = ref("");
const content = ref("");
const error = ref("");

const createArticle = async () => {
  try {
    // localStorage에서 토큰 가져오기
    const token = localStorage.getItem("token");

    // 요청 헤더에 토큰 설정
    const response = await axios.post(
      "/api/articles",
      {
        title: title.value,
        content: content.value,
      },
      {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      }
    );

    // 성공 시 입력 필드 초기화
    title.value = "";
    content.value = "";

    return response.data;
  } catch (err) {
    error.value = "게시글 작성에 실패했습니다.";
  }
};
</script>

<template>
  <form @submit.prevent="createArticle">
    <input v-model="title" type="text" placeholder="제목" />
    <textarea v-model="content" placeholder="내용"></textarea>
    <button type="submit">글 작성</button>
    <p v-if="error" class="error">{{ error }}</p>
  </form>
</template>
