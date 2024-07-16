import { useState } from "react";

export default function ClickCount() {
    // // 기존 자바스크립트 방식 (리랜더링이 안되기에 값 변경 X)
    // let count = 0;

    // function handelClickCount() {
    //     count ++;
    //     alert("클릭 되었습니다.")
    // }

    // 초기 상태 설정: useState(0);
    // 상태 변수와 상태 변경 함수 생성: const [count, setCount] 
    const [count, setCount] = useState(0);

    function handleClickCount(){
        // 상태 업데이트: setCount(count + 1);
        setCount(count + 1);
        if(count < 10) {
            setCount(count + 1);
            console.log("클릭 되었습니다.");
        } else {
            alert("더 이상 클릭할 수 없습니다.");
        }
    }

    return (
        <>
            <h2>{count}</h2>
            {/* {count < 10 && <h2>{count}</h2>}
            {count >= 10 && <h2>10</h2>} */}
            <button onClick={handleClickCount}>Click</button>
        </>
    )
}
