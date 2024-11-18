import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'


export const useChatBotStore = defineStore('chatbot', () => {
  const messages = ref([])
  const sendMsg = function(message){
    messages.value.push({message, input: true})


    axios.get(`http://localhost:8080/chatGPT`, {
      params: {
        message
      }
    })
    .then((response)=>{
      console.log(response.data)
      messages.value.push({message: response.data, input: false})
    })

  }

  return { sendMsg, messages }
})
