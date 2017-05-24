package com.mylzs.db;


import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 进行数据的访问
 * @author Go With Me
 *
 */
public class DBAccess {
		public SqlSession getSqlSession() throws Exception{
			//通过xml
		Reader reader	 =Resources.getResourceAsReader("com/mylzs/config/Configuration.xml");
//			构建sqlsession
		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
		//打开会话
		SqlSession sqlSession= sqlSessionFactory.openSession();
		return sqlSession;
		}
}
