<template>
    <div>
        <h4>직원 등록</h4>
        <div>
            <label for="name">이름 : </label>
            <input type="text" id="name" v-model="employee.name">
        </div>
        <div>
            <label for="position">직급 : </label>
            <input type="text" id="position" v-model="employee.position">
        </div>
        <div>
            <label for="department">부서 : </label>
            <input type="text" id="department" v-model="employee.department">
        </div>
        <div>
            <button @click="employeeInsert">등록</button>
        </div>
    </div>
</template>

<script setup>
//Q6. 등록하는 기능을 완성해봅시다.

import { ref } from "vue";
import { useEmployeeStore } from "@/stores/employee";

const store = useEmployeeStore()
const employee = ref({
    name: '',
    position: '',
    department: ''
})

const employeeInsert = function () {
    store.employeeInsert(employee.value)
}
</script>

<style scoped></style>