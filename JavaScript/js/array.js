function array(){
    // javascript: 배열내부 값 자료형 상관 X
    let arr = ["Hello", 'World', 777, true, [10, 20, 30]];
    
    const showArray = document.getElementById("array");

    // 1. 배열 값 하나씩 꺼내기 (for문 )
    for(let i=0; i<arr.length; i++){
        // 2. 꺼낸 값 추가 해주기
        showArray.innerHTML += arr[i] + "<br>";
    }
}

function test() {
    const result = document.getElementById("result");

    // 배열의 크기가 동적으로 관리됨
    let arr = new Array();
    console.log(arr.length);
    arr[0] = "홍길동";
    console.log(arr.length);

    console.log("------------------------------");
    
    // 배열의 크기가 동적으로 관리됨
    let array = new Array(3);
    console.log(array.length);
    array[0] = "A";
    array[1] = "B";
    array[2] = "C";
    array[3] = "D";
    console.log(array.length);
    console.log(array.indexOf("C"));

    console.log("------------------------------");
    
    // [] 이렇게도 선언할 수 있음
    let blankArray = [];
    console.log(blankArray.length);
    blankArray[0] = "b";
    console.log(blankArray.length);
    
    console.log("------------------------------");

    // 인덱스에 숫자 여러개를 넣으면 0부터 시작하는 인덱스에 차례대로 초기화
    let setArray = new Array(1, 5);
    console.log(setArray.length);
}

// 사용자가 입력한 메뉴의 인덱스를 출력해보기
function selectMenu(){
    let list = ["국밥", "돈까스", "초밥", "김밥", "멸치국수", "소맥"];
    const show = document.getElementById("lunch");

    // 1. 사용자가 입력한 값 가져오기
    const inputMenu = document.getElementById("menu").value;

    // 2. 가져온 값이 몇번 인덱스에 있는지 찾기
    let find = list.indexOf(inputMenu);

    // 3. 찾은 인덱스를 화면에 출력 
    // 단, 메뉴가 없으면 "ㅇㅇㅇ 메뉴가 없습니다."" 출력
    //    메뉴가 있으면 "ㅇㅇㅇ 메뉴가 ㅇ 번째에 있습니다."" 출력
    if(find === -1) {
        show.innerText = inputMenu + " 메뉴가 없습니다.";
    } else if(find <= list.length) {
        show.innerText = inputMenu + " 메뉴가 " + (find+1) + "번째에 있습니다."
    }


}