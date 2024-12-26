<template>
    <v-app>
      <v-container>
        <v-card>
          <v-row>
            <v-col cols="6" class="bg-blue">
              <v-img
                :width="logo_w"
                src="https://mblogthumb-phinf.pstatic.net/MjAyMTA5MjhfMjMz/MDAxNjMyODE3NTEwMjU0.u_NeK6WJend9XakySaMBaLLWiVLdJrJ8-T9FI3QANtMg.hURGuv1Y53cL144xauSQ0Lux0POhmfsks1REPUmkKIwg.PNG.spongebob5288/ssafy_logo-removebg-preview.png?type=w800"
              />
              <h2 class="text-center pb-3">SSAFY COMPANY</h2>
            </v-col>
            <!--오른쪽 회사 정보 부분 -->
            <v-col cols="6" class="d-flex justify-center align-center">
              <div>
                <div>
                  <h2>김싸피</h2>
                  <p>CEO, SSAFY Company</p>
                </div>
  
                <div class="d-flex pt-4">
                  <v-icon>mdi-phone</v-icon>
                  <p>(123)456-7890</p>
                </div>
  
                <div class="d-flex pt-4">
                  <v-icon>mdi-map-marker</v-icon>
                  <p>SSAFY CAMPUS</p>
                </div>
  
                <div class="d-flex pt-4">
                  <v-icon>mdi-email</v-icon>
                  <p>kim@edu.ssafy.com</p>
                </div>
              </div>
            </v-col>
          </v-row>
        </v-card>
      </v-container>
    </v-app>
  </template>
  
  <script setup>
    import { ref } from 'vue'
  
    const logo_w = ref(300)
  </script>
  