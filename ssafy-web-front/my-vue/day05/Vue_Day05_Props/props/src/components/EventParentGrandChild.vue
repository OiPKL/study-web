<template>
    <div>
      <h4>EventParentGrandChild.Vue</h4>
      <p>{{ myMsg }}</p>
      <p>이름: {{ dynamicName }}</p>
      <input v-model="name">
      <button @click="updateName">이름변경</button>
    </div>
  </template>
  
  <script setup>
    import { ref } from 'vue'

    const props = defineProps({
      myMsg: String,
      dynamicName: String,
    })

    const emit = defineEmits(["updateName"])
    const updateName = function(){
      emit("updateName", name.value)
      name.value = ""
    }

    const name = ref("")
    
  </script>