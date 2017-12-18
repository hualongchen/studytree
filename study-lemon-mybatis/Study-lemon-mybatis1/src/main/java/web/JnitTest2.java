package web;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lemon.chen.annoation.InterfaceDAO;
import com.lemon.chen.annoation.InterfaceInfo;
import com.lemon.chen.model2.InterfaceInfoPOMapper;

public class JnitTest2 {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	
	static{
		
		try {
			  reader = Resources.getResourceAsReader("config2.xml");
	            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	            sqlSessionFactory.getConfiguration().addMapper(InterfaceDAO.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	

public static void main(String[] args) {
	
	SqlSession session = sqlSessionFactory.openSession();

	InterfaceDAO interfaceInfoPOMapper = session.getMapper(InterfaceDAO.class);

	InterfaceInfo  interfaceInfo = interfaceInfoPOMapper.getInfoById(3);

	if (null != interfaceInfo) {

		System.out.println("查询出来" + interfaceInfo.toString());
	}else{
		
		System.out.println("没查出来");
	}
	
	session.close();
}

}
