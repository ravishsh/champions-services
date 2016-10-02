package com.rs.champions.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.champions.entity.EventTrack;
import com.rs.champions.repository.EventTrackRepository;
import com.rs.champions.vo.EventTrackVO;

@Component("eventTrackUtil")
public class EventTrackUtil {

	@Autowired
	EventTrackRepository eventTrackRepository;
	
	@Autowired
	ChampionshipEventUtil championshipEventUtil;
	
	@Autowired
	TrackUtil trackUtil;
	
	public List<EventTrackVO> getAll(){
		List<EventTrackVO> eventTrackVO = new ArrayList<EventTrackVO>();
		Iterable<EventTrack> eventTracks = eventTrackRepository.findAll();
		Iterator<EventTrack> iterator = eventTracks.iterator();		
		while (iterator.hasNext()){
			eventTrackVO.add(this.getEventTrackVO(iterator.next()));
		}
		return eventTrackVO;
	}
	
	public List<EventTrackVO> getAllTrackByEventId(Long eventId){
		List<EventTrackVO> eventTrackVO = new ArrayList<EventTrackVO>();
		Iterable<EventTrack> eventTracks = eventTrackRepository.findByChampionshipEvent_EventId(eventId);
		Iterator<EventTrack> iterator = eventTracks.iterator();		
		while (iterator.hasNext()){
			eventTrackVO.add(this.getEventTrackVO(iterator.next()));
		}
		return eventTrackVO;
	}
	
	public EventTrackVO getEventTrackVO(EventTrack eventTrack){
		EventTrackVO eventTrackVO = new EventTrackVO();
		eventTrackVO.setEventTrackId(eventTrack.getEventTrackId());
		eventTrackVO.setChampionshipEventVO(championshipEventUtil.getChampionshipEventVO(eventTrack.getChampionshipEvent()));
		eventTrackVO.setTrackVO(trackUtil.getTrackVO(eventTrack.getTrack()));
		return eventTrackVO;
	}
}
