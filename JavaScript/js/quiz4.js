function setAbs(){
    const inputNum = document.getElementById("num1").value;
    const show = document.getElementById("abs");

    const absNum = Math.abs(inputNum);
    show.innerHTML = absNum;
}

function getLength(){
    const inputText = document.getElementById("input-text").value;
    const show = document.getElementById("length");
    
    show.innerHTML = Object.keys(inputText).length;
}

function getSum(){
    const inputNum1 = parseInt(document.getElementById("get-num-1").value);
    const inputNum2 = parseInt(document.getElementById("get-num-2").value);
    const inputNum3 = parseInt(document.getElementById("get-num-3").value);
    const show = document.getElementById("sum");

    show.innerHTML = (inputNum1 + inputNum2 + inputNum3);
}

function getMin(){
    const getNum1 = document.getElementById("get-num1").value;
    const getNum2 = document.getElementById("get-num2").value;
    const show = document.getElementById("min");

    const arr = [getNum1, getNum2];
    let min = 100;

    for(let i=0; i<arr.length; i++){
        if(min > arr[i]) {
            min = arr[i];
        }
    }

    show.innerHTML = min;
}

function upper(){
    const getString = document.getElementById("input-string").value;
    const show = document.getElementById("upper");
    
    show.innerHTML = getString.toUpperCase();
}

function minus(){
    const getMinusNum1 = parseInt(document.getElementById("minus-num-1").value);
    const getMinusNum2 = parseInt(document.getElementById("minus-num-2").value);
    const show = document.getElementById("minus");
    
    show.innerHTML = (getMinusNum1-getMinusNum2);
    
}

function checkNumber(){
    const checkNumber = document.getElementById("check-number").value;
    const show = document.getElementById("check");
    
    console.log(checkNumber);
    
    if(checkNumber > 0){
        // show.innerHTML = "양수";
        alert("양수 입니다.");
    } else if(checkNumber < 0 ){
        // show.innerHTML = "음수";
        alert("음수 입니다.");
    } else if(checkNumber == 0){
        // show.innerHTML = "0";
        alert("0 입니다.");
    }
}

function addNumber(){
    const addNumber1 = parseInt(document.getElementById("add-number-1").value);
    const addNumber2 = parseInt(document.getElementById("add-number-2").value);
    const show = document.getElementById("add");
    
    show.innerHTML = (addNumber1+addNumber2);
}

function checking(){
    const checkingNumber1 = document.getElementById("checking1").value;
    const checkingNumber2 = document.getElementById("checking2").value;
    const checkingNumber3 = document.getElementById("checking3").value;
    const show = document.getElementById("checking");

    checkingArray = [checkingNumber1, checkingNumber2, checkingNumber3];

    let maxObject = 1;
    for(let i=0; i<checkingArray.length; i++){
        if(maxObject < checkingArray[i]){
            maxObject = checkingArray[i];
        }
    }
    show.innerHTML = maxObject;
}