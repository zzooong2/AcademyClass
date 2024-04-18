function input(){
    const number = document.getElementById("num").value;
    const show = document.getElementById("quiz");
    
    show.innerText = "입력한 숫자: " + number;
}

function multiple(){
    const num = document.getElementById("num").value;
    const show = document.getElementById("mul");

    let common = 0;
    for(let i=1; i<num; i++){
        if(i%3==0 && i%5==0){
            common = i;
            
            show.innerHTML += common + "<br>";
        }
    }

}

function factorial(){
    const num = document.getElementById("num").value;
    const show = document.getElementById("fac");

    let fac = "";
    let factorial = 1;

    for(let i=1; i<=num; i++){
        factorial *= i;
        fac += i + "*";
    }

    show.innerHTML = num + "의 factorial: " + factorial + "<br>" + fac;
}

function change(){
    const cc = document.getElementsByClassName("color")[0];
    
    console.log(cc.style.backgroundColor);

    if(cc.style.backgroundColor == "gray"){
        cc.style.backgroundColor = "lightpink";
    } else if(cc.style.backgroundColor == "lightpink") {
        cc.style.backgroundColor = "skyblue";
    } else if(cc.style.backgroundColor == "skyblue") {
        cc.style.backgroundColor ="lightpink";
    }
}   


function sum() {
    const kor = getValue("kor");
    const eng = getValue("eng");
    const mat = getValue("mat");
    const sci = getValue("sci");

    const show = document.getElementById("sum");
    show.innerText = "합계: " + (parseInt(kor) + parseInt(eng) + parseInt(mat) + parseInt(sci)) + "점";
}

function avg() {
    const kor = getValue("kor");
    const eng = getValue("eng");
    const mat = getValue("mat");
    const sci = getValue("sci");
    
    const show = document.getElementById("avg");
    show.innerText = "평균: " + ((parseInt(kor) + parseInt(eng) + parseInt(mat) + parseInt(sci)) / 4) + "점";
}

function getValue(id) {
    return parseInt(document.getElementById("kor").value);
}