import { useState } from "react";

export default function InputState() {
    // 사용자로부터 입력받은 값을 저장하는 변수
    const [inputValue, setInputValue] = useState("");
    // 더한 값을 저장하는 변수
    const [addResult, setAddResult] = useState(null);

    function add() {
        const numberValue = parseInt(inputValue);

        // NaN: Not a Number
        if(isNaN(numberValue)){
            setAddResult("숫자를 입력해주세요.");
        } else {
            setAddResult(numberValue + 10);
        }
    }

    return (
        <>
            <input type="text" onChange={(e) => setInputValue(e.target.value)}/>
            <button onClick={add}>+ 10</button>
            {addResult !== null && <p>result: {addResult}</p>}
        </>
    )
}