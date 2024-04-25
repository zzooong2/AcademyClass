// click event

// $("#submit-button").click(function() {
//     alert($("input[type=password]").val());
// });

// 권장하는 방법
$("#submit-button").on(function() {
    alert($("input[type=password]").val());
});

/*
// mouseenter: 마우스가 요소 안으로 들어갈 때 발생하는 이벤트
$(".submit-button").on('mouseenter', function() {
    // submit-button 클래스를 가진 버튼 모두 변경
    // $(".submit-button").css("backgroundColor", "aqua");
    
    // 선택된 버튼만 변경
    $(this).css("backgroundColor", "aqua");
});

// mouseout: 마우스가 요소 밖으로 나갈때 발생하는 이벤트
$(".submit-button").on('mouseenter', function() {
    // $(".submit-button").css("backgroundColor", "white");
    
    // 선택된 버튼만 변경
    $(this).css("backgroundColor", "white");
});
*/

$(".submit-button").hover(function(){
    // $(this).css("backgroundColor", "red");
    $(this).addClass("in-color");
}, function() {
    // $(this).addClass("out-color");
    $(this).removeClass("in-color");
});

// button----------------------------------------------

$("#movie").on('change', function() {
    console.log($(this).val());
    
    const selectedMovie = $(this).val();
    const resultMovie = $("#result-movie");

    resultMovie.html(selectedMovie);
});