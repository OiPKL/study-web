<template>
    <div>
        <h2>Cat Img</h2>
        <div>
            <button @click="getCat">이미지 가져오기</button>
        </div>
        <img :src="imgSrc">
    </div>
</template>

<script setup>
//Q1. Axios를 활용할 수 있도록 import 한다.
import axios from 'axios'
import { ref, onMounted } from 'vue'

const imgSrc = ref('')

const getCat = function () {
    //고양이 이미지 주소를 반환해주는 API
    const URL = 'https://api.thecatapi.com/v1/images/search'
    //Q3. Axios에 config 객체를 이용하여 API에 요청을 보낸다.
    axios({
        url: URL,
        method: 'GET',
    })
        //요청 성공시 img 태그의 src 속성을 갱신한다.
        .then((response) => {
            imgSrc.value = response.data[0].url
        })
        // 실패했을 때 '에러발생'이라는 메시지를 출력해본다.
        .catch((error) => {
            console.log('에러발생')
        })
}
//Q4. 해당 컴포넌트가 연결되었을 때 API 서버에 요청을 보내어 응답을 가져온다.
onMounted(() => {
    getCat()
})
</script>

<style></style>