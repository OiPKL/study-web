<template>
  <div class="post-detail">
    <div v-if="loading">로딩 중...</div>
    <div v-else-if="error">에러: {{ error }}</div>
    <template v-else-if="currentPost">
      <article class="post">
        <h1>{{ currentPost.title }}</h1>
        <div class="post-meta">작성일: {{ new Date(currentPost.createdAt).toLocaleDateString() }}</div>
        <div class="post-content">
          {{ currentPost.content }}
        </div>
        <div class="post-actions">
          <router-link :to="`/posts/${currentPost.id}/edit`" class="edit-btn">수정</router-link>
          <button @click="handleDelete" class="delete-btn">삭제</button>
        </div>
      </article>

      <section class="comments">
        <h2>댓글</h2>
        <form @submit.prevent="handleCommentSubmit" class="comment-form">
          <textarea v-model="newComment" placeholder="댓글을 작성하세요"></textarea>
          <button type="submit">댓글 작성</button>
        </form>

        <div class="comment-list">
          <div v-for="comment in currentPost.comments" :key="comment.id" class="comment">
            <p>{{ comment.content }}</p>
            <div class="comment-meta">작성일: {{ new Date(comment.createdAt).toLocaleDateString() }}</div>
            <div class="comment-actions">
              <button @click="handleCommentDelete(comment.id)">삭제</button>
            </div>
          </div>
        </div>
      </section>
    </template>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { storeToRefs } from "pinia";
import { usePostStore } from "@/stores/post";
import { useCommentStore } from "@/stores/comment";

const route = useRoute();
const router = useRouter();
const postStore = usePostStore();
const commentStore = useCommentStore();
const { currentPost, loading, error } = storeToRefs(postStore);
const newComment = ref("");

onMounted(() => {
  postStore.getPost(route.params.id);
});

const handleDelete = async () => {
  if (confirm("정말 삭제하시겠습니까?")) {
    try {
      await postStore.deletePost(currentPost.value.id);
      router.push("/");
    } catch (err) {
      alert("삭제 중 오류가 발생했습니다.");
    }
  }
};

const handleCommentSubmit = async () => {
  if (!newComment.value.trim()) return;

  try {
    await commentStore.addComment(currentPost.value.id, {
      content: newComment.value,
    });
    newComment.value = "";
    await postStore.getPost(route.params.id);
  } catch (err) {
    alert("댓글 작성 중 오류가 발생했습니다.");
  }
};

const handleCommentDelete = async (commentId) => {
  if (confirm("댓글을 삭제하시겠습니까?")) {
    try {
      await commentStore.deleteComment(commentId);
      await postStore.getPost(route.params.id);
    } catch (err) {
      alert("댓글 삭제 중 오류가 발생했습니다.");
    }
  }
};
</script>
