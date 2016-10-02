package com.rs.champions.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.champions.entity.Address;
import com.rs.champions.vo.AddressVO;

@Component("addressUtil")
public class AddressUtil {	

	@Autowired
	CityUtil cityUtil;
	
	public AddressVO getAddressVO(Address address){
		AddressVO addressVO = new AddressVO();
		addressVO.setAddressId(address.getAddressId());
		addressVO.setAddressLine1(address.getAddressLine1());
		addressVO.setAddressLine2(address.getAddressLine2());
		addressVO.setCity(cityUtil.getCityVO(address.getCityId()).getCity());
		return addressVO;
	}
}
