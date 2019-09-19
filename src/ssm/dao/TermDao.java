package ssm.dao;

import java.util.List;

import ssm.entity.Term;

public interface TermDao {

	//1.查询学期信息并展示 
	public List<Term> getTerm();
}
