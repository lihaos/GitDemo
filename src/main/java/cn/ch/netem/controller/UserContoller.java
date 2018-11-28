package cn.ch.netem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.ch.netem.exceptions.NoActivationException;
import cn.ch.netem.mapper.RoleMapper;
import cn.ch.netem.pojo.Page;
import cn.ch.netem.pojo.Role;
import cn.ch.netem.pojo.User;
import cn.ch.netem.service.UserService;

@Controller
public class UserContoller {
	@Autowired
	private JavaMailSenderImpl javaMailSenderImpl;
	@Autowired
	private UserService userService;
	@Autowired
	private StringRedisTemplate  a ;
  
	@Autowired
	private RoleMapper roleMapper;
	@ResponseBody
	@RequestMapping("/demo")
	public String Demo(HttpSession session) {
		ValueOperations<String, String> ss = a.opsForValue();
		ss.set("key12", "222222");
	/*	WebApplicationContext a = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
		String[] beanDefinitionNames = a.getBeanDefinitionNames();
		String names = "1";
		
		 for (String string : beanDefinitionNames) { names+=string+"<br/>"; }*/
		 
		/*HttpMessageConverters bean = a.getBean(HttpMessageConverters.class);
		List<HttpMessageConverter<?>> converters = bean.getConverters();
		for (HttpMessageConverter<?> httpMessageConverter : converters) {
			names += httpMessageConverter.getClass().getName() + "<br/>";
		}*/

		return ss.get("key12");
	}

	@RequestMapping("send")
	public String addUser() {
		MimeMessage createMimeMessage = javaMailSenderImpl.createMimeMessage();
		MimeMessageHelper MimeMessageHelper = new MimeMessageHelper(createMimeMessage);
		try {
			MimeMessageHelper.setTo("563170921@qq.com");
			MimeMessageHelper.setSubject("1122");
			MimeMessageHelper.setFrom(javaMailSenderImpl.getUsername());
			MimeMessageHelper.setText("111", true);
			javaMailSenderImpl.send(createMimeMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		 * simpleMailMessage.setSubject("tesrEmail");
		 * simpleMailMessage.setText("<html><a href='www.baidu.com' >点击激活</a></html>");
		 * simpleMailMessage.setTo("1127126139@qq.com");
		 * simpleMailMessage.setFrom("loveluzhilong@qq.com");
		 * javaMailSenderImpl.send(simpleMailMessage);
		 */
		return "/pre/index.html";
	}

	/* @ResponseBody */
	@PostMapping("/dologin")
	public String doLogin(@RequestParam("userName") String user, @RequestParam("password") String password, Model model,
			HttpSession session) {
		try {
			userService.login(user, password);
		} catch (UnknownAccountException e) {
			model.addAttribute("loginError", "账户不存在");
			return "/pre/login";
		} catch (IncorrectCredentialsException e) {
			model.addAttribute("loginError", "密码错误");
			return "/pre/login";
		} catch (NoActivationException e) {
			model.addAttribute("loginError", "账户未激活");
			return "/pre/login";
		}
		/*
		 * Subject subject = SecurityUtils.getSubject(); User principal = (User)
		 * subject.getPrincipal(); session.setAttribute("user", principal);
		 */
		return "redirect:main";

	}

	@ResponseBody
	@RequestMapping("/findUsers")
	public Map findUserAll(@RequestParam(value = "userCode", required = false) String userCode,
			@RequestParam(value = "currentPage", required = false) Integer currentPage,
			@RequestParam(value = "userNmae", required = false) String userNmae, Model model) {
		Page page = new Page();
		page.setCurrentPage(currentPage);
		List<User> findUserAll = userService.findUserAll(userCode, userNmae, page, 1);

		Map map = new HashMap();
		map.put("users", findUserAll);
		map.put("page", page);
		return map;
	}

	@ResponseBody
	@RequestMapping("/findAdmins")
	public Map findAdminAll(@RequestParam(value = "userCode", required = false) String userCode,
			@RequestParam(value = "currentPage", required = false) Integer currentPage,
			@RequestParam(value = "userNmae", required = false) String userNmae, Model model) {
		Page page = new Page();
		page.setCurrentPage(currentPage);
		List<User> findUserAll = userService.findUserAll(userCode, userNmae, page, 2);
		Map map = new HashMap();
		map.put("users", findUserAll);
		map.put("page", page);
		return map;
	}

	@RequestMapping("/doregister")
	public String register(User user, Model model, HttpServletRequest request) {
		int addUser=0;
        try {
        	addUser = userService.addUser(user, "http://" + request.getServerName()+":"+request.getServerPort() + "/activation");
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("registerError", "异常");
			return "/pre/register.html";
		}
		
		if (addUser == 1) {
			model.addAttribute("registerSuccess", "用户注册成功,去到邮箱激活用户");
			return "/pre/login";
		} else if (addUser == 0) {
			model.addAttribute("registerError", "用户注册失败");

		} else if (addUser == -1) {
			model.addAttribute("registerError", "系统错误");

		} else if (addUser == 2) {
			model.addAttribute("registerError", "邮箱已存在");

		} else if (addUser == 3) {
			model.addAttribute("registerError", "用户已存在");
		}
		return "/pre/register.html";
	}

	// 激活
	@GetMapping("/activation")
	public String activationUser(@RequestParam("userCode")String userCode) {
		int status = userService.activationUser(userCode);
		return "/pre/register_success";
	}

	@RequestMapping("del/{id}")
	public String delUser(@PathVariable("id") Integer id) {
		userService.delUset(id);
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/getRoles")
	public List<Role> findRole()
	{
		List<Role> roles= roleMapper.findRoles();
		return roles;
	}

	@ResponseBody
	@PostMapping("/doAddAdmin")
	public String addAdmin(User user) {
	   return userService.addAdmin(user);
	}
}
