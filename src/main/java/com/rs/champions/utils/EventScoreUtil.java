package com.rs.champions.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.champions.entity.EventScore;
import com.rs.champions.repository.EventScoreRepository;
import com.rs.champions.vo.EventScoreVO;

@Component("eventScoreUtil")
public class EventScoreUtil {
	
	@Autowired
	EventScoreRepository eventScoreRepository;
	
	@Autowired
	UserUtil userUtil;
	
	public List<EventScoreVO> getAll(){
		List<EventScoreVO> eventScoreVO = new ArrayList<EventScoreVO>();
		Iterable<EventScore> eventScores = eventScoreRepository.findAll();
		Iterator<EventScore> iterator = eventScores.iterator();
		while(iterator.hasNext()){
			eventScoreVO.add(this.getEventScoreVO(iterator.next()));
		}
		return eventScoreVO;
	}
	
	public List<EventScoreVO> getAllByEventId(Long eventId){
		List<EventScoreVO> eventScoreVO = new ArrayList<EventScoreVO>();
		Iterable<EventScore> eventScores = eventScoreRepository.findByChampionshipEvent_EventId(eventId);
		Iterator<EventScore> iterator = eventScores.iterator();
		while(iterator.hasNext()){
			eventScoreVO.add(this.getEventScoreVO(iterator.next()));
		}
		return eventScoreVO;
	}
	
	public List<EventScoreVO> getAllByEventTrackId(Long eventTrackId){
		List<EventScoreVO> eventScoreVO = new ArrayList<EventScoreVO>();
		Iterable<EventScore> eventScores = eventScoreRepository.findByEventTrack_EventTrackId(eventTrackId);
		Iterator<EventScore> iterator = eventScores.iterator();
		while(iterator.hasNext()){
			eventScoreVO.add(this.getEventScoreVO(iterator.next()));
		}
		return eventScoreVO;
	}
	
	public EventScore getEventScore(Long eventScoreId){
		return eventScoreRepository.findOne(eventScoreId);
	}
	
	public EventScoreVO getEventScoreVO(Long eventScoreId){
		return this.getEventScoreVO(this.getEventScore(eventScoreId));
	}
	
	public EventScoreVO getEventScoreVO(EventScore eventScore){
		EventScoreVO eventScoreVO = new EventScoreVO();
		eventScoreVO.setEventScoreId(eventScore.getEventScoreId());
		eventScoreVO.setEventScore(eventScore.getEventScore());
		eventScoreVO.setUserVO(userUtil.getUserVO(eventScore.getUser()));
		return eventScoreVO;
	}
}
