package com.tongrong.order.util;

public class ErrorContent {

    public static String MISS_FILED_CODE="1001";

    public static String MISS_FILED_MESSAGE="缺少请求参数";

    public static String PARAMETER_RESOLUTION_FAILURE_CDOE="1002";

    public static String PARAMETER_RESOLUTION_FAILURE_MESSAGE="参数解析失败";

    public static String PARAMETER_VALIDATION_FAILURE_CDOE="1003";

    public static String PARAMETER_VALIDATION_FAILURE_MESSAGE="参数验证失败";

    public static String PARAMETER_BINDING_FAILURE_CDOE="1004";

    public static String METHOD_NOT_SUPPORTED_CDOE="1005";

    public static String METHOD_NOT_SUPPORTED_MESSAGE="不支持当前方法";

    public static String MEDIA_NOT_SUPPORTED_CDOE="1006";

    public static String MEDIA_NOT_SUPPORTED_MESSAGE="不支持当前媒体类型";

    public static String GENEREL_ERROR_CDOE="1007";

    public static String GENEREL_ERROR_MESSAGE="系统错误";

    public static String DATABASE_ERROR_CDOE="1008";


    /**
     *
     *
     * 用户系统： 1101开头
     *
     * 文件系统1011开头
     *
     * 订单系统： 1300开头
     *
     *
     */


    //======================用户基本信息保存或修改===========================
    public static String  REGIST_MOBILE_ERROR_CODE="1101";
    public static String  REGIST_MOBILE_ERROR_MESSAGE="用户名格式错误";


    public static String  REGIST_OPENID_ERROR_CODE="1102";
    public static String  REGIST_OPENID_ERROR_MESSAGE="微信openid错误";

    public static String REGIST_CHANNELID_ERROR_CODE="1103";
    public static String REGIST_CHANNELID_ERROR_MESSAGE="渠道码错误";

    public static String  FIND_USER_ERROR_CODE="1104";
    public static String  FIND_USER_ERROR_MESSAGE="手机号或则微信ID必须至少填一个";

    public static String SAVE_USER_NULL_ERROR_CODE="1105";
    public static String SAVE_USER_NULL_ERROR_MESSAGE="姓名不能为空";

    public static String SAVE_USER_IDCARD_NULL_ERROR_CODE="1106";
    public static String SAVE_USER_IDCARD_NULL_ERROR_MESSAGE="身份证不能为空";

    public static String SAVE_USER_IDCARD_LENGTH_ERROR_CODE="1107";
    public static String SAVE_USER_IDCARD_LENGTH_ERROR_MESSAGE="身份证格式错误";

    public static String SAVE_USER_MARRY_ERROR_CODE="1108";
    public static String SAVE_USER_MARRY_ERROR_MESSAGE="婚姻状况值错误";

    public static String SAVE_USER_FRIEND_NAME_ERROR_CODE="1109";
    public static String SAVE_USER_FRIEND_NAME_ERROR_MESSAGE="第一位联系人姓名格式错误";

    public static String SAVE_USER_FRIEND_MOBILE_ERROR_CODE="1110";
    public static String SAVE_USER_FRIEND_MOBILE_ERROR_MESSAGE="第一位联系人手机错误";

    public static String SAVE_USER_FRIEND_SHIP_ERROR_CODE="1111";
    public static String SAVE_USER_FRIEND_SHIP_ERROR_MESSAGE="第一位联系人关系值错误";

    public static String SAVE_USER_FRIEND2_NAME_ERROR_CODE="1112";
    public static String SAVE_USER_FRIEND2_NAME_ERROR_MESSAGE="第二位联系人姓名格式错误";

    public static String SAVE_USER_FRIEND2_MOBILE_ERROR_CODE="1113";
    public static String SAVE_USER_FRIEND2_MOBILE_ERROR_MESSAGE="第二位联系人手机错误";

    public static String SAVE_USER_FRIEND2_SHIP_ERROR_CODE="1114";
    public static String SAVE_USER_FRIEND2_SHIP_ERROR_MESSAGE="第二位联系人关系值错误";

