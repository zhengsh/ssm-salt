package cn.edu.cqvie.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class MyRealmTest {

    MyRealm realm = new MyRealm();

    @Test
    public void testAuthentication() {
        // 1.构建SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        defaultSecurityManager.setRealm(realm);
        // 加密
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        // 加密算法
        matcher.setHashIterations(1);
        // 加密次数
        realm.setCredentialsMatcher(matcher);

        // 2. Subject提交认证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("Tom", "123456");
        subject.login(token);
        System.out.println(subject.isAuthenticated());
        subject.checkRoles("admin");
        subject.checkPermission("user:delete");
    }
}