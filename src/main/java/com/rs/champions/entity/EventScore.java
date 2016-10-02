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
@Table(name = "eventscore")
public class EventScore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventscore_id", nullable = false)
	private Long eventScoreId;
	
	@Column(name = "eventscore", nullable = false)
	private String eventScore;
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private ChampionshipEvent championshipEvent;

	@ManyToOne
	@JoinColumn(name="eventtrack_id")
	private EventTrack eventTrack;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public EventTrack getEventTrack() {
		return eventTrack;
	}

	public void setEventTrack(EventTrack eventTrack) {
		this.eventTrack = eventTrack;
	}

	public ChampionshipEvent getChampionshipEvent() {
		return championshipEvent;
	}

	public void setChampionshipEvent(ChampionshipEvent championshipEvent) {
		this.championshipEvent = championshipEvent;
	}

	public Long getEventScoreId() {
		return eventScoreId;
	}

	public void setEventScoreId(Long eventScoreId) {
		this.eventScoreId = eventScoreId;
	}

	public String getEventScore() {
		return eventScore;
	}

	public void setEventScore(String eventScore) {
		this.eventScore = eventScore;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
