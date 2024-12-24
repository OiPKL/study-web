// 단순화된 reactive 함수 구현
function reactive(obj) {
  return new Proxy(obj, {
    /* 프록시의 get, set 메소드 작성 */
  })
}

// 사용 예제
const person = reactive({ age: 20, name: 김싸피 })

// age 값 읽기
console.log("현재 나이는", person.age)

// age 값을 10 증가
console.log("\nIncreasing age by 10...")
person.age += 10

// 최종 값 확인
console.log("\nFinal age:", person.age)
