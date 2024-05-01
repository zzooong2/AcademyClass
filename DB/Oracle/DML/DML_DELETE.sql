--DELETE: 테이블의 기존 데이터를 삭제하는 구문
--조건을 주지 않으면 테이블에 존재하는 데이터가 전부 삭제되기 때문에 주의 필요!!

SELECT * FROM EMPLOYEES e 

DELETE FROM EMPLOYEES e
WHERE EMPLOYEE_ID = 213;


------------------------------------------------------------------------

--연습예제

--1. LAST_NAME이 'Sully'인 직원 삭제
DELETE FROM EMPLOYEES e 
WHERE LAST_NAME = 'Sully';

--2. SALARY가 7000이면서, 보너스를 0.15 받는 직원 삭제
DELETE FROM EMPLOYEES e 
WHERE SALARY = 7000
AND COMMISSION_PCT = 0.15;

--3. JOB_ID가 SA_REP 이면서 핸드폰 번호가 011.44.1346.229268인 직원 삭제
DELETE FROM EMPLOYEES e 
WHERE JOB_ID = 'SA_REP'
AND PHONE_NUMBER = '011.44.1346.229268';

--4. 입사일이 2007년 01월 01일 이전이면서, 월급을 3400 받는 직원 삭제
DELETE FROM EMPLOYEES e
WHERE HIRE_DATE <= '2007-01-01'
AND SALARY = 3400;