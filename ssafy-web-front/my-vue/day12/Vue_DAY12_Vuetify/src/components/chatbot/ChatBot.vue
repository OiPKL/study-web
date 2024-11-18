<template>
    <div>
        <h4>간단한 챗봇</h4>
        <input type="text" v-model.trim="input" placeholder="질문을 남겨주세요.">
        <button @click="send">전송</button>
        <hr>
        <div class="chat-container">
            <div v-for="(msg, index) in store.messages"
                :key="msg.index"
                :class="['message', msg.input ? 'left' : 'right']"
            >
                <span>{{ msg.message }}</span>
            </div>


        </div>
    </div>
</template>

<script setup>

import { ref } from 'vue';
import { useChatBotStore } from '@/stores/chatbot';

const store = useChatBotStore()

const input = ref('')
const send = function() {
    store.sendMsg(input.value)
    input.value=''
}
</script>

<style scoped>
 .chat-container {
    display: flex;
    flex-direction: column;
    margin: auto;
    max-width: 400px;
 }

 .message {
    padding: 10px;
    margin: 5px 0;
    border-radius: 10px;
    max-width: 70%;
 }

 .left {
    align-self: flex-start;
    background-color: antiquewhite;
 }

 .right {
    align-self: flex-end;
    background-color: blue;
    color: white;
 }
</style>