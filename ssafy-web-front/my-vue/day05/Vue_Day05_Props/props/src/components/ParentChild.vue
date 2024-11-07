<template>
    <div>
      <h3>ParentChild.vue</h3>
      <!-- <p>{{ my-msg }}</p> -->
      <p>{{ myMsg }}</p>
      <p>{{ dynamicName }}</p>
      <p>{{ dynamicPerson }}</p>
      <!-- v-bind를 사용한 동적 Props -->
      <ParentGrandChild 
        :my-msg="myMsg"
        :dynamic-name="dynamicName"
        :dynamic-person="dynamicPerson"/>
    </div>
  </template>
  
  <script setup>
    import ParentGrandChild from './ParentGrandChild.vue'

    // 문자열 배열을 이용한 Props 선언
    // defineProps(['myMsg'])

    // 객체를 이용한 Props 선언 (권장, 유효성 검사 가능)
    // 키-> Props 이름, 값-> 데이터 타입에 해당하는 생성자 함수(Number, String, ...)
    const props = defineProps({
      myMsg: String,
      dynamicName: String,
      dynamicPerson: Object,
    })

    // Props 객체 반환 -> JavaScript에서 접근 가능
    console.log(props)          // {myMsg : 'message'}
    console.log(props.myMsg)    // 'message'

  </script>