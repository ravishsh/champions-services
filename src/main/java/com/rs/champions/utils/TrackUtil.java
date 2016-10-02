package com.rs.champions.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.champions.entity.Track;
import com.rs.champions.repository.TrackRepository;
import com.rs.champions.vo.TrackVO;

@Component("trackUtil")
public class TrackUtil {

	@Autowired
	TrackRepository trackRepository;
	
	public List<TrackVO> getAll(){
		List<TrackVO> trackVO = new ArrayList<TrackVO>();
		Iterable<Track> tracks = trackRepository.findAll();
		Iterator<Track> iterator = tracks.iterator();		
		while (iterator.hasNext()){
			trackVO.add(this.getTrackVO(iterator.next()));
		}
		return trackVO;
	}
	
	public Track getOne(Long trackId){
		return trackRepository.findOne(trackId);
	}
	
	public TrackVO getTrackVO(Track track){
		TrackVO trackVO = new TrackVO();
		trackVO.setTrackId(track.getTrackId());
		trackVO.setTrack(track.getTrack());
		return trackVO;
	}
	
	public TrackVO getTrackVO(Long trackId){
		TrackVO trackVO = new TrackVO();
		return this.getTrackVO(trackRepository.findOne(trackId));
	}
	
	
}
	
	
	
