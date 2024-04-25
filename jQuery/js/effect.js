// hide
$("#hide-btn").click(function() {
    $("#mainoo").hide(5000);
    $('#div-area').hide(2000);
})

// show
$("#show-btn").click(function() {
    $("#mainoo").show(5000);
    $("#div-area").show(2000);
})

// toggle: 처음 누르면 hide, 다시 누르면 show
$("#toggle-btn").click(function() {
    $("#mainoo").toggle(10000);
    $("#div-area").toggle(4000);
})


// fadeOut
$("#fadeOut").click(function() {
    $("#mctominay").fadeOut(2000);
})

// fadeIn
$("#fadeIn").click(function() {
    $("#mctominay").fadeIn(2000);
})

// fadeToggle
$("#fadeToggle").click(function() {
    $("#mctominay").fadeToggle(2000);
})

// slideUp, slideDown
$("div").click(function() {
    const answer = $(this).next();

    if(answer.css("display")==="none") {
        $(this).siblings("p").slideUp();
        answer.slideDown();
    } else {
        answer.slideUp();
    }
})
