package ssm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.ClassDao;
import ssm.dao.Show_scoreDao;
import ssm.entity.Classes;
import ssm.entity.Department;
import ssm.entity.St_score;
import ssm.entity.Tt_score;

@Service
public class Show_scoreService {

	@Autowired
	private Show_scoreDao scoreDao;
	
	public List<St_score> selectSt_scoreById(int id){
		return scoreDao.selectSt_scoreById(id);
	}
	
	public List<Tt_score> selectTt_scoreById(int id){
		return scoreDao.selectTt_scoreById(id);
	}
}
