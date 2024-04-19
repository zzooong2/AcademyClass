function handler1() {
    const show = document.getElementById("result-1");
    show.innerHTML = "run Handler1";
}

//--------------------------------------------------------

const btn2 = document.getElementById("btn-2");
const show2 = document.getElementById("result-2");

// handler: 실행
btn2.onclick = function() {
    show2.innerHTML = "run Handler2";
}

//--------------------------------------------------------

const btn3 = document.getElementById("btn-3");
const show3 = document.getElementById("result-3");

// EventListener: 감지(click), 처리(function(){})
btn3.addEventListener('click', function() {
    show3.innerHTML = "run EventListener"
});

//--------------------------------------------------------

// dblclick: 더블클릭 했을 때 발생하는 이벤트
const btn4 = document.getElementById("btn-4");
const show4 = document.getElementById("result-4");

btn4.addEventListener('dblclick', function() {
    show4.innerHTML = "double click"
});

//--------------------------------------------------------

// mouseover: 마우스가 요소 위로 이동했을때 발생하는 이벤트
const btn5 = document.getElementById("btn-5");
const show5 = document.getElementById("result-5");

btn5.addEventListener('mouseover', function() {
    show5.innerHTML = "mouseover"
});

//--------------------------------------------------------

// contextmenu: 우클릭 되었을 때 발생하는 이벤트
const divArea = document.getElementById("div-area");

// 우클릭 시 발생되는 이벤트
// divArea.addEventListener('contextmenu', function(){
    //     alert("우클릭!!!");
    // });
    
    // 우클릭 방지 로직
    divArea.addEventListener('contextmenu', function(event){
        event.preventDefault();
    });


//--------------------------------------------------------

const keyboard = document.getElementById("keyboard");
const btn6 = document.getElementById("btn6");
const show6 = document.getElementById("result-6");
let keydownTime;

keyboard.addEventListener('keydown', function() {
    if(!keydownTime){
        keydownTime = new Date();
        show6.innerHTML = "키 입력된 시간: " + keydownTime;
    }
});

keyboard.addEventListener('keyup', function() {
    const keyupTime = new Date();
    const duration = keyupTime - keydownTime;
    
    show6.innerHTML = "키 입력중인 시간: " + duration + "ms";
    
    keydownTime = null;
});

// btn6.addEventListener('click', function() {
    //     alert("Success")
    // });
    
    // keyboard.addEventListener('keydown', function(event) {
        //     show6.innerHTML = "키 눌림" + event.keyCode;
        
        //     if(event.keyCode === 13){
            //         btn6.click();
            //     }
            // });
            
//--------------------------------------------------------

let isValid;
const show7 = document.getElementById("result-7");

function validatePassword(password) {
    console.log(password);

    // PW 규칙: 소문자, 대문자, 숫자를 포함한 6자리 이상 12자리 이하
    // ^: 시작
    // \d: 모든 숫자
    // $: 끝
    const pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,12}$/;
    
    isValid = pattern.test(password);
    
    if(isValid){
        show7.innerHTML = "비밀번호가 적합합니다.";
        show7.style.color = "green";
    } else {
        show7.innerHTML = "비밀번호가 부적합합니다.";
        show7.style.color = "red";
    }
}