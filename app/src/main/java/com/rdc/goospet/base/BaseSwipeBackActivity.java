
package com.rdc.goospet.base;

import android.os.Bundle;
import android.view.View;

import com.rdc.goospet.swipeback.SwipeBackActivityBase;
import com.rdc.goospet.swipeback.SwipeBackActivityHelper;
import com.rdc.goospet.swipeback.SwipeBackLayout;
import com.rdc.goospet.swipeback.Utils;


public abstract class BaseSwipeBackActivity<V, P extends BasePresenter<V>> extends BaseActivity<V, P> implements SwipeBackActivityBase {
    private SwipeBackActivityHelper mHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v == null && mHelper != null)
            return mHelper.findViewById(id);
        return v;
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }
}
