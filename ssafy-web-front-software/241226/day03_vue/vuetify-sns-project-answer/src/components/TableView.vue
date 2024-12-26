<script setup>
import { ref, onMounted, watch } from 'vue'

const articles = ref([])
const loading = ref(true)
const totalItems = ref(0)
const options = ref({
  page: 1,
  itemsPerPage: 10
})

const headers = [
  { title: '제목', key: 'title' },
  { title: '내용', key: 'content' },
  { title: '날짜', key: 'date' },
  { title: '조회수', key: 'views' }
]

const fetchArticles = async () => {
  loading.value = true
  try {
    const page = options.value.page
    const limit = options.value.itemsPerPage
    const start = (page - 1) * limit

    const [data, total] = await Promise.all([
      fetch(`http://localhost:3000/articles?_start=${start}&_limit=${limit}`).then(res => res.json()),
      fetch('http://localhost:3000/articles').then(res => res.json())
    ])
    
    articles.value = data
    totalItems.value = total.length
  } catch (error) {
    console.error('Error fetching articles:', error)
  } finally {
    loading.value = false
  }
}

watch(options, () => {
  fetchArticles()
}, { deep: true })

onMounted(() => {
  fetchArticles()
})
</script>

<template>
  <v-data-table
    :headers="headers"
    :items="articles"
    :loading="loading"
    :items-per-page-options="[5, 10, 20]"
    :items-per-page="options.itemsPerPage"
    :page="options.page"
    :total-items="totalItems"
    @update:options="options = $event"
    class="elevation-1"
  >
    <template v-slot:item.content="{ item }">
      {{ item.content.substring(0, 50) }}...
    </template>
    <template v-slot:item.views="{ item }">
      {{ item.views.toLocaleString() }}
    </template>
  </v-data-table>
</template>