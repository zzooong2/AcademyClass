// 1. map() 사용하여 animals 요소를 li 태그로 렌더링
// export default function Rendering({ animals }) {
//     return (
//         <>
//             <ul>
//                 {animals.map((animals, index) => {
//                     return <li key={index}>{animals}</li>
//                 })}
//             </ul>
//         </>
//     );
// }

// 2. filter() 사용하여 animals 요소를 li 태그로 렌더링
// 조건: 나이가 홀수인 동물
// 출력: 이름, 나이 모두 출력
export default function Rendering( {animals}) {
    // 나이가 홀수인 동물만 필터
    const firstFilter = animals.filter((animal) => (animal.age % 2) !== 0);
    // 요소 꺼내기
    const result = firstFilter.map((show, index) => {
        return( 
            <>
                <li key={index}>
                    <p>
                        name: {show.name}, age: {show.age}
                    </p>
                </li>
            </>
        )
    });

    return (
        <>
            <ul>
                {result}
            </ul>
        </>
    )

    
}