// 엔터키로 버튼 활성화
const areaQ1 = document.getElementById("numIsNan"); // input
const btnQ1 = document.getElementById("q1"); // button
areaQ1.addEventListener('keyup', function(event) {
    console.log(event.keyCode)
    if(event.keyCode === 13){
        btnQ1.click();
    }
});

// 숫자인지 확인
function Q1() {
    const inputElement = document.getElementById("numIsNan").value; // input value
    

    // 숫자 확인 로직 (isNaN -> 숫자가 아니면 true, 숫자면 false)
    if(isNaN(inputElement)) {
        alert("숫자가 아닙니다.");
    } else {
        alert("숫자입니다.");
    }
}

const areaQ2 = document.getElementById("nameChk"); // input
const btnQ2 = document.getElementById("q2"); // button

// 엔터키로 버튼 활성화
areaQ2.addEventListener('keyup', function(event) {
    if(event.keyCode === 13) {
        btnQ2.click();
    }
});


// 이름 찾기
function Q2() {
    const inputElement = document.getElementById("nameChk").value; // input value

    const arr = ['홍길동', '이순신', '김선달', '유재석', '강호동'];
    let index = false;

    for(let i=0; i<arr.length; i++){
        if(arr[i] == inputElement) {
            index = true;
        }
    }

    if(index == true){
        alert("이름이 있습니다.");
    } else {
        alert("이름이 없습니다.");
    }
}

// 전체선택 누르면 체크박스 모두 선택되게하는 로직
function selectAll() {
    let state = document.getElementById("Allchk"); // 전체선택 체크박스
    let checkBox = document.getElementsByName("leng"); // 체크박스

    for(let i=0; i<checkBox.length; i++) {
        if(state.checked){
            checkBox[i].checked = true;
        } else {
            checkBox[i].checked = false;
        }
    }
}

// 엔터키로 버튼 활성화
const areaQ4 = document.getElementById("ran");
const btnQ4 = document.getElementById("q4");

areaQ4.addEventListener('keyup', function(event){
    if(event.keyCode === 13) {
        btnQ4.click();
    }
});

function Q4() {
    const randomNum = Math.floor(Math.random()*21); // 난수 생성
    const inputArea = document.getElementById("ran"); // input
    // const random = document.createTextNode(randomNum);
    
    inputArea.value = randomNum;
}

// 엔터키로 버튼 활성화
const areaQ5 = document.getElementById("ran");
const btnQ5 = document.getElementById("q5");

areaQ5.addEventListener('keyup', function(event){
    if(event.keyCode === 13) {
        btnQ5.click();
    }
});

function Q5() {
    const inputName = document.getElementById("name").value; // name value
    const inputAge = document.getElementById("age").value; // age value
    const inputGender = document.getElementById("gender").value; // gender value

    const tbody = document.getElementById("insert"); // tbody
    const trTag = document.createElement("tr"); // tr 노드요소 생성
    const createTdName = document.createElement("td"); // td-name 노드요소 생성
    const createTdAge = document.createElement("td"); // td-age 노드요소 생성
    const createTdGender = document.createElement("td"); // td-gender 노드요소 생성

    const createName = document.createTextNode(inputName);
    const createAge = document.createTextNode(inputAge);
    const createGender = document.createTextNode(inputGender);

    // td 노드 생성 후 input에 기입한 값 기입
    createTdName.appendChild(createName);
    createTdAge.appendChild(createAge);
    createTdGender.appendChild(createGender);

    trTag.appendChild(createTdName);
    trTag.appendChild(createTdAge);
    trTag.appendChild(createTdGender);

    tbody.appendChild(trTag);
}