    public static String SAVE_USER_BANKCARDNO_ERROR_CODE="1115";
    public static String SAVE_USER_BANKCARDNO_ERROR_MESSAGE="银行卡格式错误";

    public static String SAVE_USER_BANKNAME_ERROR_CODE="1116";
    public static String SAVE_USER_BANKNAME_ERROR_MESSAGE="银行卡名称格式错误";

    public static String SAVE_USER_BANKMOBILE_ERROR_CODE="1117";
    public static String SAVE_USER_BANKMOBILE_ERROR_MESSAGE="银行卡预留手机号格式错误";

    public static String SAVE_USER_IDCARDURL_ERROR_CODE="1118";
    public static String SAVE_USER_IDCARDURL_ERROR_MESSAGE="身份证背面照片地址不正确";

    public static String SAVE_USER_IDCARDURL2_ERROR_CODE="1119";
    public static String SAVE_USER_IDCARDURL2_ERROR_MESSAGE="身份证正面照片地址不正确";

    public static String SAVE_USER_UPLOADNAME_ERROR_CODE="1120";
    public static String SAVE_USER_UPLOADNAME_ERROR_MESSAGE="上传人姓名错误";

    public static String SAVE_USER_NAME_RULE_ERROR_CODE="1121";
    public static String SAVE_USER_NAME_RULE_ERROR_MESSAGE="姓名不能更改";

    public static String SAVE_USER_INNO_RULE_ERROR_CODE="1122";
    public static String SAVE_USER_INFO_RULE_ERROR_MESSAGE="身份证不能更改";

    public static String SAVE_USER_MOBILE_RULE_ERROR_CODE="1123";
    public static String SAVE_USER_MOBILE_RULE_ERROR_MESSAGE="注册手机号不能改";

    public static String SAVE_USER_CITY_ERROR_CODE="1124";
    public static String SAVE_USER_CITY_ERROR_MESSAGE="城市地址格式错误";

    public static String SAVE_USER_REGION_ERROR_CODE="1125";
    public static String SAVE_USER_REGION_ERROR_MESSAGE="详细地址格式错误";

    public static String SAVE_USER_HOUSETYPE_ERROR_CODE="1126";
    public static String SAVE_USER_HOUSETYPE_ERROR_MESSAGE="住房情况值错误";

    public static String SAVE_USER_COMPANYTYPE_ERROR_CODE="1127";
    public static String SAVE_USER_COMPANYTYPE_ERROR_MESSAGE="单位类型值错误";

    public static String SAVE_USER_WORKTYPE_ERROR_CODE="1128";
    public static String SAVE_USER_WORKTYPE_ERROR_MESSAGE="职业类型值错误";

    public static String SAVE_USER_HASSOCIAL_ERROR_CODE="1129";
    public static String SAVE_USER_HASSOCIAL_ERROR_MESSAGE="社保信息值错误";

    public static String SAVE_USER_SOCIALOPENYEAR_CODE="1130";
    public static String SAVE_USER_SOCIALOPENYEAR_MESSAGE="开户年月值错误";

    public static String SAVA_USER_SOCIALSTATUS_CODE="1131";
    public static String SAVA_USER_SOCIALSTATUS_MESSAGE="社保状态值错误";

    public static String SAVE_USER_SOCIALMONEY_CODE="1132";
    public static String SAVE_USER_SOCIALMONEY_MESSAGE="社保月缴存金额值错误";

    public static String SAVE_USER_SOCIALUNIT_ERROR_CODE="1133";
    public static String SAVE_USER_SOCIALUNIT_ERROR_MESSAGE="缴存单位格式错误";

    public static String SAVE_USER_ACCUMULATION_ERROR_CODE="1134";
    public static String SAVE_USER_ACCUMULATION_ERROR_MESSAGE="是否有公积金值错误";

    public static String SAVE_USER_ACCUMULATION_MONEY_ERROR_CODE="1135";
    public static String SAVE_USER_ACCUMULATION_MONEY_ERROR_MESSAGE="公积金缴存金额值错误";

