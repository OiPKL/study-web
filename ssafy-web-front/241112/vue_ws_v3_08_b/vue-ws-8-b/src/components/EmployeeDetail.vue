<template>
    <div>
        <h4>직원 상세 정보</h4>
        <hr>
        <div>{{ store.employee.id }}</div>
        <div>{{ store.employee.name }}</div>
        <div>{{ store.employee.position }}</div>
        <div>{{ store.employee.department}}</div>

        <button @click="employeeRemove">삭제</button>
        <button @click="employeeUpdate">수정</button>
    </div>
</template>

<script setup>
//Q4. 상세조회 기능을 완성해 봅시다.
import { useRoute, useRouter } from 'vue-router'
import { useEmployeeStore } from "@/stores/employee";
import { onMounted } from "vue";
import axios from 'axios'

const store = useEmployeeStore()

const route = useRoute();
const router = useRouter();
//컴포넌트가 연결될 때 상세정보를 가져옵니다.
onMounted(() => {
    store.getEmployee(route.params.id)
})
const employeeRemove = function () {
    store.employeeRemove(route.params.id)
}

const employeeUpdate = function () {
    router.push({ name: 'employeeUpdate' })
}


</script>

<style scoped></style>