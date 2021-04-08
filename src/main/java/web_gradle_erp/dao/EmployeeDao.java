package web_gradle_erp.dao;

import java.util.List;

import web_gradle_erp.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectEmpByAll();
	Employee selectEmpByNo(Employee emp);
	
	int insertEmp(Employee emp);
	int updateEmp(Employee emp);
	int deleteEmp(Employee emp);
}
