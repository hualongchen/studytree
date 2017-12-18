package com.lemon.chen.model;

import com.lemon.chen.model.InterfaceInfoPO;
import com.lemon.chen.model.InterfaceInfoPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface InterfaceInfoPOMapper {
    long countByExample(InterfaceInfoPOExample example);

    int deleteByExample(InterfaceInfoPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InterfaceInfoPO record);

    int insertSelective(InterfaceInfoPO record);

    List<InterfaceInfoPO> selectByExample(InterfaceInfoPOExample example);

    InterfaceInfoPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InterfaceInfoPO record, @Param("example") InterfaceInfoPOExample example);

    int updateByExample(@Param("record") InterfaceInfoPO record, @Param("example") InterfaceInfoPOExample example);

    int updateByPrimaryKeySelective(InterfaceInfoPO record);

    int updateByPrimaryKey(InterfaceInfoPO record);
    
    /**
     * 测试一下注解形式
     * @param name
     * @return
     */
    @Select("select * from datasource_interface_info where interface_name= #{name}")
    public InterfaceInfoPO  selectByName(String name);
}