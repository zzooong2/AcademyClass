--Donald 직원의 부서 번호
SELECT
	DEPARTMENT_ID
FROM
	EMPLOYEES e
WHERE
	FIRST_NAME = 'Donald';
	
--부서 번호 50에 속한 직원 이름
SELECT
	FIRST_NAME,
	DEPARTMENT_ID
FROM
	EMPLOYEES e
WHERE
	DEPARTMENT_ID = 50;
	

--SubQuery: 쿼리 안에 포함된 또 다른 쿼리
SELECT
	FIRST_NAME,
	DEPARTMENT_ID
FROM
	EMPLOYEES e
WHERE
	DEPARTMENT_ID = (SELECT
						DEPARTMENT_ID
					FROM
						EMPLOYEES e2
					WHERE
						FIRST_NAME = 'Donald');
		
--단일행 서브쿼리: 결과값의 데이터의 행이 1개인 서브쿼리 (단일행 비교 연산자와 사용)
	
--부서 아이디가 30인 직원들의 평균 급여보다 높은 직원명 조회
SELECT
	FIRST_NAME || ' ' || LAST_NAME AS NAME,
	SALARY
FROM
	EMPLOYEES e
WHERE
	SALARY > (SELECT
					AVG(SALARY)
				FROM
					EMPLOYEES e2
				WHERE
					DEPARTMENT_ID = 30);
	
--가장 높은 월급을 받는 직원의 이름 조회
SELECT
	FIRST_NAME || ' ' || LAST_NAME AS NAME,
	SALARY
FROM
	EMPLOYEES e
WHERE
	SALARY = (SELECT
					MAX(SALARY)
				FROM
					EMPLOYEES e2);
	
--입사가 가장 빠른 직원의 이름 조회
SELECT
	FIRST_NAME || ' ' || LAST_NAME AS NAME,
	HIRE_DATE
FROM
	EMPLOYEES e
WHERE
	HIRE_DATE = (SELECT
  					   MIN(HIRE_DATE)
				   FROM
				  	   EMPLOYEES e2);
	
--번호가 가장 낮은 도시 조회
SELECT
	CITY,
	LOCATION_ID
FROM
	LOCATIONS l
WHERE
	LOCATION_ID = (SELECT
						MIN(LOCATION_ID)
					FROM
						LOCATIONS l2);
	
--가장 높은 보너스를 받는 직원의 이름 조회
SELECT
	FIRST_NAME || ' ' || LAST_NAME AS NAME,
	COMMISSION_PCT
FROM
	EMPLOYEES e
WHERE
	COMMISSION_PCT = (SELECT
							MAX(COMMISSION_PCT)
						FROM
							EMPLOYEES e2);
	
--다중행 서브쿼리: 결과값의 데이터가 여러개인 서브쿼리 (다중행 비교 연산자 사용 - IN, ANY, ALL...)

--부서별 가장 낮은 급여조회
SELECT
	DEPARTMENT_ID,
	MIN(SALARY)
FROM
	EMPLOYEES e
GROUP BY
	DEPARTMENT_ID;

--부서별 가장 낮은 급여를 받는 직원의 정보 조회
--IN: 조건에 만족하는 데이터를 출력
SELECT
	*
FROM
	EMPLOYEES e
WHERE
	SALARY IN (SELECT
					MIN(SALARY)
				FROM
					EMPLOYEES e
				GROUP BY
					DEPARTMENT_ID);

--ALL: 모든 조건식을 대입했을 때 모두 TRUE가 나와야함
--ANY: 모든 조건식을 대입했을 때 하나라도 TURE가 나와야함
SELECT
	*
FROM
	EMPLOYEES e
WHERE
	SALARY > ALL (SELECT
						MIN(SALARY)
					FROM
						EMPLOYEES e2
					GROUP BY
						DEPARTMENT_ID); 
	
	
	
--다중열 서브쿼리: 결과값의 컬럼이 여러개인 서브쿼리. 단, 데이터(행)은 반드시 하나 (단일행 비교 연산자 사용)
--WHERE(컬럼1, 컬럼2) = (값1, 값2)와 같이 대입되어 조건식을 계산
	
