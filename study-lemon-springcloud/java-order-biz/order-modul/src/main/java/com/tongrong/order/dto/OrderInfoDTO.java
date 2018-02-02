package com.tongrong.order.dto;

import com.tongrong.order.po.OrderInfoPO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author :chenhualong
 * @Date : created in 11:04 2018/1/12
 * @Description :
 */

@Data
public class OrderInfoDTO implements Serializable {


    /**
     * 当前页具体数据
     */
   private  List<OrderInfoPO>  list ;

    /**
     * 总条数
     */
   private int count ;

    /**
     * 当前页
     */
   private  int  page;

    /**
     * 下一页
     */
   private int nextPage;



}
