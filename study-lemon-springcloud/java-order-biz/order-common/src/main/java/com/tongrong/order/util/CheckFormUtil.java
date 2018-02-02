package com.tongrong.order.util;

import com.tongrong.order.form.ApproveLogForm;
import com.tongrong.order.form.OrderFindForm;
import com.tongrong.order.form.OrderInfoForm;
import com.tongrong.order.util.exception.BusinessException;

/**
 * @author :chenhualong
 * @Date : created in 15:08 2018/1/16
 * @Description :
 */
public class CheckFormUtil {


    /**
     * 用户订单保存检验
     *
     * @param form
     */
    public static void checkSaveOrder(OrderInfoForm form) {


        /**
         * 用户的ID
         */
        if (form.getUserId() == 0) {

            throw new BusinessException(ErrorContent.SAVE_FILE_USERID_ERROR_CODE, ErrorContent.SAVE_FILE_USERID_ERROR_MESSAGE);
        }

        //申请贷款金额
        if (null == form.getAccount() || form.getAccount().trim().length() == 0) {

            throw new BusinessException(ErrorContent.ORDER_SAVE_ACCOUNT_ERROR_CODE,ErrorContent.ORDER_SAVE_ACCOUNT_ERROR_MESSAGE);
        }
        //申请贷款金额
        if (!CheckUtil.isDouble(form.getAccount())) {

            throw new BusinessException(ErrorContent.ORDER_SAVE_ACCOUNT_ERROR_CODE,ErrorContent.ORDER_SAVE_ACCOUNT_ERROR_MESSAGE);
        }

        //申请期限
        if (null == form.getTermNo() || form.getTermNo().trim().length() == 0) {

            throw new BusinessException(ErrorContent.ORDER_SAVE_TERMNO_ERROR_CODE,ErrorContent.ORDER_SAVE_TERMNO_ERROR_MESSAGE);
        }
        //申请期限
        if(!CheckUtil.isDouble(form.getTermNo())){

            throw new BusinessException(ErrorContent.ORDER_SAVE_TERMNO_ERROR_CODE,ErrorContent.ORDER_SAVE_TERMNO_ERROR_MESSAGE);
        }

        //贷款用途

        if (null == form.getPurpose() || form.getPurpose().trim().length() == 0) {

            throw new BusinessException(ErrorContent.ORDER_SAVE_PURPOSE_ERROR_CODE,ErrorContent.ORDER_SAVE_PURPOSE_ERROR_MESSAGE);
        }

        //贷款用途
        if (!form.getPurpose().equals("旅游") &&
                !form.getPurpose().equals("装修") &&
                !form.getPurpose().equals("经营") &&
                !form.getPurpose().equals("其他消费")) {

            throw new BusinessException(ErrorContent.ORDER_SAVE_PURPOSE_ERROR_CODE,ErrorContent.ORDER_SAVE_PURPOSE_ERROR_MESSAGE);
        }

        //来源
        if (null == form.getSource() || form.getSource().trim().length() == 0) {

            throw new BusinessException(ErrorContent.ORDER_SAVE_SOURCE_ERROR_CODE,ErrorContent.ORDER_SAVE_SOURCE_ERROR_MESSAGE);
        }

        //订单贷款金额
        if (null == form.getOrderAccount() || form.getOrderAccount().trim().length() == 0) {

            throw new BusinessException(ErrorContent.ORDER_SAVE_ORDERACCOUNT_ERROR_CODE,ErrorContent.ORDER_SAVE_ORDERACCOUNT_ERROR_MESSAGE);
        }

        //订单贷款金额
        if (!CheckUtil.isDouble(form.getOrderAccount())) {

            throw new BusinessException(ErrorContent.ORDER_SAVE_ORDERACCOUNT_ERROR_CODE,ErrorContent.ORDER_SAVE_ORDERACCOUNT_ERROR_MESSAGE);
        }

        //绑定的银行卡

        if (null == form.getBankCardNo() || form.getBankCardNo().trim().length() == 0) {

            throw new BusinessException(ErrorContent.SAVE_USER_BANKCARDNO_ERROR_CODE, ErrorContent.SAVE_USER_BANKCARDNO_ERROR_MESSAGE);
        }

        //19位暂时无法判断
        if (form.getBankCardNo().length() == 16 && !CheckUtil.matchLuhn(form.getBankCardNo())) {

            throw new BusinessException(ErrorContent.SAVE_USER_BANKCARDNO_ERROR_CODE, ErrorContent.SAVE_USER_BANKCARDNO_ERROR_MESSAGE);
        }

        //银行卡名称

        if (null != form.getBankCardName() && form.getBankCardName().trim().length() > 50) {

            throw new BusinessException(ErrorContent.SAVE_USER_BANKNAME_ERROR_CODE, ErrorContent.SAVE_USER_BANKNAME_ERROR_MESSAGE);
        }

        //订单大状态
        if(form.getOrderStatus() ==0){

            throw new BusinessException(ErrorContent.ORDER_SAVE_STATUS_ERROR_CODE,ErrorContent.ORDER_SAVE_STATUS_ERROR_MESSAGE);
        }

        //订单小状态
        if(form.getInsideOrderStatus() == 0){

            throw new BusinessException(ErrorContent.ORDER_SAVE_INSIDESTATUS_ERROR_CODE,ErrorContent.ORDER_SAVE_INSIDESTATUS_ERROR_MESSAGE);
        }

        //姓名必填
        if (null == form.getName() || form.getName().trim().length() == 0) {

            throw new BusinessException(ErrorContent.SAVE_USER_NULL_ERROR_CODE, ErrorContent.SAVE_USER_NULL_ERROR_MESSAGE);
        }

        if (form.getName().trim().length() > 100) {

            throw new BusinessException(ErrorContent.SAVE_USER_NULL_ERROR_CODE, ErrorContent.SAVE_USER_NULL_ERROR_MESSAGE);
        }



        //身份证
        if (null == form.getIdNo() || form.getIdNo().trim().length() != 18) {

            throw new BusinessException(ErrorContent.SAVE_USER_IDCARD_NULL_ERROR_CODE, ErrorContent.SAVE_USER_IDCARD_NULL_ERROR_MESSAGE);
        }

        //身份证校验
        if (!IdCardCheckUtil.isValidatedAllIdcard(form.getIdNo())) {

            throw new BusinessException(ErrorContent.SAVE_USER_IDCARD_LENGTH_ERROR_CODE, ErrorContent.SAVE_USER_IDCARD_LENGTH_ERROR_MESSAGE);
        }

        //注册手机号
        if (null == form.getMobileNo() || form.getMobileNo().trim().length() == 0) {

            throw new BusinessException(ErrorContent.SAVE_USER_MOBILENO_ERROR_CODE, ErrorContent.SAVE_USER_MOBILENO_ERROR_MESSAGE);
        }
        //注册手机

        if (!IphoneUtil.isPhone(form.getMobileNo())) {

            throw new BusinessException(ErrorContent.SAVE_USER_MOBILENO_ERROR_CODE, ErrorContent.SAVE_USER_MOBILENO_ERROR_MESSAGE);
        }

        //婚姻状况
        if (null == form.getMarry() || form.getMarry().trim().length() == 0) {

            throw new BusinessException(ErrorContent.SAVE_USER_MARRY_ERROR_CODE, ErrorContent.SAVE_USER_MARRY_ERROR_MESSAGE);
        }
        //婚姻状况具体值验证
        if (!form.getMarry().equals("未婚") && !form.getMarry().equals("已婚") &&
                !form.getMarry().equals("离异") && !form.getMarry().equals("丧偶")) {

            throw new BusinessException(ErrorContent.SAVE_USER_MARRY_ERROR_CODE, ErrorContent.SAVE_USER_MARRY_ERROR_MESSAGE);
        }

        //城市
        if (null != form.getCity() && form.getCity().trim().length() > 50) {

            throw new BusinessException(ErrorContent.SAVE_USER_CITY_ERROR_CODE, ErrorContent.SAVE_USER_CITY_ERROR_MESSAGE);
        }
        //详细地址

        if (null != form.getRegion() && form.getRegion().trim().length() > 100) {

            throw new BusinessException(ErrorContent.SAVE_USER_REGION_ERROR_CODE, ErrorContent.SAVE_USER_REGION_ERROR_MESSAGE);
        }

        //住房情况
        if (null != form.getHouseType() && form.getHouseType().trim().length() > 0) {

            if (!form.getHouseType().equals("自购无按揭") &&
                    !form.getHouseType().equals("自购按揭") &&
                    !form.getHouseType().equals("自建房屋") &&
                    !form.getHouseType().equals("与父母同住") &&
                    !form.getHouseType().equals("租房")) {

                throw new BusinessException(ErrorContent.SAVE_USER_HOUSETYPE_ERROR_CODE, ErrorContent.SAVE_USER_HOUSETYPE_ERROR_MESSAGE);
            }
        }

        //单位类型

        if (null != form.getCompanyType() && form.getCompanyType().trim().length() > 0) {

            if (!form.getCompanyType().equals("国有企业") &&
                    !form.getCompanyType().equals("外资企业") &&
                    !form.getCompanyType().equals("合资企业") &&
                    !form.getCompanyType().equals("民营企业") &&
                    !form.getCompanyType().equals("私营 企业") &&
                    !form.getCompanyType().equals("个体户") &&
                    !form.getCompanyType().equals("自由职业者") &&
                    !form.getCompanyType().equals("其他")) {

                throw new BusinessException(ErrorContent.SAVE_USER_COMPANYTYPE_ERROR_CODE, ErrorContent.SAVE_USER_COMPANYTYPE_ERROR_MESSAGE);
            }
        }

        //职业类型

        if (null != form.getWorkType() && form.getWorkType().trim().length() > 0) {

            if (!form.getWorkType().equals("高管") &&
                    !form.getWorkType().equals("技术人员") &&
                    !form.getWorkType().equals("营销业务人员") &&
                    !form.getWorkType().equals("无业") &&
                    !form.getWorkType().equals("其他")) {

                throw new BusinessException(ErrorContent.SAVE_USER_WORKTYPE_ERROR_CODE, ErrorContent.SAVE_USER_WORKTYPE_ERROR_MESSAGE);
            }
        }

        //社保信息
        if (null != form.getHasSocialSecurity() && form.getHasSocialSecurity().trim().length() > 5) {

            throw new BusinessException(ErrorContent.SAVE_USER_HASSOCIAL_ERROR_CODE, ErrorContent.SAVE_USER_HASSOCIAL_ERROR_MESSAGE);
        }

        //开户年月
        if (null != form.getSocialSecurityOpenYear() && form.getSocialSecurityOpenYear().trim().length() > 18) {

            throw new BusinessException(ErrorContent.SAVE_USER_SOCIALOPENYEAR_CODE, ErrorContent.SAVE_USER_SOCIALOPENYEAR_MESSAGE);
        }

        //社保状态
        if (null != form.getSocialSecurityNowStatus() && form.getSocialSecurityNowStatus().trim().length() > 20) {

            throw new BusinessException(ErrorContent.SAVA_USER_SOCIALSTATUS_CODE, ErrorContent.SAVA_USER_SOCIALSTATUS_MESSAGE);
        }
        //社保月缴存金额
        if (null != form.getSocialSecurityMonthMoney()) {

            if (!CheckUtil.isDouble(form.getAccumulationFundMonthMoney())) {

                throw new BusinessException(ErrorContent.SAVE_USER_SOCIALMONEY_CODE, ErrorContent.SAVE_USER_SOCIALMONEY_MESSAGE);
            }
        }
        //缴存单位
        if (null != form.getSocialSecurityDepositUnits() && form.getSocialSecurityDepositUnits().trim().length() > 200) {

            throw new BusinessException(ErrorContent.SAVE_USER_SOCIALUNIT_ERROR_CODE, ErrorContent.SAVE_USER_SOCIALUNIT_ERROR_MESSAGE);
        }
        //是否有公积金
        if (null != form.getHasAccumulationFund() && form.getHasAccumulationFund().trim().length() > 10) {

            throw new BusinessException(ErrorContent.SAVE_USER_ACCUMULATION_ERROR_CODE, ErrorContent.SAVE_USER_ACCUMULATION_ERROR_MESSAGE);
        }
        //公积金缴存金额
        if (null != form.getAccumulationFundMonthMoney()) {

            if (!CheckUtil.isDouble(form.getAccumulationFundMonthMoney())) {

                throw new BusinessException(ErrorContent.SAVE_USER_ACCUMULATION_MONEY_ERROR_CODE, ErrorContent.SAVE_USER_ACCUMULATION_MONEY_ERROR_MESSAGE);
            }
        }
        //公积金缴存的单位
        if (null != form.getAccumulationFundDepositUnits() && form.getAccumulationFundDepositUnits().trim().length() > 200) {

            throw new BusinessException(ErrorContent.SAVE_USER_ACCUMULATION_UNIT_ERROR_CODE, ErrorContent.SAVE_USER_ACCUMULATION_UNIT_ERROR_MESSAGE);
        }

        //是否有房产
        if (null != form.getHasHouse() && form.getHasHouse().trim().length() > 10) {

            throw new BusinessException(ErrorContent.SAVE_USER_HASHOUSE_ERROR_CODE, ErrorContent.SAVE_USER_HASHOUSE_ERROR_MESSAGE);
        }

        //住房地址
        if (null != form.getHouseAddress() && form.getHouseAddress().trim().length() > 200) {

            throw new BusinessException(ErrorContent.SAVE_USER_HOUSEADDRESS_ERROR_CODE, ErrorContent.SAVE_USER_HOUSEADDRESS_ERROR_MESSAGE);
        }
        //住房面积
        if (null != form.getHouseArea() && form.getHouseArea().trim().length() > 10) {

            throw new BusinessException(ErrorContent.SAVE_USER_HOUSEAREA_ERROR_CODE, ErrorContent.SAVE_USER_HOUSEAREA_ERROR_MESSAGE);
        }
        if (null != form.getHouseArea() && CheckUtil.isDouble(form.getHouseArea())) {

            throw new BusinessException(ErrorContent.SAVE_USER_HOUSEAREA_ERROR_CODE, ErrorContent.SAVE_USER_HOUSEAREA_ERROR_MESSAGE);
        }
        //住房估值
        if (null != form.getHouseValue() && form.getHouseValue().trim().length() > 15) {

            throw new BusinessException(ErrorContent.SAVE_USER_HOUSEVALUE_ERROR_CODE, ErrorContent.SAVE_USER_HOUSEVALUE_ERROR_MESSAGE);
        }

        if (null != form.getHouseValue() && CheckUtil.isDouble(form.getHouseValue())) {

            throw new BusinessException(ErrorContent.SAVE_USER_HOUSEVALUE_ERROR_CODE, ErrorContent.SAVE_USER_HOUSEVALUE_ERROR_MESSAGE);

        }

        //消费合同
        if (null != form.getContract() && form.getContract().trim().length() > 15) {

            throw new BusinessException(ErrorContent.SAVE_FILE_CONTRACT_ERROR_CODE, ErrorContent.SAVE_FILE_CONTRACT_ERROR_MESSAGE);
        }

        if (null != form.getContract() && CheckUtil.isDouble(form.getContract())) {

            throw new BusinessException(ErrorContent.SAVE_FILE_CONTRACT_ERROR_CODE, ErrorContent.SAVE_FILE_CONTRACT_ERROR_MESSAGE);
        }

        //第一联系人信息
        if (null == form.getFriendName1() || form.getFriendName1().trim().length() == 0) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND_NAME_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND_NAME_ERROR_MESSAGE);
        }

        if (null != form.getFriendName1() && form.getFriendName1().trim().length() > 50) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND_NAME_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND_NAME_ERROR_MESSAGE);
        }

        //第一联系人手机号
        if (null == form.getFriendMobileNo1() || form.getFriendMobileNo1().trim().length() != 11) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND_MOBILE_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND_MOBILE_ERROR_MESSAGE);
        }

        //第一联系人手机校验
        if (!IphoneUtil.isPhone(form.getFriendMobileNo1())) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND_MOBILE_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND_MOBILE_ERROR_MESSAGE);

        }

        //第一联系人关系校验
        if (null == form.getFriendShip1() || form.getFriendShip1().trim().length() == 0) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND_SHIP_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND_SHIP_ERROR_MESSAGE);
        }
        if (!form.getFriendShip1().equals("配偶") && !form.getFriendShip1().equals("亲属") &&
                !form.getFriendShip1().equals("朋友") && !form.getFriendShip1().equals("同事") &&
                !form.getFriendShip1().equals("同学") && !form.getFriendShip1().equals("邻居") &&
                !form.getFriendShip1().equals("其他")) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND_SHIP_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND_SHIP_ERROR_MESSAGE);
        }


        //第二个联系人名字校验
        if (null == form.getFriendName2() || form.getFriendName2().trim().length() == 0) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND2_NAME_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND2_NAME_ERROR_MESSAGE);
        }
        //第二个联系人校验
        if (null != form.getFriendName2() && form.getFriendName2().trim().length() > 100) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND2_NAME_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND2_NAME_ERROR_MESSAGE);
        }

        //第二联系人手机校验
        if (null == form.getFriendMobileNo2() || form.getFriendMobileNo2().trim().length() != 11) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND2_MOBILE_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND2_MOBILE_ERROR_MESSAGE);
        }

        if (!IphoneUtil.isPhone(form.getFriendMobileNo2())) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND2_MOBILE_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND2_MOBILE_ERROR_MESSAGE);

        }

        //第二联系人关系校验

        if (null == form.getFriendShip2() || form.getFriendShip2().trim().length() == 0) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND2_SHIP_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND2_SHIP_ERROR_MESSAGE);
        }
        if (!form.getFriendShip2().equals("配偶") && !form.getFriendShip2().equals("亲属") &&
                !form.getFriendShip2().equals("朋友") && !form.getFriendShip2().equals("同事") &&
                !form.getFriendShip2().equals("同学") && !form.getFriendShip2().equals("邻居") &&
                !form.getFriendShip2().equals("其他")) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND2_SHIP_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND2_SHIP_ERROR_MESSAGE);
        }

        //银行卡名称
        if (null == form.getBankCardName() || form.getBankCardName().trim().length() == 0) {

            throw new BusinessException(ErrorContent.SAVE_USER_BANKNAME_ERROR_CODE, ErrorContent.SAVE_USER_BANKNAME_ERROR_MESSAGE);
        }

        //银行卡名称

        if (null != form.getBankCardName() && form.getBankCardName().trim().length() > 50) {

            throw new BusinessException(ErrorContent.SAVE_USER_BANKNAME_ERROR_CODE, ErrorContent.SAVE_USER_BANKNAME_ERROR_MESSAGE);
        }

        //操作者
        if(null == form.getOperateName() || form.getOperateName().trim().length()==0){

            throw new BusinessException(ErrorContent.SAVE_USER_OPERATENAME_ERROR_CODE,ErrorContent.SAVE_USER_OPERATENAME_ERROR_MESSAGE);
        }

        //操作者
        if(null != form.getOperateName() && form.getOperateName().trim().length()>100){

            throw new BusinessException(ErrorContent.SAVE_USER_OPERATENAME_ERROR_CODE,ErrorContent.SAVE_USER_OPERATENAME_ERROR_MESSAGE);
        }

        //产品
        if(null == form.getProduct() || form.getProduct().trim().length() == 0){

            throw new BusinessException(ErrorContent.ORDER_SAVE_PRODUCT_ERROR_CODE,ErrorContent.ORDER_SAVE_PRODUCT_ERROR_MESSAGE);
        }

         //产品
        if(null != form.getProduct() && form.getProduct().trim().length()>100){

            throw new BusinessException(ErrorContent.ORDER_SAVE_PRODUCT_ERROR_CODE,ErrorContent.ORDER_SAVE_PRODUCT_ERROR_MESSAGE);
        }


    }

    /**
     * 更新订单检验
     *
     * @param form
     */
    public static void checkUpdateOrder(OrderInfoForm form) {



        //检查订单
        if(null == form.getOrderId() || form.getOrderId().trim().length() == 0){

            throw new BusinessException(ErrorContent.ORDER_SAVE_ORDERID_ERROR_CODE,ErrorContent.ORDER_SAVE_ORDERID_ERROR_MESSAGE);
        }

        //申请贷款金额
        if ( null != form.getAccount() && !CheckUtil.isDouble(form.getAccount())) {

            throw new BusinessException(ErrorContent.ORDER_SAVE_ACCOUNT_ERROR_CODE,ErrorContent.ORDER_SAVE_ACCOUNT_ERROR_MESSAGE);
        }

        //申请期限
        if (null != form.getTermNo() && form.getTermNo().trim().length() >5) {

            throw new BusinessException(ErrorContent.ORDER_SAVE_TERMNO_ERROR_CODE,ErrorContent.ORDER_SAVE_TERMNO_ERROR_MESSAGE);
        }
        //申请期限
        if(null != form.getTermNo() && !CheckUtil.isDouble(form.getTermNo())){

            throw new BusinessException(ErrorContent.ORDER_SAVE_TERMNO_ERROR_CODE,ErrorContent.ORDER_SAVE_TERMNO_ERROR_MESSAGE);
        }

        //贷款用途
        if (null != form.getPurpose() &&
                !form.getPurpose().equals("旅游") &&
                !form.getPurpose().equals("装修") &&
                !form.getPurpose().equals("经营") &&
                !form.getPurpose().equals("其他消费")) {

            throw new BusinessException(ErrorContent.ORDER_SAVE_PURPOSE_ERROR_CODE,ErrorContent.ORDER_SAVE_PURPOSE_ERROR_MESSAGE);
        }


        //订单贷款金额
        if (null != form.getOrderAccount() && form.getOrderAccount().trim().length()>15) {

            throw new BusinessException(ErrorContent.ORDER_SAVE_ORDERACCOUNT_ERROR_CODE,ErrorContent.ORDER_SAVE_ORDERACCOUNT_ERROR_MESSAGE);
        }

        //订单贷款金额
        if (null != form.getOrderAccount() && !CheckUtil.isDouble(form.getOrderAccount())) {

            throw new BusinessException(ErrorContent.ORDER_SAVE_ORDERACCOUNT_ERROR_CODE,ErrorContent.ORDER_SAVE_ORDERACCOUNT_ERROR_MESSAGE);
        }

        //绑定的银行卡

        if (null != form.getBankCardNo() && form.getBankCardNo().trim().length() >20) {

            throw new BusinessException(ErrorContent.SAVE_USER_BANKCARDNO_ERROR_CODE, ErrorContent.SAVE_USER_BANKCARDNO_ERROR_MESSAGE);
        }

        //19位暂时无法判断
        if (null != form.getBankCardNo() && form.getBankCardNo().length() == 16 && !CheckUtil.matchLuhn(form.getBankCardNo())) {

            throw new BusinessException(ErrorContent.SAVE_USER_BANKCARDNO_ERROR_CODE, ErrorContent.SAVE_USER_BANKCARDNO_ERROR_MESSAGE);
        }

        //银行卡名称

        if (null != form.getBankCardName() && form.getBankCardName().trim().length() > 50) {

            throw new BusinessException(ErrorContent.SAVE_USER_BANKNAME_ERROR_CODE, ErrorContent.SAVE_USER_BANKNAME_ERROR_MESSAGE);
        }


        //姓名不能改
        if (null != form.getName() ) {

            throw new BusinessException(ErrorContent.SAVE_USER_NAME_RULE_ERROR_CODE,ErrorContent.SAVE_USER_NAME_RULE_ERROR_MESSAGE);
        }


        //身份证
        if (null != form.getIdNo()) {

            throw new BusinessException(ErrorContent.SAVE_USER_INNO_RULE_ERROR_CODE,ErrorContent.SAVE_USER_INFO_RULE_ERROR_MESSAGE);
        }


        //注册手机号
        if (null != form.getMobileNo() ) {

            throw new BusinessException(ErrorContent.SAVE_USER_MOBILE_RULE_ERROR_CODE,ErrorContent.SAVE_USER_MOBILE_RULE_ERROR_MESSAGE);
        }


        //婚姻状况具体值验证
        if (null != form.getMarry()&& !form.getMarry().equals("未婚") && !form.getMarry().equals("已婚") &&
                !form.getMarry().equals("离异") && !form.getMarry().equals("丧偶")) {

            throw new BusinessException(ErrorContent.SAVE_USER_MARRY_ERROR_CODE, ErrorContent.SAVE_USER_MARRY_ERROR_MESSAGE);
        }

        //城市
        if (null != form.getCity() && form.getCity().trim().length() > 50) {

            throw new BusinessException(ErrorContent.SAVE_USER_CITY_ERROR_CODE, ErrorContent.SAVE_USER_CITY_ERROR_MESSAGE);
        }
        //详细地址

        if (null != form.getRegion() && form.getRegion().trim().length() > 100) {

            throw new BusinessException(ErrorContent.SAVE_USER_REGION_ERROR_CODE, ErrorContent.SAVE_USER_REGION_ERROR_MESSAGE);
        }

        //住房情况
        if (null != form.getHouseType() && form.getHouseType().trim().length() > 0) {

            if (!form.getHouseType().equals("自购无按揭") &&
                    !form.getHouseType().equals("自购按揭") &&
                    !form.getHouseType().equals("自建房屋") &&
                    !form.getHouseType().equals("与父母同住") &&
                    !form.getHouseType().equals("租房")) {

                throw new BusinessException(ErrorContent.SAVE_USER_HOUSETYPE_ERROR_CODE, ErrorContent.SAVE_USER_HOUSETYPE_ERROR_MESSAGE);
            }
        }

        //单位类型

        if (null != form.getCompanyType() && form.getCompanyType().trim().length() > 0) {

            if (!form.getCompanyType().equals("国有企业") &&
                    !form.getCompanyType().equals("外资企业") &&
                    !form.getCompanyType().equals("合资企业") &&
                    !form.getCompanyType().equals("民营企业") &&
                    !form.getCompanyType().equals("私营 企业") &&
                    !form.getCompanyType().equals("个体户") &&
                    !form.getCompanyType().equals("自由职业者") &&
                    !form.getCompanyType().equals("其他")) {

                throw new BusinessException(ErrorContent.SAVE_USER_COMPANYTYPE_ERROR_CODE, ErrorContent.SAVE_USER_COMPANYTYPE_ERROR_MESSAGE);
            }
        }

        //职业类型

        if (null != form.getWorkType() && form.getWorkType().trim().length() > 0) {

            if (!form.getWorkType().equals("高管") &&
                    !form.getWorkType().equals("技术人员") &&
                    !form.getWorkType().equals("营销业务人员") &&
                    !form.getWorkType().equals("无业") &&
                    !form.getWorkType().equals("其他")) {

                throw new BusinessException(ErrorContent.SAVE_USER_WORKTYPE_ERROR_CODE, ErrorContent.SAVE_USER_WORKTYPE_ERROR_MESSAGE);
            }
        }

        //社保信息
        if (null != form.getHasSocialSecurity() && form.getHasSocialSecurity().trim().length() > 5) {

            throw new BusinessException(ErrorContent.SAVE_USER_HASSOCIAL_ERROR_CODE, ErrorContent.SAVE_USER_HASSOCIAL_ERROR_MESSAGE);
        }

        //开户年月
        if (null != form.getSocialSecurityOpenYear() && form.getSocialSecurityOpenYear().trim().length() > 18) {

            throw new BusinessException(ErrorContent.SAVE_USER_SOCIALOPENYEAR_CODE, ErrorContent.SAVE_USER_SOCIALOPENYEAR_MESSAGE);
        }

        //社保状态
        if (null != form.getSocialSecurityNowStatus() && form.getSocialSecurityNowStatus().trim().length() > 20) {

            throw new BusinessException(ErrorContent.SAVA_USER_SOCIALSTATUS_CODE, ErrorContent.SAVA_USER_SOCIALSTATUS_MESSAGE);
        }
        //社保月缴存金额
        if (null != form.getSocialSecurityMonthMoney()) {

            if (!CheckUtil.isDouble(form.getAccumulationFundMonthMoney())) {

                throw new BusinessException(ErrorContent.SAVE_USER_SOCIALMONEY_CODE, ErrorContent.SAVE_USER_SOCIALMONEY_MESSAGE);
            }
        }
        //缴存单位
        if (null != form.getSocialSecurityDepositUnits() && form.getSocialSecurityDepositUnits().trim().length() > 200) {

            throw new BusinessException(ErrorContent.SAVE_USER_SOCIALUNIT_ERROR_CODE, ErrorContent.SAVE_USER_SOCIALUNIT_ERROR_MESSAGE);
        }
        //是否有公积金
        if (null != form.getHasAccumulationFund() && form.getHasAccumulationFund().trim().length() > 10) {

            throw new BusinessException(ErrorContent.SAVE_USER_ACCUMULATION_ERROR_CODE, ErrorContent.SAVE_USER_ACCUMULATION_ERROR_MESSAGE);
        }
        //公积金缴存金额
        if (null != form.getAccumulationFundMonthMoney()) {

            if (!CheckUtil.isDouble(form.getAccumulationFundMonthMoney())) {

                throw new BusinessException(ErrorContent.SAVE_USER_ACCUMULATION_MONEY_ERROR_CODE, ErrorContent.SAVE_USER_ACCUMULATION_MONEY_ERROR_MESSAGE);
            }
        }
        //公积金缴存的单位
        if (null != form.getAccumulationFundDepositUnits() && form.getAccumulationFundDepositUnits().trim().length() > 200) {

            throw new BusinessException(ErrorContent.SAVE_USER_ACCUMULATION_UNIT_ERROR_CODE, ErrorContent.SAVE_USER_ACCUMULATION_UNIT_ERROR_MESSAGE);
        }

        //是否有房产
        if (null != form.getHasHouse() && form.getHasHouse().trim().length() > 10) {

            throw new BusinessException(ErrorContent.SAVE_USER_HASHOUSE_ERROR_CODE, ErrorContent.SAVE_USER_HASHOUSE_ERROR_MESSAGE);
        }

        //住房地址
        if (null != form.getHouseAddress() && form.getHouseAddress().trim().length() > 200) {

            throw new BusinessException(ErrorContent.SAVE_USER_HOUSEADDRESS_ERROR_CODE, ErrorContent.SAVE_USER_HOUSEADDRESS_ERROR_MESSAGE);
        }
        //住房面积
        if (null != form.getHouseArea() && form.getHouseArea().trim().length() > 10) {

            throw new BusinessException(ErrorContent.SAVE_USER_HOUSEAREA_ERROR_CODE, ErrorContent.SAVE_USER_HOUSEAREA_ERROR_MESSAGE);
        }
        if (null != form.getHouseArea() && CheckUtil.isDouble(form.getHouseArea())) {

            throw new BusinessException(ErrorContent.SAVE_USER_HOUSEAREA_ERROR_CODE, ErrorContent.SAVE_USER_HOUSEAREA_ERROR_MESSAGE);
        }
        //住房估值
        if (null != form.getHouseValue() && form.getHouseValue().trim().length() > 15) {

            throw new BusinessException(ErrorContent.SAVE_USER_HOUSEVALUE_ERROR_CODE, ErrorContent.SAVE_USER_HOUSEVALUE_ERROR_MESSAGE);
        }

        if (null != form.getHouseValue() && CheckUtil.isDouble(form.getHouseValue())) {

            throw new BusinessException(ErrorContent.SAVE_USER_HOUSEVALUE_ERROR_CODE, ErrorContent.SAVE_USER_HOUSEVALUE_ERROR_MESSAGE);

        }

        //消费合同
        if (null != form.getContract() && form.getContract().trim().length() > 15) {

            throw new BusinessException(ErrorContent.SAVE_FILE_CONTRACT_ERROR_CODE, ErrorContent.SAVE_FILE_CONTRACT_ERROR_MESSAGE);
        }

        if (null != form.getContract() && CheckUtil.isDouble(form.getContract())) {

            throw new BusinessException(ErrorContent.SAVE_FILE_CONTRACT_ERROR_CODE, ErrorContent.SAVE_FILE_CONTRACT_ERROR_MESSAGE);
        }

        //第一联系人信息
        if (null != form.getFriendName1() && form.getFriendName1().trim().length() > 50) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND_NAME_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND_NAME_ERROR_MESSAGE);
        }

        //第一联系人手机号
        if (null != form.getFriendMobileNo1() && form.getFriendMobileNo1().trim().length() != 11) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND_MOBILE_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND_MOBILE_ERROR_MESSAGE);
        }

        //第一联系人手机校验
        if (null != form.getFriendMobileNo1() && !IphoneUtil.isPhone(form.getFriendMobileNo1())) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND_MOBILE_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND_MOBILE_ERROR_MESSAGE);

        }

        if (null != form.getFriendShip1() && !form.getFriendShip1().equals("配偶") && !form.getFriendShip1().equals("亲属") &&
                !form.getFriendShip1().equals("朋友") && !form.getFriendShip1().equals("同事") &&
                !form.getFriendShip1().equals("同学") && !form.getFriendShip1().equals("邻居") &&
                !form.getFriendShip1().equals("其他")) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND_SHIP_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND_SHIP_ERROR_MESSAGE);
        }

        //第二个联系人校验
        if (null != form.getFriendName2() && form.getFriendName2().trim().length() > 100) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND2_NAME_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND2_NAME_ERROR_MESSAGE);
        }

        //第二联系人手机校验
        if (null != form.getFriendMobileNo2() && form.getFriendMobileNo2().trim().length() != 11) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND2_MOBILE_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND2_MOBILE_ERROR_MESSAGE);
        }

        if (null != form.getFriendMobileNo2() && !IphoneUtil.isPhone(form.getFriendMobileNo2())) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND2_MOBILE_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND2_MOBILE_ERROR_MESSAGE);

        }

        //第二联系人关系校验

        if (null != form.getFriendShip2() && !form.getFriendShip2().equals("配偶") && !form.getFriendShip2().equals("亲属") &&
                !form.getFriendShip2().equals("朋友") && !form.getFriendShip2().equals("同事") &&
                !form.getFriendShip2().equals("同学") && !form.getFriendShip2().equals("邻居") &&
                !form.getFriendShip2().equals("其他")) {

            throw new BusinessException(ErrorContent.SAVE_USER_FRIEND2_SHIP_ERROR_CODE, ErrorContent.SAVE_USER_FRIEND2_SHIP_ERROR_MESSAGE);
        }

        //操作者
        if(null == form.getOperateName() || form.getOperateName().trim().length()==0){

            throw new BusinessException(ErrorContent.SAVE_USER_OPERATENAME_ERROR_CODE,ErrorContent.SAVE_USER_OPERATENAME_ERROR_MESSAGE);
        }

        //操作者
        if(null != form.getOperateName() && form.getOperateName().trim().length()>100){

            throw new BusinessException(ErrorContent.SAVE_USER_OPERATENAME_ERROR_CODE,ErrorContent.SAVE_USER_OPERATENAME_ERROR_MESSAGE);
        }


        //利率
        if(null !=form.getRate() && form.getRate().trim().length()>7){

            throw new BusinessException(ErrorContent.ORDER_SAVE_RATE_ERROR_CODE,ErrorContent.ORDER_SAVE_RATE_ERROR_MESSAGE);
        }
        //批准期限
        if(null !=form.getRiskTerm() &&form.getRate().trim().length()>10){

            throw new BusinessException(ErrorContent.ORDER_SAVE_RISKTERM_ERROR_CODE,ErrorContent.ORDER_SAVE_RISKTERM_ERROR_MESSAGE);
        }
        //最终贷款金额
        if(null != form.getFinalAccount() && form.getFinalAccount().trim().length()>19){

            throw new BusinessException(ErrorContent.ORDER_SAVE_FINALACCOUNT_ERROR_CODE,ErrorContent.ORDER_SAVE_FINALACCOUNT_ERROR_MESSAGE);
        }



    }


    /**
     * 检验订单查询
     *
     * @param form
     */
    public static void checkFindOrderByUserId(OrderFindForm form) {

        //不能同时为空

        if(null == form.getUserId() || form.getUserId() ==0){

            if(null == form.getName() || form.getName().trim().length()==0){

                if(form.getInsideOrderStatus() == 0){

                    if(form.getOrderStatus() == 0){


                        if(form.getPage() ==0  ||form.getLimit()==0){

                                throw new BusinessException(ErrorContent.ORDER_FIND_NOPARAM_ERROR_CODE,ErrorContent.ORDER_FIND_NOPARAM_ERROR_MESSAGE);

                        }

                    }
                }
            }

        }

        //分页必须传
        if(form.getPage()<=0 || form.getLimit()<=0){

            throw new BusinessException(ErrorContent.ORDER_FIND_LIMIT_ERROR_CODE,ErrorContent.ORDER_FIND_LIMIT_ERROR_MESSAGE);
        }

    }


    /**
     * 检查审批进度
     * @param form
     */
    public static void checkAddApproveLog(ApproveLogForm form){


        //订单号
        if(null == form.getOrderId() || form.getOrderId().trim().length()==0){

            throw new BusinessException(ErrorContent.ORDER_SAVE_ORDERID_ERROR_CODE,ErrorContent.ORDER_SAVE_ORDERID_ERROR_MESSAGE);
        }

        //环节
        if(null == form.getLink() || form.getLink().trim().length() ==0  || form.getLink().trim().length() >50){

            throw new BusinessException(ErrorContent.RISK_LINK_ERROR_CODE,ErrorContent.RISK_LINK_ERROR_MESSAGE);
        }

        //操作者
        if(null == form.getOperateName() || form.getOperateName().trim().length() ==0 || form.getOperateName().trim().length() >50){

            throw new BusinessException(ErrorContent.RISK_OPERATENAME_ERROR_CODE,ErrorContent.RISK_OPERATENAME_ERROR_MESSAGE);
        }
        //操作
        if(null == form.getOperate() || form.getOperate().trim().length()==0 || form.getOperate().trim().length()>50){

            throw new BusinessException(ErrorContent.RISK_OPERATE_ERROR_CODE,ErrorContent.RISK_OPERATE_ERROR_MESSAGE);
        }
        //处理意见
        if(null == form.getResult() || form.getResult().trim().length()==0 || form.getResult().trim().length()>50){

            throw new BusinessException(ErrorContent.RISK_RESULT_ERROR_CODE,ErrorContent.RISK_RESULT_ERROR_MESSAGE);
        }


    }

}
