function testObject(){
    const show = document.getElementById("result-1");
    
    const member = {
        name: "김현중",
        age: 31,
        address : "안양"
    };

    console.log(member);

    // show.innerHTML = "이름: " + member["name"] + "</br>";
    show.innerHTML = "이름: " + member.name + "</br>";
    show.innerHTML += "나이: " + member.age + "</br>";
    show.innerHTML += "주소: " + member.address + "</br>";

    for(let item in member) {
        console.log(item + ": " + member[item]);
    }    

}   


function testObject2() {
    const show = document.getElementById("result-2");
    
    const car = {
        name: "레이",
        type: "경차",
        drive: function(point) {
            console.log(this);
            show.innerHTML = "차량명: " + this.name + "<br>"
            show.innerHTML = "차분류: " + this.type + "<br>"
            show.innerHTML = "여행지: " + point + "<br>"
        },
        
        testDrive: (point) => {
            console.log(this);
            show.innerHTML = "차량명: " + this.name + "<br>"
            show.innerHTML = "차분류: " + this.type + "<br>"
            show.innerHTML = "여행지: " + point + "<br>"
        }
    }
    
    car.drive("제주도");
    car.testDrive("강원도");
}


function testObject3(){
    const show = document.getElementById("result-3");
    
    const object = {
        name: "김현중",
        exec: function() {
            console.log(this.name);
            const name = "백재롱";

            const innerArrow = () => {
                console.log(this.name);
            }
            innerArrow();
        },

        execArrow: () => {
            console.log(this.name);
        }
    }

    object.exec();
}

function testObject4() {
    const member1 = {name: "유저1", age: 19, address: "안양"};
    const member2 = {name: "유저2", age: 30, address: "인천"};
    const member3 = {name: "유저3", age: 40, address: "서울"};

    let members = [member1, member2, member3];

    console.log(members[0].age);
    console.log(members[1].name);
    console.log(members[2].address);
    console.log("------------------");

    let sum = 0;
    let avg = 0;
    for(let i=0; i<members.length; i++){
        sum += members[i].age;
    }
    avg = sum/members.length;

    console.log(sum);
    console.log(avg);
}   


