const coffee_price = 4500;
let amount = 3;
let total_price = 0;

function effect() {
  total_price = coffee_price * amount;
  console.log("총 가격은", total_price, "원입니다.");
}
effect(); // 의존성 파악을 위해 1회 호출

console.log(total_price); // 0이 출력
amount += 2; // 음? 나를 변경한다고?! effect(); 호출!
console.log(total_price); // 22500이 출력
