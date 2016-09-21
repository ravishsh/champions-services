package com.rs.champions.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rs.champions.entity.ChampionshipEvent;

public interface ChampionshipEventRepository extends CrudRepository<ChampionshipEvent, Long>{
	
}
