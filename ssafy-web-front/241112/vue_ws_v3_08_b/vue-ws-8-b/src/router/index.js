import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import EmployeeView from '../views/EmployeeView.vue'

import EmployeeList from '@/components/EmployeeList.vue'
import EmployeeInsert from '@/components/EmployeeInsert.vue'
import EmployeeDetail from '@/components/EmployeeDetail.vue'
import EmployeeUpdate from '@/components/EmployeeUpdate.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  // Q2. URL과 컴포넌트를 매핑 합니다. 
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/employee',
      name: 'employee',
      component: EmployeeView,
      children: [
        {
          path: "",
          name: "employeeList",
          component: EmployeeList
        },
        {
          path: "insert",
          name: "employeeInsert",
          component: EmployeeInsert
        },
        {
          path: ":id",
          name: "employeeDetail",
          component: EmployeeDetail
        },
        {
          path: "update",
          name: "employeeUpdate",
          component: EmployeeUpdate
        }
      ]
    }
  ]
})

export default router