--'Bruce'와 같은 직무, 부서, 급여 출력
SELECT
	DEPARTMENT_ID,
	SALARY
FROM
	EMPLOYEES e
WHERE
	(DEPARTMENT_ID, SALARY) = (SELECT
									DEPARTMENT_ID, SALARY
								FROM
									EMPLOYEES e
								WHERE
									FIRST_NAME = 'Bruce');
	
--이메일이 'SBELL'인 직원과 사수번호(MANAGER_ID), 부서번호(DEPARTMENT_ID)가 같은 직원 이름(FIRST_NAME) 조회
SELECT
	FIRST_NAME
FROM
	EMPLOYEES e
WHERE
	(MANAGER_ID,
	DEPARTMENT_ID) = (SELECT
							MANAGER_ID,
							DEPARTMENT_ID
						FROM
							EMPLOYEES e
						WHERE
							EMAIL = 'SBELL');

--월급이 5000 이상인 직원 이름, 부서 조회
SELECT
	FIRST_NAME,
	DEPARTMENT_ID
FROM
	EMPLOYEES e
WHERE
	(FIRST_NAME,
	DEPARTMENT_ID) IN (SELECT
							FIRST_NAME,
							DEPARTMENT_ID
						FROM
							EMPLOYEES e
						WHERE
							SALARY >= 5000);


--부서번호: 50, 이름이 'S'로 시작하는 직원 이름, 연봉 조회
SELECT
	FIRST_NAME,
	SALARY
FROM
	EMPLOYEES e
WHERE
	(FIRST_NAME,
	DEPARTMENT_ID) IN (SELECT
					FIRST_NAME,
					DEPARTMENT_ID 
				FROM
					EMPLOYEES e
				WHERE
					FIRST_NAME LIKE 'S%'
					AND DEPARTMENT_ID = 50);

						
--월급을 가장 많이 받는 직원의 이름, 부서번호, 월급을 부서별로 조회
SELECT
	FIRST_NAME,
	DEPARTMENT_ID,
	SALARY
FROM
	EMPLOYEES e
WHERE
	(DEPARTMENT_ID,
	SALARY) IN (SELECT
					DEPARTMENT_ID,
					MAX(SALARY)
				FROM
					EMPLOYEES e
				GROUP BY
					DEPARTMENT_ID)
ORDER BY
	DEPARTMENT_ID;


--인라인뷰: FROM절에 서브쿼리를 사용하며, 수행한 결과가 테이블 대신 사용됨
--인라인뷰를 사용할 때에는 되도록 메인쿼리에 사용(성능향상)
--인라인뷰를 사용할 때 별칭을 사용하여 쿼리의 가독성을 높일 수 있음(별칭 사용시 이후 쿼리는 별칭을 사용해야함 - 쿼리 순서 생각해보기)
--TOP-N 쿼리를 사용하기 위해 주로 사용
SELECT
	*
FROM
	(SELECT
		FIRST_NAME,
		SALARY
	FROM
		EMPLOYEES e
	WHERE
		e.SALARY >= 10000);
	
	
SELECT
	*
FROM
	(SELECT
		DEPARTMENT_ID,
		MAX(SALARY)
	FROM
		EMPLOYEES e
	GROUP BY
		DEPARTMENT_ID);

--이름이 'K'로 시작하고 월급이 5000 이상인 직원 출력
SELECT
	*
FROM
	(SELECT
		FIRST_NAME,
		SALARY
	FROM
		EMPLOYEES e)
WHERE
	FIRST_NAME LIKE 'K%'
	AND SALARY >= 5000;

--부서별 월급합계, 월급평균, 인원수 조회 (인라인뷰 안에 사용된 그룹함수를 인라인뷰 밖에서 호출하고자 하면 Alias 사용)
SELECT
	*
FROM
	(SELECT
		DEPARTMENT_ID,
		SUM(SALARY) AS 월급합계,
		AVG(SALARY) AS 월급평균,
		COUNT(EMPLOYEE_ID) AS 인원수
	FROM
		EMPLOYEES e
	GROUP BY
		DEPARTMENT_ID
	ORDER BY
		DEPARTMENT_ID)
