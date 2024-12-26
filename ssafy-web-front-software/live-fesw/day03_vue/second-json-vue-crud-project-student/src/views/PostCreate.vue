<template>
  <div class="post-create">
    <h1>새 게시글 작성</h1>
    <form @submit.prevent="handleSubmit" class="post-form">
      <div class="form-group">
        <label for="title">제목</label>
        <input id="title" v-model="form.title" type="text" required />
      </div>

      <div class="form-group">
        <label for="content">내용</label>
        <textarea id="content" v-model="form.content" required></textarea>
      </div>

      <div class="form-actions">
        <button type="submit">작성</button>
        <router-link to="/" class="cancel-btn">취소</router-link>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { usePostStore } from "@/stores/post";

const router = useRouter();
const postStore = usePostStore();
const form = ref({
  title: "",
  content: "",
});

const handleSubmit = async () => {
  try {
    const post = await postStore.createPost(form.value);
    router.push(`/posts/${post.id}`);
  } catch (err) {
    alert("게시글 작성 중 오류가 발생했습니다.");
  }
};
</script>
