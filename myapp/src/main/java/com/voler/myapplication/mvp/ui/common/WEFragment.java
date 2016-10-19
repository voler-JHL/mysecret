package com.voler.myapplication.mvp.ui.common;

import com.jess.arms.base.BaseFragment;
import com.jess.arms.mvp.BasePresenter;
import com.voler.myapplication.app.WEApplication;
import com.voler.myapplication.di.component.AppComponent;


/**
 * Created by jess on 8/5/16 14:11
 * contact with jess.yan.effort@gmail.com
 */
public abstract class WEFragment<P extends BasePresenter> extends BaseFragment<P> {
    protected WEApplication mWeApplication;
    @Override
    protected void ComponentInject() {
        mWeApplication = (WEApplication)mActivity.getApplication();
        setupFragmentComponent(mWeApplication.getAppComponent());
    }

    //提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
    protected abstract void setupFragmentComponent(AppComponent appComponent);
}
