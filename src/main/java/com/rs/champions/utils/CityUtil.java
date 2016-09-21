package com.rs.champions.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.champions.entity.City;
import com.rs.champions.repository.CityRepository;
import com.rs.champions.vo.CityVO;

@Component("cityUtil")
public class CityUtil {
	
	@Autowired
	CityRepository cityRepository;
	
	public List<CityVO> getAll(){
		List<CityVO> cityVO = new ArrayList<CityVO>();
		Iterable <City> cities = cityRepository.findAll();
		Iterator<City> iterator = cities.iterator();
		while(iterator.hasNext()){
			cityVO.add(this.getCityVO(iterator.next()));
		}
		return cityVO;
	}
	
	public City getCity(Long cityId){
		return cityRepository.findOne(cityId);
	}
	
	public CityVO getCityVO(Long cityId){
		CityVO cityVO = new CityVO();
		cityVO.setCityId(cityId);
		cityVO.setCity(this.getCity(cityId).getCity());
		return cityVO;
	}
	
	public CityVO getCityVO(City city){
		CityVO cityVO = new CityVO();
		cityVO.setCityId(city.getCityId());
		cityVO.setCity(city.getCity());
		return cityVO;
	}
}
