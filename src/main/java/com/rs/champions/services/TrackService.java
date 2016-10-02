package com.rs.champions.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.champions.utils.TrackUtil;
import com.rs.champions.vo.TrackVO;

@Path("/track")
@Component("trackService")
@Produces(value=MediaType.APPLICATION_JSON)
public class TrackService {

	@Autowired
	TrackUtil trackUtil;
	
	@GET
	@Path("/all")
	public List<TrackVO> getAll(){
		return trackUtil.getAll();
	}
	
	@GET
	@Path("/get")
	public TrackVO getOne(@QueryParam(value="trackId") Long trackId){
		return trackUtil.getTrackVO(trackId);
	}
	
}
