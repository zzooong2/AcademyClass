import ClickCount from "../components/08_State"
import ObjectState from "../components/08_ObjectState"
import ArrayState from "../components/08_ArrayState"
import BooleanState from "../components/08_BooleanState"
import InputState from "../components/08_InputState"

export default function StatePage() {
    return (
        <>
            <h1>Click</h1>
            <ClickCount />
            
            <hr />

            <h1>객체 상태 변경하기</h1>
            <ObjectState />

            <hr />

            <h1>배열 상태 변경하기</h1>
            <ArrayState />

            <hr />

            <h1>버튼 토글</h1>
            <BooleanState />

            <hr />

            <h1>인풋 토글</h1>
            <InputState />
        </>
    )
}