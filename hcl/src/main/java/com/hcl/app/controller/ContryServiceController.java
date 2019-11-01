package com.hcl.app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.app.service.CountryServices;

@RestController
@RequestMapping("/flags") 
public class ContryServiceController {
	
	static Logger log = Logger.getLogger(ContryServiceController.class.getName());
	
	@Autowired
	private CountryServices service;
	
	@GetMapping("/getflag")
    public ResponseEntity<?> getRattingsList(@RequestParam("continent") String continent,@RequestParam("country") String country) { 
		log.info("Entered into getRattingsList( "+ continent+","+country);
        return service.getFlagByCountry(continent,country);
    }
	
}
