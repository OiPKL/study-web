<template>
    <div>
      <h2>EventParent.Vue</h2>
      <EventParentChild
        my-msg="HELLO 2"
        :dynamic-name="name"
        @some-event="someCallback"
        @emit-args="getNumber"
        @update-name = "setName"/>
        <!-- v-on을 사용하여 수신 후 처리할 콜백함수 호출 -->
    </div>
  </template>
  
  <script setup>
    import { ref } from 'vue'
    import EventParentChild from './EventParentChild.vue'
    
    const name = ref("Park")

    const someCallback = function(){
      console.log("이벤트 발생!")
    }

    const getNumber = function(...args){
      console.log(args)
    }

    const setName = function(newName){
      name.value = newName
    }

  </script>