// 현재 실행 중인 effect를 저장
let currentEffect = null

// effect 함수
function effect(fn) {
  currentEffect = fn
  fn()
  currentEffect = null
}

// ref 함수 ver.1 : 가장 기본적인 저장 기능을 가진 객체를 반환
function ref(initialValue) {
  let _value = initialValue
  return {
    get value() {
      return _value
    },
    set value(newValue) {
      _value = newValue
    },
  }
}

// ref 함수 ver.2 : 구독자(subscriber)라는 개념을 추가
// 구독자 : 값이 변경될 때 실행할 함수 (디자인 패턴에서 옵저버 패턴과 유사)
function ref(initialValue) {
  let _value = initialValue
  let subscriber = null // 구독자를 저장할 변수 추가

  return {
    get value() {
      return _value
    },
    set value(newValue) {
      _value = newValue
      // 값이 변경될 때 구독자가 있다면 호출
      if (subscriber) {
        subscriber()
      }
    },
  }
}

// ref 구현 ver4. : 현재 실행 중인 effect를 구독자로 등록
function ref(initialValue) {
  let _value = initialValue
  let subscriber = null

  return {
    get value() {
      if (currentEffect) {
        subscriber = currentEffect
      }
      return _value
    },
    set value(newValue) {
      _value = newValue
      if (subscriber) {
        subscriber()
      }
    },
  }
}

// 반응형 변수 생성
const count = ref(0)
const message = ref("안녕하세요!")

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
