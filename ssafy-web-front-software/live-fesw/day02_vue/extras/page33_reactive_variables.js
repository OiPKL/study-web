function reactive(obj) {/* 기존 정의 */}
function ref(value) {
  return reactive({ value });
}
const message = ref("안녕하세요!");


