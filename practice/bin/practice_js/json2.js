// JSON 문자열

var str = '{"name":"Luna","age":4}'
var obj = JSON.parse(str)

// str
// '{"name":"Luna","age":4}'
// obj
// {name: 'Luna', age: 4}


// 배열 -> [] 사용
var arr = [1,2,3,"hi"]
var arrStr = JSON.stringify(arr)

// arr
// (4) [1, 2, 3, 'hi']
// arrStr
// '[1,2,3,"hi"]'

var arrStr2 = '[1,2,3,"hi"]'
var arr2 = JSON.parse(arrStr2)

// arrStr2
// '[1,2,3,"hi"]'
// arr2
// (4) [1, 2, 3, 'hi']