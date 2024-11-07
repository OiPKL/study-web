<script setup>
import { ref } from 'vue';
import Box from './components/Box.vue';

const backgroundColors = ref([
{color:'#FFA7A7', emoji: "🍔"}, 
{color:'#FFC19E', emoji: "🍊"}, 
{color:'#FFE08C', emoji: "🌭"}, 
{color:'#FAED7D', emoji: "💔"}, 
{color:'#CEF279', emoji: "👨‍🦱"}, 
{color:'#B7F0B1', emoji: "👨‍🏫"}, 
{color:'#B2EBF4', emoji: "🧛‍♂️"} 
]);
const selectedIdx = ref(-1);

const detectChildEvent = (index) => {
  selectedIdx.value = index;
  console.log(selectedIdx.value);
}

</script>

<template>
  <div class="content">
    <Box
    @myClick="detectChildEvent(forIndex)"
    :childColor="color" 
    :myIdx="forIndex" 
    :selectedIdx="selectedIdx"
    v-for="(color, forIndex) in backgroundColors"></Box>
  </div>




      <!-- <div 
    class="box" 
    @click="selectedIdx = index" 
    :class="{'selected' : selectedIdx == index}" 
    :style="{'background-color':color}" 
    v-for="(color, index) in backgroundColors" :key="color">
    </div> -->
</template>

<style scoped>
.content {
  display: flex;
  flex-wrap: wrap;
}
</style>
