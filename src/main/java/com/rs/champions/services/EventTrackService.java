package com.rs.champions.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.champions.utils.EventTrackUtil;
import com.rs.champions.vo.EventTrackVO;

@Path("/eventTrack")
@Component("eventTrackService")
@Produces(value=MediaType.APPLICATION_JSON)
public class EventTrackService {
	
	@Autowired
	EventTrackUtil eventTrackUtil;
	
	@GET
	@Path("/all")
	public List<EventTrackVO> getAll(@QueryParam("eventId") Long eventId){
		if (eventId == null)
			return eventTrackUtil.getAll();
		return eventTrackUtil.getAllTrackByEventId(eventId);
	}
	
}
