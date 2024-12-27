<script setup>
import { ref, computed } from 'vue'
import SidebarLayout from '@/layouts/SidebarLayout.vue'
import CafeCard from '@/components/CafeCard.vue'

const cafeCollection = ref([
  {
    id: '1a2b3c4d-5e6f-7g8h-9i0j-1k2l3m4n5o6p',
    name: '스타*스',
    location: '서울',
    price: 5000,
    rating: 4,
    favorite: true,
    description: '',
  },
  {
    id: '2b3c4d5e-6f7g-8h9i-0j1k-2l3m4n5o6p7q',
    name: '이*야',
    location: '부산',
    price: 2500,
    rating: 3.5,
    favorite: false,
    description: '',
  },
  {
    id: '3c4d5e6f-7g8h-9i0j-1k2l-3m4n5o6p7q8r',
    name: '*다방',
    location: '구미',
    price: 3000,
    rating: 5,
    favorite: true,
    description: '',
  },
  {
    id: '4d5e6f7g-8h9i-0j1k-2l3m-4n5o6p7q8r9s',
    name: '커피*',
    location: '인천',
    price: 4000,
    rating: 0,
    favorite: false,
    description: '',
  },
])

const filterParams = ref({
  text: '',
  favorite: false,
})

const filteredCafes = computed(() => {
  return cafeCollection.value.filter((cafe) => {
    return (
      cafe.name.toLowerCase().includes(filterParams.value.text.toLowerCase()) &&
      (filterParams.value.favorite ? cafe.favorite : true)
    )
  })
})
</script>

<template>
  <SidebarLayout>
    <template v-slot:sidebar>
      <v-container>
        <h2 class="mb-4">필터</h2>
        <v-form>
          <v-text-field v-model="filterParams.text" label="가게명" />
          <v-checkbox v-model="filterParams.favorite" label="즐겨찾기유무" />
        </v-form>
      </v-container>
    </template>

    <template v-slot:main>
      <v-container>
        <h2 class="mb-4">목록</h2>
        <CafeCard
          v-for="cafe in filteredCafes"
          v-bind:cafe="cafe"
          :docId="cafe.id"
          :key="cafe.id"
        />
      </v-container>
    </template>
  </SidebarLayout>
</template>

<style></style>
