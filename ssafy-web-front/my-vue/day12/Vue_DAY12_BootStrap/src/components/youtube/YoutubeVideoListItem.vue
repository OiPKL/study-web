<template>
  <div class="carousel-item text-center" :class="active">
    <iframe
      width="800"
      height="500"
      :src="videoURL"
      title="YouTube video player"
      frameborder="0"
      allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
      referrerpolicy="strict-origin-when-cross-origin"
      allowfullscreen
    ></iframe>
    <h5>{{ videoTitle }}</h5>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue';
import { useYoutubeStore } from '@/stores/youtube';
import _ from 'lodash';

const store = useYoutubeStore();

const active = computed(()=>{
  if(props.current == props.index) return {active: true}
})

const props = defineProps({
  video: Object,
  index: Number,
  current: Number
});

const videoURL = computed(() => {
  const videoSrc = props.video.id.videoId;
  return `https://www.youtube.com/embed/${videoSrc}`;
});

const videoTitle = computed(() => {
  return _.unescape(props.video.snippet.title);
});
</script>

<style scoped></style>
