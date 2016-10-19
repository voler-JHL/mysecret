package me.jessyan.mvparms.demo.mvp.contract;

import com.jess.arms.mvp.BaseView;

import me.jessyan.mvparms.demo.mvp.model.entity.Login;
import rx.Observable;

/**
 * Created by jess on 9/4/16 10:47
 * Contact with jess.yan.effort@gmail.com
 */
public interface LoginContract {
    interface View extends BaseView {

    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model {
        Observable<Login> getLogin(String loginUrl, String phoneNum, String code, String regType);
    }
}
