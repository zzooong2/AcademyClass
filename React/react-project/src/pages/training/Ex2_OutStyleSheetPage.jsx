import "../../styles/OutStyleSheetPage.css"

export default function OutStyle() {
    return(
        <>
         <h1>실습 문제 1</h1>
         <h3>2024년 9월 가계부 : <a href="https://www.naver.com">조회하기</a></h3>

         <table>
        <thead>
            <tr>
                <th>날짜</th>
                <th>입금</th>
                <th>내역</th>
                <th>출금</th>
                <th>내역</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>2023-09-20</td>
                <td className="td-red">+100,000원</td>
                <td>부수입(투잡)</td>
                <td>-</td>
                <td>-</td>
            </tr>
            <tr>
                <td>2023-09-21</td>
                <td>-</td>
                <td>-</td>
                <td className="td-blue">-350,000원</td>
                <td>마우스, 키보드, 의자 구입</td>
            </tr>
            <tr>
                <td>2023-09-22</td>
                <td>-</td>
                <td>-</td>
                <td className="td-blue">-135,000원</td>
                <td>인터넷비, 핸드폰비</td>
            </tr>
            <tr>
                <td>2023-09-22</td>
                <td className="td-red">+1,000,000원</td>
                <td>월급</td>
                <td className="td-blue">-250,000원</td>
                <td>카드값</td>
            </tr>
            <tr>
                <td colspan="5"><strong>남은 금액 : 590,000원</strong></td>
            </tr>
            </tbody>
        </table>
        </>
    );
}