<template>
    <div>
        <p>{{ post.title }}</p>
    </div>
</template>

<script setup>

const props = defineProps({
    post: {
        type: Object,
        required: true
    }
})
</script>

<style scoped>
</style>