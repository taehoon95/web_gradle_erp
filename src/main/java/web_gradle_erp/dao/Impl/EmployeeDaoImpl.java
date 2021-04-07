package web_gradle_erp.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import web_gradle_erp.dao.EmployeeDao;
import web_gradle_erp.dto.Department;
import web_gradle_erp.dto.Employee;
import web_gradle_erp.dto.Title;

public class EmployeeDaoImpl implements EmployeeDao {

	private static final EmployeeDaoImpl instance = new EmployeeDaoImpl();
	
	public static EmployeeDaoImpl getInstance() {
		return instance;
	}
	
	private EmployeeDaoImpl() {}
	
	public Connection con;

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public List<Employee> selectTitleByAll() {
		String sql = "select empno,empname,title,manager,salary,dept,hiredate from employee";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Employee> list = new ArrayList<>();
				do {
					list.add(getEmployee(rs));
				}while(rs.next());
				return list;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		int empNo = 0;
		String empName = null;
		Title title = null;
		Employee manager = null;
		int salary = 0;
		Department dept = null;
		Date hiredate = null;
		
		try {
			empNo = rs.getInt("empNo");
		}catch (Exception e) {}
		
		try {
			empName = rs.getString("empName");
		}catch (Exception e) {}
		
		try {
			title = new Title(rs.getInt("titleNo"));
		}catch (Exception e) {}
		
		try {
			title.setTitleName("titleName");
		}catch (Exception e) {}
		
		try {
			manager = new Employee(rs.getInt("managerNo"));
		}catch (Exception e) {}
		
		try {
			manager.setEmpName("managerName");
		}catch (Exception e) {}
		
		try {
			salary = rs.getInt("salary");
		}catch (Exception e) {}
		
		try {
			dept = new Department(rs.getInt("deptNo"));
		}catch (Exception e) {}
		
		try {
			dept.setDeptName(rs.getString("deptName"));
		}catch (Exception e) {}
		
		try {
			dept.setFloor(rs.getInt("floor"));
		}catch (Exception e) {}
		
		try {
			hiredate= new Timestamp(rs.getDate("hiredate").getTime());
		}catch (Exception e) {}
		
		
		return new Employee(empNo, empName, title, manager, salary, dept, hiredate);
	}

	@Override
	public Employee selecTitleByNo(Employee dept) {
		return null;
	}

	@Override
	public int insertTitle(Employee dept) {
		return 0;
	}

	@Override
	public int updateTitle(Employee dept) {
		return 0;
	}

	@Override
	public int deleteTitle(Employee dept) {
		return 0;
	}

}
