<template>
    <div>
        <h2>Dog Img</h2>
        <div>
            <button @click="getDog">이미지 가져오기</button>
        </div>
        <img :src="imgSrc">
    </div>
</template>

<script setup>
//Q1. Axios를 활용할 수 있도록 import 한다.
import axios from 'axios'
import { ref } from 'vue'

const imgSrc = ref('')

const getDog = function () {
    //강아지 이미지 주소를 반환해주는 API
    const URL = 'https://dog.ceo/api/breeds/image/random'
    //Q2. Axios의 get 메서드를 활용하여 데이터 요청을 보내고 가져와 봅시다.
    axios.get(URL)
        // 성공적으로 데이터를 가져왔을 때 img 태그의 src 속성 갱신
        .then((response) => {
            document.querySelector('img').src = response.data.message;
        })
        // 실패했을 때 '에러발생'이라는 메시지를 출력해본다.
        .catch((error) => {
            console.log('에러발생')
        })
}
</script>

<style></style>