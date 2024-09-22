package com.global.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.global.exception.GlobalMassage;

@Repository
public class MainRepository 
{


	@Autowired
	@Qualifier("writeJdbc")
	JdbcTemplate writeJdbc;
	
	
	public String saveData(Map<String,Object> map)
	{
		String q="insert into main (`name`,`password`) Values(?,?)";
		
		writeJdbc.update(q,map.get("name").toString(),map.get("password"));
		return GlobalMassage.success;
			
	}
}
