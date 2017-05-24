package com.mylzs.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javabean.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 列表
 * @author Go With Me
 *
 */
public class ListServlet extends HttpServlet{

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			req.setCharacterEncoding("UTF-8");
			String command=req.getParameter("command");
			String desc=req.getParameter("desc");
			
			System.out.println(desc);
			Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message","root","root");
		String sql="select `id`,`command`,`desc`,`content` from message where 1=1";
		List<String> palist=new ArrayList<String>();
		if(command !=null && !"".equals(command.trim())){
//			sql.append("and command = ? ");
//			palist.add(command);
			sql+="and command ="+command;
		}
		if(desc !=null && !"".equals(desc.trim())){
//			sql.append("and desc like '%' ? '%'");
//			palist.add(desc);
			sql+="and desc like '%'"+desc+"'%'";
		}
	//	PreparedStatement statement= conn.prepareStatement(sql);
//		for(int i=0;i<palist.size();i++){
//			statement.setString(i+1, palist.get(i));
//		}
		Statement statement=conn.createStatement();
		
		ResultSet resultSet=statement.executeQuery(sql);
		List<Message> messages = new ArrayList<Message>();
		
		while(resultSet.next()){
			Message message=new Message();
			message.setId(resultSet.getString("id"));
			message.setCommand(resultSet.getString("command"));
			message.setDesc(resultSet.getString("desc"));
			message.setContent(resultSet.getString("content"));
			messages.add(message);
			
		}
		
		req.setAttribute("messages",messages );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}

	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doHead(req, resp);
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doTrace(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doTrace(req, resp);
	}

	@Override
	protected long getLastModified(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return super.getLastModified(req);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}

}
