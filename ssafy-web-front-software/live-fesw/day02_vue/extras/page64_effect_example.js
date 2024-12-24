// 1. 데이터
const counter = reactive({ count: 0 });

// 2. 구독자가 되는 effect들
effect(() => {
  console.log("첫 번째 구독자:", counter.count); // 첫 번째 구독자
});
effect(() => {
  document.title = `카운트: ${counter.count}`; // 두 번째 구독자
});
effect(() => {
  console.log("총합:", counter.count * 2); // 세 번째 구독자
});

// counter.count가 변경되면 세 개의 effect 함수가 모두 자동으로 실행
counter.count++;

