<template>
  <div>
    <h2>HomeView</h2>
    <hr>
    <WeatherForecast/>
    <hr>
    <ChatBot/>
  </div>
</template>

<script setup>
import WeatherForecast from '@/components/weather/WeatherForecast.vue';
import ChatBot from '@/components/chatbot/ChatBot.vue';
</script>

<style scoped>

</style>
