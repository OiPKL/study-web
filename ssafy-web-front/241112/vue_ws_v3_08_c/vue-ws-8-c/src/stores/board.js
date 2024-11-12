import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

const REST_BOARD_API = `http://localhost:8080/board`

export const useBoardStore = defineStore('board', () => {

  const searchCondition = ref({})
  const board = ref({})
  const boardList = ref([])
  const result = ref([])

  const getBoard = function (id) {
    axios.get(`${REST_BOARD_API}/${id}`)
      .then((response) => {
        board.value = response.data
      })
  }

  const getBoardList = function () {
    axios.get(REST_BOARD_API)
      .then((response) => {
        boardList.value = response.data
        result.value = []
      })
  }

  const boardCreate = function (board) {
    axios.post(REST_BOARD_API, board)
      .then(() => {
        getBoardList()
        router.push({ name: 'boardList' })
      })
  }

  const boardRemove = function (id) {
    axios.delete(`${REST_BOARD_API}/${id}`)
      .then(() => {
        getBoardList()
        router.push({ name: 'boardList' })
      })
  }

  const boardUpdate = function (board) {
    axios.put(`${REST_BOARD_API}/${board.id}`, board)
      .then(() => {
        getBoardList()
        router.push({ name: 'boardList' })
      })
  }

  const boardSearch = function (searchCondition) {
    console.log('Search Condition:', searchCondition)

    axios.post(`${REST_BOARD_API}/search`, searchCondition)
      .then((response) => {
        console.log('Search Result:', response.data)

        result.value = response.data
      })
  }

  return { searchCondition, board, boardList, result, getBoard, getBoardList, boardCreate, boardRemove, boardUpdate, boardSearch }
})

