package com.rs.champions.vo;

public class EventTrackVO {
	
	private Long eventTrackId;
	
	private ChampionshipEventVO championshipEventVO;
	
	private TrackVO trackVO;

	public Long getEventTrackId() {
		return eventTrackId;
	}

	public void setEventTrackId(Long eventTrackId) {
		this.eventTrackId = eventTrackId;
	}

	public ChampionshipEventVO getChampionshipEventVO() {
		return championshipEventVO;
	}

	public void setChampionshipEventVO(ChampionshipEventVO championshipEventVO) {
		this.championshipEventVO = championshipEventVO;
	}

	public TrackVO getTrackVO() {
		return trackVO;
	}

	public void setTrackVO(TrackVO trackVO) {
		this.trackVO = trackVO;
	}

}
