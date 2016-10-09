package com.rs.champions.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.champions.entity.TrackCategory;
import com.rs.champions.repository.TrackCategoryRepository;
import com.rs.champions.vo.TrackCategoryVO;

@Component("trackCategoryUtil")
public class TrackCategoryUtil {

	@Autowired
	TrackCategoryRepository trackCategoryRepository;
	
	public List<TrackCategoryVO> getAll(){
		List<TrackCategoryVO> trackCategoryVO = new ArrayList<TrackCategoryVO>();
		Iterable<TrackCategory> trackCategories = trackCategoryRepository.findAll();
		Iterator<TrackCategory> iterator = trackCategories.iterator();
		while(iterator.hasNext()){
			trackCategoryVO.add(this.getTrackCategoryVO(iterator.next()));
		}
		return trackCategoryVO;
	}
	
	public TrackCategory getTrackCategory(Long trackCategoryId){
		return trackCategoryRepository.findOne(trackCategoryId);
	}
	
	public TrackCategoryVO getTrackCategoryVO(Long trackCategoryId){
		TrackCategoryVO trackCategoryVO = new TrackCategoryVO();
		trackCategoryVO.setTrackCategoryId(trackCategoryId);
		trackCategoryVO.setTrackCategory(this.getTrackCategory(trackCategoryId).getTrackCategory());
		return trackCategoryVO;
	}
	
	public TrackCategoryVO getTrackCategoryVO(TrackCategory trackCategory){
		TrackCategoryVO trackCategoryVO = new TrackCategoryVO();
		trackCategoryVO.setTrackCategoryId(trackCategory.getTrackCategoryId());
		trackCategoryVO.setTrackCategory(trackCategory.getTrackCategory());
		return trackCategoryVO;
	}
}
