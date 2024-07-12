package com.mmtspl.configservice.controller;

import com.mmtspl.configservice.service.MMTSPLConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/restapiconfigservices")
public class MMTSPLConfigServiceController {

    @Autowired
    private MMTSPLConfigService configService;

    @GetMapping("/getIPv4Address")
    public String getIPv4Address(){
        return configService.getIPv4Address();
    }
}
