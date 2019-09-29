package ssm.dao;

import java.util.List;

import ssm.entity.Term;

public interface TermDao {

	//1.查询学期信息并展示 
	public List<Term> getTerm();
	
	//2.查询添加的学期是否存在（通过学期名）
	public int selectTermByTermname(String term_name);
	
	//3.添加学期信息
	public int addTerm(Term term);
	
	//4.查詢學期信息（通過id）
	public Term selectTermById(int id);
	
	//5.修改學期信息
	public int updateTerm(Term term);
	
	//6.删除学期信息
	public int deleteTerm(int id);
	
	List<Term> selectTerms();
	
	int selectIsCurrAppraise();
	
	int selectIsCurrAppraiseById(int id);
	
	int updateIsCurrAppraise(Term term);
}
