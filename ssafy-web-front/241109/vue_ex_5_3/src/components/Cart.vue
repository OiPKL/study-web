<template>
    <div>
      <ul v-if="cartItems.length">
        <li v-for="item in cartItems" :key="item.id">
          {{ item.name }} - {{ item.price }}원
          <button @click="remove(item.id)">삭제</button>
        </li>
      </ul>
      <p v-else>장바구니가 비어 있습니다.</p>
    </div>
  </template>
  
  <script setup>
  const props = defineProps({
    cartItems: Array
  });
  
  const emit = defineEmits(["remove-from-cart"]);
  
  function remove(productId) {
    emit("remove-from-cart", productId);
  }
  </script>