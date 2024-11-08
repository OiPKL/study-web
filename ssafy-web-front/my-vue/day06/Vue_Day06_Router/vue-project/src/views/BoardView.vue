<template>
    <div>
        <h3>BoardView.vue</h3>
        <RouterLink :to="{ name: 'boardList'}"> 게시글목록</RouterLink> | 
        <RouterLink :to="{ name: 'boardCreate'}"> 게시글등록</RouterLink> | 
        <hr>
        <RouterView/>
    </div>
</template>

<script setup>

</script>

<style scoped>

</style>