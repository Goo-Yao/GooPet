package com.rdc.goospet.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.rdc.goospet.R;
import com.rdc.goospet.utils.AppConstants;
import com.rdc.goospet.utils.DimenUtils;

/**
 * Created by Goo on 2016-8-28.
 */
public abstract class BaseActivity<V, P extends BasePresenter<V>> extends AppCompatActivity {
    protected Toolbar toolbar;
    protected P mPresenter;
    private ProgressDialog mProgressDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentViewById());
        //创建Presenter，并把自己交给Present
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        initAttributes();
        initView();
    }

    //获取Presenter;
    protected abstract P createPresenter();

    protected abstract int setContentViewById();

    protected abstract void initAttributes();

    protected abstract void initView();

    protected abstract void findAllViewById();

    /**
     * @param title 直接显示返回箭头的toolbar
     */
    public void showToolbarAndShowNavigation(String title) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setToolbarTitle(title);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            toolbar.getLayoutParams().height = DimenUtils.getAppBarHeight(this);
            toolbar.setPadding(toolbar.getPaddingLeft(),
                    DimenUtils.getStatusBarHeight(this),
                    toolbar.getPaddingRight(),
                    toolbar.getPaddingBottom());
        }
        showToolBar();
        showOrHideToolBarNavigation(true);
    }


    /**
     * 设置toolbar标题
     *
     * @param title
     */
    private void setToolbarTitle(String title) {
        if (toolbar != null) {
            toolbar.setTitle(title);
            toolbar.setTitleTextColor(0xFFFFFFFF);
        }
    }

    /**
     * 显示ToolBar
     */
    private void showToolBar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
        }
    }

    /**
     * 是否隐藏ToolBar返回按钮
     *
     * @param show
     */
    public void showOrHideToolBarNavigation(boolean show) {
        if (show) {
            //设置返回键
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    setPendingTransition(AppConstants.OUT_PENDING_TRANSITION);
                }
            });
        }
    }

    /**
     * Activity切换动画
     *
     * @param TYPE
     */
    public void setPendingTransition(int TYPE) {
        if (TYPE == AppConstants.OPEN_PENDING_TRANSITION) {
            overridePendingTransition(R.anim.transition_right_in,
                    R.anim.transition_not_move);
        } else if (TYPE == AppConstants.OUT_PENDING_TRANSITION) {
            overridePendingTransition(R.anim.transition_not_move,
                    R.anim.transition_right_out);
        }
    }

    /**
     * 启动Activity
     *
     * @param clazz
     */
    protected void launchActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * 启动Activity - 有启动码
     *
     * @param clazz
     * @param requestCode
     */
    protected void launchActivity(Class clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * 替换 findViewById
     *
     * @param viewId
     * @param <T>
     * @return
     */
    protected <T extends View> T $(int viewId) {
        return (T) findViewById(viewId);
    }


    protected void showProgressDialog(String msg) {
        if (mProgressDialog == null)
            mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage(msg);
        //可取消
        mProgressDialog.setCancelable(true);
        //不显示进度
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.show();
    }

    protected void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

    /**
     * 带动画启动Activity
     *
     * @param intent
     */
    protected void startActivityWithAnim(Intent intent) {
        startActivity(intent);
        setPendingTransition(AppConstants.OPEN_PENDING_TRANSITION);
    }

    /**
     * 带动画关闭Activity
     */
    protected void finishActivityWithAnim() {
        finish();
        setPendingTransition(AppConstants.OUT_PENDING_TRANSITION);
    }


}
