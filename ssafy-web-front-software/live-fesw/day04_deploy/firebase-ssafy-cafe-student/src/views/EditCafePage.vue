<script setup>
import { ref } from 'vue'

import FormLayout from '@/layouts/FormLayout.vue'

const cafe = ref({})

const updateCafe = () => {
  console.log(cafe.value)
}

</script>

<template>
  <FormLayout>
    <template v-slot:title>
      <h1 class="mb-4">카페 수정</h1>
    </template>
    <template v-slot:content>
      <v-card>
        <v-card-text>
          <v-form v-if="cafe">
            <v-text-field
              v-model="cafe.name"
              label="이름"
              required
              placeholder="카페명"
            />
            <v-text-field
              v-model="cafe.rating"
              label="평점"
              type="number"
              min="0"
              max="5"
              step="0.5"
              required
            />
            <v-text-field v-model="cafe.location" label="위치" required />
            <v-text-field
              v-model.number="cafe.price"
              label="가격"
              type="number"
              min="0"
              max="1000000"
              required
            />
            <v-checkbox v-model="cafe.favorite" label="즐겨찾기" />
          </v-form>
        </v-card-text>
        <v-card-actions>
          <v-btn @click="updateCafe" variant="tonal" color="success">
            수정
          </v-btn>
          <v-btn variant="tonal" color="error" outlined> 취소 </v-btn>
        </v-card-actions>
      </v-card>
    </template>
  </FormLayout>
</template>

<style></style>
