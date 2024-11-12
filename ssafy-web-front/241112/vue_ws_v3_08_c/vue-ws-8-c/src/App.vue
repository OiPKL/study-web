<template>
    <div class="container">
      <header>
        <nav>
          <RouterLink :to="{name: 'home'}">Home</RouterLink> |
          <RouterLink :to="{name: 'boardList'}">BoardList</RouterLink> |
          <RouterLink :to="{name: 'boardCreate'}">BoardCreate</RouterLink>
        </nav>
      </header>
      <RouterView/>
    </div>
</template>

<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<style scoped>
.container {
    text-align: center;
}

nav {
    padding: 30px
}

nav a {
    font-weight: bold;
    text-decoration: none;
    color: black;
}

nav a.router-link-exact-active {
    color: #42b983
}
</style>