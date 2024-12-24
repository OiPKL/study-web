// 1. 전역 상태로 현재 실행 중인 effect를 추적하는 용도
let currentEffect = null;

// 1단계. 방문자 기록 단계
currentEffect = fn;

// 2단계, 실행 단계
fn();

// 3단계, 초기화 단계
currentEffect = null;


currentEffect = null;

function effect(fn) {
  currentEffect = fn;
  fn();
  currentEffect = null;
}