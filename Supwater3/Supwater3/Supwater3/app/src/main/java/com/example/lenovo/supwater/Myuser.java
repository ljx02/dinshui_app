package com.example.lenovo.supwater;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

/**
 * Created by lenovo on 2016/9/10.
 */
public class Myuser extends BmobUser {
    private String dizhi;
    private String sushe;
    private Boolean goushui;

    public Boolean getGoushui() {
        return goushui;
    }

    public void setGoushui(Boolean goushui) {
        this.goushui = goushui;
    }

    public void setSushe(String sushe) {
        this.sushe = sushe;
    }

    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    public void setDianhua(Integer dianhua) {
        this.dianhua = dianhua;
    }

    private String xuehao;
    private Integer dianhua;

    public String getDizhi() {
        return dizhi;
    }
    public String getSushe() {
        return sushe;
    }
    public String getXuehao() {
        return xuehao;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    public Integer getShuipiao() {
        return shuipiao;
    }
    public Integer getDianhua() {
        return dianhua;
    }

    public void setShuipiao(Integer shuipiao) {
        this.shuipiao = shuipiao;
    }

    private Integer shuipiao;
}

