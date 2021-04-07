select user(),database();

-- 내 스키마
DROP SCHEMA IF EXISTS web_gradle_erp;

-- 내 스키마
CREATE SCHEMA web_gradle_erp;

-- 직책
CREATE TABLE web_gradle_erp.Title (
	titleNo   INT         NOT NULL COMMENT '직책코드', -- 직책코드
	titleName VARCHAR(20) NOT NULL COMMENT '직책명' -- 직책명
)
COMMENT '직책';

-- 직책
ALTER TABLE web_gradle_erp.Title
	ADD CONSTRAINT PK_Title -- 직책 기본키
		PRIMARY KEY (
			titleNo -- 직책코드
		);

-- 부서
CREATE TABLE web_gradle_erp.Department (
	deptno   INT           NOT NULL COMMENT '부서번호', -- 부서번호
	deptname VARCHAR(20) NOT NULL COMMENT '부서명', -- 부서명
	floor    INT           NULL     COMMENT '위치' -- 위치
)
COMMENT '부서';

-- 부서
ALTER TABLE web_gradle_erp.Department
	ADD CONSTRAINT PK_Department -- 부서 기본키
		PRIMARY KEY (
			deptno -- 부서번호
		);

-- 사원
CREATE TABLE web_gradle_erp.Employee (
	empno   INT         NOT NULL COMMENT '사워번호', -- 사워번호
	empname VARCHAR(20) NOT NULL COMMENT '사원명', -- 사원명
	title   INT         NULL     COMMENT '직책', -- 직책
	manager INT         NULL     COMMENT '직속상사', -- 직속상사
	salary  INT         NULL     COMMENT '급여', -- 급여
	dept    INT         NULL     COMMENT '부서', -- 부서
	hiredate date null COMMENT '입사일' -- 입사일
)
COMMENT '사원';

-- 사원
ALTER TABLE web_gradle_erp.Employee
	ADD CONSTRAINT PK_Employee -- 사원 기본키
		PRIMARY KEY (
			empno -- 사워번호
		);

-- 사원
ALTER TABLE web_gradle_erp.Employee
	ADD CONSTRAINT FK_Title_TO_Employee -- 직책 -> 사원
		FOREIGN KEY (
			title -- 직책
		)
		REFERENCES web_gradle_erp.Title ( -- 직책
			titleNo -- 직책코드
		);

-- 사원
ALTER TABLE web_gradle_erp.Employee
	ADD CONSTRAINT FK_Department_TO_Employee -- 부서 -> 사원
		FOREIGN KEY (
			dept -- 부서
		)
		REFERENCES web_gradle_erp.Department ( -- 부서
			deptno -- 부서번호
		);

-- 사원
ALTER TABLE web_gradle_erp.Employee
	ADD CONSTRAINT FK_Employee_TO_Employee -- 사원 -> 사원
		FOREIGN KEY (
			manager -- 직속상사
		)
		REFERENCES web_gradle_erp.Employee ( -- 사원
			empno -- 사워번호
		);
		

