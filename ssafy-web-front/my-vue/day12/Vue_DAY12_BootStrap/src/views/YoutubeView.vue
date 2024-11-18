<template>
    <div class="container">
        <h2 class="text-center"><i class="bi bi-youtube" style="color: red;"></i> Youtube</h2>
        <!-- 검색 -->
        <YoutubeVideoSearch/>
        <!-- 리스트 -->
        <hr>
        <YoutubeVideoList/>
    </div>
</template>

<script setup>
import YoutubeVideoSearch from '@/components/youtube/YoutubeVideoSearch.vue';
import YoutubeVideoList from '@/components/youtube/YoutubeVideoList.vue';
</script>

<style scoped>

</style>