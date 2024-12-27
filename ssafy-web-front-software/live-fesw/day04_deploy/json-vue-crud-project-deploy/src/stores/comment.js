import { ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

export const useCommentStore = defineStore("comment", () => {
  const comments = ref([]);
  const error = ref(null);

  async function addComment(postId, comment) {
    try {
      const response = await axios.post("/comments", {
        ...comment,
        postId,
        userId: 1,
        createdAt: new Date().toISOString(),
      });
      return response.data;
    } catch (err) {
      error.value = err.message;
      throw err;
    }
  }

  async function updateComment(id, comment) {
    try {
      const response = await axios.put(`/comments/${id}`, {
        ...comment,
        updatedAt: new Date().toISOString(),
      });
      return response.data;
    } catch (err) {
      error.value = err.message;
      throw err;
    }
  }

  async function deleteComment(id) {
    try {
      await axios.delete(`/comments/${id}`);
    } catch (err) {
      error.value = err.message;
      throw err;
    }
  }

  return {
    comments,
    error,
    addComment,
    updateComment,
    deleteComment,
  };
});
