package web_gradle_erp.dao;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_gradle_erp.dao.Impl.EmployeeDaoImpl;
import web_gradle_erp.dto.Department;
import web_gradle_erp.dto.Employee;
import web_gradle_erp.dto.Title;
import web_gradle_erp.util.JdbcUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {

	private static Connection con;
	private static EmployeeDaoImpl dao = EmployeeDaoImpl.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		con = JdbcUtil.getConnection();
		dao.setCon(con);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		con.close();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test04SelectEmpByAll() {
		System.out.println("testSelectTitleByAll");
		List<Employee> list = dao.selectEmpByAll();

		Assert.assertNotNull(list);
		list.parallelStream().forEach(System.out::println);
	}

	@Test
	public void test05SelecEmpByNo() {
		System.out.println("testSelecTitleByNo");
		Employee emp = new Employee(4377);

		Employee newEmp = dao.selectEmpByNo(emp);
		Assert.assertNotNull(newEmp);
		System.out.println(newEmp);
	}

	@Test
	public void test01InsertEmp() {
		System.out.println("testInsertTitle");
		Employee emp = new Employee(1366, "이", new Title(2), new Employee(4377), 2000000, new Department(2),
				new Date());

		int res = dao.insertEmp(emp);
		Assert.assertEquals(1, res);
		System.out.println(emp);
	}

	@Test
	public void test02UpdateEmp() {
		System.out.println("test02UpdateTitle");
		Employee emp = new Employee(1366, "자바", new Title(5), new Employee(1365), 1500000, new Department(4), new Date(2021, 3, 5));
		
		int res = dao.updateEmp(emp);
		Assert.assertEquals(1, res);
		System.out.println(emp);
	}

	@Test
	public void test03DeleteEmp() {
		System.out.println("test03DeleteEmp");
		Employee emp = new Employee(1366);
		
		int res = dao.deleteEmp(emp);
		Assert.assertEquals(1, res);
	}

}
