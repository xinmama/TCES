package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.TermDao;
import ssm.entity.Term;

@Service
public class TermService {

	@Autowired
	private TermDao termDao;
	
	
	public List<Term> getTerm(){
		return  termDao.getTerm();
	}
}
