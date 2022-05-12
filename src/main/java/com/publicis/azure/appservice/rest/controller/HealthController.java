package com.publicis.azure.appservice.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microsoft.applicationinsights.TelemetryClient;

@RestController
// @RequestMapping(path = "/health")
public class HealthController {
	
	@Autowired
	TelemetryClient telemetryClient;
	  
    @GetMapping(path="/health", produces = "application/json")
    public String  getAppHealth() {
    	telemetryClient.trackEvent("URI /health is triggered");
        return "Running";
    }
    
    @GetMapping(path="/info", produces = "application/json")
    public String  getAppInfo() {
    	telemetryClient.trackEvent("URI /info is triggered");    	
        return "Springboot App Service";
    }    
}
