// 단순화된 reactive 함수 구현
function reactive(obj) {
  return new Proxy(obj, {
    get(target, key) {
      console.log(`값에 접근했어요! ${key}: ${target[key]}`)
      return target[key]
    },
    set(target, key, value) {
      console.log(`값을 할당했어요! ${key} = ${value}`)
      target[key] = value
      return true
    },
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
