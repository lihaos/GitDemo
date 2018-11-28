package cn.ch.netem.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ch.netem.exceptions.NoActivationException;
import cn.ch.netem.mapper.RoleMapper;
import cn.ch.netem.mapper.UserMapper;
import cn.ch.netem.pojo.Page;
import cn.ch.netem.pojo.Role;
import cn.ch.netem.pojo.User;
import cn.ch.netem.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private JavaMailSenderImpl javaMailSenderImpl;


	@Override
	public List<User> findUserAll(String userCode, String userName,Page page, Integer userType) {
		
		Integer userCount = userMapper.getUserCount(userCode, userName, userType);
		page.setItemCount(userCount);
		return userMapper.findUserAll(userCode, userName,page, userType);
	}

	 public Collection<Session> getSessions()
	  {
		  DefaultWebSecurityManager defaultWebSecurityManager=(DefaultWebSecurityManager)	SecurityUtils.getSecurityManager();
			DefaultWebSessionManager defaultWebSessionManager=(DefaultWebSessionManager)defaultWebSecurityManager.getSessionManager();
			return defaultWebSessionManager.getSessionDAO().getActiveSessions();
	  }
	@Override
	/*@Cacheable("login")*/
	public void login(String userName, String password) {
		Subject currentSbject = SecurityUtils.getSubject();
		UsernamePasswordToken UsernamePasswordToken = new UsernamePasswordToken(userName, password);
		currentSbject.login(UsernamePasswordToken);
		User login = (User) currentSbject.getPrincipal();
		if (login.getStatus() == 0) {
			throw new NoActivationException();
		}
		Collection<Session> sessions = getSessions();
			User currentUser = (User) currentSbject.getPrincipal();
				for (Session session : sessions) {
					Subject  subject = new 	Subject.Builder().session(session).buildSubject();
					User user = (User) subject.getPrincipal();
					if(user.getUserCode().equals(currentUser.getUserCode()))
					{
						if(!session.getId().equals(currentSbject.getSession().getId()))
						{
							session.stop();
						}
					}
			}
	}

	/****
	 * @author long
	 * @param user
	 * @return int
	 *         <h1>新增用户 用于 用户注册</h1>
	 * @throws MessagingException
	 */
	@Override
	public int addUser(User user, String url) {
		User validateUnicode = userMapper.validateUnicode(user.getUserCode(), user.getUserEmail());
		if (validateUnicode != null) {
			if (validateUnicode.getUserCode().equals(user.getUserCode())) {
				return 3;
			}
			return 2;
		}
		user.setStatus(0);
		user.setUserType(2);
		user.setSalt(UUID.randomUUID().toString());
		SimpleHash SimpleHash = new SimpleHash("MD5", user.getPassword(), user.getSalt(), 1024);
		user.setPassword(SimpleHash.toString());
		int insertSelective = userMapper.insertSelective(user);
		if (insertSelective == 1) {
			MimeMessage createMimeMessage = javaMailSenderImpl.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(createMimeMessage);
			try {
				String content = "<html> " + "<body>"
						+ "<div style='color:red;width:100%;height100%;background:black;' >" + " <a href='" + url
						+ "?userCode=" + user.getUserCode() + "'>点击激活您的账户</a>" + "</div>" + "</body>" + "</html>";
				mimeMessageHelper.setSubject("账户激活");
				mimeMessageHelper.setText(content, true);
				mimeMessageHelper.setFrom(javaMailSenderImpl.getUsername());
				mimeMessageHelper.setTo(user.getUserEmail());
				javaMailSenderImpl.send(createMimeMessage);

				return 1;
			} catch (MessagingException e) {
				e.printStackTrace();
				return -1;
			}
		}
		return 0;
	}

	@Override
	public int activationUser(String userCode) {
		return userMapper.activationUser(userCode);
	}

	public int delUset(Integer id) {
		return userMapper.deleteByPrimaryKey(id);

	}

	@Override
	public String addAdmin(User user) {
		user.setStatus(1);
		user.setUserType(1);
		user.setSalt(UUID.randomUUID().toString());
		SimpleHash SimpleHash = new SimpleHash("MD5", user.getPassword(), user.getSalt(), 1024);
		user.setPassword(SimpleHash.toString());
		int insertSelective = userMapper.insertSelective(user);
		if(insertSelective==1)
		{
			for (Role role : user.getRoles()) {
				userMapper.setUserRole(role.getRoleId(), user.getUserId());
			}
			return "success";
		}
		return "error";
	}

}
