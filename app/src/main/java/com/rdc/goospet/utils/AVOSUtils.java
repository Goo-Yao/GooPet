package com.rdc.goospet.utils;

import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;

/**
 * Created by Goo on 2016-9-6.
 * AVOS 工具类
 */
public class AVOSUtils {
    /**
     * 注册
     *
     * @param username
     * @param password
     * @param email
     * @param signUpCallback
     */
    public static void signUp(String username, String password, String email, SignUpCallback signUpCallback) {
        AVUser user = new AVUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.signUpInBackground(signUpCallback);
    }
}
