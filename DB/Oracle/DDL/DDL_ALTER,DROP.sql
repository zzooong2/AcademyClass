CREATE TABLE DDL_ALTER (
	ALTER_ID VARCHAR2(255) PRIMARY KEY,
	ALTER_NAME VARCHAR2(255),
	ALTER_AS VARCHAR2(255)
);

SELECT * FROM DDL_ALTER_TEST DAT 

--ALTER: 데이터베이스의 객체 구조를 변경해주는 구문
--RENAME TO: 테이블 이름 변경
ALTER TABLE DDL_ALTER RENAME TO DDL_ALTER_TEST;

--MODIFY: 테이블 내부 컬럼 변경
ALTER TABLE DDL_ALTER_TEST MODIFY(
	ALTER_NAME VARCHAR2(30) NOT NULL,
	ALTER_AS VARCHAR2(30) NOT NULL
);

--RENAME: 테이블 내부 컬럼 이름 변경
ALTER TABLE DDL_ALTER_TEST RENAME COLUMN ALTER_NAME TO ALTER_NAME_TEST;

--DROP: 테이블 내부 컬럼 삭제
ALTER TABLE DDL_ALTER_TEST DROP COLUMN ALTER_NAME_TEST;

--ADD: 테이블 내부 컬럼 추가
ALTER TABLE DDL_ALTER_TEST ADD (
	ALTER_NAME VARCHAR2(30) NOT NULL
);

--컬럼에 제약조건 추가
ALTER TABLE DDL_ALTER_TEST ADD CONSTRAINT ALTER_NAME_UNIQUE UNIQUE(ALTER_NAME);

--컬럼에 제약조건 삭제
ALTER TABLE DDL_ALTER_TEST DROP CONSTRAINT ALTER_NAME_UNIQUE;

--DROP: 원하는 데이터를 삭제할 때 사용하는 구문 (로그를 남기지 않음)

CREATE TABLE PARENT_TB (
PARENT_ID NUMBER PRIMARY KEY,
PARENT_NAME VARCHAR2(50)
);

CREATE TABLE CHILD_TB (
CHILD_ID NUMBER PRIMARY KEY,
CHILD_NAME VARCHAR2(50),
PARENT_ID NUMBER,
CONSTRAINT FK_PARENT FOREIGN KEY (PARENT_ID) REFERENCES PARENT_TB(PARENT_ID)
);


--DROP TABLE PARENT_TB;
--위 쿼리 실행시 오류 발생 ORA-02449: unique/primary keys in table referenced by foreign keys 

--CASCADE: 제약조건을 가진 테이블을 삭제할 때 사용. 제약조건을 자동으로 삭젲하여 관계를 없앤 후 테이블 삭제
DROP TABLE PARENT_TB CASCADE CONSTRAINTS
-----------------------------------------------------------------------------------------------------------



--연습예제

CREATE TABLE TEST_EMPLOYEES (
   TE_ID NUMBER PRIMARY KEY,
   TE_FIRST_NAME VARCHAR2(50),
   TE_LAST_NAME VARCHAR2(50),
   TE_SALARY NUMBER,
   TE_DEPARTMENT VARCHAR2(50)
);

--1. 테이블 이름 "Staff"로 변경
ALTER TABLE TEST_EMPLOYEES RENAME TO STAFF;

--2. TE_DEPARTMENT 컬럼의 데이터 형식을 VARCHAR2(100)으로 변경
ALTER TABLE STAFF MODIFY (
	TE_DEPARTMENT VARCHAR2(100)
);

--3. TE_LAST_NAME 컬럼의 이름을 "SURNAME"으로 변경
ALTER TABLE STAFF RENAME COLUMN TE_LAST_NAME TO SURNAME;

--4. TE_FIRST_NAME 컬럼 삭제
ALTER TABLE STAFF DROP COLUMN TE_FIRST_NAME;

--5. HIRE_DATE 라는 DATE 데이터 형식의 새로운 컬럼 추가
ALTER TABLE STAFF ADD (
	TE_HIRE_DATE date
);

--6. TE_SALARY 칼럼에 Salary Check 라는 이름을 가 UNIQUE 제약 조건 추가
ALTER TABLE STAFF ADD CONSTRAINT SALARY_CHECK UNIQUE(TE_SALARY);

--7. 아래 쿼리문으로 PRIMARY KEY 제약조건의 이름을 확인하고 PK_EMPLOYEE로 변경
SELECT CONSTRAINT_NAME, COLUMN_NAME FROM USER_CONS_COLUMNS WHERE TABLE_NAME = 'STAFF';

ALTER TABLE STAFF RENAME CONSTRAINT SYS_C007201 TO EMPLOYEES;