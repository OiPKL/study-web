<template>
    <div>
        <h3>UserView.vue</h3>
        <!-- $route.params 바로 접근은 비권장 -->
        <p>UserId : {{ $route.params.id }}</p>
        <!-- Composition API 방식 권장 -->
        <!-- 이 경우 동일 컴포넌트 내에서 변경 시 변경되지않음 => watch 사용 -->
        <p>UserId : {{ userId }}</p>
        <hr/>
        <button @click="goHome1">홈으로(push)</button>
        <button @click="goHome2">홈으로(replace)</button>
    </div>
</template>

<script setup>
    import { ref, watch } from 'vue'
    import { useRoute, useRouter } from 'vue-router'

    const route = useRoute()
    const router = useRouter()

    const userId = ref(route.params.id)
    // 동일 컴포넌트 내에서도 재렌더링 위함
    watch(() => route.params.id, (newId)=>{
        userId.value = newId
    })

    const goHome1 = function(){
        // 직접 URL 경로 작성
        // router.push('/')
        // 이름으로 호출
        router.push({name: 'home'})
    }

    const goHome2 = function(){
        router.replace({name: 'home'})
    }

</script>