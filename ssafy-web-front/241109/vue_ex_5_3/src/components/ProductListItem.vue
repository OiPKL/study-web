<template>
  <li>
    {{ product.name }} - {{ product.price }}원
    <button @click="addToCart">장바구니 추가</button>
  </li>
</template>

<script setup>
const props = defineProps({
  product: Object
});

const emit = defineEmits(["add-to-cart"]);

function addToCart() {
  emit("add-to-cart", props.product);
}
</script>
