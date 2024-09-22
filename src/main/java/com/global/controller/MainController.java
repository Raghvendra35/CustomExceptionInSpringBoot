package com.global.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.exception.ResourceNotFoundException;
import com.global.service.MainService;

@RestController
public class MainController {

	
	@Autowired
	MainService mainService;
	
	
	@PostMapping("/save")
	public String saveData(@RequestBody Map<String,Object> map)
	{
		return mainService.saveData(map);
	}
	
    @GetMapping("/resource/{id}")
    public String getResourceById(@PathVariable("id") String id) {
        if (id.equals("0")) {
            throw new ResourceNotFoundException("Resource not found for this  ID");
        }
        return "Resource found for ID: " + id;
    }
}
