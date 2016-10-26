package com.rdc.goospet.base;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by Goo on 2016-9-6.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"Adlpr3dsk0rETlPXReausO2N-gzGzoHsz","JIPILdLkgE2Etvww6KH5u9Qq");
    }
}
