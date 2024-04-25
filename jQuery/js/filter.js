$("tr:first").css("color", "blue");
$("tr:last").css("color", "blue");

$("tr:even").css("color", "green");
$("tr:odd").css("color", "red");

// table css---------------------------

// p 태그의 첫번째
$("p").first().css("color", "blue");

// p 태그의 마지막
$("p").last().css("color", "red");

// filter: 선택된 요소를 변경
$("p").filter(".filter-test").html("<span>선택됨</span>");

// not: 선택 안된 요소를 변경
$("p").not(".filter-test").text("<span>사용됨</span>");

$("p").eq(3).css("color", "aqua");