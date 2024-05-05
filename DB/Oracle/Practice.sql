--실습준비
--shopping_admin 계정을 생성하세요.
CREATE USER shopping_admin IDENTIFIED BY "qwer1234";

--shopping_admin 계정에 connect, resource, dba권한을 추가하세요.
GRANT CONNECT, RESOURCE, DBA TO shopping_admin;

--생성한 계정으로 로그인하세요.

------------------------------------------------------------------------------------------------------------------

--1.CUSTOMERS 테이블 생성
CREATE TABLE CUSTOMERS (
-- > CUSTOMER_NO 컬럼은 NUMBER, 기본키를 지닙니다.
	CUSTOMER_NO NUMBER PRIMARY KEY,
-- > CUSTOMER_NAME 컬럼은 이름을 작성하며 빈 값이 올 수 없습니다. 적절한 데이터 타입을 설정하세요.	
	CUSTOMER_NAME VARCHAR2(255) NOT NULL,
-- > CUSTOMER_GENDER 컬럼은 성별을 가지며 W, M 두가지만을 입력할 수 있으며, 빈 값이 올 수 없습니다. 적절한 데이터 타입을 설정하세요.
	CUSTOMER_GENDER VARCHAR2(255) CHECK(CUSTOMER_GENDER IN('W', 'M')) NOT NULL,
-- > CUSTOMER_EMAIL 컬럼은 이메일을 작성하며 유일한 값을 가지고, 빈 값이 올 수 없습니다. 적절한 데이터 타입을 설정하세요.
	CUSTOMER_EMAIL VARCHAR2(255) UNIQUE NOT NULL,
-- > CUSTOMER_PHONE 컬럼은 휴대폰 번호를 작성하며, 빈 값이 올 수 없습니다. 적절한 데이터 타입을 설정하세요.
	CUSTOMER_PHONE VARCHAR2(255) NOT NULL
);

-- > 각 컬럼에 코멘트를 적용하세요.
COMMENT ON COLUMN CUSTOMERS.CUSTOMER_NO IS '회원번호';
COMMENT ON COLUMN CUSTOMERS.CUSTOMER_NAME IS '이름';
COMMENT ON COLUMN CUSTOMERS.CUSTOMER_GENDER IS '성별';
COMMENT ON COLUMN CUSTOMERS.CUSTOMER_EMAIL IS '이메일';
COMMENT ON COLUMN CUSTOMERS.CUSTOMER_PHONE IS '연락처';

COMMIT;

------------------------------------------------------------------------------------------------------------------

--2. ORDERS 테이블 생성
CREATE TABLE ORDERS (
-- > ORDER_NO 컬럼은 NUMBER, 기본키를 가집니다.
	ORDER_NO NUMBER PRIMARY KEY,
-- > ORDER_DATE 컬럼은 주문날짜를 작성하며, 기본값으로 SYSDATE를 갖습니다. 빈 값이 올 수 없으며 적절한 데이터 타입을 설정하세요.
	ORDER_DATE DATE DEFAULT SYSDATE NOT NULL,
-- > ORDER_NAME 컬럼은 주문상품을 작성하며, 빈 값이 올 수 없습니다. 적절한 데이터 타입을 설정하세요.
	ORDER_NAME VARCHAR2(255) NOT NULL,
-- > ORDER_AMOUNT 컬럼은 주문금액을 작성하며, 빈 값이 올 수 없습니다. 적절한 데이터 타입을 설정하세요.
	ORDER_AMOUNT NUMBER NOT NULL,
-- > CUSTOMER_NO 컬럼은 CUSTMOERS 테이블의 컬럼을 참조합니다. 	
	CUSTOMER_NO NUMBER REFERENCES CUSTOMERS(CUSTOMER_NO)
);

-- > 각 컬럼에 코멘트를 적용하세요.
COMMENT ON COLUMN orders.order_no IS '주문번호';
COMMENT ON COLUMN orders.order_date IS '주문날짜';
COMMENT ON COLUMN orders.order_name IS '주문상품';
COMMENT ON COLUMN orders.order_amount IS '주문금액';
COMMENT ON COLUMN orders.customer_no IS '회원번호';

COMMIT;


------------------------------------------------------------------------------------------------------------------

--3. CUSTOMERS 시퀀스 생성
-- > 1로 시작하여 1씩 증가합니다.
CREATE SEQUENCE CUSTOMERS_SEQ
START WITH 1
INCREMENT BY 1;

