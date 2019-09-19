package ssm.controller;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.ResultMsg;
import ssm.service.loginService;

@Controller
public class loginController {
	
	@Autowired
	private loginService loginService;
  //访问登陆页面
	@RequestMapping("login")
	public ModelAndView login(){
		ModelAndView mView= new ModelAndView("login/login");
		return mView;		
	}
	
	
}
