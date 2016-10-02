package com.rs.champions.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "track_lookup")
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "track_id", nullable = false)
	private Long trackId;
	
	@Column(name = "track", nullable = false)
	private String track;

	public Long getTrackId() {
		return trackId;
	}

	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}
}
