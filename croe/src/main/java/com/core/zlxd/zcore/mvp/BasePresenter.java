package com.core.zlxd.zcore.mvp;

public abstract class BasePresenter<V extends BaseView> {

    private V mvpView;

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    public void detachView() {
        mvpView = null;
    }

    public V getMvpView() {
        return mvpView;
    }
}
