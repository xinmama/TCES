package ssm.dao;

import java.util.List;

import ssm.entity.Standard;

public interface StandardDao {
	
	public List<Standard> selectStandard();
	
	public int selectStandardById(String title_con);
	
	public int addStandard(Standard standard);
	
	public Standard selectStandardByid(int id);
	
	public int updateStandardById(Standard standard);

	public int deleteStandardById(int id);
	
	public List<Standard> selectStandardByType(int type);
}
