package com.rs.champions.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class ChampionshipEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id", nullable = false)
	private Long eventId;
	
	@Column(name = "event", nullable = false)
	private String event;

	@Column(name = "eventstatus_id", nullable = false)
	private Long eventStatusId;
	
	public Long getEventStatus() {
		return eventStatusId;
	}

	public void setEventStatus(Long eventStatusId) {
		this.eventStatusId = eventStatusId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	
}
