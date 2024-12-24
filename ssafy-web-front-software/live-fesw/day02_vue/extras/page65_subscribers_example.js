// function createDep {
//   // 구독자를 모을 컨테이너 생성
//   // Set : 중복을 허용하지 않는 자료구조 객체
//   // (같은 Effect가 여러 번 등록되는 것을 방지)
//   subscribers = new Set();
// }


function createDep() {
    // Dep 매니저 객체 생성 후 반환
    return {
      // Dep의 의존성 수집 메서드 정의
      depend() {
        if (currentEffect) {
          // 현재 수집 중인 Effect를 구독자로 등록
          subscribers.add(currentEffect);
        }
      },
      // Dep의 의존성 알림 메서드 정의
      notify() {
        // 구독 중인 Effect를 모두 실행
        subscribers.forEach((sub) => sub());
      },
    },
  }
}