package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.St_scoreDao;
import ssm.entity.St_score;


@Service
public class St_scoreService {

	@Autowired
	private St_scoreDao st_scoreDao;
	
	public List<St_score> selectSt_score(){
		return st_scoreDao.selectSt_score();
	}
	
	public int  deleteSt_score(int id) {
		return  st_scoreDao.deleteSt_score(id);
	}
}
