// JSON : 자바스크립트 객체를 문자열로 나타낸 것
// 웹 클라이언트 <-> 웹 서버 간 데이터 교환
// 웹 브라우저 비동기 처리에 사용되는 AJAX의 데이터 교환 형식
// JSON 객체를 사용
// JSON.stringify() : 객체 -> 문자열
// JSON.parse() : 문자열 -> 객체
// '' 도 문자열을 표시하는데 사용

var luna = {
    name: "Luna",
    age: 4
}

var lunaStr = JSON.stringify(luna);

// luna
// {name: 'Luna', age: 4}
// lunaStr
// '{"name":"Luna","age":4}'

var daisy = {
    name: "Daisy",
    age: '3'
}

var daisyStr = JSON.stringify(daisy)

// daisy
// {name: 'Daisy', age: '3'}
// daisyStr
// '{"name":"Daisy","age":"3"}'