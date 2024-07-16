import { useState } from "react"

export default function ArrayState() {
    // 상태 초기 값 설정
    const [items, setItems] = useState(['wallet', 'perfume', 'mirror']);

    // 아이템 추가
    function addItem() {
        setItems((items) => [...items, "phone"]);
    }

    // 아이템 삭제
    function deleteItem(index) {
        setItems((items) => items.filter((_, i) => i !== index))

        // items = ['wallet', 'perfume', 'mirror'];
        // i=0, index=1
        // return 0 !== 1 --> true, 새로운 배열을 반환
        // 결과: ["wallet"]

        // i=1, index=1
        // return 0 === 1 --> false, 반환 x

        // i=2, index=1
        // return 2 !== 1 --> true, 새로운 배열을 반환
        // 결과: ['wallet', 'mirror']
    }
    
    // 아이템 변경
    function updateItem(index, newItem) {
        setItems((items) => 
            items.map((item, i) => (i === index ? newItem : item)));
    }

    return (
        <>
            <ul>
                {items.map((item, index) => (
                    <li key={index}>
                        {item}
                        <button onClick={() => deleteItem(index)}>Remove</button>
                        <button onClick={() => updateItem(index, "변경됨")}>Update</button>
                    </li>
                ))}
            </ul>
            <button onClick={addItem}>Add Item</button>
        </>
    )


}