package com.rs.champions.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.champions.utils.CityUtil;
import com.rs.champions.vo.CityVO;

@Path("/city")
@Component("cityService")
@Produces(value=MediaType.APPLICATION_JSON)
public class CityService {
	
	@Autowired
	private CityUtil cityUtil;
	
	@GET
	@Path("/all")
	public List<CityVO> getAll(){
		return cityUtil.getAll();
	}
	
}
