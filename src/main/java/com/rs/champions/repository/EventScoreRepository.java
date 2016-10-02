package com.rs.champions.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rs.champions.entity.EventScore;

@Repository
public interface EventScoreRepository extends CrudRepository<EventScore, Long>{

	public List<EventScore> findByChampionshipEvent_EventId(Long eventId);
	
	public List<EventScore> findByEventTrack_EventTrackId(Long eventTrackId);

}
