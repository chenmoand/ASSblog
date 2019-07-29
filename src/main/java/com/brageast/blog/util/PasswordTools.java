package com.brageast.blog.util;

import com.alibaba.druid.filter.config.ConfigTools;

public class PasswordTools {
//    private static String[] keyPair;
//    获取公钥和私钥 keyPair[1] 是公钥 keyPair[0]是私钥;
//    static {
//        try {
//            keyPair = ConfigTools.genKeyPair(512);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        }
//    }
    private static final String PUBLIC_KEY = "MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEAv46rR9t5fsiwJHhbhZ8ZLGizAdTovK4IT" +
            "ewKLFgP/J9gXBzsxyj7wfZFBtZIX884m+1Tin7ZEdxqwalo6PsJnQIDAQABAkEAsOti9HYXa2qNjNGArhP4WxTEJ+/t" +
            "mL4fu2BDMRuQgF9U8oVrHgt++fJEIAS8l77DiI8A8VtG2jeMtrMdFKG1nQIhAOvJnn6s/ZZA1LQNDua4m6eo/4m+WR" +
            "PrIEjbHseLzK0HAiEAz/ppkFmKOBQ7aWeJNymq8pqZqwXhwJxw5XUcP6zGTzsCIQCKscBPV0abWWtEteGsCa9Vwez+gz82" +
            "njoRYQML8cnlhQIgRa67C9hUTTHKLii4erkFQ7+02O5hky1XTioMyvDSiN0CIQCQdQih50NvoNOuz3SoHYY1rxowNbnmaxcTCj" +
            "Q9+7qaFA==";
    private static final String PRIVATE_KEY = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAL+Oq0fbeX7IsCR4W4WfGSxoswHU6LyuCE3s" +
            "CixYD/yfYFwc7Mco+8H2RQbWSF/POJvtU4p+2RHcasGpaOj7CZ0CAwEAAQ==";
    public static String encrypt(String str) {
        String paw = null;
        try {
            paw = ConfigTools.encrypt(PUBLIC_KEY, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paw;
    }

    public static String decrypt(String str) {
        String paw = null;
        try {
            paw = ConfigTools.decrypt(PRIVATE_KEY, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paw;
    }
}
