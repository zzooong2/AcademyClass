import { useState } from "react"

export default function StateQuizePage() {
    // ****************** 문제 1 ******************
    // 사용자로부터 입력받은 값을 저장하는 변수
    const [inputValue1, setInputValue1] = useState("");

    function q1Func(){
        alert(inputValue1 + "님 환영합니다.");
    }

    // ****************** 문제 2 ******************    
    // 사용자로부터 입력받은 값을 저장하는 변수
    const [inputValue2, setInputValue2] = useState("");
    const arr = [];

    // 곱한 값을 저장하는 변수
    const [result2, setResult2] = useState(null);

    function q2Func(){
        // 형변환
        const numberValue2 = parseInt(inputValue2);
        
        if(isNaN(numberValue2)){
            setResult2("숫자를 입력해주세요.");
        } else {
            for(let i=1; i<10; i++) {
                // 배열에 요소 추가하기
                arr[i-1] = inputValue2 * i;
                    
            }
        }
    }

    return (
        <>
            <h3>Q1. 사용자의 이름을 입력받고, 확인 버튼을 누르면 OOO님 환영합니다를 alert으로 출력하세요.</h3>
            <input type="text" onChange={(e) => setInputValue1(e.target.value)}/>
            <button onClick={q1Func}>확인</button>
            <hr / >

            <h3>Q2. 몇단을 출력할지 입력받고, 확인 버튼을 누르면 innerHTML을 활용해 구구단의 합계를 div 태그에 출력하세요.</h3>
            <input type="text" onChange={(e) => setInputValue2(e.target.value)} />
            <button onClick={q2Func}>확인</button>
            {result2 !== null && <ul>result: {result2}</ul>}
            <hr />
        </>
    )
}