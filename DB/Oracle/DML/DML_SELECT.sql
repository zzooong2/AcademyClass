--SELECT: 데이터를 조회할 때 사용하는 명령어 SELECT [컬럼명] FROM [테이블명]; 

--컬럼(column): 테이블의 각 열
--로우(row): 테이블의 각 행

--컬럼명을 작성하는 공간에 *을 입력하면 모든 컬럼에 대한 정보를 조회
SELECT * FROM DEPARTMENTS d ;

--DEPARTMENTS 테이블의 DEPARTMENT_NAME 컬럼을 조회
SELECT DEPARTMENT_NAME FROM DEPARTMENTS d ;

--연산자 사용해보기 (연봉 = SALARY * 12)
--EMPLOYEES 테이블의 직원번호, 급여, 연봉 조회
--AS: alias (별칭)
SELECT EMPLOYEE_ID, SALARY, SALARY*12 AS "연봉" FROM EMPLOYEES e ;

--DISTINT: 중복제거
SELECT DISTINCT MANAGER_ID FROM EMPLOYEES e ;

------------------------------------------------------------------

--연습예제(1 ~ 6)

--1. EMPLOYEES(직원) 테이블의 EMPLOYEE_ID, LAST_NAME, EMAIL 컬럼 조회
SELECT EMPLOYEE_ID, LAST_NAME, EMAIL FROM EMPLOYEES e ;

--2. EMPLOYEES(직원) 테이블의 JOB_ID 컬럼 조회
SELECT JOB_ID FROM EMPLOYEES e ;

--3. JOBS 테이블의 JOB-TITLE, MIN_SALASRY, MAX_SALARY 컬럼 조회
SELECT JOB_TITLE, MIN_SALARY, MAX_SALARY FROM JOBS j; 

--4. DEPARTMENTS 테이블의 모든 컬럼 조회
SELECT * FROM DEPARTMENTS d ;

--5. EMPLOYEES 테이블에서 부서(DEPARTMENTS) 아이디 조회
--중복을 제거하여 조회하세요.
SELECT DISTINCT DEPARTMENT_ID FROM DEPARTMENTS;

--6. EMPLOYEES 테이블에서 월급(SALARY), 연봉, 연봉(보너스 포함) 조회
--산술 연산자를 사용하세요. 
--보너스 컬럼은 COMMISION_PCT 입니다.
--연봉과 연봉(보너스포함)은 컬럼명에 별칭을 주세요.
SELECT * FROM EMPLOYEES e2 
SELECT SALARY, SALARY*12 AS "연봉", (SALARY*12)+(COMMISSION_PCT*SALARY) AS "연봉(보너스포함)" FROM EMPLOYEES e ;
