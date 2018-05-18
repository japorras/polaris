package com.atsistemas.polaris.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VersionController {

	@Value("${polaris.app.version}")
    private String applicationVersion;

	@RequestMapping("/version")
	public String welcome(Map<String, Object> model) {
		model.put("applicationVersion", this.applicationVersion);
		return "welcome";
	}
	
}
