<template>
  <h2>App.vue</h2>
  <MyComponent></MyComponent>
  <my-component></my-component>
</template>

<script setup>
  // import MyComponent from './components/MyComponent.vue'; // 상대경로
  import MyComponent from '@/components/MyComponent.vue'; // 절대경로
</script>

<style scoped>

</style>