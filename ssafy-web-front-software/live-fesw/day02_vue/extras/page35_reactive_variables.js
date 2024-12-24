const name = "김싸피"; // 원시 데이터 선언

// 원시 데이터를 새로운 반응형 변수(객체)로 만들기
const obj = {
  _value: name,
  get value() {
    /*...*/
  },
  set value(newValue) {
    /*...*/
  },
};

// 현싸피 출력
console.log(obj.value);
// 반응형 변수에 새로운 값 할당
obj.value = "현싸피";
