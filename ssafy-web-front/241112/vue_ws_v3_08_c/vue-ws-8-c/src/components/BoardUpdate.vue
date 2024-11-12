<template>
    <div>
        <h4>게시글 수정</h4>
        <hr />
        <div>
            <label for="title">제목 : </label>
            <input type="text" id="title" v-model="store.board.title">
        </div>
        <div>
            <label for="content">내용 : </label>
            <input type="text" id="content" v-model="store.board.content">
        </div>
        <div>
            <button @click="boardUpdate">등록</button>
        </div>
    </div>
</template>

<script setup>
import {onMounted} from 'vue'
import { useBoardStore } from "@/stores/board"

const store = useBoardStore()

onMounted(() => {
    store.getBoard(store.board.id)
})

const boardUpdate = function () {
    store.boardUpdate(store.board)
}
</script>

<style scoped></style>