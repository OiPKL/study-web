import { createRouter, createWebHistory } from "vue-router";
import PostList from "@/views/PostList.vue";
import PostDetail from "@/views/PostDetail.vue";
import PostCreate from "@/views/PostCreate.vue";
import PostEdit from "@/views/PostEdit.vue";
import LoginView from "@/views/LoginView.vue";
import RegisterView from "@/views/RegisterView.vue";
import { useAuthStore } from "@/stores/auth";

const routes = [
  {
    path: "/login",
    name: "Login",
    component: LoginView,
  },
  {
    path: "/register",
    name: "Register",
    component: RegisterView,
  },
  {
    path: "/",
    name: "PostList",
    component: PostList,
  },
  {
    path: "/posts/create",
    name: "PostCreate",
    component: PostCreate,
    meta: {
      requiresAuth: true,
    },
  },
  {
    path: "/posts/:id",
    name: "PostDetail",
    component: PostDetail,
  },
  {
    path: "/posts/:id/edit",
    name: "PostEdit",
    component: PostEdit,
    meta: {
      requiresAuth: true,
    },
    beforeEnter: (to, from) => {
      if (localStorage.getItem("token")) {
        return true;
      } else {
        return "/login";
      }
    },
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach((to, from) => {
  const authStore = useAuthStore();
  if (to.meta?.requiresAuth && !authStore.isAutenicated) {
    return "/login";
  }
}

export default router;
