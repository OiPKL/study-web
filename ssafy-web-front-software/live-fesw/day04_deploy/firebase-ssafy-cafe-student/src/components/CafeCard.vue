<script setup>
import { computed } from 'vue'

import BaseImageCard from '@/components/base/BaseImageCard.vue'
import CafeImage from '@/components/CafeImage.vue'

const props = defineProps({
  cafe: {
    type: Object,
    required: true,
  },
})
</script>

<template>
  <BaseImageCard>
    <template v-slot:image>
      <CafeImage />
    </template>
    <template v-slot:title>
      {{ cafe.name }}
    </template>
    <template v-slot:subtitle v-if="cafe.favorite">
      <v-icon color="error" icon="mdi-fire-circle" size="small" class="mr-1" />
      <span class="mr-1">Favorite</span>
    </template>
    <template v-slot:rating>
      <v-rating
        :model-value="cafe.rating"
        color="amber"
        density="compact"
        half-increments
        readonly
        size="small"
      />
      <div class="text-grey ms-2">{{ cafe.rating }}</div>
    </template>
    <template v-slot:description>
      <p>{{ cafe.description }}</p>
    </template>
    <template v-slot:price> {{ cafe.price }} 원 </template>
    <template v-slot:actions>
      <v-btn color="primary" disabled>
        <v-icon icon="mdi-pencil" class="mr-1" /> 수정
      </v-btn>
      <v-btn color="error" text disabled>
        <v-icon icon="mdi-trash-can-outline" class="mr-1" />
        삭제
      </v-btn>
    </template>
  </BaseImageCard>
</template>

<style></style>
