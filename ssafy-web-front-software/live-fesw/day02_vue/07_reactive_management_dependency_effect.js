let currentEffect = null

// 의존성을 추적하는 effect 함수 작성
function effect(fn) {
  // 여기에 코드를 작성
}

function createDep() {
  // Dep 매니저 객체 생성 후 반환
  return {
    // Dep의 의존성 수집 메서드 정의
    depend() {
      console.log("값 접근, 의존성을 추적합니다")
    },
    // Dep의 의존성 알림 메서드 정의
    notify() {
      console.log("값 변경, 의존성에게 전파합니다")
    },
  }
}

function ref(initalValue) {
  return {
    // Dep 매니저 객체 생성
    dep: createDep(),
    _value: initalValue,
    get value() {
      dep.depend() // 의존성 수집
      return this._value
    },
    set value(newValue) {
      this._value = newValue
      dep.notify() // 의존성 알림
    },
  }
}

// 반응형 변수 생성
const name = ref("김싸피")

// "값 접근, 의존성을 추적합니다" 출력
console.log(name.value)

// "값 변경, 의존성에게 전파합니다" 출력
name.value = "현싸피"
