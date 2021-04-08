package web_gradle_erp.service;

import java.util.List;

import web_gradle_erp.dao.Impl.EmployeeDaoImpl;
import web_gradle_erp.ds.JndiDs;
import web_gradle_erp.dto.Employee;

public class EmployeeService {

	private EmployeeDaoImpl dao;
	
	public EmployeeService() {
		dao = EmployeeDaoImpl.getInstance();
		dao.setCon(JndiDs.getConnection());		
	}
	
	public List<Employee> showEmployees(){
		return dao.selectEmpByAll();
	}
	
}
