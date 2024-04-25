// 부모요소 탐색 메서드
// parent(): 바로 위에 있는 상위요소 한개 선택
$("span").parent().css("color", "green");
// parents(): 모든 상위요소 선택
$("li").parents().css("color", "red");
// parent("선택자"): 모든 상위요소 중, 선택자와 일치하는 요소 선택
$("li").parents("div").css("color", "red");



// 자식요소 탐색 메서드
// childern(): 모든 자식요소 선택
// childern("선택자"): 모든 자식요소 중, 선택자가 일치하는 요소 선택
// find("선택자"): 모든 후손요소 중, 선택자가 일치하는 요소 선택

const borderStyle = {color:"green", border:"1px solid green"};
    // $(".wrap").children().css(borderStyle);
    $(".wrap").children().children().css(borderStyle); // 연달아 쓰면 div > div > ul
    $(".wrap").find(li).css("color", "blue"); //