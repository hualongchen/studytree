package com.lemon.chen.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lemon.chen.bean.UserForm;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chenhualong on 2017/7/6.
 */

@RestController
@RequestMapping(value = "/user")
public class LemonController {


    /**
     * 增加测试数据
     */
    public static List<UserForm> userMap = new ArrayList<UserForm>();

    static {


        UserForm form = new UserForm();
        form.setUserAge(1);
        form.setUserName("lemon" + 1);
        form.setUserId(1);
        userMap.add(form);
        form = new UserForm();
        form.setUserAge(2);
        form.setUserName("lemon" + 2);
        form.setUserId(2);
        userMap.add(form);
        form = new UserForm();
        form.setUserAge(3);
        form.setUserName("lemon" + 3);
        form.setUserId(3);
        userMap.add(form);


    }

    /**
     * @param usereId
     * @return
     * @RequestParam get查询方式    通过
     */
    @ApiOperation(value = "根据用户ID查找用户信息", notes = "")
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public UserForm getUser(@RequestParam int usereId) {

        return userMap.get(usereId);
    }

    /**
     * @param id 通过
     * @return
     * @PathVariable 利用路径进行查询， get的方式
     */
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserForm getUser2(@PathVariable int id) {

        return userMap.get(id);
    }

    /**
     * 利用PathVariable，ModelAttribute put的方式进行更新
     *
     * @param id   通过
     * @param user
     * @return
     */
    @ApiOperation(value = "存储用户详细信息", notes = "根据url的id来指定存储对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "UserForm")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute UserForm user) {
        System.out.println(user.toString());
        System.out.println(id);
        return "success";
    }

