<template>
    <div>
      <h1>UserView</h1>
      <p>ㅎㅇ {{ userName }} 님</p>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  import { useRoute } from 'vue-router'

  const route = useRoute()
  
  console.log(route.params.username)
  const userName = ref(route.params.username)

  </script>
  