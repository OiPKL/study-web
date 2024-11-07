<template>
    <div>
        <h3>{{ product.name }}</h3>
        <p>가격: {{ product.price }}원</p>
    </div>
</template>

<script setup>
    const props = defineProps({
        product: Object
    })
</script>