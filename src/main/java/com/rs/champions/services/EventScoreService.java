package com.rs.champions.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.champions.utils.EventScoreUtil;
import com.rs.champions.vo.EventScoreVO;

@Path("/score")
@Component("eventScoreService")
@Produces(value=MediaType.APPLICATION_JSON)
public class EventScoreService {
	
	@Autowired
	private EventScoreUtil eventScoreUtil;
	
	@GET
	@Path("/all")
	public List<EventScoreVO> getAll(@QueryParam("eventId") Long eventId, @QueryParam("eventTrackId") Long eventTrackId){
		if (eventId == null && eventTrackId == null)
			return eventScoreUtil.getAll();
		if (eventTrackId == null)
			return eventScoreUtil.getAllByEventId(eventId);
		return eventScoreUtil.getAllByEventTrackId(eventTrackId);
	}
	
	@GET
	@Path("/get")
	public EventScoreVO getOne(Long eventId){
		return eventScoreUtil.getEventScoreVO(eventId);
	}
}
