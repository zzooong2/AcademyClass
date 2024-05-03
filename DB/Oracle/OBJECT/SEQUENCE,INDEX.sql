--SEQUENCE: 번호 자동증가 역할수행 객체 (회원번호, 게시글 번호 등 식별자 역할을 하는 PRIMARY KEY에 주로 사용)

--사용방법
-- > CREATE SEQUENCE 시퀀스명: 시퀀스 생성
-- > START WITH 시작값: 처음 시작할 숫자 지정
-- > INCREMENT BY 증가값: 시퀀스 발생시 증가시킬 값 설정
-- > MAXVALUE 최대값: 숫자의 최댓값 설정
-- > MINVALUE 최소값: 숫자의 최솟값 설정
-- > CYCLE / NOCYCLE 지정 값 반복 / 미반복: 값의 순환 여부 설정
-- > CACHE 바이트크기 / NOCACHE: 캐시 메모리 사용 여부 지정


SELECT * FROM ACCOUNTS;
DELETE FROM ACCOUNTS;
COMMIT;

--시퀀스 생성 및 옵션 부여
CREATE SEQUENCE ACCOUNTS_SEQ
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 5
NOCYCLE;

--시퀀스 이용 데이터 삽입
INSERT INTO ACCOUNTS values(accounts_seq.nextval, '이름1', 10000);
INSERT INTO ACCOUNTS values(accounts_seq.nextval, '이름2', 300);
INSERT INTO ACCOUNTS values(accounts_seq.nextval, '이름3', 1000000);
INSERT INTO ACCOUNTS values(accounts_seq.nextval, '이름4', 20000);
INSERT INTO ACCOUNTS values(accounts_seq.nextval, '이름5', 14000);

--시퀀스 옵션 변경
ALTER SEQUENCE accounts_seq MAXVALUE 9999999;


--INDEX: 데이터가 많은 테이블에서 특정 컬럼에 대한 정렬 및 검색 성능을 향상시키기 위해 사용
--오라클에서는 PK 설정시 자동으로 인덱스가 생성됨 (DB마다 자동설정은 다름)
--검색은 빠르나 추가, 수정, 삭제 작업에서는 성능 저하
DELETE FROM ACCOUNTS;
COMMIT;

--인덱스 생성
CREATE INDEX IDX_NAME ON ACCOUNTS(ACCOUNT_NAME);

--인덱스 삭제
DROP INDEX IDX_NAME;

--데이터 삽입
INSERT INTO ACCOUNTS(ACCOUNT_ID, ACCOUNT_NAME, BALANCE)
SELECT ACCOUNTS_SEQ.nextval, '이름' || LEVEL, 10000
FROM dual
CONNECT BY LEVEL <= 500000;

--데이터 조회
SELECT count(*) FROM ACCOUNTS;

