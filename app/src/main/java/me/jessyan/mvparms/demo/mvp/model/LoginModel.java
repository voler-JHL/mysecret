package me.jessyan.mvparms.demo.mvp.model;

import com.jess.arms.mvp.BaseModel;

import me.jessyan.mvparms.demo.mvp.contract.LoginContract;
import me.jessyan.mvparms.demo.mvp.model.api.cache.CacheManager;
import me.jessyan.mvparms.demo.mvp.model.api.cache.CommonCache;
import me.jessyan.mvparms.demo.mvp.model.api.service.CommonService;
import me.jessyan.mvparms.demo.mvp.model.api.service.ServiceManager;
import me.jessyan.mvparms.demo.mvp.model.entity.Login;
import rx.Observable;

/**
 * 妈妈生活圈
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/10/15.
 */

public class LoginModel extends BaseModel<ServiceManager,CacheManager> implements LoginContract.Model {

    private CommonService mCommonService;
    private CommonCache mCommonCache;

    public LoginModel(ServiceManager serviceManager, CacheManager cacheManager) {
        super(serviceManager, cacheManager);
        this.mCommonService = mServiceManager.getCommonService();
        this.mCommonCache = mCacheManager.getCommonCache();
    }

    @Override
    public Observable<Login> getLogin(String loginUrl, String phoneNum, String code, String regType) {
        Observable<Login> login = mCommonService
                .getLogin(loginUrl,phoneNum,code,regType);
        //使用rxcache缓存,上拉刷新则不读取缓存,加载更多读取缓存
        return login;
    }
}
