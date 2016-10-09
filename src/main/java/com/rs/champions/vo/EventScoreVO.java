package com.rs.champions.vo;

public class EventScoreVO {

	private long eventScoreId;
	
	private String eventScore;

	private UserVO userVO;
	
	private Long rank;
	
	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public long getEventScoreId() {
		return eventScoreId;
	}

	public void setEventScoreId(long eventScoreId) {
		this.eventScoreId = eventScoreId;
	}

	public String getEventScore() {
		return eventScore;
	}

	public void setEventScore(String eventScore) {
		this.eventScore = eventScore;
	}

	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}
	
}
