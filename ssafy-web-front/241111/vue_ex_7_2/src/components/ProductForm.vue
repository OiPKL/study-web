<template>
    <div>
        <h3>Product Form</h3>
        <input
            v-model.trim="newProduct.title"
            placeholder="상품명"
        />
        <input
            v-model.trim="newProduct.body"
            placeholder="상품설명"
        />
        <button @click="createProduct">+</button>
    </div>
</template>

<script setup>
import { ref } from 'vue'
import { useProductStore } from '@/stores/product'

const store = useProductStore()

const newProduct = ref({
    title: '',
    body: ''
})

const createProduct = () => {
    if (newProduct.value.title && newProduct.value.body) {
        store.addItem(newProduct.value.title, newProduct.value.body)
        newProduct.value.title = ''
        newProduct.value.body = ''
    } else {
        alert('상품명과 설명을 모두 입력하세요')
    }
}
</script>

<style scoped>
</style>
