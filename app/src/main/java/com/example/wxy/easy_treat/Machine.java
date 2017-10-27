package com.example.wxy.easy_treat;

/**
 * Created by wxy on 2017/10/26.
 */

public class Machine {
    private String machineName;
    private String machineTime;
    private String machineText;
    int machineImage;
    Machine (String machineName ,String machineTime ,String machineText,int machineImage  ){
        this.machineName =machineName ;
        this.machineTime =machineTime ;
        this.machineText =machineText ;
        this.machineImage =machineImage ;
    }
    public String getMachineName (){
        return machineName ;
    }
    public String getMachineText (){
        return machineText ;
    }
    public String getMachineTime (){
        return machineTime ;
    }
    public int getMachineImage (){
        return machineImage ;
    }
}
