package com.tongrong.order.util;


import lombok.Data;

@Data
public class PropertiesConfigBean {


    /**
     * 机构代码，前海征信分配
     */
    private String orgCode;

    /**
     * 渠道ID，前海征信分配
     */
    private String chnlId;

    /**
     * 授权码，机构授权码，前海征信分配
     */
    private String authCode;

    /**
     * 用户名，前海征信提供
     */
    private String userName;

    /**
     * 密码， 前海征信提供
     */
    private String userPassWord;

    /**
     * 校验钥匙
     */
    private String keyStr;

    /**
     * 存放证书的地址
     */
    private String keyAddr;

    /**
     * 银行卡鉴权URL
     */
    private String bankcardurl;

    /**
     * 常贷客数据URL
     */
    private String loaneeurl;

    /**
     * 风险度提示数据查询
     */
    private String rskdooqueryurl;

    /**
     * 好信一鉴通
     */
    private String onecheckurl;

    /**
     * 地址通数据接口
     */
    private String addressurl;
    
    /**
     * 好信度查询接口
     */
    private String credoourl ;

    /**
     * 秘钥密码
     */
    private String  storePassword ;


}
