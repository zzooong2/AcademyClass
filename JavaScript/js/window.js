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

let cnt = 0;

function createEle2(){
    cnt ++;
    const show = document.getElementById("create2");
    const show2 = document.getElementById("yoso");
    const elementNode = document.createElement("p");
    const textNode = document.createTextNode("안녕하세요" + cnt);

    elementNode.style.color = "blue";
    elementNode.style.fontSize = "16px";

    elementNode.appendChild(textNode);
    
    show.appendChild(elementNode);

    show2.appendChild(show);
}