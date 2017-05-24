package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

import javabean.Message;

import com.mylzs.dao.MessageDao;
import com.sun.org.apache.bcel.internal.generic.ICONST;

public class QueryService {


	
	public String querycomand(String p) {
		
		MessageDao dao=new MessageDao();
		List<Message> messages=new ArrayList<Message>();
		messages=dao.queryMessage(p, null);
		if(messages.size()>0){
			return messages.get(0).getContent();
		}
		
		
		return "对不起,可能我还不够聪明！";
	}
	
}
