<template>
    <div>
      <p>PostList.vue</p>
      <ul>
        <li v-for="post in posts" :key="post.id">
          <RouterLink :to="{ name: 'post-detail', params: { username: 'admin', id: post.id }}">
            {{ post.title }}
          </RouterLink>
        </li>
      </ul>
      <RouterView :posts="posts" />
    </div>
  </template>
  
  <script setup>
  
  const props = defineProps({
    posts: {
      type: Array,
      required: true
    }
  })
  </script>