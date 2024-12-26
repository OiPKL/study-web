import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

export const BASE_URL = "http://localhost:3000"; // API 서버 주소
