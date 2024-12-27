<script setup>
import { ref } from 'vue'

const userInput = ref({
  email: '',
  password: '',
})

const createUser = () => {
  console.log('createUser')
}

const signIn = () => {
  console.log('signIn')
}

</script>

<template>
  <v-container>
    <h1 class="mb-4">로그인 / 회원가입</h1>
    <v-card>
      <v-card-text>
        <v-form>
          <v-text-field
            v-model="userInput.email"
            type="email"
            label="이메일"
            required
            placeholder="ssafy@ssafy.com"
          />
          <v-text-field
            v-model="userInput.password"
            label="비밀번호"
            type="password"
            required
          />
        </v-form>
      </v-card-text>
      <v-card-actions>
        <v-btn @click="signIn" variant="tonal" color="primary">
          로그인
        </v-btn>
        <v-btn @click="createUser" variant="tonal" color="secondary">
          새 사용자 생성
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-container>
</template>

<style></style>
