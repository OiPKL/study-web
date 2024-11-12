<template>
    <div>
        <h4>게시글 검색</h4>
        <hr />
        <div>
            <label>검색 기준:</label>
            <select v-model="searchCondition.title">
                <option value="title">제목</option>
                <option value="content">내용</option>
            </select>

            <label>검색 내용:</label>
            <input type="text" v-model="searchCondition.content" placeholder="검색어를 입력하세요" />

            <label>정렬 기준:</label>
            <select v-model="searchCondition.order">
                <option value="created">등록일</option>
                <option value="viewCnt">조회수</option>
            </select>

            <label>정렬 방향:</label>
            <select v-model="searchCondition.direction">
                <option value="asc">오름차순</option>
                <option value="desc">내림차순</option>
            </select>

            <button @click="boardSearch">검색</button>
        </div>
        <hr />
        <table>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>조회수</th>
                <th>등록일</th>
            </tr>
            <tr v-for="board in store.result" :key="board.id">
                <td>{{ board.id }}</td>
                <td>{{ board.title }}</td>
                <td>{{ board.viewCnt }}</td>
                <td>{{ board.created }}</td>
            </tr>
        </table>

    </div>
</template>

<script setup>
import { ref } from 'vue'
import {useBoardStore} from "@/stores/board"

const store = useBoardStore()
const searchCondition = ref({
    title: 'title',
    content: '',
    order: 'created',
    direction: 'asc',
})

const boardSearch = function () {
    store.boardSearch(searchCondition.value)
}

</script>

<style scoped>
/* 필요시 스타일 추가 */
</style>