    /**
     * 利用 requestmethod DELETE 进行删除
     *
     * @param id 通过
     * @return
     */

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable long id) {

        System.out.println("delete the userId  ：" + id);
        return "success";
    }


    /**
     * 直接查询全局
     * 通过
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserForm> getUserList() {

        return userMap;
    }

    /**
     * 利用postMaping结合，更方便
     *
     * @param id 通过
     * @return
     */
    @PostMapping(value = "/find2")
    public Object findUser(@RequestParam int id) {

        System.out.println("PostMapping userId :" + id);

        return id;
    }

    /**
     * 通过
     *
     * @param id
     * @return
     */
    @GetMapping(value = "find3")
    public Object findUser2(@RequestParam int id) {

        System.out.println("GetMapping userId :" + id);

        return id;
    }


    public static void main(String[] args) {


        try{

            File  filename = new File("D:\\test.txt");

            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            System.out.println(line.substring(0,2));
            while (line != null) {
                // System.out.println(line.substring(0,2));
                line = br.readLine(); // 一次读入一行数据

                System.out.println(line.substring(0,2));
            }
        }catch (Throwable th){

        }





        /*//Scanner sc = new Scanner(System.in);


        String json = "{\"KBMerchandiseQueryCondition\":{\"pageSize\":20,\"secondOrderByField\":\"MerchantSalesCount\",\"channelCode\":\"KOUBEI\",\"supportTest\":false,\"sort\":\"-\",\"pageNum\":7,\"statusList\":[\"ONLINE\"],\"firstOrderByField\":\"Rating\",\"categoryId\":\"102505\"},\"listVo\":[{\"orderCountDesc\":\"0\",\"chargeType\":\"03\",\"title\":\"银收宝移动支付\",\"priceItemList\":[{\"specification\":\"\",\"priceItemId\":\"04ea33e5-bce0-4b1c-9ba7-ab6c3f18abd6\"}],\"avgScore\":0.0,\"subTitle\":\"移动支付\",\"appType\":\"OPERATION\",\"logo\":\"https://appstoreisvpic.alipayobjects.com/prod/c27bacc3-76b9-40a7-89b4-78aca8ac4834.jpg\",\"onlineTime\":\"2017-06-03 14:20:09\",\"sucOrderItems\":\"0\",\"sucOrderItemsDesc\":\"0\",\"isvCardNo\":\"2088712678644142\",\"orderCount\":\"0\",\"commentCount\":0,\"merchandiseId\":\"I1060100001000007770\",\"isvName\":\"慕尚岁月\",\"categoryId\":\"102505\",\"priceDesc\":\"面议\",\"status\":\"ONLINE\"},{\"orderCountDesc\":\"0\",\"chargeType\":\"03\",\"title\":\"86商业联盟\",\"priceItemList\":[{\"period\":\"YEAR\",\"price\":\"0.00\",\"priceItemId\":\"8e8e223e-95b8-45a1-939f-588966b073bd\",\"specification\":\"标准版\",\"sellPrice\":{\"currency\":{},\"currencyCode\":\"CNY\",\"cent\":0,\"currencyValue\":\"156\"}},{\"period\":\"QUARTER\",\"price\":\"0.00\",\"priceItemId\":\"e9ac93c8-a350-40eb-bd8b-9aefab90e7a7\",\"specification\":\"标准版\",\"sellPrice\":\"~unique-id~5\"},{\"period\":\"MONTH\",\"price\":\"0.00\",\"priceItemId\":\"4072d7d1-9948-4aca-ba4c-09140590ca49\",\"specification\":\"标准版\",\"sellPrice\":\"~unique-id~5\"},{\"period\":\"2YEAR\",\"price\":\"0.00\",\"priceItemId\":\"268ebe10-be2d-43c1-b020-49e81e1aeca2\",\"specification\":\"标准版\",\"sellPrice\":\"~unique-id~5\"},{\"period\":\"SIX_MONTH\",\"price\":\"0.00\",\"priceItemId\":\"4b9e924b-d492-439c-b357-3a387ab02d33\",\"specification\":\"标准版\",\"sellPrice\":\"~unique-id~5\"}],\"avgScore\":0.0,\"subTitle\":\"专业的收银系统开发商，还为商户提供了技术、商户接入、商户经营和收银系统等多重解决方案，也会持续不断地为商户提供基于微信更多的更好的产品和服务\",\"appType\":\"APP\",\"logo\":\"https://appstoreisvpic.alipayobjects.com/prod/15e2c378-31b7-4d92-aa36-0627f384f562.jpg\",\"onlineTime\":\"2017-04-04 08:53:13\",\"sucOrderItems\":\"0\",\"sucOrderItemsDesc\":\"0\",\"isvCardNo\":\"2088521286745718\",\"orderCount\":\"0\",\"commentCount\":0,\"merchandiseId\":\"201612030243380071\",\"isvName\":\"义乌市军瑜电子商务有限公司\",\"categoryId\":\"102505\",\"priceDesc\":\"面议\",\"status\":\"ONLINE\"},{\"orderCountDesc\":\"0\",\"chargeType\":\"03\",\"title\":\"汇富收银系统\",\"priceItemList\":[{\"specification\":\"\",\"priceItemId\":\"83ea56a5-3744-4f6c-b7cf-48faf447226b\"}],\"avgScore\":0.0,\"subTitle\":\"365天D+0即时到帐,商户使用更放心,收款信息即时接收,更灵活.费率相比更优惠\",\"appType\":\"OPERATION\",\"logo\":\"https://appstoreisvpic.alipayobjects.com/prod/79301b3e-2402-4fb7-b14a-82d2cdf74d6c.jpg\",\"onlineTime\":\"2017-11-10 22:00:46\",\"sucOrderItems\":\"0\",\"sucOrderItemsDesc\":\"0\",\"isvCardNo\":\"2088102193079790\",\"orderCount\":\"0\",\"commentCount\":0,\"merchandiseId\":\"I1060100001000028515\",\"isvName\":\"叶润康\",\"categoryId\":\"102505\",\"priceDesc\":\"面议\",\"status\":\"ONLINE\"},{\"orderCountDesc\":\"0\",\"chargeType\":\"03\",\"title\":\"会商掌柜\",\"priceItemList\":[{\"priceItemId\":\"57f1c08b-0a93-435f-b744-10349a4bd93f\"}],\"avgScore\":0.0,\"subTitle\":\"为具有会员管理需求的线上、线下商家精准锁定会员人脉、实现会员带动会员消费，并创造会员事业机会的互动营销管理系统。\",\"appType\":\"OPERATION\",\"logo\":\"https://appstoreisvpic.alipayobjects.com/prod/1b29d029-04fc-4927-b172-72b11c6794a8.png\",\"onlineTime\":\"2016-12-16 15:39:44\",\"sucOrderItems\":\"0\",\"sucOrderItemsDesc\":\"0\",\"isvCardNo\":\"2088012049377780\",\"orderCount\":\"0\",\"commentCount\":0,\"merchandiseId\":\"201610280203820178\",\"isvName\":\"会商掌柜\",\"categoryId\":\"102505\",\"priceDesc\":\"面议\",\"status\":\"ONLINE\"},{\"orderCountDesc\":\"0\",\"chargeType\":\"03\",\"title\":\"盒子推荐服务商\",\"priceItemList\":[{\"priceItemId\":\"8a056ad4-652e-437a-be11-b5788b9b6166\"}],\"avgScore\":0.0,\"subTitle\":\"盒子支付\",\"appType\":\"OPERATION\",\"logo\":\"https://appstoreisvpic.alipayobjects.com/prod/2aad49b4-ad1c-4a1c-a208-4c630a9e3bd2.jpg\",\"onlineTime\":\"2016-10-18 23:19:30\",\"sucOrderItems\":\"0\",\"sucOrderItemsDesc\":\"0\",\"isvCardNo\":\"2088702059230602\",\"orderCount\":\"0\",\"commentCount\":0,\"merchandiseId\":\"201610060187741260\",\"isvName\":\"盒子支付\",\"categoryId\":\"102505\",\"priceDesc\":\"面议\",\"status\":\"ONLINE\"},{\"orderCountDesc\":\"1\",\"chargeType\":\"03\",\"title\":\"讯商软件专卖店管理系统\",\"priceItemList\":[{\"period\":\"QUARTER\",\"price\":\"0.00\",\"priceItemId\":\"63f1b13b-eb23-4eb3-a1b0-f78be45123e6\",\"specification\":\"标准版\",\"sellPrice\":{\"currency\":{},\"currencyCode\":\"CNY\",\"cent\":0,\"currencyValue\":\"156\"}},{\"period\":\"2YEAR\",\"price\":\"0.00\",\"priceItemId\":\"3effd03e-a8ba-407e-b102-c24a8a80a3a5\",\"specification\":\"标准版\",\"sellPrice\":\"~unique-id~19\"},{\"period\":\"YEAR\",\"price\":\"0.00\",\"priceItemId\":\"486ed6ae-159f-4f6f-9f4a-4d821c1646df\",\"specification\":\"标准版\",\"sellPrice\":\"~unique-id~19\"},{\"period\":\"SIX_MONTH\",\"price\":\"0.00\",\"priceItemId\":\"6ab0dbc2-b555-4ec0-a5d4-0c5a910f9e89\",\"specification\":\"标准版\",\"sellPrice\":\"~unique-id~19\"}],\"avgScore\":0.0,\"subTitle\":\"讯商软件专卖店管理系统是一款适应于有手机支付需求客户群体的商户，并且轻松实现收银员交班对账，多个门店一个收款账户收款并对账，账目清晰，财务清算简单的管理系统。\",\"appType\":\"APP\",\"logo\":\"https://appstoreisvpic.alipayobjects.com/prod/0ca07994-c568-402e-8aec-9462a07b5602.jpg\",\"onlineTime\":\"2016-12-17 10:09:15\",\"sucOrderItems\":\"0\",\"sucOrderItemsDesc\":\"0\",\"isvCardNo\":\"2088011082823634\",\"orderCount\":\"1\",\"commentCount\":0,\"merchandiseId\":\"201610100187891263\",\"isvName\":\"深圳市讯商科技股份有限公司\",\"categoryId\":\"102505\",\"priceDesc\":\"面议\",\"status\":\"ONLINE\"},{\"orderCountDesc\":\"0\",\"chargeType\":\"03\",\"title\":\"支付信息技术服务\",\"priceItemList\":[{\"priceItemId\":\"236a379d-5465-4b72-93fd-3ef428a4c064\"}],\"avgScore\":0.0,\"subTitle\":\"最便捷的支付信息技术服务平台。信息反馈、POS机及时跟踪调查，主动推送支付信息，同时交易管理，申办管理让您放心、舒心、安心。我们一直在努力！\",\"appType\":\"OPERATION\",\"logo\":\"https://appstoreisvpic.alipayobjects.com/prod/90adeb31-09fb-402f-ba54-192017e18ad3.jpg\",\"onlineTime\":\"2016-10-30 19:52:52\",\"sucOrderItems\":\"0\",\"sucOrderItemsDesc\":\"0\",\"isvCardNo\":\"2088521150789767\",\"orderCount\":\"0\",\"commentCount\":0,\"merchandiseId\":\"201610270198990876\",\"isvName\":\"杭州夺鼎科技有限公司\",\"categoryId\":\"102505\",\"priceDesc\":\"面议\",\"status\":\"ONLINE\"},{\"orderCountDesc\":\"0\",\"chargeType\":\"03\",\"title\":\"众联商城\",\"priceItemList\":[{\"priceItemId\":\"d8bcfd26-0713-422f-9df8-e10d88c69847\"}],\"avgScore\":0.0,\"subTitle\":\"众联支付旗下的众联商城是一个多元化的创新性购物平台，用户可以买到高质量、高性价比的商品，还可以根据经济状况选择分期还款。\",\"appType\":\"OPERATION\",\"logo\":\"https://appstoreisvpic.alipayobjects.com/prod/968a3739-bca8-4ec7-86fb-b77e8c98da9c.png\",\"onlineTime\":\"2016-12-16 15:49:23\",\"sucOrderItems\":\"0\",\"sucOrderItemsDesc\":\"0\",\"isvCardNo\":\"2088521377225255\",\"orderCount\":\"0\",\"commentCount\":0,\"merchandiseId\":\"201612130249831025\",\"isvName\":\"深圳众联支付科技有限公司\",\"categoryId\":\"102505\",\"priceDesc\":\"面议\",\"status\":\"ONLINE\"},{\"orderCountDesc\":\"0\",\"chargeType\":\"03\",\"title\":\"商户收银系统\",\"priceItemList\":[{\"priceItemId\":\"41e1c923-015c-444d-a94d-505148bbaf96\"}],\"avgScore\":0.0,\"subTitle\":\"商户收银系统，方便快捷，安全专业。一款可应用于零售商超、餐饮娱乐、生活服务等行业的PC端支付系统。\",\"appType\":\"OPERATION\",\"logo\":\"https://appstoreisvpic.alipayobjects.com/prod/e9530814-f38b-4130-a3c2-c7bacae0ea8d.png\",\"onlineTime\":\"2016-09-17 18:12:45\",\"sucOrderItems\":\"0\",\"sucOrderItemsDesc\":\"0\",\"isvCardNo\":\"2088421816422545\",\"orderCount\":\"0\",\"commentCount\":0,\"merchandiseId\":\"201609130178320254\",\"isvName\":\"上海翔汇网络科技有限公司\",\"categoryId\":\"102505\",\"priceDesc\":\"面议\",\"status\":\"ONLINE\"},{\"orderCountDesc\":\"0\",\"chargeType\":\"03\",\"title\":\"支付宝线下收款品牌推广\",\"priceItemList\":[{\"priceItemId\":\"2c34d71d-e0fa-4f4d-af67-7c427e3e003e\"}],\"avgScore\":0.0,\"subTitle\":\"帮助商户开通支付宝线下收款方式，包含二维码支付、扫码枪支付\",\"appType\":\"OPERATION\",\"logo\":\"https://appstoreisvpic.alipayobjects.com/prod/c2aa6db8-b427-4f6e-89d7-8b37b272b2cd.jpg\",\"onlineTime\":\"2016-10-20 18:28:14\",\"sucOrderItems\":\"0\",\"sucOrderItemsDesc\":\"0\",\"isvCardNo\":\"2088012469586818\",\"orderCount\":\"0\",\"commentCount\":0,\"merchandiseId\":\"201610080187341081\",\"isvName\":\"重庆速洪科技有限责任公司\",\"categoryId\":\"102505\",\"priceDesc\":\"面议\",\"status\":\"ONLINE\"},{\"orderCountDesc\":\"0\",\"chargeType\":\"03\",\"title\":\"商户收款快速接入\",\"priceItemList\":[{\"priceItemId\":\"c2002e65-0e4b-4cad-8b04-026eacf0e58b\"}],\"avgScore\":0.0,\"subTitle\":\"商户二维码收款服务以及其他相关收款工具，关于店铺利益问题，您比较谨慎我可以理解，只需要您迈出第一步，稍微努力点，我们的故事就可以开始，您的肯定是我们最大的动力，手机：15642930400\",\"appType\":\"OPERATION\",\"logo\":\"https://appstoreisvpic.alipayobjects.com/prod/eeb39304-5b88-4527-9ec9-f06c96db7ee3.png\",\"onlineTime\":\"2016-11-19 18:35:05\",\"sucOrderItems\":\"0\",\"sucOrderItemsDesc\":\"0\",\"isvCardNo\":\"2088221796695830\",\"orderCount\":\"0\",\"commentCount\":0,\"merchandiseId\":\"201611180231770683\",\"isvName\":\"葫芦岛大壮科技有限公司\",\"categoryId\":\"102505\",\"priceDesc\":\"面议\",\"status\":\"ONLINE\"},{\"orderCountDesc\":\"0\",\"chargeType\":\"03\",\"title\":\"微源素\",\"priceItemList\":[{\"priceItemId\":\"ce044349-4373-486b-bb44-af3eca471f67\"}],\"avgScore\":0.0,\"subTitle\":\"微源素\",\"appType\":\"OPERATION\",\"logo\":\"https://appstoreisvpic.alipayobjects.com/prod/8998ab57-25cb-4e77-a8e9-42f408760549.jpg\",\"onlineTime\":\"2016-12-09 09:00:31\",\"sucOrderItems\":\"0\",\"sucOrderItemsDesc\":\"0\",\"isvCardNo\":\"2088421875490288\",\"orderCount\":\"0\",\"commentCount\":0,\"merchandiseId\":\"201612080245110128\",\"isvName\":\"北京融源汇通投资咨询有限公司\",\"categoryId\":\"102505\",\"priceDesc\":\"面议\",\"status\":\"ONLINE\"},{\"orderCountDesc\":\"0\",\"chargeType\":\"03\",\"title\":\"收钱吧三码合一付款码\",\"priceItemList\":[{\"specification\":\"\",\"priceItemId\":\"b720d639-610b-4217-851b-8f4c7e3a0e6c\"}],\"avgScore\":0.0,\"subTitle\":\"收钱吧是由收钱吧应用APP、收钱吧POS机、收钱吧SDK等产品组成，旨在为中小商户提供一站式的线上收款工具，手机安装注册完成后，手机就可做门店收银机使用。收钱吧目前支持支付宝、微信、银联卡支付。  \",\"appType\":\"OPERATION\",\"logo\":\"https://appstoreisvpic.alipayobjects.com/prod/075c818a-4a61-4a56-b094-af562f562410.jpg\",\"onlineTime\":\"2017-12-20 14:06:48\",\"sucOrderItems\":\"0\",\"sucOrderItemsDesc\":\"0\",\"isvCardNo\":\"2088921276664359\",\"orderCount\":\"0\",\"commentCount\":0,\"merchandiseId\":\"I1060100001000102504\",\"isvName\":\"驻马店市开发区豫粤吧网络科技有限公司\",\"categoryId\":\"102505\",\"priceDesc\":\"面议\",\"status\":\"ONLINE\"}],\"paginator\":{\"page\":7,\"items\":133,\"itemsPerPage\":20},\"success\":true}";

        JSONObject jsonObject = JSON.parseObject(json);


        JSONArray array = jsonObject.getJSONArray("listVo");

        for (int i = 0; i < array.size(); i++) {


            JSONObject jsonObject2 = JSON.parseObject(array.get(i).toString());

            System.out.println(jsonObject2.get("title"));
        }

        System.out.println("=======================================================边分====================================================");

        for (int i = 0; i < array.size(); i++) {


            JSONObject jsonObject2 = JSON.parseObject(array.get(i).toString());

            System.out.println(jsonObject2.get("isvName"));
        }*/
    }
}
