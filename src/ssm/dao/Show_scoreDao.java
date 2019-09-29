package ssm.dao;

import java.util.List;

import ssm.entity.Classes;
import ssm.entity.Department;
import ssm.entity.St_score;
import ssm.entity.Tt_score;

public interface Show_scoreDao {

	public List<St_score> selectSt_scoreById(int id);
	
	public List<Tt_score> selectTt_scoreById(int id);
}
