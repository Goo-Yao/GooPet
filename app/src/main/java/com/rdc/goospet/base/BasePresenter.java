package com.rdc.goospet.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by Goo on 2016-8-28.
 */
public abstract class BasePresenter<V> {
    protected Reference<V> mViewRef = null;

    protected V view;

    public BasePresenter(V viewInterface) {
        this.view = viewInterface;
    }

    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    protected V getView() {
        return mViewRef.get();
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
