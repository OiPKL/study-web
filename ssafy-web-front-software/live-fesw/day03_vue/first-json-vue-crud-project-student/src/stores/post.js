import { ref } from "vue";
import { defineStore } from "pinia";

const initData = [
  { id: 1, title: "Post 1", content: "Content 1" },
  { id: 2, title: "Post 2", content: "Content 2" },
];

export const usePostStore = defineStore("post", () => {
  const posts = ref([...initData]);
  const currentPost = ref(null);
  const loading = ref(false);
  const error = ref(null);

  async function fetchPosts() {
    loading.value = true;
    try {
      // posts.value = [...initData];
    } catch (err) {
      error.value = err.message;
    } finally {
      loading.value = false;
    }
  }

  async function getPost(id) {
    loading.value = true;
    try {
      const index = posts.value.findIndex((p) =>  p.id == id);
      currentPost.value = posts.value[index];
      return currentPost.value;
    } catch (err) {
      error.value = err.message;
    } finally {
      loading.value = false;
    }
  }

  async function createPost(post) {
    try {
      const newPost = { ...post, id: posts.value.length + 1 };
      posts.value.push(newPost);
      return newPost;
    } catch (err) {
      error.value = err.message;
      throw err;
    }
  }

  async function updatePost(id, post) {
    try {
      const index = posts.value.findIndex((p) => p.id === id);
      if (index !== -1) {
        posts.value[index] = { ...post, id };
      }
      return posts.value.find(p => p.id === id);
    } catch (err) {
      error.value = err.message;
      throw err;
    }
  }

  async function deletePost(id) {
    try {
      const updatedPosts = posts.value.filter(post => post.id !== id);
      posts.value = updatedPosts;
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
