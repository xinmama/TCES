package ssm.dao;

import java.util.List;

import ssm.entity.St_score;

public interface St_scoreDao {
	List<St_score> selectSt_score();
	
	public int  deleteSt_score(int id);
}
