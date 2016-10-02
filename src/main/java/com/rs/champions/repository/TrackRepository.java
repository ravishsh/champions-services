package com.rs.champions.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rs.champions.entity.Track;

@Repository
public interface TrackRepository extends CrudRepository<Track, Long>{


}
