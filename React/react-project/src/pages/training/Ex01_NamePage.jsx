// URL: /Training/NamePage
// p태그 입력된 이름 : [경로 파라미터로 가져온 이름]
// 뒤로가기 버튼

import { useParams } from "react-router-dom";
import BackButton from "../../components/common/BackButton";

function PathVariable() {
    const {value} = useParams();

    return (
        <>
            <p>입력된 이름: {value}</p>
            <BackButton />
        </>
    );
}

export default PathVariable