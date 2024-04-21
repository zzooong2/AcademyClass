// 랜덤 숫자
const randomNumber = Math.floor(Math.random() * (100 - 1 + 1)) + 1;

// 다시하기
function reload() {
    location.reload();
}

const guessInput = document.getElementById("guessInput"); // input
const submitGuess = document.getElementById("submitGuess"); // button
const show = document.getElementById("message"); // p
let cnt = 0; // 시도 횟수

// input에서 사용자가 엔터 누르면 제출 버튼 클릭될 수 있게
guessInput.addEventListener('keydown', function(event) {
    if(event.keyCode === 13){
        submitGuess.click();
    }
});

function check(){
    const inputValue = document.getElementById("guessInput").value; // input value
    const replay = document.getElementById("resetGuess");
    cnt++; // 시도횟수 증가
    
    console.log("랜덤숫자: " + randomNumber);
    console.log("입력숫자: " + inputValue);
    console.log("입력횟수: " + cnt);
    console.log("-----------------------");

        // 사용자가 입력한 숫자와 랜덤 숫자를 비교
    if(inputValue == randomNumber) { 
        // 숫자를 맞추면 몇번째 만에 숫자를 맞췄는지 알려줌
        // "축하합니다! 3번째 시도만에 숫자를 맞추셨습니다"
        show.innerHTML = "축하합니다! " + cnt + "번째 시도에 숫자를 맞추셨습니다!";
        show.style.fontSize = "14px";
        show.style.color = "green";
        replay.style.display = "inline-block";
    } else if (inputValue < randomNumber) {
        // "숫자가 너무 작습니다. 다시 시도하세요"
        show.innerHTML = "숫자가 너무 작습니다. 다시 시도하세요";
    } else if (inputValue > randomNumber) {
        // "숫자가 너무 큽니다. 다시 시도하세요"
        show.innerHTML = "숫자가 너무 큽니다. 다시 시도하세요";
    }

}

// 제출 후 로직
submitGuess.addEventListener('click', function() {
    const inputValue = document.getElementById("guessInput").value; // input value
    
    // 1부터 100 사이가 아닌 숫자를 입력 받으면 "1부터 100 사이의 숫자를 입력하세요." 출력
    if(inputValue >= 1 && inputValue <= 100) {
        // 0초부터 2초동안 0.5초마다 "두구두구" 문자열 뒤에 . 추가
        // ex)   0초 : 두구두구
        setTimeout(function() {
            show.innerHTML = "두구두구";
        }, 0);
        
        // ex) 0.5초 : 두구두구.
        setTimeout(function() {
            show.innerHTML = "두구두구.";
        }, 500);
        
        // ex)   1초 : 두구두구..
        setTimeout(function() {
            show.innerHTML = "두구두구..";
        }, 1000);
        
        // ex) 1.5초 : 두구두구...
        setTimeout(function() {
            show.innerHTML = "두구두구...";
        }, 1500);
        
        // ex)   2초 : 두구두구....
        setTimeout(function() {
            show.innerHTML = "두구두구....";
        }, 2000);

        setTimeout(function() {
            check();
        }, 3000);
    } else {
        show.innerHTML = " 0 ~ 100 사이의 숫자를 입력해주세요."
    }

});
    