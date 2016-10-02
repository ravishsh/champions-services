package com.rs.champions.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rs.champions.entity.EventTrack;

@Repository
public interface EventTrackRepository extends CrudRepository<EventTrack, Long>{

	public List<EventTrack> findByChampionshipEvent_EventId(Long eventId);
	public List<EventTrack> findByTrack_TrackId(Long trackId);

}
