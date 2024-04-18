function checkType(){
    let name = "김현중";
    let age = 31;
    let flag = true;
    let hobby = ["축구시청", "농구시청", "여행"];
    let memberInfo = {
        name: "홍길동",
        age: 22,
        flag: false
    };

    // typeof(): 객체의 타입 확인
    console.log(typeof(name));
    console.log(typeof(age));
    console.log(typeof(flag));
    console.log(typeof(hobby));
    console.log(typeof(false));
    
    console.log("----------------------------");
    
    console.log(name);
    console.log(age);
    console.log(flag);
    console.log(hobby);
    console.log(memberInfo);
    
    console.log("----------------------------");
    
    // index로 접근
    console.log(hobby[1]);
    // key로 접근
    console.log(memberInfo.age);
}

function showType(){
    const typeText = document.getElementById("type");

    let name = "김현중";
    let age = 31;
    let flag = true;
    let hobby = ["축구시청", "농구시청", "여행"];
    let memberInfo = {
        name: "홍길동",
        age: 22,
        flag: false
    };

    typeText.innerHTML = name + " 자료형: " + typeof(name) + "<br>"
    typeText.innerHTML += age + " 자료형: " + typeof(age) + "<br>"
}
