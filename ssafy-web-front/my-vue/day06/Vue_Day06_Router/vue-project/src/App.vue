<template>
  <div>
    <h2>App.vue</h2>
  </div>
  <nav>
    <RouterLink to="/">Home</RouterLink> | 
    <RouterLink to="/about">about</RouterLink> | 
    <RouterLink :to="{name: 'home'}">HomeName</RouterLink> | 
    <RouterLink :to="{name: 'about'}">aboutName</RouterLink> | 
    <RouterLink :to="{name: 'user', params: {id: 'ssafy1'}}">User1</RouterLink> | 
    <RouterLink :to="{name: 'user', params: {id: 'ssafy2'}}">User2</RouterLink> | 
    <RouterLink :to="{name: 'login'}">Login</RouterLink> | 
    <RouterLink :to="{name: 'board'}">Board</RouterLink>
  </nav>

  <RouterView/>
</template>

<script setup>

</script>

<style scoped>

</style>