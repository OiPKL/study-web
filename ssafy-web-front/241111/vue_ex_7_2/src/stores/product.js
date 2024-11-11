import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useProductStore = defineStore('products', () => {

  let id = 0

  const products = ref([
    { id: id++, title: 'Product 1', body: '사과' },
    { id: id++, title: 'Product 2', body: '포도' },
    { id: id++, title: 'Product 3', body: '감귤' },
  ])

  const addItem = function(title, body) {
    products.value.push({
      id: id++,
      title: title,
      body: body,
    })
  }

  const deleteItem = function(id){
    const idx = products.value.findIndex((product) => {
      return product.id === id
    })

    products.value.splice(idx, 1)
  }

  const remainsCount = computed(() => {
    return products.value.length
  })

  return { products, addItem, deleteItem, remainsCount }
}, {persist: true})
