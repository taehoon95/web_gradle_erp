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

select empno, empname, title, manager, salary,dept,hiredate from employee where empno = 4377;

select e.empno, e.empname, t.titleNo , t.titleName , m.empno as managerNo, m.empname  as managerName,e.salary ,d.deptno ,d.deptname ,d.floor ,e.hiredate 
  from employee e join title t on e.title = t.titleNo 
  left join  employee m on e.manager = m.empno 
  join department d on e.dept = d.deptno ;
  
select empno, empname, title, manager, salary,dept,hiredate from employee where empno = 4377;
 
select * from employee;
INSERT INTO EMPLOYEE VALUES(1366, '김상원', 5, 3426, 1500000, 1, '2020-03-01');
delete from employee where empno = 1366;
update employee set empname = '김', title = 4, manager = 4377, salary = 2000000, dept  = 2, hiredate ="2021-03-01"where empno = 1366;