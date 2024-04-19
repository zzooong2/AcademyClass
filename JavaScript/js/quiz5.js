const btn = document.getElementById("btn");
const show = document.getElementById("output");
let flag = true;

btn.addEventListener('click', function() {
    if(flag){
        btn.innerHTML = "클릭 되었습니다.";
        show.innerHTML = "버튼이 클릭되었습니다.";
        flag = false;
    } else {
        btn.innerHTML = "최소 되었습니다.";
        show.innerHTML = "버튼이 취소되었습니다.";
        flag = true;
    }
});