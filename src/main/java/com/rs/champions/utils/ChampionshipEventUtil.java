package com.rs.champions.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.champions.entity.ChampionshipEvent;
import com.rs.champions.repository.ChampionshipEventRepository;
import com.rs.champions.vo.ChampionshipEventVO;

@Component("championshipEventUtil")
public class ChampionshipEventUtil {

	@Autowired
	ChampionshipEventRepository championshipEventRepository;
	
	public List<ChampionshipEventVO> getAll(){
		List<ChampionshipEventVO> championshipEventVO = new ArrayList<ChampionshipEventVO>();
		Iterable<ChampionshipEvent> championshipEvents = championshipEventRepository.findAll();
		Iterator<ChampionshipEvent> iterator = championshipEvents.iterator();
		while(iterator.hasNext())
		{
			championshipEventVO.add(this.getChampionshipEventVO(iterator.next()));
		}
		return championshipEventVO;
	}
	
	public ChampionshipEvent getChampionshipEvent(Long eventId){
		return championshipEventRepository.findOne(eventId);
	}
	
	public ChampionshipEventVO getChampionshipEventVO(ChampionshipEvent championshipEvent){
		ChampionshipEventVO championshipEventVO = new ChampionshipEventVO();
		championshipEventVO.setEventId((championshipEvent.getEventId()));
		championshipEventVO.setEvent(championshipEvent.getEvent());
		championshipEventVO.setEventStatusId(championshipEvent.getEventStatus());
		return championshipEventVO;
	}
	
	public ChampionshipEventVO getChampionshipEventVO(long eventId){
		return this.getChampionshipEventVO(this.getChampionshipEvent(eventId));
	}
	
	public ChampionshipEvent getChampionshipEvent(ChampionshipEventVO championshipEventVO){
		ChampionshipEvent championshipEvent = new ChampionshipEvent();
		championshipEvent.setEventId(championshipEventVO.getEventId());
		championshipEvent.setEvent(championshipEventVO.getEvent());
		championshipEvent.setEventStatus(championshipEventVO.getEventStatusId());
		return championshipEventRepository.save(championshipEvent);
	}
}
