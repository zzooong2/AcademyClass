const list = $("#list");

function elementAdd() {
    const listItem = $("<li></li>")
                        .html("리스트")
                        .css("color", "green");
    // append: 추가
    list.append(listItem);

    // remove: 삭제
    // listItem.remove();
}