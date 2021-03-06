/*
 * ====================================================================
 * 龙果学院： www.roncoo.com （微信公众号：RonCoo_com）
 * 超级教程系列：《微服务架构的分布式事务解决方案》视频教程
 * 讲师：吴水成（水到渠成），840765167@qq.com
 * 课程地址：http://www.roncoo.com/course/view/7ae3d7eddc4742f78b0548aa8bd9ccdb
 * ====================================================================
 */
package com.lemon.notify.service.api.impl;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import com.lemon.core.page.PageBean;
import com.lemon.core.page.PageParam;
import com.lemon.notify.api.aip.RpNotifyService;
import com.lemon.notify.api.entity.RpNotifyRecord;
import com.lemon.notify.api.entity.RpNotifyRecordLog;
import com.lemon.notify.api.enums.NotifyStatusEnum;
import com.lemon.notify.api.enums.NotifyTypeEnum;
import com.lemon.notify.service.dao.RpNotifyRecordDao;
import com.lemon.notify.service.dao.RpNotifyRecordLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;


/**
 * @功能说明:
 * @创建者: Peter
 * @创建时间: 16/6/2  上午10:42
 * @公司名称:广州市领课网络科技有限公司 龙果学院(www.roncoo.com)
 * @版本:V1.0
 */
@Service("rpNotifyService")
public class RpNotifyServiceImpl implements RpNotifyService {

    @Autowired
    private JmsTemplate notifyJmsTemplate;

    @Autowired
    private RpNotifyRecordDao rpNotifyRecordDao;

    @Autowired
    private RpNotifyRecordLogDao rpNotifyRecordLogDao;
    
    /**
     * 创建消息通知
     *
     * @param rpNotifyRecord
     */
    @Override
    public long createNotifyRecord(RpNotifyRecord rpNotifyRecord) {
        return rpNotifyRecordDao.insert(rpNotifyRecord);
    }

    /**
     * 修改消息通知
     *
     * @param rpNotifyRecord
     */
    @Override
    public void updateNotifyRecord(RpNotifyRecord rpNotifyRecord) {
        rpNotifyRecordDao.update(rpNotifyRecord);
    }

    /**
     * 创建消息通知记录
     *
     * @param rpNotifyRecordLog
     * @return
     */
    @Override
    public long createNotifyRecordLog(RpNotifyRecordLog rpNotifyRecordLog) {
        return rpNotifyRecordLogDao.insert(rpNotifyRecordLog);
    }
    
    
    
    /**
     * 发送消息通知
     *
     * @param notifyUrl       通知地址
     * @param merchantOrderNo 商户订单号
     * @param merchantNo      商户编号
     */
    @Override
    public void notifySend(String notifyUrl, String merchantOrderNo, String merchantNo) {

        RpNotifyRecord record = new RpNotifyRecord();
        record.setNotifyTimes(0);
        record.setLimitNotifyTimes(5);
        record.setStatus(NotifyStatusEnum.CREATED.name());
        record.setUrl(notifyUrl);
        record.setMerchantOrderNo(merchantOrderNo);
        record.setMerchantNo(merchantNo);
        record.setNotifyType(NotifyTypeEnum.MERCHANT.name());

        Object toJSON = JSONObject.toJSON(record);
        final String str = toJSON.toString();

        notifyJmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(str);
            }
        });
    }

    /**
     * 通过ID获取通知记录
     *
     * @param id
     * @return
     */
    @Override
    public RpNotifyRecord getNotifyRecordById(String id) {
        return rpNotifyRecordDao.getById(id);
    }

    /**
     * 根据商户编号,商户订单号,通知类型获取通知记录
     *
     * @param merchantNo      商户编号
     * @param merchantOrderNo 商户订单号
     * @param notifyType      消息类型
     * @return
     */
    @Override
    public RpNotifyRecord getNotifyByMerchantNoAndMerchantOrderNoAndNotifyType(String merchantNo, String merchantOrderNo, String notifyType) {
        return rpNotifyRecordDao.getNotifyByMerchantNoAndMerchantOrderNoAndNotifyType(merchantNo,merchantOrderNo,notifyType);
    }

    @SuppressWarnings("unchecked")
	@Override
    public PageBean<RpNotifyRecord> queryNotifyRecordListPage(PageParam pageParam, Map<String, Object> paramMap) {
        return rpNotifyRecordDao.listPage(pageParam,paramMap);
    }




}
