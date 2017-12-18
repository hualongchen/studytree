package web;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lemon.chen.model.InterfaceInfoPO;
import com.lemon.chen.model.InterfaceInfoPOMapper;

public class TestController {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	@Before
	public void before() {

		try {
			reader = Resources.getResourceAsReader("config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void after() {

		System.out.println("测试完成-----------");
	}

	/**
	 * 加载第一种不包含通用mapper的方案
	 * 
	 * @param args
	 */

	@Test
	public void testOne() {

		SqlSession session = sqlSessionFactory.openSession();
		InterfaceInfoPO interfaceInfoPO = session
				.selectOne("com.lemon.chen.model.InterfaceInfoPOMapper.selectByPrimaryKey", 1);

		if (null != interfaceInfoPO) {

			System.out.println("查询出来" + interfaceInfoPO.toString());
		}
		
		session.close();
	}

	@Test
	public void testTwo() {
		
		//测试2专用
        sqlSessionFactory.getConfiguration().addMapper(InterfaceInfoPOMapper.class);

		SqlSession session = sqlSessionFactory.openSession();

		InterfaceInfoPOMapper interfaceInfoPOMapper = session.getMapper(InterfaceInfoPOMapper.class);

		InterfaceInfoPO interfaceInfoPO = interfaceInfoPOMapper.selectByName("前海征信工作单位验证");

		if (null != interfaceInfoPO) {

			System.out.println("查询出来" + interfaceInfoPO.toString());
		}
		
		session.close();

	}

}
