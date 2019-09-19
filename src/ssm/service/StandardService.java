package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ssm.dao.StandardDao;
import ssm.entity.Standard;

public class StandardService {
	
	@Autowired
	private StandardDao standardDao;
	
	public List<Standard> selectStandart(){
		return standardDao.selectStandart();
	}
	
}
