package com.rs.champions.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rs.champions.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
/*
	public List<User> findByEventTrack_EventTrackId(Long eventTrackId);
	public List<User> findByEvent_EventId(Long eventId);
*/
}
