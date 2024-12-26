<template>
  <v-container fluid>
    <v-infinite-scroll height="100%" @load="onLoadArticles">
      <v-row
        align="start"
        justify="space-between"
        no-gutters
        v-for="article in articles"
      >
        <v-col cols="12" class="d-flex justify-space-between">
          <div class="d-flex">
            <v-avatar size="50" image="/ssafy_banner.png"></v-avatar>
            <div class="ml-2 mt-2">
              <strong>SSAFY EDU</strong>
              <span class="ml-2">@SSAFY</span>
              <span class="ml-2">{{
                new Date(article?.date).toLocaleDateString("ko-KR", {
                  month: "short",
                  day: "numeric",
                })
              }}</span>
              <p>{{ article?.title }}</p>
              <v-row>
                <v-col cols="4">
                  <v-icon icon="mdi-chat-outline"> </v-icon>
                </v-col>
                <v-col cols="4">
                  <v-icon icon="mdi-repeat-variant"></v-icon>
                </v-col>
                <v-col cols="4">
                  <v-icon icon="mdi-heart-outline"></v-icon>
                </v-col>
              </v-row>
            </div>
          </div>
          <v-btn variant="outlined" rounded="xl">Promote</v-btn>
        </v-col>
      </v-row>
      <template v-slot:error>
        <v-alert type="error">An error occurred!</v-alert>
      </template>
      <template v-slot:empty>
        <v-alert type="info">No More contents</v-alert>
      </template>
    </v-infinite-scroll>
  </v-container>
</template>

<script setup>
import { ref } from "vue";

const articles = ref([]);
const totalNumberOfArticles = ref(0);

const nextPage = ref(1);

const fetchArticles = async function (page = 1, pageSize = 10) {
  try {
    const response = await fetch(
      `http://localhost:3000/articles?_page=${page}&_limit=${pageSize}`
    );
    if (!response.ok) {
      throw new Error("Error fetching articles");
    }
    const data = await response.json();
    console.log(data);
    return data;
  } catch (error) {
    console.error(error);
    throw error;
  }
};

const onLoadArticles = async function ({ done }) {
  if (
    articles.value.length >= totalNumberOfArticles.value &&
    totalNumberOfArticles > 0
  ) {
    done("empty");
    return;
  }
  try {
    const articlesData = await fetchArticles(nextPage.value);
    articles.value = articles.value.concat(articlesData);
    if (articlesData.length === 0) {
      done("empty");
      return;
    }
    nextPage.value += 1;
    done("ok");
  } catch (error) {
    console.error(error);
    done("error");
  }
};
</script>

<style scoped></style>
