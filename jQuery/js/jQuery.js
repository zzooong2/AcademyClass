/*
// JavaScript 방식
const textColorGreen = document.getElementById("text-color-green");

for(let i=0; i<textColorGreen.length; i++){
    textColorGreen[i] = "green";
}
 */

// jQuery 방식
$(".text-color-green").css("color","green");
// p --------------------------------------------------------------------


$("ul > li").css("color", "blue");
$("ul > li > h3").css("color", "hotpink");
// div > ul > li > h3 ---------------------------------------------------


$("input[type=text]").val("value");

console.log($("input[type=checkbox]"));
$("input[type=checkbox]").attr("checked", true);

// $("input[type=button").val("버튼");
// $("input[type=button").css("height", "100px");

// 메서드 체이닝 : 메서드를 연속적으로 호출하는 방식
// $("input[type=button")
//     .css("height", "30px")
//     .css("width", "30px")
//     .val("버튼");

    $("input[type=button")
    .css({height:"30px", width:"30px"})
    .val("버튼");
// input ----------------------------------------------------------------