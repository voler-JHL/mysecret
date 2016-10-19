package me.jessyan.mvparms.demo.mvp.presenter;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.mvp.BasePresenter;

import javax.inject.Inject;

import me.jessyan.mvparms.demo.mvp.contract.LoginContract;
import me.jessyan.mvparms.demo.mvp.model.entity.Login;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 妈妈生活圈
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/10/14.
 */

public class LoginPersenter extends BasePresenter<LoginContract.Model, LoginContract.View> {

    private RxErrorHandler mErrorHandler;
    private Login mUsers = new Login();
    private int lastUserId = 1;

    @Inject
    public LoginPersenter(LoginContract.Model model, LoginContract.View rootView, RxErrorHandler handler) {
        super(model, rootView);
        this.mErrorHandler = handler;
    }

    public void login(String loginUrl, String phoneNum, String code, String regType) {
        mModel.getLogin(loginUrl, phoneNum, code, regType)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {

                    }
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate(new Action0() {
                    @Override
                    public void call() {
                    }
                })
                .compose(((BaseActivity) mRootView).<Login>bindToLifecycle())//使用RXlifecycle,使subscription和activity一起销毁
                .subscribe(new ErrorHandleSubscriber<Login>(mErrorHandler) {
                    @Override
                    public void onNext(Login login) {

                    }
                });
    }
}
