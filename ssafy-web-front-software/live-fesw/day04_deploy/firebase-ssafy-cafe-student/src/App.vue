<script setup>
import { RouterView, useRoute } from 'vue-router'
import AppNavbar from './components/AppNavbar.vue'
import AppLayout from './layouts/AppLayout.vue'

const route = useRoute()
</script>

<template>
  <AppLayout>
    <template v-slot:topbar>
      <AppNavbar />
    </template>
    <template v-slot:content>
      <Suspense>
        <RouterView :key="route.fullPath" />
        <template v-slot:fallback>
          <p>카페가 없습니다</p>
        </template>
      </Suspense>
    </template>
  </AppLayout>
</template>

<style></style>
