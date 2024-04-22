// function consolePrint(){
//     // resolve: 성공, reject: 실패
//     return new Promise(function(resolve, reject) {
//         setTimeout(function() {
//             const user = {name: '김현중', age: 31};
//             resolve(user);
//         },2000);
//     });
// }

// async function getPrint(){
//     try {
//         const result = await consolePrint();
        
//         console.log("실행 완료: " + result);
//     } catch (error) {
//         console.log("에러 발생: " + error);
//     }
    
//     console.log("코드 실행");
// }

// getPrint();
// console.log("함수 호출 완료");

// // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
// // function consolePrint(){
// //     return new Promise(function(resolve, reject) {
// //         setTimeout(function() {
// //             resolve(user);
// //         },2000);
// //     });
// // }
// // 위, 아래 같은 행위를 하는 로직
// // consolePrint()
// //     .then(result => console.log(result))
// //     .catch(error => console.log(error));


// // const result = await consolePrint();
// // 화살표 코드로 작성 
// // const result = await new Promise((resolve, reject) => {
// //     resolve("작업성공");
// // })         
// // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ


// // 콜백함수 이용 - 사용자의 이름을 1초 뒤에 출력하는 로직
// function getUserData(callback) {
//     setTimeout(() => {
//         const userName = "김현중";
//         callback(userName);
//     },1000)
// }

// getUserData(function(result){
//     console.log(result);
// });

// // 프로미스 이용 - success 변수의 값에 따라 변경
// // 성공: data 출력
// // 실패: "실패했습니다." 출력
// function fetchData(success) {
//     return new Promise((resolve, reject) => {
//         const data = "데이터";
//         if(success){
//             resolve(data);
//         } else {
//             reject("실패했습니다.");
//         }
//     });
// }

// fetchData(true)
// .then(result => console.log(result))
// .catch(error => console.log(error));


// // 홀수일 경우 then으로 받는 결과를 "홀수입니다." 출력
// // 짝수일 경우 catch로 받는 결과를 "짝수입니다." 출력

// function checkOddEven(num){
//     return new Promise((resolve, reject) => {
//         const odd = "홀수입니다.";
//         const even = "짝수입니다.";

//         if(num % 2 == 1) {
//             resolve(odd);
//         } else {
//             reject(even);
//         }
//     });
// }

// checkOddEven(6)
// .then(result => console.log(result))
// .catch(error => console.log(error));

// 2초 뒤 이메일계정 반환
function getUserByEmail() {
    const email = "zzooong2@gmail.com";
    console.log("promise return 전");
    
    return new Promise((resolve, reject) => {
        console.log("setTimeout 전");
        setTimeout(() => {
            resolve(email);
        }, 2000)
        console.log("setTimeout 후");
    });
}

async function emailPrint() {
    try {
        console.log("await 실행 전");
        const getEmail = await getUserByEmail();
        console.log("await 실행: " + getEmail);
    } catch (error) {
        console.log("실행 실패: " + error);
    }
}

console.log("함수 호출 전");
emailPrint();
console.log("함수 호출 후");