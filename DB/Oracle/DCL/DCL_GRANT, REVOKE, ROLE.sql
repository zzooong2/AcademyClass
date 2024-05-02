--DCL: 계정에게 권한을 부여하거나 회수하는 역할을 가진 언어
--시스템 권한: DB, 스키마에 접근하여 객체를 관리할 수 있는 권한
--접근 권한: 특정 객체들을 조작(DML)할 수 있는 권한

--GRANT: 계정에게 권한을 부여하며 시스템 권한과 접근 권한으로 나뉨
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER GRANTUSER IDENTIFIED BY QWER1234;

--세션에 접근 권한부여
GRANT CREATE SESSION TO GRANTUSER;
--테이블 생성 권한부여
GRANT CREATE TABLE TO GRANTUSER;
--HR스키마의 EMPLOYEES 테이블에 SELECT 권한부여
GRANT SELECT ON HR.EMPLOYEES TO GRANTUSER;

SELECT * FROM hr.employees

CREATE TABLE grant_test(
	test_id varchar2(50) PRIMARY KEY,
	test_name varchar2(50)
);

--REVOKE: 권한 제거
REVOKE SELECT ON HR.EMPLOYEES FROM GRANTUSER;

--ROLE: 권한들을 그룹으로 묶어둠. 권한을 효율적으로 관리하기 위한 집합
--ROLE 생성
CREATE ROLE back_dev;
CREATE ROLE front_dev;

--생성된 ROLE에 권한 부여
GRANT SELECT, INSERT, UPDATE, DELETE ON HR.EMPLOYEES TO back_dev;
GRANT SELECT ON HR.EMPLOYEES TO front_dev;

--ROLE 적용 되어있는지 확인
SELECT * FROM DBA_TAB_PRIVS WHERE TABLE_NAME = 'EMPLOYEES';

--web_back 유저에게 ROLE 부여
GRANT back_dev TO web_back;

--web_back 유저에게 부여된 ROLE 확인
SELECT * FROM DBA_ROLE_PRIVS WHERE grantee = 'WEB_BACK';

--front_back 유저에게 ROLE 부여
GRANT front_dev TO web_front;

--web_front 유저에게 부여된 ROLE 확인
SELECT * FROM DBA_ROLE_PRIVS WHERE grantee = 'WEB_FRONT';

--web_front 계정에 부여된 ROLE 제거
REVOKE FRONT_DEV FROM WEB_FRONT;

--ROLE 안에 DELETE 권한 제거
REVOKE DELETE ON HR.EMPLOYEES FROM back_dev;

--ROLE 삭제
DROP ROLE front_dev;
------------------------------------------------------------------------

--연습예제


--1. web_back 계정을 생성한 후 아래의 시나리오에 맞춰 권한을 부여하세요.
-- > HR 개발팀의 백엔드 직원들만 사용하는 계정입니다.
-- > 오라클에 접속할 수 있어야 하며 테이블을 생성할 수 있는 권한을 가집니다.
-- > HR 스키마의 EMPLOYEES 테이블을 조작(DML)할 수 있는 모든 권한을 가집니다.
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;

--계정 생성
CREATE USER web_back IDENTIFIED BY qwer1234;

--접속 권한
GRANT CREATE SESSION TO web_back;

--테이블생성 권한
GRANT CREATE TABLE TO web_back;

--DML 권한
GRANT SELECT, INSERT, UPDATE, DELETE ON HR.EMPLOYEES TO web_back;

--권한 제거
REVOKE SELECT, INSERT, UPDATE, DELETE ON HR.EMPLOYEES FROM web_back;

--2. web_front 계정을 생성한 후 아래의 시나리오에 맞춰 권한을 부여하세요.
-- > HR 개발팀의 프론트 직원들만 사용하는 계정입니다.
-- > 오라클에 접속할 수 있어야 하며 테이블을 생성할 수 있습니다.
-- > HR 스키마의 EMPLOYEES 테이블을 조회할 수 있는 권한을 가지며, 그 외 수정, 추가, 삭제에 대한 권한은 가질 수 없습니다.

--계정 생성
CREATE USER web_front IDENTIFIED BY qwer1234;

--접속 권한
GRANT CREATE SESSION TO web_front;

--테이블생성 권한
GRANT CREATE TABLE TO web_front;

--SELECT 권한
GRANT SELECT ON HR.EMPLOYEES TO web_front;

--권한 제거
REVOKE SELECT ON HR.EMPLOYEES FROM web_front;