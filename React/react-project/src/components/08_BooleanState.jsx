import { useState } from "react";

export default function BooleanState() {
    const [isClick, setIsClick] = useState(true);
    
    return (
        <> 
            {/* 버튼 클릭 시 텍스트 숨기기, 보이기 */}
            <button onClick={() => setIsClick(!isClick)}>
                {isClick ? "Hide" : "Show"}
            </button>
            {isClick && <p>Hello!</p>}
        </>
    )
}