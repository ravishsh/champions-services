package com.rs.champions.vo;

public class ChampionshipEventVO {
	private long eventId;	
	private String event;
	private long eventStatusId;

	public long getEventStatusId() {
		return eventStatusId;
	}

	public void setEventStatusId(long eventStatusId) {
		this.eventStatusId = eventStatusId;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
}
