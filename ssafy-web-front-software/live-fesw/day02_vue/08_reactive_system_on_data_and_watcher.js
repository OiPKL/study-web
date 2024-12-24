let currentEffect = null

function effect(fn) {
  currentEffect = fn
  fn()
  currentEffect = null
}

function createDep() {
  // 구독자 컨테이너 생성
  const subscribers = new Set()
  // Dep 매니저 객체 생성 후 반환
  return {
    // Dep의 의존성 수집 메서드 정의
    depend() {
      if (currentEffect) {
        // 현재 수집 중인 Effect를 구독자로 등록
        subscribers.add(currentEffect)
      }
    },
    // Dep의 의존성 알림 메서드 정의
    notify() {
      // 구독 중인 Effect를 모두 실행
      subscribers.forEach((sub) => sub())
    },
  }
}

function ref(initalValue) {
  return {
    // Dep 매니저 객체 생성
    dep: createDep(),
    _value: initalValue,
    get value() {
      this.dep.depend() // 의존성 수집
      return this._value
    },
    set value(newValue) {
      this._value = newValue
      this.dep.notify() // 의존성 알림
    },
  }
}

// 반응형 변수 생성
const name = ref("김싸피")

let output = ""

// 반응형 변수에 의존하는 Effect 생성
effect(() => {
  output = "안녕하세요, " + name.value
})

// 의존성 알림으로 인해 Effect 실행
name.value = "현싸피"

// "안녕하세요, 현싸피" 출력
console.log(output)