    public static String SAVE_USER_ACCUMULATION_UNIT_ERROR_CODE="1136";
    public static String SAVE_USER_ACCUMULATION_UNIT_ERROR_MESSAGE="公积金缴存单位值错误";

    public static String SAVE_USER_HASHOUSE_ERROR_CODE="1137";
    public static String SAVE_USER_HASHOUSE_ERROR_MESSAGE="是否有房产值错误";

    public static String SAVE_USER_HOUSEADDRESS_ERROR_CODE="1138";
    public static String SAVE_USER_HOUSEADDRESS_ERROR_MESSAGE="住房地址格式错误";

    public static String SAVE_USER_HOUSEAREA_ERROR_CODE="1139";
    public static String SAVE_USER_HOUSEAREA_ERROR_MESSAGE="住房面积值错误";

    public static String SAVE_USER_HOUSEVALUE_ERROR_CODE="1140";
    public static String SAVE_USER_HOUSEVALUE_ERROR_MESSAGE="住房估值值错误";

    public static String SAVE_FILE_USERID_ERROR_CODE="1141";
    public static String SAVE_FILE_USERID_ERROR_MESSAGE="用户ID值错误";

    public static String SAVE_FILE_FILENAME_ERROR_CODE="1142";
    public static String SAVE_FILE_FILENAME_ERROR_MESSAGE="文件名称值错误";

    public static String SAVE_FILE_FILETYPE_ERROR_CODE="1143";
    public static String SAVE_FILE_FILETYPE_ERROR_MESSAGE="文件类型值错误";

    public static String SAVE_FILE_FILEURL_ERROR_CODE="1144";
    public static String SAVE_FILE_FILEURL_ERROR_MESSAGE="文件地址错误";

    public static String SAVE_FILE_CONTRACT_ERROR_CODE="1151";
    public static String SAVE_FILE_CONTRACT_ERROR_MESSAGE="消费合同金额值错误";

    public static String FIND_USERID_ERROR_CODE="1152";
    public static String FIND_USERID_ERROR_MESSAGE="用户ID值错误";

    public static String FIND_USERINFO_ERROR_CODE="1153";
    public static String FIND_USERINFO_ERROR_MESSAGE="没有用户相关信息";

    public static String  SAVE_USER_MOBILENO_ERROR_CODE="1179";
    public static String  SAVE_USER_MOBILENO_ERROR_MESSAGE="注册手机号值错误";

    public static String SAVE_USER_OPERATENAME_ERROR_CODE="1180";
    public static String SAVE_USER_OPERATENAME_ERROR_MESSAGE="操作者值错误";





    //===================用户附件存储=======================
    public static String USER_FILE_NOEXIT_ERROR_CODE="1154";
    public static String USER_FILE_NOEXIT_ERROR_MESSAGE="没有用户相关附件";



    //====================后台登陆=======================

    public static String SYSTEMLOGIN_USERNAME_ERROR_CODE="1145";
    public static String SYSTEMLOGIN_USERNAME_ERROR_MESSAGE="用户名值错误";

    public static String SYSTEMLOGIN_PASSWORD_ERROR_CODE="1146";
    public static String SYSTEMLOGIN_PASSWORD_ERROR_MESSAGE="用户名密码错误";

    public static String SYSTEMLOGIN_NOUSER_ERROR_CODE="1147";
    public static String SYSTEMLOGIN_NOUSER_ERROR_MESSAGE="用户名或密码错误";


    //====================前台注册=========================

    public static String CHANNEL_ERROR_CODE="1148";
    public static String CHANNEL_ERROR_MESSAGE="推荐码不存在";

    public static String USERNAME_OPEID_EXIT_ERROR_CODE="1149";
    public static String USERNAME_OPEID_EXIT_ERROR_MESSAGE="注册手机号或微信号已经绑定过";

    public static String USERNAME_OPENID_NOEXIT_ERROR_CODE="1150";
    public static String USERNAME_OPENID_NOEXIT_ERROR_MESSAGE="没有相关用户信息";


//======================人行征信报告=========================

    public static String  PERSONAL_USERID_ERROR_CODE="1155";
    public static String  PERSONAL_USERID_ERROR_MESSAGE="用户ID错误";

