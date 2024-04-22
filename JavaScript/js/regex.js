let regExp = /[a-z]/; // 소문자 알파벳 포함
console.log(regExp.test("ABC")); // false
console.log(regExp.test("abc")); // true

regExp = /[^a-z]/; // 소문자 알파벳 미포함
console.log(regExp.test("ABC")); // true
console.log(regExp.test("abc")); // false

regExp = /^[0-5]/; // 0-5로 시작
console.log(regExp.test(0)); // true
console.log(regExp.test(9)); // false

regExp = /[가-힣]$/; // 한글로 끝나는 문자열
console.log(regExp.test("가나다라")); // true
console.log(regExp.test("가나다ABC")); // false


// email 조건 검사하는 로직
function isValidEmail() {
    const inputEmail = document.getElementById("input-email").value;
    const show = document.getElementById("message");

    // \s : 공백문자(띄어쓰기, 탭, 줄바꿈 등)
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/;
    // ^ : 문자의 시작
    // [^\s@]+ : 공백문자, @ 제외 나머지 문자 1개 이상
    // @ : @
    // \. : .


    if(emailPattern.test(inputEmail)){
        show.innerHTML = "사용 가능한 이메일입니다.";
        show.style.color = "green";
    } else {
        show.innerHTML = "사용 불가한 이메일입니다.";
        show.style.color = "red";
    }
}
