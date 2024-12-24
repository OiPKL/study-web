Object.keys(obj).forEach((key) => {
  // 루프가 실행될 때마다 새로운 함수 스코프가 생성 (독립된 스코프)
  let innerValue = obj[key];
  // ... defineProperty
});