--4. ORDER 시퀀스 생성
-- > 1로 시작하여 1씩 증가합니다.
CREATE SEQUENCE ORDER_SEQ
START WITH 1
INCREMENT BY 1;

--5. CUSTOMERS_SEQ, ORDER_SEQ 모두 NOCAHE, NOCYCLE을 가집니다.
ALTER SEQUENCE CUSTOMERS_SEQ NOCACHE;
ALTER SEQUENCE CUSTOMERS_SEQ NOCYCLE;

ALTER SEQUENCE ORDER_SEQ NOCACHE;
ALTER SEQUENCE ORDER_SEQ NOCYCLE;

COMMIT;

------------------------------------------------------------------------------------------------------------------


--6. customers 테이블에 데이터를 삽입하세요.
INSERT INTO CUSTOMERS VALUES (CUSTOMERS_SEQ.NEXTVAL, 'John Doe', 'M', 'john.doe@example.com', '123-456-7890');

INSERT INTO CUSTOMERS VALUES (CUSTOMERS_SEQ.NEXTVAL, 'Jane Smith', 'W', 'jane.smith@example.com', '987-654-3210');

INSERT INTO CUSTOMERS VALUES (CUSTOMERS_SEQ.NEXTVAL, 'Bob Johnson', 'M', 'bob.johnson@example.com', '555-555-5555');

INSERT INTO CUSTOMERS VALUES (CUSTOMERS_SEQ.NEXTVAL, 'Alice White', 'W', 'alice.white@example.com', '777-777-7777');

INSERT INTO CUSTOMERS VALUES (CUSTOMERS_SEQ.NEXTVAL, 'Charlie Brown', 'M', 'charlie.brown@example.com', '999-999-9999');

INSERT INTO CUSTOMERS VALUES (CUSTOMERS_SEQ.NEXTVAL, 'Eva Davis', 'W', 'eva.davis@example.com', '111-111-1111');

INSERT INTO CUSTOMERS VALUES (CUSTOMERS_SEQ.NEXTVAL, 'Frank Lee', 'M', 'frank.lee@example.com', '222-222-2222');

INSERT INTO CUSTOMERS VALUES (CUSTOMERS_SEQ.NEXTVAL, 'Grace Taylor', 'W', 'grace.taylor@example.com', '333-333-3333');

INSERT INTO CUSTOMERS VALUES (CUSTOMERS_SEQ.NEXTVAL, 'David Clark', 'M', 'david.clark@example.com', '444-444-4444');

INSERT INTO CUSTOMERS VALUES (CUSTOMERS_SEQ.NEXTVAL, 'Helen Wilson', 'W', 'helen.wilson@example.com', '666-666-6666');

------------------------------------------------------------------------------------------------------------------

--7. ORDERS 테이블에 데이터를 삽입하세요.
INSERT INTO ORDERS VALUES (ORDER_SEQ.NEXTVAL, DEFAULT, '마우스', 10000, 13);
INSERT INTO ORDERS VALUES (order_seq.nextval, DEFAULT, '데스크탑', 15000, 14);
INSERT INTO ORDERS VALUES (order_seq.nextval, DEFAULT, '스캐너', 20000, 15);
INSERT INTO ORDERS VALUES (order_seq.nextval, DEFAULT, '마우스패드', 7500, 16);
INSERT INTO ORDERS VALUES (order_seq.nextval, DEFAULT, '조이스틱', 30000, 17);
INSERT INTO ORDERS VALUES (order_seq.nextval, DEFAULT, '모니터', 125000, 18);
INSERT INTO ORDERS VALUES (order_seq.nextval, DEFAULT, '마우스패드', 18000, 19);
INSERT INTO ORDERS VALUES (order_seq.nextval, DEFAULT, '허브', 9000, 20);
INSERT INTO ORDERS VALUES (order_seq.nextval, DEFAULT, '데스크탑', 220000, 21);
INSERT INTO ORDERS VALUES (order_seq.nextval, DEFAULT, '데스크탑', 175000, 22);

------------------------------------------------------------------------------------------------------------------

--8. 데스크탑을 구입한 고객이 몇 명인지 조회하세요.
SELECT COUNT(ORDER_NO)
FROM ORDERS o
WHERE ORDER_NAME = '데스크탑';

