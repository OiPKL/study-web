<template>
    <div>
        <h4>직원 수정</h4>
        <div>
            <label for="name">이름 : </label>
            <input type="text" id="name" readonly v-model="store.employee.name">
        </div>
        <div>
            <label for="position">직급 : </label>
            <input type="text" id="position" v-model="store.employee.position">
        </div>
        <div>
            <label for="department">부서 : </label>
            <input type="text" id="department" v-model="store.employee.department">
        </div>
        <div>
            <button @click="employeeUpdate">수정</button>
        </div>
    </div>
</template>

<script setup>
//Q7. 업데이트 기능을 완성해봅시다.
//데이터는 store를 통해 바인딩 합니다.
import { onMounted } from 'vue'
import { useRoute } from 'vue-router'
import { useEmployeeStore } from "@/stores/employee";
const store = useEmployeeStore();
const route = useRoute()

onMounted(() => {
    store.getEmployee(store.employee.id)
})

const employeeUpdate = function () {
    store.employeeUpdate(store.employee)
}
</script>

<style scoped></style>