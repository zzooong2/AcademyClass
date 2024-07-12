

export default function InlinePage() {
    return(
        <>
         <h1>실습 문제 1</h1>
         <h3>2024년 9월 가계부 : <a href="https://www.naver.com">조회하기</a></h3>

         <table style={{width:"100", border:"1px solid black", textAlign:"center", backgroundColor:"powderblue", borderCollapse:"collapse"}}>
          <thead>
            <tr>
                <th style={{border:"1px solid black"}}>날짜</th>
                <th style={{border:"1px solid black"}}>입금</th>
                <th style={{border:"1px solid black"}}>내역</th>
                <th style={{border:"1px solid black"}}>출금</th>
                <th style={{border:"1px solid black"}}>내역</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue"}}>2023-09-20</td>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue", color:"red"}}>+100,000원</td>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue"}}>부수입(투잡)</td>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue"}}>-</td>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue"}}>-</td>
            </tr>
            <tr>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue"}}>2023-09-21</td>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue"}}>-</td>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue"}}>-</td>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue", color:"blue"}}>-350,000원</td>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue"}}>마우스, 키보드, 의자 구입</td>
            </tr>
            <tr>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue"}}>2023-09-22</td>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue"}}>-</td>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue"}}>-</td>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue", color:"blue"}}>-135,000원</td>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue"}}>인터넷비, 핸드폰비</td>
            </tr>
            <tr>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue"}}>2023-09-22</td>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue", color:"blue"}}>+1,000,000원</td>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue"}}>월급</td>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue", color:"red"}}>-250,000원</td>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue"}}>카드값</td>
            </tr>
            <tr>
                <td style={{border:"1px solid black", backgroundColor:"aliceblue"}} colSpan={5}><strong>남은 금액 : 590,000원</strong></td>
            </tr>
          </tbody>
        </table>
        </>
    );
}