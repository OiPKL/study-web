<template>
  <div class="post-edit">
    <h1>게시글 수정</h1>
    <form v-if="currentPost" @submit.prevent="handleSubmit" class="post-form">
      <div class="form-group">
        <label for="title">제목</label>
        <input id="title" v-model="form.title" type="text" required />
      </div>

      <div class="form-group">
        <label for="content">내용</label>
        <textarea id="content" v-model="form.content" required></textarea>
      </div>

      <div class="form-actions">
        <button type="submit">수정</button>
        <router-link :to="`/posts/${currentPost.id}`" class="cancel-btn">취소</router-link>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { storeToRefs } from "pinia";
import { usePostStore } from "@/stores/post";

const route = useRoute();
const router = useRouter();
const postStore = usePostStore();
const { currentPost } = storeToRefs(postStore);
const form = ref({
  title: "",
  content: "",
});

onMounted(async () => {
  await postStore.getPost(route.params.id);
  if (currentPost.value) {
    form.value = {
      title: currentPost.value.title,
      content: currentPost.value.content,
    };
  }
});

const handleSubmit = async () => {
  try {
    await postStore.updatePost(currentPost.value.id, form.value);
    router.push(`/posts/${currentPost.value.id}`);
  } catch (err) {
    alert("게시글 수정 중 오류가 발생했습니다.");
  }
};
</script>
