<template>
  <Suspense>
    <!-- 컴포넌트와 중첩된 비동기 의존성 -->
    <Dashboard />

    <!-- #fallback 슬롯을 통한 로딩 상태 -->
    <template #fallback>로딩중...</template>
  </Suspense>
</template>

<script></script>
