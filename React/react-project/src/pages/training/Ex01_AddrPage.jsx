// URL: /Training/AddrPage
// p태그 입력된 주소: [쿼리스트링에 입력한 주소]
// 뒤로가기 버튼
import useQuery from "../../components/common/UseQuery";

import BackButton from "../../components/common/BackButton";

function QueryString() {
    // 자바스크립트 코드
    const query = useQuery();

    // 쿼리스트링의 key가 value를 가져온다
    const getAddr = query.get("addr");

    return (
        <>
        <p>입력된 주소: {getAddr}</p>
        <BackButton />
        </>
    );
}

export default QueryString