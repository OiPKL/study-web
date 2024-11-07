<template>
  <li>
    {{ product.name }} - {{ product.price }}원
    <button @click="addToCart">장바구니 추가</button>
  </li>
</template>

<script setup>
const props = defineProps({
  product: Object
})

function addToCart() {
  console.log(`${props.product.name} 추가완료!`)
}
</script>