function reactive(obj) {
  // 코드 작성...

  return obj
}

const obj = reactive({ age: 20, name: "김싸피" })

// "값에 접근했어요!" 출력, 10 출력
console.log(obj.age)
console.log(obj.name)
// "값을 변경했어요!" 출력, 25 출력
obj.age = 25
obj.name = "현싸피"
