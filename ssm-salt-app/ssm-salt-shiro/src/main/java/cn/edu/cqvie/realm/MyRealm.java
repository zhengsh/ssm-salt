package cn.edu.cqvie.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    Map<String, String> userMap = new HashMap();

    {
        //userMap.put("Tom","123456");
        //加密
        userMap.put("Tom","da3177cbd9f064004b6a0d59a3a484bb");
        super.setName("myRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        Set<String> roles = getRolesByUsername(username);
        Set<String> permissions = getPermissionsByUsername(username);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //测试
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 1. 根据认证信息获取用户名
        String username = (String) token.getPrincipal();
        // 2. 通过用户名获取密码
        String password = getPassswordByUsername(username);
        if (password != null) {
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, "myRealm");
            //加盐值
            authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("abcd"));
            return authenticationInfo;
        }
        return null;
    }

    private String getPassswordByUsername(String username) {
        // 模拟查询db
        return userMap.get(username);
    }

    private Set<String> getPermissionsByUsername(String username) {
        //模拟从缓存或db中获取roles
        Set<String> permissions = new HashSet<>();
        permissions.add("user:delete");
        permissions.add("user:add");
        return permissions;
    }

    private Set<String> getRolesByUsername(String username) {
        //模拟从缓存或db中获取roles
        Set<String> roles = new HashSet<>();
        roles.add("admin");
        roles.add("user");
        return roles;
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456", "abcd");
        System.out.println(md5Hash.toString());
    }
}