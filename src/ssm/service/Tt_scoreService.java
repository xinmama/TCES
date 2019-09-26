package ssm.service;

import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import ssm.dao.Tt_scoreDao;
import ssm.entity.Tt_score;

@Service
public class Tt_scoreService {
	
	@Autowired
     private Tt_scoreDao tt_scoreDao;
	
	public List<Tt_score> getTt_score(){
		return tt_scoreDao.getTt_score();
	}
	
	public int deleteTt_score(int id) {
		return tt_scoreDao.deleteTt_score(id);
	}
	
}
