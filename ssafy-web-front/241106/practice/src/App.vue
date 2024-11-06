<script setup>
  import { ref } from 'vue'

  const backgroundColors = ref([
    '#ff7675',
    '#a29bfe',
    '#ffeaa7',
    '#55efc4',
    '#0984e3',
    '#fd79a8',
    '#dfe6e9',
    '#00cec9',
    '#fdcb6e',
  ])
  const selectedIdx = ref(-1)

</script>

<template>
  <div class="content">
    <!-- div.box * 9 -->
    <div
      class="box"
      @click="selectedIdx = index"
      :class="{'selected' : selectedIdx == index}"
      :style="{'background-color': color}"
      v-for="(color, index) in backgroundColors" :key="color">
    </div>
  </div>
</template>

<style scoped>
  .content {
    display: flex;
    flex-wrap: wrap;
  }

  .box {
    width: 200px;
    height: 200px;
    margin: 10px;
    transition: .2s;
  }

  .box:hover {
    box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24) , 0 17px 50px 0 rgba(0, 0, 0, 0.19);
  }

  .selected {
    box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24) , 0 17px 50px 0 rgba(0, 0, 0, 0.19);
  }
</style>
