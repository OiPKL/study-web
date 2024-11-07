<template>
    <div>
      <h4>ParentGrandChild.Vue</h4>
      <p>{{ myMsg }}</p>
    </div>
  </template>
  
  <script setup>
    defineProps({
      myMsg: String
    })
  </script>
  
  <style scoped>
  </style>