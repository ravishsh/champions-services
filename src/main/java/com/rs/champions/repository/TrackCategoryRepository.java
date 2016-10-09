package com.rs.champions.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rs.champions.entity.TrackCategory;

@Repository
public interface TrackCategoryRepository extends CrudRepository<TrackCategory, Long>{

}
