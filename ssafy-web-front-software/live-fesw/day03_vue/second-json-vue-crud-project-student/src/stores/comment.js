import { ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

export const useCommentStore = defineStore("comment", () => {
  const comments = ref([]); // 댓글 목록을 저장하는 배열
  const error = ref(null);

  // TODO: 댓글을 불러오는 API 호출
  async function fetchComments(/* ... */) {
    try {
      const response = await axios.get(/* ... */);
      /* ... */
    } catch (err) {
      error.value = err.message;
    }
  }

  // TODO: 댓글을 생성하는 API 호출
  async function addComment(/* ... */) {
    try {
      const response = await axios.post(/* ... */, {
        /* ... */
        createdAt: new Date().toISOString(),
      });
      /* ... */
      return response.data;
    } catch (err) {
      error.value = err.message;
      throw err;
    }
  }
  // TODO: 댓글을 수정하는 API 호출
  async function updateComment(id, comment) {
    try {
      const response = await axios.put(/* ... */, {
        /* ... */
        updatedAt: new Date().toISOString(),
      });
      /* ... */
      return response.data;
    } catch (err) {
      error.value = err.message;
      throw err;
    }
  }

  // TODO: 댓글을 삭제하는 API 호출
  async function deleteComment(/* ... */) {
    try {
      await axios.delete(/* ... */);
      /* ... */
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
