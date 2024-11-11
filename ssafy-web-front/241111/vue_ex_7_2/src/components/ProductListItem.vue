<template>
    <div>
        <p>{{ product.id + 1 }}: {{ product.title }} - {{ product.body }}</p>
        <button @click="store.deleteItem(product.id)">X</button>
    </div>
</template>

<script setup>
    import { useProductStore } from '@/stores/product'

    const store = useProductStore()

    defineProps({
        product: Object,
    })
</script>

<style scoped>

</style>