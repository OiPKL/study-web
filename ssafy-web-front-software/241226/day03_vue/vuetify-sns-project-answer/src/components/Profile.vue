<template>
  <v-container class="w-50 pa-0 mt-10">
    <v-img src="/SSAFY_AI_IMG.png" height="300" cover></v-img>

    <v-row justify="space-between" class="profile">
      <v-col cols="auto">
        <v-avatar image="/ssafy_banner.png" size="200"></v-avatar>
      </v-col>

      <v-col cols="auto" class="mt-6" align-self="center">
        <v-btn variant="outlined" rounded="xl">Edit Profile</v-btn>
      </v-col>
    </v-row>

    <v-row>
      <div class="pl-8">
        <h2>SSAFY EDU</h2>
        <p>@SSAFY</p>

        <p class="py-2">
          삼성 청년 소프트웨어 아카데미 <br />삼성이 주관하고,<br />
          고용노동부가 후원하는 "청년 취업 프로그램"<br />
          SW 교육, 취업지원, 코딩교육, IT교육, AI
        </p>

        <a href="https://www.ssafy.com/">SSAFY 홈페이지 바로가기</a>
      </div>
    </v-row>

    <v-row class="pl-6 pt-6">
      <v-col class="d-flex" cols="auto">
        <v-icon icon="mdi-briefcase-outline"></v-icon>
        <span>Science & Technology</span>
      </v-col>
      <v-col class="d-flex" cols="auto">
        <v-icon icon="mdi-map-marker-outline"> </v-icon>
        <span>역삼역 멀티캠퍼스</span>
      </v-col>

      <v-col class="d-flex" cols="auto">
        <v-icon icon="mdi-link-variant"> </v-icon>
        <a href="https://www.ssafy.com/">ssafy.com</a>
      </v-col>

      <v-col class="d-flex" cols="auto">
        <v-icon icon="mdi-calendar-month"> </v-icon>
        <span>Joined October, 2017</span>
      </v-col>
    </v-row>

    <v-row class="pl-6">
      <v-col cols="auto">
        <h4>696 following</h4>
      </v-col>
      <v-col cols="auto">
        <h4>24k followers</h4>
      </v-col>
    </v-row>

    <v-tabs class="pl-6 mt-5" v-model="tab">
      <v-tab v-for="tab in tabList" :key="tab.value" :value="tab.value" color="blue">
        {{ tab.title }}
      </v-tab>
    </v-tabs>

    <v-window v-model="tab">
      <v-window-item v-for="tab in tabList" :value="tab.value" :key="tab.value">
        <component :is="tab.component" />
      </v-window-item>
    </v-window>
  </v-container>
</template>

<script setup>
import { ref } from "vue";

import Highlights from "./tabs/Highlights.vue";
import Likes from "./tabs/Likes.vue";
import Media from "./tabs/Media.vue";
import Posts from "./tabs/Posts.vue";
import Replies from "./tabs/Replies.vue";

const tabList = [
  {
    title: "Posts",
    value: "posts",
    component: Posts,
  },
  {
    title: "Replies",
    value: "replies",
    component: Replies,
  },
  {
    title: "Highlights",
    value: "highlights",
    component: Highlights,
  },
  {
    title: "Media",
    value: "media",
    component: Media,
  },
  {
    title: "Likes",
    value: "likes",
    component: Likes,
  },
];
const tab = ref(null);
</script>

<style>
.profile {
  margin-top: -100px;
}
</style>
