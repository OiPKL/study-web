<template>
    <div>
        <h4>TodoForm</h4>
        <input
            v-model.trim="todoText"
            @keyup.enter="createTodo">
        <button
            @click="createTodo"
        >등록</button>
    </div>
  </template>
  
  <script setup>
    import { ref } from 'vue'
    import { useTodosStore } from '@/stores/todos'

    const store = useTodosStore()
    const todoText = ref("")

    const createTodo = function(){
        if (todoText.value){
            store.addTodo(todoText.value)
            todoText.value = ''
        } else {
            alert('내용을 입력하세요')
        }
    }
  </script>
  
  <style scoped>
  
  </style>