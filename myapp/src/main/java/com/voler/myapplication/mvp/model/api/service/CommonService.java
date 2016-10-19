package com.voler.myapplication.mvp.model.api.service;

import com.voler.myapplication.mvp.model.entity.Login;

import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jess on 8/5/16 12:05
 * contact with jess.yan.effort@gmail.com
 */
public interface CommonService {

    String HEADER_API_VERSION = "Accept: application/vnd.github.v3+json";


    @POST("login")
    Observable<Login> getLogin(@Path("login") String loginUrl, @Query("phoneNum") String phoneNum, @Query("code") String code, @Query("regType") String regType);



//    @GET("/api/v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
//    Observable<HomePicEntity> getDailyList();
//
//    @GET("/api/v2/categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
//    Observable<FindMoreEntity> getFindMore();
//
//    @GET("/api/v3/ranklist?num=10&strategy=%s&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
//    Observable<HotStrategyEntity> getHotStrategy();
//
//    @GET("/api/v3/videos?categoryName=%s&strategy=%s&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
//    Observable<FindDetailEntity> getFindDetail();
}
