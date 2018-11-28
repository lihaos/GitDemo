package cn.ch.netem.shiro.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.ch.netem.exceptions.NoActivationException;
import cn.ch.netem.mapper.UserMapper;
import cn.ch.netem.pojo.Permission;
import cn.ch.netem.pojo.Role;
import cn.ch.netem.pojo.User;

public class LoanRealm extends AuthorizingRealm {
	@Autowired
	private UserMapper userMapper;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User userName = (User) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		List<Role> roles = userName.getRoles();
		List<Permission> permissions = userName.getPermissions();
		for (Role role : roles) {
			simpleAuthorizationInfo.addRole(role.getRoleName());
		}
		for (Permission permission : permissions) {
			simpleAuthorizationInfo.addStringPermission(permission.getPermissionName());
		}
		return simpleAuthorizationInfo;
	}
	@Override
	public String getName() {
		return "myRealm";
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userCode = (String) token.getPrincipal();
		User login = userMapper.findUserByCode(userCode);
		if (login == null) {
			return null;
		}
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(login, login.getPassword(),
				ByteSource.Util.bytes(login.getSalt()), this.getName());
		return simpleAuthenticationInfo;
	}

}
