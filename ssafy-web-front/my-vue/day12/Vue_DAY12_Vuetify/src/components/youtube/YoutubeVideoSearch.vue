<template>
  <div>
    <h4>검색컴포넌트</h4>
    <input type="text" v-model.trim="keyword" @keyup.enter="search" />
    <button @click="search">검색</button>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useYoutubeStore } from '@/stores/youtube';

const store = useYoutubeStore();
const keyword = ref('');

const search = function () {
  store.youtubeSearch(keyword.value);
};
</script>

<style scoped></style>
