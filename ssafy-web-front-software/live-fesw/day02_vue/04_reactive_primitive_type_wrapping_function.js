function ref(initalValue) {
  const obj = {/* ... */ }
  return obj; 
}

// 반응형 변수 생성
const name = ref("김싸피"); 

// "값에 접근했어요!" 출력, 김싸피 출력
console.log(name.value);

// "값을 변경했어요!" 출력, 현싸피 출력
name.value = "현싸피";
