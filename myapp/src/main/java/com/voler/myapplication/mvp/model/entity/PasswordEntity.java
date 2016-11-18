package com.voler.myapplication.mvp.model.entity;

/**
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/11/18.
 */

public class PasswordEntity {

    public PasswordEntity(String pid, String name, String account, String pwd) {
        this.pid = pid;
        this.name = name;
        this.account = account;
        this.pwd = pwd;
    }

    /**
     * pid : 1
     * name : csdn
     * account : 130
     * pwd : 123
     */

    private String pid;
    private String name;
    private String account;
    private String pwd;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
