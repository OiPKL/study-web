<template>
    <div>
        <h3>남은 제품 수: {{ store.remainsCount }}</h3>
    </div>
</template>

<script setup>
    import { useProductStore } from '@/stores/product'

    const store = useProductStore()
</script>

<style scoped>

</style>