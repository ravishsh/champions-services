package com.rs.champions.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "eventtrack")
public class EventTrack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventtrack_id", nullable = false)
	private Long eventTrackId;
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private ChampionshipEvent championshipEvent;
	
	@ManyToOne
	@JoinColumn(name="track_id")
	private Track track;
	
	@ManyToOne
	@JoinColumn(name="trackcategory_id")
	private TrackCategory trackCategory;

	public Long getEventTrackId() {
		return eventTrackId;
	}

	public void setEventTrackId(Long eventTrackId) {
		this.eventTrackId = eventTrackId;
	}

	public ChampionshipEvent getChampionshipEvent() {
		return championshipEvent;
	}

	public void setChampionshipEvent(ChampionshipEvent championshipEvent) {
		this.championshipEvent = championshipEvent;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}
	
	public TrackCategory getTrackCategory() {
		return trackCategory;
	}

	public void setTrackCategory(TrackCategory trackCategory) {
		this.trackCategory = trackCategory;
	}
	
}
