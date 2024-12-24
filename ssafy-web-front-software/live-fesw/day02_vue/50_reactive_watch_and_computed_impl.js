// 현재 실행 중인 effect를 저장
let currentEffect = null

// effect 함수
function effect(fn) {
  currentEffect = fn
  fn()
  currentEffect = null
}

// ref 구현 ver.5 : subscribers를 Set으로 관리
function ref(initialValue) {
  let _value = initialValue
  const subscribers = new Set()

  return {
    get value() {
      if (currentEffect) {
        subscribers.add(currentEffect)
      }
      return _value
    },
    set value(newValue) {
      _value = newValue
      subscribers.forEach((subscriber) => subscriber())
    },
  }
}

// watch 구현 ver1.
// source가 업데이트 되면 callback 실행
function watch(source, callback) {
  effect(() => {
    const value = source.value
    callback(value)
  })
}

// watch 구현 ver2. : source를 감시하다가 변경되면 callback을 실행
function watch(source, callback) {
  effect(() => {
    // source가 함수인 경우 실행하고, ref인 경우 value를 가져옴
    const value = typeof source === "function" ? source() : source.value
    callback(value)
  })
}

// computed 구현 ver.1
// getter 함수를 실행하고, 의존성 추적
function computed(getter) {
  let result = ref()

  effect(() => {
    result.value = getter()
  })

  return result
}

// 반응형 변수 생성
const count = ref(0)
const message = ref("안녕하세요!")

const doubleCount = computed(() => {
  return count.value * 2
})

watch(doubleCount, (value) => {
  console.log("watchCount:", value)
})

// effect 등록 (의존성 추적)
effect(() => {
  console.log("카운트가 변경됨:", count.value)
})

effect(() => {
  console.log("메시지가 변경됨:", message.value)
})

// 값 변경 테스트
console.log("--- 카운트 증가 ---")
count.value++

console.log("--- 메시지 변경 ---")
message.value = "반가워요!"