--9. 마우스패드를 구입한 고객의 이름을 조회하세요.
SELECT c.CUSTOMER_NAME FROM CUSTOMERS c
JOIN ORDERS o ON c.CUSTOMER_NO = o.CUSTOMER_NO
WHERE o.ORDER_NAME = '마우스패드';

--10. 주문 금액이 20000원 이상인 고객들의 이메일과 핸드폰 번호를 조회하세요.
SELECT c.CUSTOMER_EMAIL, c.CUSTOMER_PHONE FROM CUSTOMERS c 
JOIN ORDERS o ON c.CUSTOMER_NO = o.CUSTOMER_NO
WHERE o.ORDER_AMOUNT >= 20000;

--11. 가장 큰 금액의 물품을 구입한 고객의 이름과 주문 상품을 조회하세요.
SELECT CUSTOMER_NAME, o.ORDER_NAME FROM CUSTOMERS c  
JOIN ORDERS o ON c.CUSTOMER_NO = o.CUSTOMER_NO
WHERE o.ORDER_AMOUNT = (SELECT MAX(ORDER_AMOUNT) FROM ORDERS o);

--SELECT c.CUSTOMER_NAME, o.ORDER_NAME FROM ORDERS o
--JOIN CUSTOMERS c ON o.CUSTOMER_NO = c.CUSTOMER_NO 
--ORDER BY o.ORDER_AMOUNT DESC
--FETCH FIRST 1 ROW ONLY;

--12. 모든 주문의 합계 금액을 조회하세요.
SELECT SUM(ORDER_AMOUNT) FROM ORDERS o; 

--13. 전체 주문에 대한 평균 금액을 구하세요.
SELECT AVG(ORDER_AMOUNT) FROM ORDERS o;

--14. 핸드폰 번호가 0으로 끝나는 고객의 이름을 조회하세요.
SELECT CUSTOMER_NAME FROM CUSTOMERS c
WHERE CUSTOMER_PHONE LIKE '%0';

--15. 이름에 i가 들어가는 모든 고객의 번호와 이름을 조회하고 내림차순으로 정렬하세요.
SELECT CUSTOMER_NAME FROM CUSTOMERS c
WHERE CUSTOMER_NAME LIKE '%i%'
ORDER BY CUSTOMER_NAME DESC;

--16.데스크탑과 스캐너, 모니터를 구입한 고객의 이름과 주문 금액을 조회하세요.
SELECT c.CUSTOMER_NAME, o.ORDER_NAME, o.ORDER_AMOUNT FROM CUSTOMERS c 
JOIN ORDERS o ON c.CUSTOMER_NO = o.CUSTOMER_NO
WHERE o.ORDER_NAME IN ('데스크탑', '스캐너', '모니터');

--17. 전체 주문 금액의 평균을 구하고 평균 금액보다 높은 고객의 이름과 주문 금액을 조회하세요. (평균 금액은 정수로 조회되어야 합니다.)
SELECT c.CUSTOMER_NAME, o.ORDER_AMOUNT FROM ORDERS o
JOIN CUSTOMERS c ON o.CUSTOMER_NO = c.CUSTOMER_NO
WHERE o.ORDER_AMOUNT > (SELECT ROUND(AVG(o.ORDER_AMOUNT)) FROM ORDERS o)

--18. 주문 금액이 15000 이상, 21000 이하인 고객의 수를 조회하세요.
SELECT COUNT(*) FROM ORDERS o
WHERE o.ORDER_AMOUNT BETWEEN 15000 AND 21000; 

--19. 인라인뷰를 활용하여 주문 테이블에서 가장 많은 주문 상품을 검색하고 주문 번호와 함께 조회하세요.
SELECT
	*
FROM
	(SELECT
		o.ORDER_NAME,
		COUNT(*)
	FROM
		ORDERS o
	GROUP BY
		ORDER_NAME
	ORDER BY
		count(*) DESC)
WHERE ROWNUM = 1;
		
--20. 주문 금액이 가장 높은 상위 3명의 고객 이름과 핸드폰 번호를 조회하세요.
SELECT
	*
FROM
	(SELECT
		c.CUSTOMER_NAME,
		c.CUSTOMER_PHONE
	FROM
		ORDERS o
	JOIN CUSTOMERS c ON
		o.CUSTOMER_NO = c.CUSTOMER_NO
	ORDER BY
		o.ORDER_AMOUNT DESC)
WHERE ROWNUM <= 3;
