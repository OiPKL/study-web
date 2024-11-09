<template>
  <div>
    <h1>쇼핑 애플리케이션</h1>
    <ul>
      <ProductList :products="products" @add-to-cart="addToCart" />
    </ul>
    <hr />
    <Cart :cart-items="cartItems" @remove-from-cart="removeFromCart" />
    <p>총 가격: {{ totalPrice }}원</p>
  </div>
</template>

<script setup>
import { ref, computed } from "vue";
import ProductList from "@/components/ProductList.vue";
import Cart from "@/components/Cart.vue";

let id = 0;
const products = ref([
  { id: id++, name: "사과", price: 1000 },
  { id: id++, name: "바나나", price: 1500 },
  { id: id++, name: "딸기", price: 2000 },
  { id: id++, name: "포도", price: 3000 },
  { id: id++, name: "복숭아", price: 2000 },
  { id: id++, name: "수박", price: 5000 },
]);

const cartItems = ref([]);

function addToCart(product) {
  cartItems.value = cartItems.value.concat(product);
}

function removeFromCart(productId) {
  const index = cartItems.value.findIndex(item => item.id === productId);
  if (index !== -1) {
    cartItems.value = [
      ...cartItems.value.slice(0, index),
      ...cartItems.value.slice(index + 1)
    ];
  }
}

const totalPrice = computed(() => {
  let sum = 0;
  for (let i = 0; i < cartItems.value.length; i++) {
    sum += cartItems.value[i].price;
  }
  return sum;
});
</script>
