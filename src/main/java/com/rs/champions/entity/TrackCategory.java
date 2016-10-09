package com.rs.champions.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trackcategory")
public class TrackCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trackcategory_id", nullable = false)
	private Long trackCategoryId;
	
	@Column(name = "trackcategory", nullable = false)
	private String trackCategory;

	public Long getTrackCategoryId() {
		return trackCategoryId;
	}

	public void setTrackCategoryId(Long trackCategoryId) {
		this.trackCategoryId = trackCategoryId;
	}

	public String getTrackCategory() {
		return trackCategory;
	}

	public void setTrackCategory(String trackCategory) {
		this.trackCategory = trackCategory;
	}
}
