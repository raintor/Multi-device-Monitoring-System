package com.nuaa.back_ma.domain;

import java.io.Serializable;

/**
 * @author: raintor
 * @Date: 2019/5/28 15:24
 * @Description:
 */
public class Traveller implements Serializable {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;

    private Integer credentialsType;
    private String credentialsTypeStr;

    private String credentialsNum;

    private Integer travellerType;
    private String travellerTypeStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
//        证件类型 0身份证 1护照 2军官证
        switch (credentialsType){
            case 0:
                credentialsTypeStr="身份证";
                break;
            case 1:
                credentialsTypeStr="护照";
                break;
            case 2:
                credentialsTypeStr="军官证";
                break;
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        //        旅客类型(人群) 0 成人 1 儿童
        switch (travellerType){
            case 0:
                travellerTypeStr="成人";
                break;
            case 1:
                travellerTypeStr="儿童";
                break;

        }
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}
