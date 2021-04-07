select empno,empname,title,manager,salary,dept,hiredate from employee;

select * from department;

select titleNo,titleName from title;

select titleNo,titleName from title where titleNo = ?;

INSERT INTO TITLE VALUES (6, '인턴');

delete from title where titleNo = 6;

select deptNo, deptName, floor from department;

INSERT INTO DEPARTMENT VALUES(5, '개발', 11);

update department set deptName = '감사',  floor = 3 where deptNo = 5; 
 
delete from department where deptno = 5;

