package ssm.dao;

import java.util.List;

import ssm.entity.Term;

public interface TermDao {

	//1.查询学期信息并展示 
	public List<Term> getTerm();
	
	//2.查询添加的学期是否存在（通过学期名）
	public int selectTermByTermname(String term_name);
}
