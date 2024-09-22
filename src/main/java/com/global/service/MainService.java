package com.global.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.repository.MainRepository;

@Service
public class MainService 
{
    
	@Autowired
	MainRepository mainrepo;
	
	public String saveData(Map<String,Object> map)
	{
		String name=(String) map.get("name");
		 //  name=null;
		   //name.length();
		return mainrepo.saveData(map);
	}
}
