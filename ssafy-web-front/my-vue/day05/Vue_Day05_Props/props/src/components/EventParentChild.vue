<template>
    <div>
      <h3>EventParentChild.vue</h3>
      <p>{{ myMsg }}</p>
      <p>이름: {{ dynamicName }}</p>
      <!-- $emit : 템플릿 표현식에서 사용자 정의 이벤트를 발신 -->
      <button @click="$emit('someEvent')">부모전송</button>
      <!-- script 에서 $emit 메서드 접근불가 -> defineEmits( ) 사용 -->
      <button @click="buttonClick">부모전송2</button>
      <button @click="emitArgs">추가인자전달</button>
      <EventParentGrandChild 
        :my-msg="myMsg"
        :dynamic-name="dynamicName"
        @update-name="updateName"/>
    </div>
  </template>
  
  <script setup>
    import EventParentGrandChild from './EventParentGrandChild.vue'

    const props = defineProps({
      myMsg: String,
      dynamicName: String,
    })

    // 부모전송1 부모전송2 => 부모에게 같은 someEvent 발신
    const emit = defineEmits(["someEvent", "emitArgs", "updateName"])
    const buttonClick = function(){
      emit("someEvent")
    }

    // 추가인자전달 메서드 정의
    const emitArgs = function(){
      emit("emitArgs", 1, 2, 3)
    }

    const updateName = function(name){
      console.log(name)
      emit("updateName", name)
    }

  </script>