WHERE
	월급합계 >= 50000;








--------------------------------------------------------------------------------------------------------------------
	

	
--연습예제
	
--1. MANAGER_ID가 가장 낮은 직원의 이름과 휴대폰 번호를 출력하세요.
SELECT
	FIRST_NAME || ' ' || LAST_NAME AS NAME,
	PHONE_NUMBER,
	MANAGER_ID
FROM
	EMPLOYEES e
WHERE
	MANAGER_ID = (SELECT
						MIN(MANAGER_ID)
					FROM
						EMPLOYEES e2);
	
--2. EMPLOYEES_ID가 제일 높은 직원의 이름, 사번을 출력하세요.
SELECT
	FIRST_NAME || ' ' || LAST_NAME AS NAME,
	EMPLOYEE_ID
FROM
	EMPLOYEES e
WHERE
	EMPLOYEE_ID = (SELECT
						MAX(EMPLOYEE_ID)
					FROM
						EMPLOYEES e2);
	
--3. LOCATIONS 테이블에서 COUNTRY_ID가 가장 많은 도시의 이름을 출력하세요.
SELECT
	CITY,
	COUNTRY_ID
FROM
	LOCATIONS l
WHERE
	COUNTRY_ID = (SELECT
						MAX(COUNTRY_ID)
					FROM
						LOCATIONS l2); 
	
--4. 직원이 가장 많은 부서의 부서명과 인원수를 조회하세요.
SELECT
	DEPARTMENT_NAME,
	COUNT(e.EMPLOYEE_ID)
FROM
	DEPARTMENTS d
JOIN EMPLOYEES e ON
	d.DEPARTMENT_ID = e.DEPARTMENT_ID
GROUP BY
	DEPARTMENT_NAME
HAVING
	COUNT(e.EMPLOYEE_ID) =(SELECT
								MAX(COUNT(e2.EMPLOYEE_ID))
							FROM
								EMPLOYEES e2
							GROUP BY
								DEPARTMENT_ID);

--5. Luis 또는 Pat과 같은 부서인 직원들을 조회하세요. / 사번, 이름, 부서번호를 출력하세요.
SELECT
	FIRST_NAME,
	EMPLOYEE_ID,
	DEPARTMENT_ID
FROM
	EMPLOYEES e
WHERE
	DEPARTMENT_ID IN (SELECT
							DEPARTMENT_ID
						FROM
							EMPLOYEES e
						WHERE
							FIRST_NAME = 'Luis'
							OR FIRST_NAME = 'Pat');

--6. 직무명 FI_ACCOUNT의 평균 월급(7,920)보다 많이 받는 직원들의 이름과 월급을 조회하세요.
SELECT
	FIRST_NAME,
	SALARY
FROM
	EMPLOYEES e
WHERE SALARY > (SELECT
					AVG(SALARY)
				FROM
					EMPLOYEES e
				WHERE
					JOB_ID = 'FI_ACCOUNT');
	
--7. 보너스를 받는 직원들의 평균 월급(8,900)보다 더 높은 월급을 가진 직원들의 이름과 월급을 조회하세요.
SELECT
	FIRST_NAME,
	SALARY
FROM
	EMPLOYEES e
GROUP BY
	FIRST_NAME,
	SALARY
HAVING
	SALARY > (SELECT
					AVG(SALARY)
				FROM
					EMPLOYEES e
				WHERE
					COMMISSION_PCT IS NOT NULL);

--8. 가장 월급이 높은 직원의 이름과 월급을 조회하세요(인라인뷰 사용)
SELECT
	*
FROM
	(SELECT
		FIRST_NAME,
		SALARY
	FROM
		EMPLOYEES e
	ORDER BY
		SALARY DESC)
WHERE ROWNUM = 1;

	
--9. JOBS 테이블에서 JOB_TITLE 별로 MAX_SALARY를 확인하고, 가장 높은 MAX_SALARY의 JOB_TITLE을 조회하세요.(인라인뷰 사용)
SELECT
	*
