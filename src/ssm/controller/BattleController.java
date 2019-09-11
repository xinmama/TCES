package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.Battle;
import ssm.entity.Player;
import ssm.entity.ResultMsg;
import ssm.service.BattleService;
import ssm.service.PlayerService;


@Controller
public class BattleController {

	@Autowired
	public BattleService battleService;
	
	@Autowired
	public PlayerService playerService;
	
	
	@RequestMapping("/battle")
	public ModelAndView battle() {
		ModelAndView mv=new ModelAndView("battle");
		List<Battle> battle=battleService.getBattle();
		List<Player> player=playerService.getPlayer();	
		
		mv.addObject("player",player);
		mv.addObject("battle",battle);
		return mv;
	}
	
	
	
	@RequestMapping("/battles")
	@ResponseBody
	public ResultMsg add_submit(int player1_id,int player2_id,String song1,String song2) {
		System.out.println(player1_id);
		System.out.println(player2_id);
		System.out.println(song1);
		System.out.println(song2);
		Battle battle=new Battle();
		
		battle.setPlayer1_id(player1_id);
		battle.setPlayer2_id(player2_id);
		battle.setSong1(song1);
		battle.setSong2(song2);
		
		int i=battleService.addBattle(battle);
			System.out.println(i);
		if(i>0) {			
			return new ResultMsg(1, "添加对战成功！");
		}
		return new ResultMsg(0, "添加对战失败!");
		
	}
	
	
	
	//开启战队
	@RequestMapping("/open_battles")
	@ResponseBody
	public ResultMsg open_battles(int id) {
		int i=battleService.getStatus();
		if(i==0) {			
			int j = battleService.updateStatus(id);
			if(j>0) {
				return new ResultMsg(1, "开启战队成功！");
			}else {
				return new ResultMsg(0, "开启战队失败");
			}			
		}else if(i==1) {
			return new ResultMsg(0, "已有其他战队开启，请稍后重试！");
		}
		return new ResultMsg(0, "开启战队失败");

	}
	
	
	//关闭战队
	@RequestMapping("/close_battles")
	@ResponseBody
	public ResultMsg close_battles( int id) {
		System.out.println(id);
		int i=battleService.updateStatusClose(id);
		System.out.println(i);
		if(i>0) {
			return new ResultMsg(1, "关闭战队成功！");
		}
			return new ResultMsg(0, "关闭战队失败！");		
	}
	
}
