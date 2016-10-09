package com.rs.champions.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.champions.utils.TrackCategoryUtil;
import com.rs.champions.vo.TrackCategoryVO;

@Path("/trackCategory")
@Component("trackCategoryService")
@Produces(value=MediaType.APPLICATION_JSON)
public class TrackCategoryService {

	@Autowired
	private TrackCategoryUtil trackCategoryUtil;
	
	@GET
	@Path("/all")
	public List<TrackCategoryVO> getAll(){
		return trackCategoryUtil.getAll();
	}
	
	
	
}
