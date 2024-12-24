const object1 = {};

// 비어있는 객체에 프로퍼티를 추가하고 싶을 때
Object.defineProperty(object1, "property1", {
  value: 42,
});

console.log(object1.property1); // 42


