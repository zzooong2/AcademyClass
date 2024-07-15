
export default function Event() {
    function handleClick() {
        alert("클릭 되었습니다.");
    }

    return <button onClick={handleClick}>Click!</button>;
}

// 1. 이벤트 리스너: 이벤트 등록, 삭제
// HTML요소.AddEventListener('click', function() { 실행할 동작 정의 })

// 2. 이벤트 핸들러: 이벤트 발생시 실행할 동작(함수)
// <button onclick="func()">버튼</button>
// function func() { 실행할 동작 정의 }