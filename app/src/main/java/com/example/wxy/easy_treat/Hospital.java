package com.example.wxy.easy_treat;

/**
 * Created by wxy on 2017/10/26.
 */

public class Hospital {
    String hospitalName;
    String hospitalAdress;
    int hospitalImageId;
    int id;
    Hospital (String  hospitalName,String hospitalAdress,int hospitalImageId,int id ){
        this.hospitalAdress =hospitalAdress ;
        this.hospitalName =hospitalName ;
        this.hospitalImageId =hospitalImageId ;
        this.id=id;

    }
    public String getHospitalAdress (){
        return hospitalAdress ;
    }
    public String getHospitalName (){
        return hospitalName ;
    }
    public int getHospitalImageId (){
        return hospitalImageId ;
    }
    public int getId (){
        return id;
    }
}
