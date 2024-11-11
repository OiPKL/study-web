<template>
    <div>
        <h1>ProductList</h1>
        <ProductListItem
            v-for="product in store.products"
            :key="product.id"
            :product="product"/>
    </div>
</template>

<script setup>
import ProductListItem from './ProductListItem.vue';
import { useProductStore } from '@/stores/product';

const store = useProductStore()

</script>

<style scoped>

</style>