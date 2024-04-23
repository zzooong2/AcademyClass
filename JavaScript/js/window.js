function windowTest() {
    // window.open(주소, 인자값(title변경), 속성)
    // window.open("https://www.naver.com", "네이버", "width=500px,height=500px");
    window.open("https://www.naver.com");
}

function windowTest2() {
    // setTimeout(function() {
    //     alert("setTimeout: 2초가 지났습니다.")
    // },2000);

    const newNaver = window.open("https://www.naver.com");
    newNaver.alert("setTimeout: 5초 뒤 사라짐");
    
    setTimeout(function() {
        newNaver.close();
    },5000);
}

function windowTest3() {
    const show = document.getElementById("test-3");

    const intervalControl = setInterval(function(){
                            const date = new Date();
                            show.innerHTML = date;
                            }, 1000);

    // setTimeout(function(){
    //     // Interval 종료
    //     clearInterval(intervalControl);
    // },5000);
}


function createEle() {
    const show = document.getElementById("create");

    // 방법 1
    show.innerHTML = "<p>p 태그 생성</p>";

    // 방법 2 - document 메서드를 사용하여 요소 객체 생성
    const elementNode = document.createElement("h3");
    const textNode = document.createTextNode("text");
    
    elementNode.appendChild(textNode)
    show.appendChild(elementNode);

    const img = document.createElement("img");

    img.src = "https://file.kinolights.com/original/post_detail/202401/25/08516c1e-b41d-49ed-814a-5408bd3397cb.webp";

    show.appendChild(img)
}

let cnt = 0; // 버튼 누르는 횟수

function createEle2(){
    cnt ++; // 횟수 증가
    const show = document.getElementById("yoso");
    const elementNode = document.createElement("p");
    const textNode = document.createTextNode("안녕하세요" + cnt);

    elementNode.style.color = "blue";
    elementNode.style.fontSize = "16";

    elementNode.appendChild(textNode);
    
    show.appendChild(elementNode);
}

function createEle3() {
    const show = document.getElementById("ul-space"); // ul
    const elementNode = document.createElement("li"); // 요소노드 생성 : li
    const menu = document.getElementById("menu"); // input 
    const textNode = document.createTextNode(menu.value); // 텍스트노드 생성 : input value

    
    elementNode.appendChild(textNode);
    show.appendChild(elementNode);

    menu.innerHTML = "";

    // 삭제 버튼 생성
    const deleteBtn = document.createElement("button"); // 요소노드 생성 : button
    deleteBtn.innerHTML = "삭제"; // 텍스트노드 생성 : delete

    show.appendChild(deleteBtn);

    deleteBtn.addEventListener('click', function(){
        // removeChild : 자식 요소 삭제
        elementNode.removeChild(textNode);
    })
}