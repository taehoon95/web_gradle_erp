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

	private EmployeeDaoImpl() {
	}

	public Connection con;

	public void setCon(Connection con) {
		this.con = con;
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
		} catch (Exception e) {
		}

		try {
			empName = rs.getString("empName");
		} catch (Exception e) {
		}

		try {
			title = new Title(rs.getInt("titleNo"));
		} catch (Exception e) {
		}

		try {
			title.setTitleName(rs.getString("titleName"));
		} catch (Exception e) {
		}

		try {
			manager = new Employee(rs.getInt("managerNo"));
		} catch (Exception e) {
		}

		try {
			manager.setEmpName(rs.getString("managerName"));
		} catch (Exception e) {
		}

		try {
			salary = rs.getInt("salary");
		} catch (Exception e) {
		}

		try {
			dept = new Department(rs.getInt("deptNo"));
		} catch (Exception e) {
		}

		try {
			dept.setDeptName(rs.getString("deptName"));
		} catch (Exception e) {
		}

		try {
			dept.setFloor(rs.getInt("floor"));
		} catch (Exception e) {
		}

		try {
			hiredate = new Timestamp(rs.getDate("hiredate").getTime());
		} catch (Exception e) {
		}

		return new Employee(empNo, empName, title, manager, salary, dept, hiredate);
	}

	@Override
	public List<Employee> selectEmpByAll() {
		String sql = "select e.empno, e.empname, t.titleNo , t.titleName , m.empno as managerNo, m.empname  as managerName,e.salary ,d.deptno ,d.deptname ,d.floor ,e.hiredate \r\n"
				+ "  from employee e join title t on e.title = t.titleNo \r\n"
				+ "  left join  employee m on e.manager = m.empno \r\n" + "  join department d on e.dept = d.deptno ";
		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Employee> list = new ArrayList<>();
				do {
					list.add(getEmployee(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee selectEmpByNo(Employee emp) {
		String sql = "select empno, empname, title, manager, salary,dept,hiredate from employee where empno = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, emp.getEmpNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getEmployee(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertEmp(Employee emp) {
		String sql = "INSERT INTO EMPLOYEE VALUES(?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setInt(3, emp.getTitle().getTitleNo());
			pstmt.setInt(4, emp.getManager().getEmpNo());
			pstmt.setInt(5, emp.getSalary());
			pstmt.setInt(6, emp.getDept().getDeptNo());
			pstmt.setTimestamp(7, new Timestamp(emp.getHiredate().getTime()));
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateEmp(Employee emp) {
		String sql = "update employee set empname = ?, title = ?, manager = ?, salary = ?, dept  = ?, hiredate =? where empno = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, emp.getEmpName());
			pstmt.setInt(2, emp.getTitle().getTitleNo());
			pstmt.setInt(3, emp.getManager().getEmpNo());
			pstmt.setInt(4, emp.getSalary());
			pstmt.setInt(5, emp.getDept().getDeptNo());
			pstmt.setTimestamp(6, new Timestamp(emp.getHiredate().getTime()));
			pstmt.setInt(7, emp.getEmpNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteEmp(Employee emp) {
		String sql = "delete from employee where empno = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, emp.getEmpNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
