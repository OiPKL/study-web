<template>
    <div>
        <h2>YoutubeView</h2>
        <!-- 검색 -->
        <YoutubeVideoSearch/>
        <!-- 상세보기 -->
        <hr>
        <YoutubeVideoDetail/>
        <!-- 리스트 -->
        <hr>
        <YoutubeVideoList/>
    </div>
</template>

<script setup>
import YoutubeVideoSearch from '@/components/youtube/YoutubeVideoSearch.vue';
import YoutubeVideoList from '@/components/youtube/YoutubeVideoList.vue';
import YoutubeVideoDetail from '@/components/youtube/YoutubeVideoDetail.vue';
</script>

<style scoped>

</style>