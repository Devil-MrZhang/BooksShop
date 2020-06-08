/**
 * 
 */
package com.bookshop.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bookshop.model.User;
import com.bookshop.service.UserService;
import com.bookshop.utils.ChangeImgcode;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator.Success;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 张家宝
 * @data 2020年5月4日 下午5:24:33
 * @describe
 */
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private User user;
	@Resource
	private UserService userService;
	
	public int id;
	public String telephone;
	public String pwd;
	public String pwdd;
	public String gender="男";
	private String root;
	public String ypwd;
	
	
	
	
	private List<String> words = new ArrayList<String>();

	public UserAction() {

		String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/new_words.txt");
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		session = request.getSession();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			String line;
			while ((line = reader.readLine()) != null) {
				words.add(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//修改账户信息
	public String modiry() {
		System.out.println("++++++++++++++++++++++++++++modiry");
		System.out.println("id:"+id+"手机号"+telephone+"性别:"+gender);
		
			user=userService.cha(id);
			user.setTelephone(telephone);
			user.setGender(gender);
			user.setId(id);

			//userService.register(user);

			userService.modiry(user);

			return "modiry";

	}
	//修改用户密码
	public String modiry2() {
		System.out.println("---密码："+pwd+"二次密码："+pwdd);
		if(pwd.equals(pwdd)){
			User ue = (User)session.getAttribute("user");
			System.out.println(ue.getPassword());
			ue.setPassword(pwd);
			userService.modiry(ue);
			return "modiry";
		}else{
			request.setAttribute("modiry2", "两次密码不一致");
			return "error";
		}
		
		
		
	}
	public String ajax(){
		System.out.println("ajax-------------------");
		User u1 = (User) session.getAttribute("user");
		System.out.println("当前密码是："+u1.getPassword());
		JSONObject json=new JSONObject();
		System.out.println("获取到的密码："+ypwd);
		if(ypwd.equals(u1.getPassword())){
			json.put("songList", "1");
		}else{
		json.put("songList", "2");
		request.setAttribute("yz", "输入错误");}
		this.root = json.toString();
		System.out.println("root="+root.toString());
		return Action.SUCCESS ;


	}
	
	public String register() {

		userService.register(user);

		return "register";
	}

	public String changeImg() {
		ChangeImgcode imgcode = new ChangeImgcode();
		try {
			imgcode.changeImg(session, response, words);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "changeImg";
	}

	public void validateRegister() {
		
		
		//判断验证码
		String ckcode = request.getParameter("ckcode");
		String repassword=request.getParameter("repassword");
		
		if (ckcode==null) {
			this.addFieldError("ckcode_msg", "验证码不能为空");
		}else if (user.getUsername()==null) {
			this.addFieldError("username", "用户名不能为空");
		}else if (user.getPassword()==null) {
			this.addFieldError("password", "密码不能为空");
		}else if (user.getEmail()==null) {
			this.addFieldError("email", "邮箱不能为空");
		}else if (repassword==null) {
			this.addFieldError("repassword", "请再次输入密码");
		}else{
			//都不为空判断
			String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
			String reg_Email="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
			boolean result=Pattern.matches(reg_Email, user.getEmail());
			if (!checkcode_session.equals(ckcode)) {
				this.addFieldError("ckcode_msg", "验证码错误");

			}
			
			if (user.getUsername().length()<6) {
				this.addFieldError("username", "用户名必须大于6位");
			}if (user.getPassword().length()<6) {
				this.addFieldError("password", "密码必须大于6位");
			}if (!user.getPassword().equals(repassword)) {
				this.addFieldError("repassword", "两次密码输入不一致");
			}if (!result) {
				this.addFieldError("email", "请输入正确的邮箱格式");
			}
			
			
		}
			
		
		
		
		//判断用户名
		
		

	}
	
	
	/**
	 * 登录方法————判断用户是否存在。
	 * 如果存在 判断用户为管理用户还是为普通用户
	 */

	public String UserRegister() {

		ArrayList<Object> list1 = new ArrayList<>();
		
		System.out.println("==========登录方法运行！===========");
		
		String username = request.getParameter("username");
		System.out.println(username);
	
		String password = request.getParameter("password");
		System.out.println(password);
		
		
		User user = userService.login(username, password);

		
			System.out.println("-------------"+user+"----------------");
			
			if(user==null){
				System.out.println("用户登录失败，请重新输入");
				return "failed";
			}
			else if (user.getRole()==0) {
				session.setAttribute("user", user);
				
			System.out.println("------用户登录成功！------");
			return "usersucceed";
			}else if (user.getRole()==1) {

			session.setAttribute("user", user);
			System.out.println("------管理用户登录成功！------");
			return "adminsucceed";	
			}
			else {
				System.out.println("用户登录失败，请重新输入");
				return "failed";
			}
}

	/**
	 *writeoff() 注销功能
	 */

	public String writeoff() {
		
		session.invalidate();
		System.out.println("------用户注销成功！-----------");
		return "writeoff";
}

	public String isLogin() {
		Object user = session.getAttribute("user");
		if (user==null) {
			return "login";
		}else{
			return "usersucceed";
		}
		
		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	

}
