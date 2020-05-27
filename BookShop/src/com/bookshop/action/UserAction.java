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

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bookshop.model.User;
import com.bookshop.service.UserService;
import com.bookshop.utils.ChangeImgcode;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator.Success;

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
	public String gender;
	
	
	
	
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
		System.out.println("id"+id+"密码："+pwd+"手机号"+telephone+"性别"+gender);
		if(pwd.equals(pwdd)){
			user=userService.cha(id);
			user.setPassword(pwd);
			user.setTelephone(telephone);
			user.setGender(gender);
			user.setId(id);
			userService.register(user);

			return "modiry";
		}else{
			session.setAttribute("mm", "两次输入的密码不一样");
			return "error";
		}
		
		
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
		String ckcode = request.getParameter("ckcode");
		String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
		System.out.println(checkcode_session + "------" + ckcode);
		if (!checkcode_session.equals(ckcode)) {
			this.addFieldError("ckcode_msg", "验证码错误");

		}

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
