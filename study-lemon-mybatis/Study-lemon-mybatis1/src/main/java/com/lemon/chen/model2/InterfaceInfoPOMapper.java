package com.lemon.chen.model2;

import org.apache.ibatis.annotations.Select;

public interface InterfaceInfoPOMapper {

	/**
	 * 测试一下注解形式
	 * 
	 * @param name
	 * @return
	 */
	@Select("select interface_name from datasource_interface_info where id= #{id}")
	public InterfaceInfoPO selectUserByID( int id);
	
	
	
}