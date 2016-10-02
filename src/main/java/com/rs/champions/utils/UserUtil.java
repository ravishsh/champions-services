package com.rs.champions.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.champions.entity.User;
import com.rs.champions.repository.UserRepository;
import com.rs.champions.vo.UserVO;

@Component("userUtil")
public class UserUtil {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressUtil addressUtil;
	
	public UserVO getOne(Long userId){
		return this.getUserVO(userRepository.findOne(userId));
	}
	
	public UserVO getUserVO(User user){
		UserVO userVO = new UserVO();
		userVO.setFirstName(user.getFirstName());
		userVO.setLastName(user.getLastName());
		userVO.setPhonenumber(user.getPhoneNumber());
		userVO.setUserName(user.getUserName());
		userVO.setUserId(user.getUserId());
		userVO.setAddressVO(addressUtil.getAddressVO(user.getAddress()));
		return userVO;
	}
	
	public List<UserVO> getAll(){
		List<UserVO> userVOs = new ArrayList<UserVO>();
		Iterable<User> users = userRepository.findAll();
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()){
			userVOs.add(this.getUserVO(iterator.next()));
		}
		return userVOs;
	}
	/*
	public List<UserVO> getAllByEventTrackId(Long eventTrackId){
		List<UserVO> userVOs = new ArrayList<UserVO>();
		Iterable<User> users = userRepository.findByEventTrack_EventTrackId(eventTrackId);
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()){
			userVOs.add(this.getUserVO(iterator.next()));
		}
		return userVOs;
	}
	
	public List<UserVO> getAllByEventId(Long eventId){
		List<UserVO> userVOs = new ArrayList<UserVO>();
		Iterable<User> users = userRepository.findByEvent_EventId(eventId);
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()){
			userVOs.add(this.getUserVO(iterator.next()));
		}
		return userVOs;
	}
	*/
}
