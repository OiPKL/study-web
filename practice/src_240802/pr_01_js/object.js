
// 자바스크립트에서의 객체 생성
// 자바스크립트에서의 변수의 선언 : var 변수이름
// 객체의 생성은 객체 리터럴을 이용
// { key : 속성명, value : 속성값 }
// value에 메서드(함수)가 올 수 있음
// 세미클론(;) 생략 가능

// 개발자도구 F12 console
// allow pasting
// $ max.eat()

var luna = {
    name: "Luna",
    age: 4
}

var max = {
    name: "Max",
    age: 3,
    eat: function() {
        console.log("음식을 먹는다")   // = sysout
    }
}

var daisy = {
    name: "Daisy",
    hobby: "sleep",
    age: 3
}