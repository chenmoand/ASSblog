package com.brageast.blog.shiro;

import com.brageast.blog.entity.User;
import com.brageast.blog.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    {
        HashedCredentialsMatcher hashcm = new HashedCredentialsMatcher();
        hashcm.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
        hashcm.setStoredCredentialsHexEncoded(false);
        hashcm.setHashIterations(1024);
        this.setCredentialsMatcher(hashcm);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if(principalCollection == null){
            throw new AuthenticationException("PrincipalCollection method argument cannot be null.");
        }
        User user = (User)getAvailablePrincipal(principalCollection);
        Set<String> Roles = new HashSet<>(Arrays.asList(user.getGroup().split(",")));
        Set<String> Perms = new HashSet<>(Arrays.asList(user.getPermissions().split(",")));
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(Roles);
        info.setStringPermissions(Perms);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
       return null;
    }
}
