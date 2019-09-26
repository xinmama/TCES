package ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.EvaluateDao;

@Service
public class EvaluateService {

	@Autowired
	public EvaluateDao evaluateDao;
	
	public int InsertSt_score(int score) {
		
		return evaluateDao.InsertSt_score(score);
	}
	
	public int InsertTt_score(int score) {
		
		return evaluateDao.InsertTt_score(score);
	}
}
