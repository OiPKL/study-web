import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

const REST_API = `http://localhost:8080/employee`

export const useEmployeeStore = defineStore('employee', () => {
  const employeeList = ref([])
  //Q3. 
  const getEmployeeList = function () {
    axios.get(REST_API)
      .then((response) => {
        employeeList.value = response.data
      })
  }

  const employee = ref({})
  //Q4.
  const getEmployee = function (id) {
    axios.get(`${REST_API}/${id}`)
      .then((response) => {
        employee.value = response.data
    })
  }

  //Q6.
  const employeeInsert = function (employee) {
    axios({
      url: REST_API,
      method: 'POST',
      data: employee
    })
      .then(() => {
        getEmployeeList()
        router.push({ name: 'employeeList'})
      })
      .catch((err) => {
      console.log(err)
    })
  }

  const employeeRemove = function (id) {
    //Q5. 삭제 기능을 완성해 봅시다.
    axios.delete(`${REST_API}/${id}`)
      .then(() => {
      getEmployeeList()
      router.push({ name: 'employeeList' })
    })
  }

  //Q7.
  const employeeUpdate = function (employee) {
    axios.put(`${REST_API}/${employee.id}`, employee)
      .then(() => {
      getEmployeeList()
      router.push({name: 'employeeList'})
    })
  }

  return { 
    employeeList, getEmployeeList, employee, getEmployee, employeeInsert, employeeRemove, employeeUpdate }
})
