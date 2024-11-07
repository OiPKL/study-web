<script setup>
  import { ref } from 'vue'
  import Box from './components/Box.vue'

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

    const detectChildEvent = (index) => {
      selectedIdx.value = index
      console.log(selectedIdx.value)
    }

</script>

<template>
  <div class="content">
    <Box 
      @myClick="console.log('자식이벤트발생')" 
      :childColor="color" 
      :myIndex="index"
      :selectedIdx="selectetdIdx"
      v-for="(color, index) in backgroundColors"/>
  </div>
</template>

<style scoped>
  .content {
    display: flex;
    flex-wrap: wrap;
  }

</style>
