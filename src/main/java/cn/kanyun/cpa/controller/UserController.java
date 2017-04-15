package cn.kanyun.cpa.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kanyun.cpa.pojo.CpaResult;
import cn.kanyun.cpa.pojo.CpaUser;
import cn.kanyun.cpa.service.IUserService;
import cn.kanyun.cpa.util.MD5util;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name=IUserService.SERVICE_NAME)
	private IUserService userService;
	/* 登陆检查 */
	@RequestMapping("/login.do")
	@ResponseBody
	public CpaResult toLogin(String v_code,String username,String password,HttpSession session){
		CpaResult result = new CpaResult();
		String s_code = (String) session.getAttribute("code");
		// 先比较验证码(equalsIgnoreCase忽略大小写，equals不忽略)
		if (!s_code.equalsIgnoreCase(v_code)) {
			result.setStatus(2);
			result.setMsg("验证码错误！");
		}else{
		 result = userService.checkLogin(username, password);
		}
		return result;
		
	}
	/* 注册Ajax检查用户名是否可用 */
	@RequestMapping("/checkname.do")
	@ResponseBody
	public CpaResult checkName(String username) {
		Object[] params = { username };
		String where = "o.username=? ";
		CpaResult result = userService.getScrollData(-1,-1,where,params);
		if(result.getTotalCount()>0){
			result.setStatus(2);
			result.setMsg("当前用户名已存在!");
		}
		return result;
	}
	/*用户注册*/
	@RequestMapping("/register.do")
	@ResponseBody
	public CpaResult saveUser(String v_code,String username, String password,HttpSession session) throws NoSuchAlgorithmException{
		CpaResult result = new CpaResult();
		// 获取session中保存的验证码
		String s_code = (String) session.getAttribute("code");
		// 先比较验证码(equalsIgnoreCase忽略大小写，equals不忽略)
		if (!s_code.equalsIgnoreCase(v_code)) {
			result.setStatus(2);
			result.setMsg("验证码错误！");
		}else{
		String md5_pwd = MD5util.md5(password);
		CpaUser user = new CpaUser();
		user.setPassword(md5_pwd);
		user.setUsername(username);
		user.setRegDate(new Timestamp(System.currentTimeMillis()));
		Integer k =userService.save(user);
		if (k!=null){
		result.setStatus(1);
		}else{
		result.setStatus(2);
		result.setMsg("注册失败,请重试！");
		}
		}
		return result;
}
}
