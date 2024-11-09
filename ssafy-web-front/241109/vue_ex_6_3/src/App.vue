
<template>
  <div>
    <header>
      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink :to="{ name: 'user', params: {'username': username } }">User</RouterLink>
      </nav>
    </header>
    <RouterView />
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { RouterLink, RouterView } from 'vue-router'

const username = ref(route.params.username || 'admin')
</script>

<style scoped>
</style>
