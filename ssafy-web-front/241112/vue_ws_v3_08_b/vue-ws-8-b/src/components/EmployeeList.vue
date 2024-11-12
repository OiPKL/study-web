<template>
    <div>
        <h4>직원 목록</h4>
        <hr>
        <table>
            <tr>
                <th>사번</th>
                <th>이름</th>
                <th>부서</th>
                <th>상세정보</th>
            </tr>
            <tr v-for="employee in store.employeeList" :key="employee.id">
                <td>{{ employee.id }}</td>
                <td>{{ employee.name }}</td>
                <td>{{ employee.department }}</td>
                <td><RouterLink :to="`/employee/${employee.id}`">상세정보보기</RouterLink></td>
            </tr>
        </table>
    </div>
</template>

<script setup>
//Q3. 조회 기능을 완성해봅시다.
import { useEmployeeStore } from "@/stores/employee";
import { onMounted } from "vue";
const store = useEmployeeStore()
//컴포넌트가 연결될 때 전체 목록을 불러옵니다.
onMounted(() => {
    store.getEmployeeList()
})
</script>

<style scoped></style>