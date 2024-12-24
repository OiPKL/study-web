// 간단한 reactive 함수
function reactive(obj) {
  // 각 속성별로 dep를 저장할 객체
  const deps = {};

  // 각 속성에 대해 dep 생성
  Object.keys(obj).forEach((key) => {
    deps[key] = createDep();
  });

  return new Proxy(obj, {
    // 값을 읽을 때: effect 등록
    get(target, key) {
      deps[key].depend();
      return target[key];
    },

    // 값을 변경할 때: effect 실행
    set(target, key, value) {
      target[key] = value;
      deps[key].notify();
      return true;
    },
  });
}
