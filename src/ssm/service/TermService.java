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
	
	//3.添加学期信息
	public int addTerm(Term term) {
		return termDao.addTerm(term);
	}
	
	//4.查詢學期信息（通過id）
	public Term selectTermById(int id) {
		return termDao.selectTermById(id);
	}
	
	//5.修改學期信息
	public int updateTerm(Term term) {
		return termDao.updateTerm(term);
	}
	
	//6.删除学期信息
	public int deleteTerm(int id) {
		return termDao.deleteTerm(id);
	}
	
	public List<Term> selectTerms() {
		return termDao.selectTerms();
	}
	
	public int selectIsCurrAppraise() {
		return termDao.selectIsCurrAppraise();
	}
	
	public int selectIsCurrAppraiseById(int id) {
		return termDao.selectIsCurrAppraiseById(id);
	}
	
	public int updateIsCurrAppraise(Term term) {
		return termDao.updateIsCurrAppraise(term);
	}
	
	public int selectIsCurrAppraiseByIs_open() {
		return termDao.selectIsCurrAppraiseByIs_open();
	}
}
