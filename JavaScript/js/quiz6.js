
// id: 영어 소문자, 숫자만 사용가능 / 6글자 이상 20글자 이하
function idCondition() {
    const inputId = document.getElementById("id").value; // input
    const show = document.getElementById("id-msg"); // span
    
    const idPattern = /^[a-z0-9]{6,20}$/; // 조건
    
    if(idPattern.test(inputId)) {
        show.innerHTML = "사용 가능한 아이디입니다.";
        show.style.color = "green";
    } else {
        show.innerHTML = "영어 소문자, 숫자를 이용하여 6~20 글자 내외로 작성해주세요."
        show.style.color = "red";
    }
}

// pw: 소문자 또는 대문자 최소 1개 이상 / 특수문자 최소 1개 이상 / 6글자 이상 20글자 이하
function pwCondition() {
    const inputPassword = document.getElementById("password").value; // input
    const passwordMsg = document.getElementById("password-msg"); // span
    
    const pwPattern = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_]).{6,20}$/; // 조건
    
    if(pwPattern.test(inputPassword)){
        passwordMsg.innerHTML = "사용 가능한 패스워드입니다.";
        passwordMsg.style.color = "green";
    } else {
        passwordMsg.innerHTML = "사용 불가한 패스워드입니다.";
        passwordMsg.style.color = "red";
    }
    
}


// 비밀번호 확인
function checkPassword() {
    const inputPassword = document.getElementById("password").value; // input
    const inputCheckedPassword = document.getElementById("password-check").value; // input
    const checkedPasswordMsg = document.getElementById("password-check-msg"); // span 
    
    if(inputPassword === inputCheckedPassword) {
        checkedPasswordMsg.innerHTML = "비밀번호가 동일합니다.";
        checkedPasswordMsg.style.color = "green";
    } else {
        checkedPasswordMsg.innerHTML = "비밀번호가 상이합니다.";
        checkedPasswordMsg.style.color = "red";
    }

}
































// const pwPattern2 = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]+/; // 특수문자 최소 1개 이상
// const pwPattern3 = /{6,12}/; // 6글자 이상, 12글자 이하