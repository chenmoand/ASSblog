package com.brageast.blog.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Autho chenmo
 * 用于自己的密码加密方式
 */

@Slf4j
@Component
public class MyPasswordEncoder implements PasswordEncoder {
    /**
     * 用于加密密码
     * @param charSequence
     * @return 加密后密码
     */
    @Override
    public String encode(CharSequence charSequence) {
        // 用阿里爸爸的加密工具
        return PasswordTools.encrypt(charSequence.toString());
    }

    /**
     *
     * @param charSequence 加密后的字符串
     * @param str 需要比对的字符串
     * @return 比对玩后是否相等
     */

    @Override
    public boolean matches(CharSequence charSequence, String str) {
        final boolean b = PasswordTools.decrypt(charSequence.toString()).equals(str);
        if(!b) log.error("密码不匹配");
        return b;
    }
}
