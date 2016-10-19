package me.jessyan.mvparms.demo.mvp.model.api;

/**
 * Created by jess on 8/5/16 11:25
 * contact with jess.yan.effort@gmail.com
 */
public interface Api {
    public static final String APP_DOMAIN = "https://api.github.com";

    public static final String HOST = "http://d.uservice.mamashenghuo.com";  //开发其他接口
    public static final String HOST_SEARCH = "http://d.search.mamashenghuo.com";  //开发搜索接口

//    public static final String HOST = "http://t.uservice.mamashenghuo.com";  //测试外网其他接口
//    public static final String HOST_SEARCH = "http://t.search.mamashenghuo.com";  //测试外网搜索接口
//    public static final String HOST = "http://uservice.mamashenghuo.com";  //生产环境
//    public static final String HOST_SEARCH = "http://search.mamashenghuo.com";  //生产环境、


    //18.	首页推荐-用户登录	(陈金)(已完成)
    public static final String LOGIN_ACTIVITY_USERLOGIN = HOST + "/api/mmshq/user/V64/userRegLogin";
}
