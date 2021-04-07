package web_gradle_erp.dao;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_gradle_erp.dao.Impl.TitleDaoImpl;
import web_gradle_erp.dto.Title;
import web_gradle_erp.util.JdbcUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleDaoTest {

	private static Connection con;
	private static TitleDaoImpl dao = TitleDaoImpl.getInstance();
	
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
		System.out.println("test01SelectTitleByAll");
		
		List<Title> list = dao.selectTitleByAll();
		Assert.assertNotNull(list);
		
		list.parallelStream().forEach(System.out::println);
	}

	@Test
	public void test04SelecTitleByNo() {
		System.out.println("test04SelecTitleByNo");
		
		Title title = new Title(1);
		Title addTitle = dao.selecTitleByNo(title);
		
		Assert.assertNotNull(addTitle);
		System.out.println(addTitle);
	}

	@Test
	public void test02InsertTitle() {
		Title title = new Title(6, "인턴");
		
		int res = dao.insertTitle(title);
		Assert.assertEquals(1, res);
		System.out.println(title);
	}

	@Test
	public void test03UpdateTitle() {
		Title title = new Title(6,"명훈");
		
		int res = dao.updateTitle(title);
		Assert.assertEquals(1,res);
		System.out.println(title);
	
	}

	@Test
	public void test05DeleteTitle() {
		Title title = new Title(6);
		
		int res = dao.deleteTitle(title);
		Assert.assertEquals(1,res);
	}

}
