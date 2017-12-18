package web;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lemon.chen.model3.User;

public class OneToMany {

	
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	
	
	
	public static void main(String[] args) throws Throwable {
		
		reader = Resources.getResourceAsReader("config3.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        
      User user=(User)  session.selectOne("com.lemon.chen.model3.UserMapper.getUser", 1);
      
      System.out.println(user.toString());
      
      session.close();

	}
}