FROM
	(SELECT
		JOB_TITLE,
		MAX_SALARY
	FROM
		JOBS j
	ORDER BY
		MAX_SALARY DESC)
WHERE ROWNUM = 1;


--10. 부서별로 평균 연봉을 계산하고, 평균 연봉이 가장 높은 부서의 이름과 평균 연봉을 조회하세요.(인라인뷰 사용)
SELECT
	*
FROM
	(SELECT
		d.DEPARTMENT_NAME,
		ROUND(AVG(e.SALARY*12)) AS 평균연봉
	FROM
		EMPLOYEES e
	JOIN DEPARTMENTS d ON
		d.DEPARTMENT_ID = e.DEPARTMENT_ID
	GROUP BY
		d.DEPARTMENT_NAME
	ORDER BY
		평균연봉 DESC )
WHERE
	--FETCH FIRST 1 ROW ONLY
	ROWNUM = 1;

--11. 월급이 6000 이상인 직원 중, 상위 5명의 직원명과 연봉을 출력하세요.
SELECT
	FIRST_NAME,
	SALARY*12 AS "연봉"
FROM
	EMPLOYEES e
WHERE
	(SALARY*12) >= 6000
	AND ROWNUM <= 5
ORDER BY
	연봉 DESC;
	

--12. JOBS 테이블에서 JOB_TITLE을 ABC 순으로 정렬하고 상위 10개의 JOB_TITLE을 출력하세요.
SELECT
	ROWNUM, JOB_TITLE
FROM
	JOBS j
WHERE
	ROWNUM <= 10
ORDER BY
	JOB_TITLE
	
--13. DEPARTMENTS 테이블에서 DEPARTMENT_ID를 기준으로 내림차순 정렬하여 상위 15개의 ID, NAME, LOCATION_ID를 출력하세요.
SELECT
	DEPARTMENT_ID,
	DEPARTMENT_NAME,
	LOCATION_ID
FROM
	DEPARTMENTS d
WHERE
	ROWNUM <= 15
ORDER BY
	DEPARTMENT_ID DESC
	
--14. 이름이 'e'로 끝나는 직원 중 입사일이 오래된 상위 3명의 직원명과 연봉, 입사일을 조회하세요.
SELECT
	FIRST_NAME,
	SALARY * 12 AS 연봉,
	HIRE_DATE
FROM
	EMPLOYEES e 
WHERE 
	FIRST_NAME LIKE '%e'
AND
	ROWNUM <= 3
ORDER BY
	HIRE_DATE;
	
--15. 전화번호가 4로 끝나는 직원중 이메일을 ABC순으로 정렬하고 상위 3명의 이름, 이메일을 출력하세요.
SELECT
	FIRST_NAME,
	EMAIL
FROM
	EMPLOYEES e
WHERE
	PHONE_NUMBER LIKE '%4'
AND
	ROWNUM <= 4
ORDER BY EMAIL

--16. 보너스를 가진 직원들의 보너스를 표함한 연봉을 계하고, 가장 많은 연봉을 받는 상위 5명의 이름, 연봉(보너스포함)을 출력하세요.
SELECT
	ROWNUM AS 순위,
	FIRST_NAME AS 이름,
	((COMMISSION_PCT *(SALARY * 12))+(SALARY * 12)) AS 연봉
FROM
	(
	SELECT
		FIRST_NAME,
		SALARY,
		COMMISSION_PCT
	FROM
		EMPLOYEES e
	WHERE
		COMMISSION_PCT IS NOT NULL
	ORDER BY
		SALARY DESC)
WHERE
	ROWNUM <= 5
	
	
SELECT
	ROWNUM AS "순위",
	"이름",
	"보너스 연봉"
FROM
	(
	SELECT
		FIRST_NAME || ' ' || LAST_NAME AS "이름",
		(SALARY + COMMISSION_PCT * SALARY)* 12 AS "보너스 연봉"
	FROM
		EMPLOYEES e
	ORDER BY
		"보너스 연봉" DESC NULLS LAST)
WHERE
	ROWNUM <= 5;