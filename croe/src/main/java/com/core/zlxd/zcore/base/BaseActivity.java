package com.core.zlxd.zcore.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.core.zlxd.zcore.mvp.BasePresenter;
import com.core.zlxd.zcore.mvp.BaseView;

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends AppCompatActivity {

    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
    }

    private void initPresenter() {
        if (presenter == null) {
            presenter = createPresenter();
        }

        if (presenter == null) {
            throw new NullPointerException(this.toString() + "presenter 不能为空");
        }

        presenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    public P getPresenter() {
        return presenter;
    }

    protected abstract P createPresenter();
}
