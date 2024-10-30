// 페이지에 처음 들어왔을 때 

window.addEventListener("load", function () {
  let data = localStorage.getItem("data")
  if (data != null) {
    document.querySelector("#saved > li").innerText = JSON.parse(data)
  } else {
    document.querySelector('#saved > li').innerText = "저장된 내용이 없습니다."
  }
})



// 등록 #create 

let createBtn = document.querySelector("#create")
createBtn.addEventListener("click", function () {
  let inputTag = document.querySelector("#input")
  let jsonData = JSON.stringify(inputTag.value)
  const ls = localStorage // localStorage는 JS의 객체. 변수 대입 가능
  ls.setItem("data", jsonData)
  inputTag.value = ""
})



// 조회 #read 

document.querySelector("#read").addEventListener("click", function () {
  let readTag = document.querySelector("#saved > li")
  let jsonData = localStorage.getItem("data")
  if (jsonData != null) {
    let data = JSON.parse(jsonData)
    readTag.innerText = data
  }
})






// 삭제 #delete 

document.querySelector("#delete").addEventListener("click", function () {
  localStorage.removeItem("data")
  document.querySelector("#saved > li").innerText = "저장된 내용이 없습니다."
  alert("삭제됐습니다.")
})
