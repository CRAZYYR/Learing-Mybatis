package service;

import java.sql.SQLException;
import java.util.List;

import com.mylzs.dao.MessageDao;

import javabean.Message;

/***
 * 列表相关业务功能
 * @author Go With Me
 *
 */
public class ListService {
	public List<Message> queryMessage(String command,String desc) throws ClassNotFoundException, SQLException {
		MessageDao dao=new MessageDao();
		return dao.queryMessage(command, desc);
	}
}
