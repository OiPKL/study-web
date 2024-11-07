<template>
    <div>
      <h2>Parent.Vue</h2>
      <!-- my-msg : HTML 속성 -->
      <ParentChild
        my-msg="HELLO 1"
        :dynamic-name="name"
        :dynamic-person="person"/>
    </div>
  </template>
  
  <script setup>
    import { ref } from 'vue'
    import ParentChild from './ParentChild.vue'
    
    const name = ref("Kim")
    const person = ref({
      name: "Kim",
      age: 19,
    })

  </script>