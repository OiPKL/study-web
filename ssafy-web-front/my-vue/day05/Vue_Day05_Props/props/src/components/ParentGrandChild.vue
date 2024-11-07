<template>
    <div>
      <h4>ParentGrandChild.Vue</h4>
      <p>{{ myMsg }}</p>
      <p>{{ dynamicName }}</p>
      <p>{{ dynamicPerson }}</p>
    </div>
  </template>
  
  <script setup>
    const props = defineProps({
      myMsg: String,
      dynamicName: String,
      dynamicPerson: Object,
    })
    
  </script>