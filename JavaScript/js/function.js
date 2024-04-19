function argsTest(value1, value2){
    const result = document.getElementById("argsResult1");
    
    result.innerHTML = value1 + " " + value2;
}

// arguments: 함수마다 내부적으로 존재하는 배열 객체
//            인자값의 개수와 상관없이 배열에 담아서 저장
//            array 관련 함수 사용불가 (indexOf, join, pop, push ...)
//            유사배열 (배열인 척 하는 객체)
function argsTest2(){
    const result = document.getElementById("argsResult2");
    
    console.log(arguments);
    
    for(let i=0; i<arguments.length; i++){
        result.innerHTML += arguments[i] + "&nbsp";
    }
}

// ...(가변인자): 여러개의 매개변수를 배열로 받아서 저장
//              배열
//              가변인자는 항상 마지막에 선언해야함. 
//              argsTest3(arg, ...args) -> 에러 발생
function argsTest3(...args){
    const result = document.getElementById("argsResult3");
    
    console.log(args);
    
    for(let i=0; i<args.length; i++){
        result.innerHTML += args[i] + "&nbsp";
    }
}

// 익명함수: 한번 사용하는 기능이 필요할 때 사용
const anonymous = function(num1, num2){
                console.log(num1 + num2);
                }
            
console.log("익명함수");
anonymous(10, 20);

// 화살표함수: 코드 라인 줄이기 위해, 가독성을 높이기 위해 사용
//          return 생략 가능
const arrow = (num1, num2) => console.log(num1+num2);
console.log("화살표함수");
arrow(10, 20);


console.log("화살표함수의 다른 사용방법");
const arrow2 = (num1, num2) => num1+num2;
console.log(arrow2(30, 40));


// 생성자함수 : 관례적으로 생성자 함수는 앞 글자 대문자 사용
//           객체를 재사용하기 위해 사용
//           함수가 종료되어도 데이터에 계속 존재 (새로고침, 브라우저 종료시 없어짐)
function Person(name, age){
    this.name = name;
    this.age = age;
    this.walk = function() {
        return "산책";
    }
}

const p1 = new Person('김현중', 31);
console.log(p1);

p1.walk();
console.log(p1.walk());


// 내부함수: 함수 내에서 다시 정의된 함수
function outerFunc() {
    let number = 10;

    console.log("outer 함수 실행");
    function innerFunc() {
        console.log("number 값: " + number);
    }

    innerFunc();
    console.log("outer 함수 종료");
}
outerFunc();


// 재귀함수: 본인을 다시 호출하는 함수
function recursion(cnt) {
    if(cnt === 0){
        console.log("end");
    } else {
        console.log("호출횟수: " + cnt);
        recursion(cnt-1);
    }
}
recursion(3);

function getFactorial(num){
    if(num === 0){
        return 1;
    } else {
        return num * getFactorial(num-1);
    }
}
console.log(getFactorial(10));


// 콜백함수: 매개변수의 자리에 함수가 들어가는 구조
//         비동기 프로그래밍을 할 때 자주 사용

setTimeout(function() {
    console.log("left 2 seconds.");
}, 2000);
console.log("before timeout");

// ex1
function first(callback) {
    console.log("first 함수 실행");
    
    callback();
}

first(function() {
    console.log("second 함수 실행");
});

// ex2
function firstFunc(callback){
    console.log("firstFunc 함수 실행");
    callback();
}

function secondFunc(){
    console.log("secondFunc 함수 실행");
}

firstFunc(secondFunc);