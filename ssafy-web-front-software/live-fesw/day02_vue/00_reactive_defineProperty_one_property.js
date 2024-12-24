// 먼저 반응형을 부여할 객체를 선언
const obj = {}

// 내부적으로 저장은 해당 변수에 저장한다.
let innerValue =
  // Object.defineProperty 메서드를 사용하여 속성을 부여합니다
  // get, set 메서드를 정의하여 속성에 접근할 때마다 로그를 출력합니다
  // "age"라는 속성에 접근(할당)할 때마다 로그가 출력됩니다
  Object.defineProperty(obj, "age", {})

// "값에 접근했어요!" 출력, 10 출력
console.log(obj.age)
// "값을 변경했어요!" 출력, 25 출력
obj.age = 25
