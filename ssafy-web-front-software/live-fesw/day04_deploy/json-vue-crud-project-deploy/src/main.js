import axios from "axios";

import { createApp } from "vue";
import { createPinia } from "pinia";

import App from "./App.vue";
import router from "./router";

// 전역으로  기본 URL을 설정한다.
axios.defaults.baseURL = "/api";

const token = localStorage.getItem("token");
if (token) {
  axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
}

const app = createApp(App);

app.use(createPinia());
app.use(router);

app.mount("#app");
