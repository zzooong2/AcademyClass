import BackButton from "../components/common/BackButton";
// 자식 컴퍼넌트 Props 호출
import Child from "../components/06_Child";

export default function PropsPage() {
    return(
        <>
            <Child size={300} picture={{ name: "지옥 참마도 할매", imageURL: "/src/assets/지옥참마도10.jpg"}}/>
            <br />
            <BackButton />
        </>
    );
}