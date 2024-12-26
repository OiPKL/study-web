import { ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

const BASE_URL = "http://localhost:3000"; // API 서버 주소

export const usePostStore = defineStore("post", () => {
  const posts = ref([]);
  const currentPost = ref(null);
  const loading = ref(false);
  const error = ref(null);

  async function fetchPosts() {
    loading.value = true;
    try {
      const response = await axios.get(BASE_URL + "/posts");
      posts.value = response.data;
    } catch (err) {
      error.value = err.message;
    } finally {
      loading.value = false;
    }
  }

  async function getPost(id) {
    loading.value = true;
    try {
      const response = await axios.get(`${BASE_URL}/posts/${id}`);
      currentPost.value = response.data;
    } catch (err) {
      error.value = err.message;
    } finally {
      loading.value = false;
    }
  }

  async function createPost(post) {
    try {
      const response = await axios.post(
        BASE_URL + "/posts",
        {
          ...post,
          userId: authStore.user.id,
        },
        {
          headers: {
            Authorization: `Bearer ${authStore.token}`,
          },
        }
      );
      posts.value.push(response.data);
      return response.data;
    } catch (err) {
      error.value = err.message;
      throw err;
    }
  }

  async function updatePost(id, post) {
    try {
      const response = await axios.put(`${BASE_URL}/posts/${id}`, {
        ...post,
      });
      const index = posts.value.findIndex((p) => p.id === id);
      if (index !== -1) {
        posts.value[index] = response.data;
      }
      return response.data;
    } catch (err) {
      error.value = err.message;
      throw err;
    }
  }

  async function deletePost(id) {
    try {
      await axios.delete(`${BASE_URL}/posts/${id}`);
      posts.value = posts.value.filter((post) => post.id !== id);
    } catch (err) {
      error.value = err.message;
      throw err;
    }
  }

  return {
    posts,
    currentPost,
    loading,
    error,
    fetchPosts,
    getPost,
    createPost,
    updatePost,
    deletePost,
  };
});
