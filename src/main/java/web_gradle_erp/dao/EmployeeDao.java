package web_gradle_erp.dao;

import java.util.List;

import web_gradle_erp.dto.Employee;
import web_gradle_erp.dto.Title;

public interface EmployeeDao {
	List<Employee> selectTitleByAll();
	Employee selecTitleByNo(Employee dept);
	
	int insertTitle(Employee dept);
	int updateTitle(Employee dept);
	int deleteTitle(Employee dept);
}
