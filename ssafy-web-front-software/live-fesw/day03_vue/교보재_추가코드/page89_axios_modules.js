// src/api/axios.js
import axios from "axios";
import router from "@/router";

const apiClient = axios.create({
  baseURL: import.meta.env.VITE_API_URL,
  timeout: parseInt(import.meta.env.VITE_API_TIMEOUT),
  headers: {
    "Content-Type": "application/json",
  },
});

// Request interceptor
apiClient.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token");
    if (token) {
      config.headers.Authorization = `Token ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// Response interceptor
apiClient.interceptors.response.use(
  (response) => response,
  async (error) => {
    if (error.response?.status === 401) {
      localStorage.removeItem("token");
      router.push("/signin");
    }
    return Promise.reject(error);
  }
);

export default apiClient;

// src/api/clients/base.js
import apiClient from "../axios";

export class BaseApiClient {
  constructor(resource) {
    this.resource = resource;
  }

  async getAll() {
    const response = await apiClient.get(`/api/v1/${this.resource}/`);
    return response.data;
  }

  async get(id) {
    const response = await apiClient.get(`/api/v1/${this.resource}/${id}/`);
    return response.data;
  }

  async create(data) {
    const response = await apiClient.post(`/api/v1/${this.resource}/`, data);
    return response.data;
  }

  async update(id, data) {
    const response = await apiClient.put(`/api/v1/${this.resource}/${id}/`, data);
    return response.data;
  }

  async delete(id) {
    const response = await apiClient.delete(`/api/v1/${this.resource}/${id}/`);
    return response.data;
  }
}

// src/api/clients/articles.js
import { BaseApiClient } from "./base";

class ArticlesApiClient extends BaseApiClient {
  constructor() {
    super("articles");
  }

  // 추가적인 article 관련 메서드들...
}

export const articlesApi = new ArticlesApiClient();

// src/api/clients/auth.js
import apiClient from "../axios";
import { authApi } from "./page85_axios_instance";


function async login(credentials) {
    const response = await authApi.post("/accounts/login/", credentials);
    return response.data;
}

function async signup(userData) {
    const response = await authApi.post("/accounts/signup/", userData);
    return response.data;
}

function async logout() {
    const response = await authApi.post("/accounts/logout/");
    return response.data;
}


export { 
    login as loginApi, 
    signup as signupApi, 
    logout as logoutApi 
};


import { loginApi } from "@/api/auth";

// 사용
const login = () => {
    const payload = data.value;
    loginApi(payload)
    .then(data => {
        router.push("/");
    });
}