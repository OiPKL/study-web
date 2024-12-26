import { createRouter, createWebHistory } from "vue-router";
import PostList from "@/views/PostList.vue";
import PostDetail from "@/views/PostDetail.vue";
import PostCreate from "@/views/PostCreate.vue";
import PostEdit from "@/views/PostEdit.vue";
import LoginView from "@/views/LoginView.vue";
import RegisterView from "@/views/RegisterView.vue";

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
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
