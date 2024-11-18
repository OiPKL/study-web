<template>
  <div>
    <h4>검색결과</h4>
    <ul>
      <!-- 컴포넌트를 반복 -->
      <YoutubeVideoListItem 
        v-for="video in store.videoList"
        :key="video.id.videoId"
        :video="video"
      
      ></YoutubeVideoListItem>
    </ul>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useYoutubeStore } from '@/stores/youtube';
import YoutubeVideoListItem from './YoutubeVideoListItem.vue';
const store = useYoutubeStore();

</script>

<style scoped></style>
