package com.lemon.chen.model2;

import java.util.Date;

public class InterfaceInfoPO {
	
	
	
	private Integer id;

	private Integer interfaceId;

	private String interfaceName;

	private Integer expireDay;

	private Date createTime;

	private Date updateTime;

	private String field1;

	private String field2;

	private String field3;

	@Override
	public String toString() {
		return "InterfaceInfoPO [id=" + id + ", interfaceId=" + interfaceId + ", interfaceName=" + interfaceName
				+ ", expireDay=" + expireDay + ", createTime=" + createTime + ", updateTime=" + updateTime + ", field1="
				+ field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(Integer interfaceId) {
		this.interfaceId = interfaceId;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName == null ? null : interfaceName.trim();
	}

	public Integer getExpireDay() {
		return expireDay;
	}

	public void setExpireDay(Integer expireDay) {
		this.expireDay = expireDay;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1 == null ? null : field1.trim();
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2 == null ? null : field2.trim();
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3 == null ? null : field3.trim();
	}
}