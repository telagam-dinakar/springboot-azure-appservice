package com.publicis.azure.appservice.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microsoft.applicationinsights.TelemetryClient;

@RestController
public class HelloController {
	@Autowired
	TelemetryClient telemetryClient;
	  
    @GetMapping(path="/greetings", produces = "application/json")
    public String  getAppInfo() {
    	telemetryClient.trackEvent("URI /gretings is triggered");    	
        return "Welcome to the Springboot App Service Demo!!!";
    }
}