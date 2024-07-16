import { useState } from "react";

export default function ObjectState() {
    // 객체 초기화
    const [user, setUser] = useState({name:"Kim", age: 31});
    
    function updateName() {
        // ...: 구조분해할당 (Spread 연산자)
        setUser((prevUser) => ({ ...prevUser, name: "Lee", age: 19}));
    }

    return (
        <>
            <p>Name: {user.name}</p>
            <p>Age: {user.age}</p>
            <button onClick={updateName}>Click</button>
        </>
    )
}