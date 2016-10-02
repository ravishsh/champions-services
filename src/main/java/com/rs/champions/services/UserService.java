package com.rs.champions.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.rs.champions.utils.UserUtil;
import com.rs.champions.vo.UserVO;

@Path("/user")
@Component("userService")
@Produces(value=MediaType.APPLICATION_JSON)
public class UserService {
	
	@Autowired
	private UserUtil userUtil;
	
	@GET
	@Path("/get")
	public UserVO getOne(@QueryParam(value="userId") Long userId){
		return userUtil.getOne(userId);
	}
	
	@GET
	@Path("/all")
	public List<UserVO> getAll(){
		return userUtil.getAll();
	}
	
	
}
