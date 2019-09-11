package ssm.dao;

import java.util.List;

import ssm.entity.Battle;

public interface BattleDao {

	List<Battle> getBattle();
	
	int addBattle(Battle battle);
	
	int getStatus();
	
	int updateStatus(int id);
	
	int updateStatusClose(int id);
	
	Battle getTicketByStatus();
	
	Battle selectBattleById(int id);
	
	int update_ticket1(int ticket1);
	
	int update_ticket2(int ticket2);
}
