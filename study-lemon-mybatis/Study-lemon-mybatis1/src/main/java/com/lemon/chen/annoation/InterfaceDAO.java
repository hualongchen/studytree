package com.lemon.chen.annoation;

import org.apache.ibatis.annotations.Select;

public interface InterfaceDAO {
	
	
	
	@Select("select * from datasource_interface_info where id= #{id}")
	public InterfaceInfo  getInfoById(int id);
	
	

}