    public static String PERSONAL_REPORTTYPE_ERROR_CODE="1156";
    public static String PERSONAL_REPORTTYPE_ERROR_MESSAGE="报告类型错误";

    public static String PERSONAL_ONE_EEROR_CODE="1157";
    public static String PERSONAL_ONE_ERROR_MESSAGE="未销户信用卡账户数值错误";

    public static String PERSONAL_TWO_ERROR_CODE="1158";
    public static String PERSONAL_TWO_ERROR_MESSAGE="未结清购房贷款账户数值 错误";

    public static String PERSONAL_THREE_ERROR_CODE="1159";
    public static String PERSONAL_THREE_ERROR_MESSAGE="未结清其他贷款账户数值错误";

    public static String PERSONAL_FOUR_ERROR_CODE="1160";
    public static String PERSONAL_FOUR_ERROR_MESSAGE="未销户信用卡最大额度值错误";

    public static String PERSONAL_FIVE_ERROR_CODE="1161";
    public static String PERSONAL_FIVE_ERROR_MESSAGE="未销户信用卡使用额度值错误";

    public static String PERSONAL_SIX_ERROR_CODE="1162";
    public static String PERSONAL_SIX_ERROR_MESSAGE="未销户信用卡总额度值错误";

    public static String PERSONAL_SEVEN_ERROR_CODE="1163";
    public static String PERSONAL_SEVEN_ERROR_MESSAGE="房屋贷款月供金额值错误";

    public static String PERSONAL_EIGHT_ERROR_CODE="1164";
    public static String PERSONAL_EIGHT_ERROR_MESSAGE="近3月信用卡加贷款审批查询次数值错误";


    public static String PERSONAL_NINE_ERROR_CODE="1165";
    public static String PERSONAL_NINE_ERROR_MESSAGE="近3月本人查询次数值错误";

    public static String PERSONAL_TEN_ERROR_CODE="1166";
    public static String PERSONAL_TEN_ERROR_MESSAGE="首张信用卡发卡月份值错误";


    public static String PERSONAL_11_ERROR_CODE="1167";
    public static String PERSONAL_11_ERROR_MESSAGE="其他贷款发放月份值错误";


    public static String PERSONAL_12_ERROR_CODE="1168";
    public static String PERSONAL_12_ERROR_MESSAGE="最早房屋贷款发放年月值错误";

    public static String PERSONAL_13_ERROR_CODE="1169";
    public static String PERSONAL_13_ERROR_MESSAGE="信用卡近12月最大逾期期数值错误";

    public static String PERSONAL_14_ERROR_CODE="1170";
    public static String PERSONAL_14_ERROR_MESSAGE="信用卡最近逾期距今月数值错误";

    public static String PERSONAL_15_ERROR_CODE="1171";
    public static String PERSONAL_15_ERROR_MESSAGE="信用卡近12月逾期月数值错误";

    public static String PERSONAL_16_ERROR_CODE="1172";
    public static String PERSONAL_16_ERROR_MESSAGE="贷款近12月最大逾期期数值错误";

    public static String PERSONAL_17_ERROR_CODE="1173";
    public static String PERSONAL_17_ERROR_MESSAGE="贷款最近逾期距今月数值错误";

    public static String PERSONAL_18_ERROR_CODE="1174";
    public static String PERSONAL_18_ERROR_MESSAGE="贷款近12月逾期月数值错误";

    public static String PERSONAL_19_ERROR_CODE="1175";
    public static String PERSONAL_19_ERROR_MESSAGE="信用卡近5年逾期月数值错误";

    public static String PERSONAL_20_ERROR_CODE="1176";
    public static String PERSONAL_20_ERROR_MESSAGE="信用卡近5年90天以上逾期月数值错误";

    public static String PERSONAL_21_ERROR_CODE="1177";
    public static String PERSONAL_21_ERROR_MESSAGE="贷款近5年逾期上月数值错误";

    public static String PERSONAL_22_ERROR_CODE="1178";
    public static String PERSONAL_22_ERROR_MESSAGE="贷款近5年90天以上逾期月数值错误";


