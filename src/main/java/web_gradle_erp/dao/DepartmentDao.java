package web_gradle_erp.dao;

import java.util.List;

import web_gradle_erp.dto.Department;

public interface DepartmentDao {
	List<Department> selectTitleByAll();
	
	int insertTitle(Department dept);
	int updateTitle(Department dept);
	int deleteTitle(Department dept);
	Department selecDepartmentByNo(Department dept);
}
