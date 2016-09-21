package com.rs.champions.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rs.champions.entity.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{

}
