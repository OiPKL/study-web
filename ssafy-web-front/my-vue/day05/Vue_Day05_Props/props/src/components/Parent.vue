<template>
    <div>
      <h2>Parent.Vue</h2>
      <!-- my-msg : HTML 속성 -->
      <ParentChild my-msg="HELLO"/>
    </div>
  </template>
  
  <script setup>
    import ParentChild from './ParentChild.vue'
    
  </script>
  
  <style scoped>
  </style>