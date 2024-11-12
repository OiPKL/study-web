<template>
    <div>
    <h4>게시글 상세</h4>
    <hr>
    <div>THIS IS 게시글</div>
    <div>id: {{ store.board.id}}</div>
    <div>title: {{ store.board.title}}</div>
    <div>content: {{ store.board.content}}</div>
    
        <button @click="boardRemove">삭제</button>
        <button @click="boardUpdate">수정</button>
    </div>
</template>

<script setup>
import { onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { useBoardStore } from "@/stores/board"

const route = useRoute()
const router = useRouter()
const store = useBoardStore()

onMounted(() => {
    store.getBoard(route.params.id)
})

const boardRemove = function () {
    store.boardRemove(store.board.id)
}

const boardUpdate = function () {
    router.push({name: 'boardUpdate'})
}

</script>

<style scoped>

</style>