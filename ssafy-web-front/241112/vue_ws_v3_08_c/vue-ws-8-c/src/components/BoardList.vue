<template>
    <div>
    <h4>게시글 목록</h4>
    <hr/>
    <table>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>조회수</th>
            <th>등록일</th>
        </tr>
        <tr v-for="board in store.boardList" :key="board.id">
            <td>{{ board.id }}</td>
            <td><RouterLink :to="`/board/${board.id}`">{{ board.title }}</RouterLink></td>
            <td>{{ board.viewCnt }}</td>
            <td>{{ board.created }}</td>
        </tr>
    </table>
    <hr/>
    <BoardSearchInput/>
    </div>
</template>

<script setup>
import { onMounted } from 'vue'
import { useBoardStore } from "@/stores/board"
import BoardSearchInput from "@/components/BoardSearchInput.vue"
const store = useBoardStore()

onMounted(() => {
        store.getBoardList()
    })
</script>

<style scoped>

</style>