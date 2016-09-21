package com.rdc.goospet.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.rdc.goospet.R;
import com.rdc.goospet.base.BaseActivity;
import com.rdc.goospet.presenter.MainPresenter;
import com.rdc.goospet.service.FloatingPetService;
import com.rdc.goospet.view.vinterface.MainVInterface;

public class MainActivity extends BaseActivity<MainVInterface, MainPresenter> implements MainVInterface, View.OnClickListener {

    private Button btnShow;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int setContentViewById() {
        return R.layout.activity_main;
    }

    @Override
    protected void initAttributes() {

    }

    @Override
    protected void initView() {
        findAllViewById();
        btnShow.setOnClickListener(this);
    }

    @Override
    protected void findAllViewById() {
        btnShow = $(R.id.btn_show);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show:
                //启动悬浮pet
                Intent intent = new Intent(MainActivity.this, FloatingPetService.class);
                startService(intent);
                Intent home = new Intent(Intent.ACTION_MAIN);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                home.addCategory(Intent.CATEGORY_HOME);
                startActivity(home);
                break;
        }
    }

    @Override
    protected void onDestroy() {
//        stopService();
        super.onDestroy();
    }
}
