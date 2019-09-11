package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ssm.dao.BattleDao;
import ssm.dao.PlayerDao;
import ssm.entity.Battle;
import ssm.entity.Player;

@Service
public class BattleService {

	@Autowired
	public BattleDao battleDao;
	
	
	//获取选手列表并展示
		public List<Battle> getBattle(){
			return battleDao.getBattle();
		}	
		
		
		//添加对战
		public int addBattle(Battle battle) {
			//判断用户名是否已经存在
			return battleDao.addBattle(battle);
		}	
		
		
		//判断对战的状态
		public int getStatus() {
			return battleDao.getStatus();
		}
		
		
		//修改对战状态
		public int updateStatus(int id) {
			return battleDao.updateStatus(id);
		}
		
		//修改关闭状态
		public int updateStatusClose(int id) {
			return battleDao.updateStatusClose(id);
		}
		
		//获取后台票数
		public Battle getTicketByStatus() {
			return battleDao.getTicketByStatus();
		}
		
		//通过id查询战队信息
		public Battle selectBattleById(int id) {
			return battleDao.selectBattleById(id);
		}
		
		//修改选手的票数
		public int update_ticket1(int ticket1) {
			return battleDao.update_ticket1(ticket1);
		}
		
		public int update_ticket2(int ticket2) {
			return battleDao.update_ticket2(ticket2);
		}
}
