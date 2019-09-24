package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.StandardDao;
import ssm.entity.Standard;

@Service
public class StandardService {
	
	@Autowired
	private StandardDao standardDao;
	
	public List<Standard> selectStandard(){
		return standardDao.selectStandard();
	}
	
	public int selectStandardById(String title_con) {
		return standardDao.selectStandardById(title_con);
	}
	
	public int addStandard(Standard standard) {
		return standardDao.addStandard(standard);
	}

	public Standard selectStandardByid(int id) {
		return standardDao.selectStandardByid(id);
	}
	
	public int updateStandardById(Standard standard) {
		return standardDao.updateStandardById(standard);
	}
	
	public  int deleteStandardById(int id) {
		return standardDao.deleteStandardById(id);
	}
	
}











