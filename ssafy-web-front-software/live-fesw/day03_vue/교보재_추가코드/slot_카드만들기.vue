<!-- https://play.vuejs.org/#eNp9VF1r01AY/isvpxe72VKHUqTGgpNdKKKiXuYmJqdtZpITzjmpnaNQBkKxQ3ZhWRnrKCjqxAtxFb2Yf2g5/Q97kzRt0o3e9TwfeZ/3OYfukQdBoLVCSqpEFxZ3AgmCyjCoGb7jBYxL2DIFfWLuslBCnTMP1rTyAoqta4avl1MvuvAgqRe4pqR4AtAX4uSMSMZDqUlNm/IZjkxzsxb1v6jRgRp1YfpxqEYT9a0LanwS/ThTowtQvSGo05768Cfq91Cq6WX0zL5bzg2+NsqmdTN0swxIBTX1+UIdf4Jof6KOz9TRIUQH3engBKL+92j0X52+n8+I65jbLv/+i77+vDwfQzQ8hOlgGO0Pc5rVMeqMyfzGQW5hdfQrnvsbVxwPovPJTQkKX4+PhXpzLFknxWuKb7jotZ0WWK4pxH2DWMyXpuNTbpBs0vLlCJdJ8E2PojzlUIs3j/A8XMGje/jFon9Zn1Poy9Xk56Xc9Xk5j17GfYodJK9RyF03XTgVw15qfs04Rt2QLKjCZtAGwVzHhpJlWfdSgcVcxqtQqlQqM6SOJW0I5x2twi3tLvUSuJM8/2QIdi4FNll3GtqOYD5WngyL6/UCx6X8WSAd5guDVLMYBjFdl719nGCSh3Q9w60mtd7cgO+IdowZ5DmngvIWNcickyZvUJnS2y+f0jb+npMes0MX1SvIFxRrCOOMqWwr9G2MndMlaR8lfw2O33glttuS+iJbKg6alJLoDYLv7uGK1Rdxb2t3ZmV2SOcK2QunOQ== -->
<template>
  <div class="container">
    <header>
      <slot name="header"></slot>
    </header>
    <main>
      <slot></slot>
    </main>
    <footer>
      <slot name="footer"></slot>
    </footer>
  </div>
</template>

<style>
footer {
  border-top: 1px solid #ccc;
  color: #666;
  font-size: 0.8em;
}
</style>

<script setup>
import BaseLayout from "./BaseLayout.vue";
</script>

<template>
  <BaseLayout>
    <template #header>
      <h1>다음은 페이지 제목일 수 있습니다.</h1>
    </template>

    <template #default>
      <p>주요 내용에 대한 단락입니다.</p>
      <p>그리고 또 하나.</p>
    </template>

    <template #footer>
      <p>다음은 연락처 정보입니다.</p>
    </template>
  </BaseLayout>
</template>
