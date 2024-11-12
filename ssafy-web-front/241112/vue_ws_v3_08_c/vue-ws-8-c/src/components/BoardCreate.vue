<template>
    <div>
        <h4>게시글 등록</h4>
        <hr/>
        <div>
            <label for="title">제목 : </label>
            <input type="text" id="title" v-model="board.title">
        </div>
        <div>
            <label for="content">내용 : </label>
            <input type="text" id="content" v-model="board.content">
        </div>
        <div>
            <button @click="boardCreate">등록</button>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue'
import { useBoardStore } from "@/stores/board"

const store = useBoardStore()
const board = ref({
    title: '',
    content: '',
})

const boardCreate = function () {
    store.boardCreate(board.value)
}
</script>

<style scoped></style>