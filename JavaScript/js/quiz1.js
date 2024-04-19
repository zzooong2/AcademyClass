function welcome(){
    alert(document.getElementById("alias").value + "님 환영합니다!");
}

// welcome() 익명함수로 전환
const anonymousWelcome = function(){
    alert(document.getElementById("alias").value + "님 환영합니다!");
}


function gugudan() {
    const number = document.getElementById("gugudan");
    const inputNumber = document.getElementById("input-gugudan").value;
    let multiple = 0;
    let sum = 0;

    for(let i=1; i<10; i++){
        multiple = i * inputNumber;
        sum = multiple + sum;
    }
    number.innerHTML = document.getElementById("input-gugudan").value + "단의 합계: " + sum;
}

function hello(){
    const hello = document.getElementById("welcome");
    const age = document.getElementById("age").value;
    const lastName = document.getElementById("lastname").value;

    if(!isNaN(age)){
        if(age >= 18){
            hello.innerHTML = lastName + "님, 안녕하세요. 성인으로 확인되었습니다."
        } else if(age < 18){
            hello.innerHTML = lastName + "님, 안녕하세요. 미성년자로 확인되었습니다."
        }
    } else {
        hello.innerHTML = "나이를 유효한 숫자로 입력하세요."
    }

}

function checkNumber(){
    const number = document.getElementById("number");
    const inputNumber = document.getElementById("input-number").value;

    if(inputNumber % 2 == 0){
        number.innerHTML = "입력한 숫자는 짝수입니다.";
        number.style.color = "blue";
    } else if(inputNumber% 2 != 0){
        number.innerHTML = "입력한 숫자는 홀수입니다.";
        number.style.color = "red";
    }
}