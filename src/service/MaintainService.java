package service;

import com.mylzs.dao.MessageDao;

/**
 * 维护数据
 * @author Go With Me
 *
 */
public class MaintainService {
	public void delete_one(String id){
		if (id!= null && !"".equals(id.trim())) {
			MessageDao dao=new MessageDao();
		dao.deleteone(Integer.valueOf(id));
		}
		
	}
}
