package com.mylzs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javabean.Message;
/**
 * 和message relaliation
 * @author Go With Me
 *
 */
public class MessageDao {
	
	/**
	 * 查询消息
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public List<Message> queryMessage(String command,String desc) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
//		驱动的加载
		Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message","root","root");
	String sql="select `id`,`command`,`desc`,`content` from message where 1=1";
	List<String> palist=new ArrayList<String>();
	if(command !=null && !"".equals(command.trim())){
//		sql.append("and command = ? ");
//		palist.add(command);
		sql+="and command ="+command;
	}
	if(desc !=null && !"".equals(desc.trim())){
//		sql.append("and desc like '%' ? '%'");
//		palist.add(desc);
		sql+="and desc like '%'"+desc+"'%'";
	}
//	PreparedStatement statement= conn.prepareStatement(sql);
//	for(int i=0;i<palist.size();i++){
//		statement.setString(i+1, palist.get(i));
//	}
	Statement statement=conn.createStatement();
//	把数据放到类当中，然后把类放到List中
	ResultSet resultSet=statement.executeQuery(sql);
	List<Message> messages = new ArrayList<Message>();
//	数据的读取
	while(resultSet.next()){
		Message message=new Message();
		message.setId(resultSet.getString("id"));
		message.setCommand(resultSet.getString("command"));
		message.setDesc(resultSet.getString("desc"));
		message.setContent(resultSet.getString("content"));
		messages.add(message);
		
	}
	return messages;
	}
}