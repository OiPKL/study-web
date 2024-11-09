<template>
    <div v-if="post">
      <h3>게시글 상세 정보</h3>
      <p>제목: {{ post.title }}</p>
      <p>내용: {{ post.content }}</p>
    </div>
  </template>
  
  <script setup>
  import { computed } from 'vue'
  import { useRoute } from 'vue-router'
  
  const props = defineProps({
    posts: {
      type: Array,
      required: true
    }
  })
  
  const route = useRoute()
  const post = computed(() => props.posts.find(p => p.id === Number(route.params.id)))
  </script>