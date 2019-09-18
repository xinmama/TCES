package ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.loginDao;

@Service
public class loginService {
	@Autowired
	private loginDao loginDao;
	
       public int selectUserName(String username){
    	   return loginDao.selectUserName(username);
       }
}
