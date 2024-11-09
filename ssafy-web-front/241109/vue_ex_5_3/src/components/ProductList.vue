<template>
  <ul>
    <ProductListItem
      v-for="product in products"
      :key="product.id"
      :product="product"
      @add-to-cart="handleAddToCart"
    />
  </ul>
</template>

<script setup>
import ProductListItem from "./ProductListItem.vue";

const props = defineProps({
  products: Array,
});

const emit = defineEmits(["add-to-cart"]);

function handleAddToCart(product) {
  emit("add-to-cart", product);
}
</script>