   //================================= 订单系统： 1300开头================================

    //==================================保存/更新订单=========================================


    public static String ORDER_SAVE_ACCOUNT_ERROR_CODE="1301";
    public static String ORDER_SAVE_ACCOUNT_ERROR_MESSAGE="申请贷款金额值错误";

    public static String ORDER_SAVE_TERMNO_ERROR_CODE="1302";
    public static String ORDER_SAVE_TERMNO_ERROR_MESSAGE="申请期限值错误";

    public static String ORDER_SAVE_PURPOSE_ERROR_CODE="1303";
    public static String ORDER_SAVE_PURPOSE_ERROR_MESSAGE="贷款用途值错误";

    public static String ORDER_SAVE_SOURCE_ERROR_CODE="1304";
    public static String ORDER_SAVE_SOURCE_ERROR_MESSAGE="来源值错误";

    public static String ORDER_SAVE_ORDERACCOUNT_ERROR_CODE="1305";
    public static String ORDER_SAVE_ORDERACCOUNT_ERROR_MESSAGE="订单贷款金额值错误";

    public static String ORDER_SAVE_STATUS_ERROR_CODE="1306";
    public static String ORDER_SAVE_STATUS_ERROR_MESSAGE="订单大状态值错误";

    public static String ORDER_SAVE_INSIDESTATUS_ERROR_CODE="1307";
    public static String ORDER_SAVE_INSIDESTATUS_ERROR_MESSAGE="订单小状态值错误";

    public static String ORDER_SAVE_ORDERID_ERROR_CODE="1308";
    public static String ORDER_SAVE_ORDERID_ERROR_MESSAGE="订单号错误";

    public static String ORDER_SAVE_HASORDER_ERROR_CODE="1309";
    public static String ORDER_SAVE_HASORDER_ERROR_MESSAGE="还有未完结订单，不能下单";

    public static String  ORDER_FIND_NOPARAM_ERROR_CODE="1310";
    public static String  ORDER_FIND_NOPARAM_ERROR_MESSAGE="查询条件不能全空";

    public static String ORDER_FIND_LIMIT_ERROR_CODE="1311";
    public static String ORDER_FIND_LIMIT_ERROR_MESSAGE="分页条件不能为空";

    public static String ORDER_SAVE_PRODUCT_ERROR_CODE="1317";
    public static String ORDER_SAVE_PRODUCT_ERROR_MESSAGE="产品名称值错误";

    public static String ORDER_SAVE_LIST_ERROR_CODE="1318";
    public static String ORDER_SAVE_LIST_ERROR_MESSAGE="订单不存在";

    public static String ORDER_SAVE_RATE_ERROR_CODE="1319";
    public static String ORDER_SAVE_RATE_ERROR_MESSAGE="利率值错误";

    public static String ORDER_SAVE_RISKTERM_ERROR_CODE="1320";
    public static String ORDER_SAVE_RISKTERM_ERROR_MESSAGE="批准的期限值错误";

    public static String ORDER_SAVE_FINALACCOUNT_ERROR_CODE="1321";
    public static String ORDER_SAVE_FINALACCOUNT_ERROR_MESSAGE="最终贷款金额值错误";








    //--------------------------- 审批-------------------------------

    public static String  RISK_LINK_ERROR_CODE="1312";
    public static String  RISK_LINK_ERROR_MESSAGE="环节值错误";

    public static String  RISK_OPERATENAME_ERROR_CODE="1313";
    public static String  RISK_OPERATENAME_ERROR_MESSAGE="操作者值错误";

    public static String  RISK_OPERATE_ERROR_CODE="1314";
    public static String  RISK_OPERATE_ERROR_MESSAGE="操作值错误";

    public static String  RISK_RESULT_ERROR_CODE="1315";
    public static String  RISK_RESULT_ERROR_MESSAGE="处理意见值错误";

    public static String  RISK_LIST_ERROR_CODE="1316";
    public static String  RISK_LIST_ERROR_MESSAGE="没有审批记录";













}


