import PropTypes from "prop-types"

// 구조 분해할당 {{size, picture}} : 배열이나 객체의 속성을 해체하여 그 값을 개별 변수에 담을 수 있도록 도와주는 자바스크립트 표현식
// [a, b, ...rest] = [10, 20, 30, 40, 50]
// console.log(a) -> [10]
// console.log(b) -> [20]
// console.log(rest) -> [30, 40, 50]
export default function Child({size, picture}) {
    console.log(size, picture)
    return (
        <>
            <img src={picture.imageURL} alt={picture.name} width={size} height={size}></img>
        </>
    );

}

Child.propTypes = {
    // size를 number타입으로 받고 필수로 입력받겠다.
    size: PropTypes.number.isRequired,

    // shape: 자바스크립트 객체 타입검사시 사용
    picture: PropTypes.shape({

        // imageURL를 string타입으로 받고 필수로 입력받겠다.
        imageURL: PropTypes.string.isRequired,
        // name을 string타입으로 받고 필수로 입력받겠다.
        name: PropTypes.string.isRequired,
    }),
};