package com.rs.champions.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.champions.utils.ChampionshipEventUtil;
import com.rs.champions.vo.ChampionshipEventVO;

@Path("/event")
@Component("eventService")
@Produces(value=MediaType.APPLICATION_JSON)
public class ChampionshipEventService {

	@Autowired
	private ChampionshipEventUtil championshipEventUtil;
	
	@GET
	@Path("/all")
	public List<ChampionshipEventVO> getAll(){
		return championshipEventUtil.getAll();
	}
	
	@GET
	@Path("/get")
	public ChampionshipEventVO getOne(int eventId){
		return championshipEventUtil.getChampionshipEventVO(eventId);
	}
}
