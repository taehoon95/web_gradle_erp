package web_gradle_erp.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_gradle_erp.dao.Impl.DepartmentDaoImpl;
import web_gradle_erp.dto.Department;
import web_gradle_erp.util.JdbcUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest {

	private static Connection con;
	private static DepartmentDaoImpl dao = DepartmentDaoImpl.getInstance();
	
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
	public void test01SelectTitleByAll() {
		System.out.println("testSelectTitleByAll");
		List<Department> list = dao.selectTitleByAll();
		
		Assert.assertNotNull(list);
		list.parallelStream().forEach(System.out::println);
	}

	@Test
	public void test02InsertTitle() {
		System.out.println("test02InsertTitle");
		
		Department dept = new Department(5, "개발", 11);
		
		int res = dao.insertTitle(dept);
		
		Assert.assertEquals(1, res);
		
		System.out.println(dept);
	}

	@Test
	public void test03UpdateTitle() {
		System.out.println("test03UpdateTitle");
		
		Department dept = new Department(5, "감사", 2);
		
		int res = dao.updateTitle(dept);
		
		Assert.assertEquals(1, res);
		
		System.out.println(dept);
	}

	@Test
	public void test04DeleteTitle() {
		System.out.println("test04DeleteTitle");
		
		Department dept = new Department(5);
		
		int res = dao.deleteTitle(dept);
		
		Assert.assertEquals(1, res);
	}

	@Test
	public void test05SelecDepartmentByNo() {
		System.out.println("test05SelecDepartmentByNo");
		
		Department dept = new Department(3);
		
		Assert.assertNotNull(dept);
		
		System.out.println(dept);
	}

}
