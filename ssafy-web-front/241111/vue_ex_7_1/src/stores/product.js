import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useProductStore = defineStore('product', () => {

  let id = 0

  const products = ref([
    { id: id++, title: 'Product 1', body: '사과' },
    { id: id++, title: 'Product 2', body: '포도' },
    { id: id++, title: 'Product 3', body: '감귤' },
  ])

  return { products }
}, {persist: true})
