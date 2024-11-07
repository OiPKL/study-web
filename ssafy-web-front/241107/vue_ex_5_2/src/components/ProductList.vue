<template>
  <ul>
    <ProductListItem
      v-for="product in products"
      :key="product.id"
      :product="product"
    />
  </ul>
</template>

<script setup>
import ProductListItem from "./ProductListItem.vue";

const props = defineProps({
  products: Array,
});
</script>
