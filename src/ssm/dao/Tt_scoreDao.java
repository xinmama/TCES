package ssm.dao;

import java.util.List;

import ssm.entity.Tt_score;

public interface Tt_scoreDao {

	List<Tt_score> getTt_score();

	int deleteTt_score(int id);

}
