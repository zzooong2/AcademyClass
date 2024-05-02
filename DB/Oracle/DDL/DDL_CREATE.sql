--DDL: 데이터베이스의 객체를 생성, 수정, 삭제 하는 등의 작업이 가능한 언어
--CREATE: 생성
--a: 1byte, 가: 3byte
--소문자를 사용하고 싶다면 "" 안에 작성해야하며, 조회할 때에도 "" 안에 작성해야한다.

--ddl_member 테이블 생성
CREATE TABLE ddl_member(
	--PRIMARY KEY: 튜플들의 데이터를 유일하게 식별할 수 있는 컬럼에 작성하는 제약조건(NOT NULL + UNIQUE) > 회원번호 or 부서번호 or 게시글번호
	MEMBER_no NUMBER PRIMARY KEY,
	MEMBER_id varchar2(30),
	MEMBER_pw varchar2(255),
	MEMBER_name varchar2(30),
	--CHECK: 해당 컬럼에 들어와야 할 값들을 미리 정해둠. 정해진 값 외 입력불가
	MEMBER_gender varchar2(5) CHECK (member_gender IN('M', 'W')),
	--DEFAULT: 해당 컬럼에 아무런 값이 들어오지 않을 경우 기본값으로 추가할 값을 설정
	MEMBER_point NUMBER DEFAULT 0,
	MEMBER_indate DATE DEFAULT sysdate
);

SELECT * FROM DDL_MEMBER dm; 

DROP TABLE DDL_MEMBER;

--커멘트 생성 (협업시, 다른 개발자가 보고 이해할 수 있도록..)
COMMENT ON COLUMN ddl_member.MEMBER_ID IS '아이디 컬럼';

INSERT INTO DDL_MEMBER dm
VALUES(1, '아이디1', 'qwer1234!', '홍길동', 'M', default, default);

INSERT INTO DDL_MEMBER dm
VALUES(2, '아이디2', 'qwer1234!', '홍준표', 'W', default, default);

INSERT INTO DDL_MEMBER dm
VALUES(3, '아이디3', 'qwer1234!', '홍길딘', 'M', default, default);

--ddl_job 테이블 생성
CREATE TABLE DDL_JOBS (
	JOB_CODE NUMBER PRIMARY KEY,
	JOB_NAME VARCHAR2 (100) NOT NULL,
	MEMBER_NO NUMBER REFERENCES DDL_MEMBER(MEMBER_NO)
);

INSERT INTO DDL_JOBS 
VALUES(1, '개발자', 3)

INSERT INTO DDL_JOBS 
VALUES(2, '국회의원', 2)

SELECT * FROM DDL_JOBS dj;


-----------------------------------------------------------------------------------------------


--연습예제

--1.FREE_BOARD 테이블 생성
--  BOARD_NO NUMBER
--  BOARD_TITLE VARCHAR2(100)
--  BOARD_CONTENT CLOB
--  BOARD_DATE DATE
--  BOARD_VIEWS NUMBER
CREATE TABLE FREE_BOARD(
  --NOT NULL: 해당 컬럼에 NULL이 들어올 수 없음을 뜻함.
  --UNIQUE: 해당 컬럼에 들어있는 값에서 반드시 유일(절대 중복X)해야 하는 값
  BOARD_NO NUMBER NOT NULL UNIQUE,
  BOARD_TITLE VARCHAR2(100) NOT NULL,
  BOARD_CONTENT CLOB NOT NULL,
  BOARD_DATE DATE,
  BOARD_VIEWS NUMBER);
  
 --2. 각 컬럼에 코멘트 추가
 COMMENT ON COLUMN FREE_BOARD.BOARD_NO IS '게시판 번호';
 COMMENT ON COLUMN FREE_BOARD.BOARD_TITLE IS '게시판 제목';
 COMMENT ON COLUMN FREE_BOARD.BOARD_CONTENT IS '게시판 내용';
 COMMENT ON COLUMN FREE_BOARD.BOARD_DATE IS '게시판 작성일';
 COMMENT ON COLUMN FREE_BOARD.BOARD_VIEWS IS '게시판 조회수';

--3. 임의의 데이터를 3개 이상 추가하세요.
INSERT INTO FREE_BOARD
VALUES (1, '제목1', '내용1', sysdate, '1');

INSERT INTO FREE_BOARD
VALUES (2, '제목2', '내용2', sysdate, '2');

INSERT INTO FREE_BOARD
VALUES (3, '제목3', '내용3', sysdate, '3');

SELECT * FROM FREE_BOARD;

DROP TABLE FREE_BOARD;
 