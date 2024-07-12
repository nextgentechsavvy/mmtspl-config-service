package com.mmtspl.configservice.service;

import org.springframework.stereotype.Service;

import java.net.Inet4Address;

@Service("MMTSPLConfigService")
public class MMTSPLConfigService {

    private String strIPv4Address = "";

    //Returned the current server IPv4 Address
    public String getIPv4Address(){
        try{
            strIPv4Address = Inet4Address.getLocalHost().getHostAddress();
            System.out.println(strIPv4Address);
        }catch(Exception e){
            e.printStackTrace();
        }
        return strIPv4Address;
    }

}
