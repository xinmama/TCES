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
	
	//1.查询学期所有信息，并展示
	public List<Term> getTerm(){
		return  termDao.getTerm();
	}
	
	//2.查询添加的学期是否已经存在
	public int selectTermByTermname(String term_name) {
		return termDao.selectTermByTermname(term_name);		
	}
}
