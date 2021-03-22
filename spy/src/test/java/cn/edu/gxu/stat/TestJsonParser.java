package cn.edu.gxu.stat;

import org.junit.Test;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.stat
 * @date 2021/3/13 22:00
 * @Description
 */
public class TestJsonParser {

    @Test
    public void test_parseAd() {
        String text = "{\"code\":0,\"msg\":\"\",\"groups\":[{\"rightsTop\":\"\",\"groupName\":\"第17组\",\"knownTop\":1,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2120,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":121.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第18组\",\"knownTop\":2,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2121,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":120.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第7组\",\"knownTop\":3,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2110,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":100.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第9组\",\"knownTop\":3,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2112,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":100.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第22组\",\"knownTop\":5,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2125,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":72.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第13组\",\"knownTop\":6,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2116,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":50.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第16组\",\"knownTop\":7,\"groupImgUrl\":\"\",\"isMyGroup\":1,\"groupId\":2119,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":33.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第19组\",\"knownTop\":7,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2122,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":33.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第5组\",\"knownTop\":9,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2108,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":25.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第6组\",\"knownTop\":9,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2109,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":25.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第15组\",\"knownTop\":11,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2118,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":14.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第14组\",\"knownTop\":12,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2117,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":10.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第20组\",\"knownTop\":12,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2123,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":10.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第12组\",\"knownTop\":14,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2115,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":9.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第4组\",\"knownTop\":15,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2107,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":7.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第1组\",\"knownTop\":16,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2104,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":6.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第2组\",\"knownTop\":17,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2105,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第3组\",\"knownTop\":17,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2106,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第8组\",\"knownTop\":17,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2111,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第10组\",\"knownTop\":17,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2113,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第11组\",\"knownTop\":17,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2114,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"},{\"rightsTop\":\"\",\"groupName\":\"第21组\",\"knownTop\":17,\"groupImgUrl\":\"\",\"isMyGroup\":0,\"groupId\":2124,\"groupRights\":\"\",\"profitTop\":\"\",\"groupScore\":\"\",\"totalOwnersEquity\":0.0,\"groupProfit\":\"\",\"isRealy\":\"\",\"scoreTop\":\"\",\"publicity\":0.00,\"groupTop\":\"\"}]}\n";
        new JsonParser().parseAd(text).stream().forEach(System.out::println);
    }

    @Test
    public void test_parseScore() {
        String text = "{\"code\":0,\"msg\":\"\",\"groups\":[{\"rightsTop\":1,\"groupId\":2110,\"groupName\":\"第7组\",\"groupRights\":4689.8,\"profitTop\":1,\"groupScore\":47348.22,\"groupImgUrl\":\"\",\"groupProfit\":3794.8,\"isMyGroup\":0,\"scoreTop\":1,\"groupTop\":1},{\"rightsTop\":2,\"groupId\":2116,\"groupName\":\"第13组\",\"groupRights\":4423.6,\"profitTop\":3,\"groupScore\":47252.9,\"groupImgUrl\":\"\",\"groupProfit\":3016.0,\"isMyGroup\":0,\"scoreTop\":2,\"groupTop\":2},{\"rightsTop\":3,\"groupId\":2106,\"groupName\":\"第3组\",\"groupRights\":4198.6,\"profitTop\":2,\"groupScore\":44312.02,\"groupImgUrl\":\"\",\"groupProfit\":3020.4,\"isMyGroup\":0,\"scoreTop\":3,\"groupTop\":3},{\"rightsTop\":4,\"groupId\":2121,\"groupName\":\"第18组\",\"groupRights\":3725.32,\"profitTop\":4,\"groupScore\":33803.55,\"groupImgUrl\":\"\",\"groupProfit\":2469.92,\"isMyGroup\":0,\"scoreTop\":4,\"groupTop\":4},{\"rightsTop\":5,\"groupId\":2109,\"groupName\":\"第6组\",\"groupRights\":2687.48,\"profitTop\":6,\"groupScore\":28664.66,\"groupImgUrl\":\"\",\"groupProfit\":1690.4,\"isMyGroup\":0,\"scoreTop\":5,\"groupTop\":5},{\"rightsTop\":6,\"groupId\":2104,\"groupName\":\"第1组\",\"groupRights\":2555.0,\"profitTop\":11,\"groupScore\":27113.66,\"groupImgUrl\":\"\",\"groupProfit\":1081.36,\"isMyGroup\":0,\"scoreTop\":6,\"groupTop\":6},{\"rightsTop\":7,\"groupId\":2113,\"groupName\":\"第10组\",\"groupRights\":2414.84,\"profitTop\":5,\"groupScore\":24810.07,\"groupImgUrl\":\"\",\"groupProfit\":1915.64,\"isMyGroup\":0,\"scoreTop\":7,\"groupTop\":7},{\"rightsTop\":9,\"groupId\":2112,\"groupName\":\"第9组\",\"groupRights\":2229.72,\"profitTop\":9,\"groupScore\":23733.14,\"groupImgUrl\":\"\",\"groupProfit\":1234.8,\"isMyGroup\":0,\"scoreTop\":8,\"groupTop\":8},{\"rightsTop\":8,\"groupId\":2111,\"groupName\":\"第8组\",\"groupRights\":2317.04,\"profitTop\":12,\"groupScore\":23568.93,\"groupImgUrl\":\"\",\"groupProfit\":1062.12,\"isMyGroup\":0,\"scoreTop\":9,\"groupTop\":9},{\"rightsTop\":11,\"groupId\":2122,\"groupName\":\"第19组\",\"groupRights\":2125.52,\"profitTop\":8,\"groupScore\":21306.21,\"groupImgUrl\":\"\",\"groupProfit\":1266.52,\"isMyGroup\":0,\"scoreTop\":10,\"groupTop\":10},{\"rightsTop\":10,\"groupId\":2108,\"groupName\":\"第5组\",\"groupRights\":2133.08,\"profitTop\":10,\"groupScore\":21300.94,\"groupImgUrl\":\"\",\"groupProfit\":1225.28,\"isMyGroup\":0,\"scoreTop\":11,\"groupTop\":11},{\"rightsTop\":12,\"groupId\":2123,\"groupName\":\"第20组\",\"groupRights\":1926.84,\"profitTop\":7,\"groupScore\":17553.51,\"groupImgUrl\":\"\",\"groupProfit\":1438.84,\"isMyGroup\":0,\"scoreTop\":12,\"groupTop\":12},{\"rightsTop\":13,\"groupId\":2115,\"groupName\":\"第12组\",\"groupRights\":1445.4,\"profitTop\":14,\"groupScore\":14410.64,\"groupImgUrl\":\"\",\"groupProfit\":932.4,\"isMyGroup\":0,\"scoreTop\":13,\"groupTop\":13},{\"rightsTop\":14,\"groupId\":2105,\"groupName\":\"第2组\",\"groupRights\":1419.56,\"profitTop\":15,\"groupScore\":13409.16,\"groupImgUrl\":\"\",\"groupProfit\":689.68,\"isMyGroup\":0,\"scoreTop\":14,\"groupTop\":14},{\"rightsTop\":15,\"groupId\":2125,\"groupName\":\"第22组\",\"groupRights\":1073.4,\"profitTop\":13,\"groupScore\":10980.88,\"groupImgUrl\":\"\",\"groupProfit\":1050.0,\"isMyGroup\":0,\"scoreTop\":15,\"groupTop\":15},{\"rightsTop\":16,\"groupId\":2124,\"groupName\":\"第21组\",\"groupRights\":920.25,\"profitTop\":18,\"groupScore\":4465.05,\"groupImgUrl\":\"\",\"groupProfit\":-327.75,\"isMyGroup\":0,\"scoreTop\":16,\"groupTop\":16},{\"rightsTop\":18,\"groupId\":2114,\"groupName\":\"第11组\",\"groupRights\":446.0,\"profitTop\":17,\"groupScore\":3255.8,\"groupImgUrl\":\"\",\"groupProfit\":-145.0,\"isMyGroup\":1,\"scoreTop\":17,\"groupTop\":17},{\"rightsTop\":17,\"groupId\":2117,\"groupName\":\"第14组\",\"groupRights\":724.0,\"profitTop\":16,\"groupScore\":2368.93,\"groupImgUrl\":\"\",\"groupProfit\":26.6,\"isMyGroup\":0,\"scoreTop\":18,\"groupTop\":18},{\"rightsTop\":19,\"groupId\":2118,\"groupName\":\"第15组\",\"groupRights\":143.12,\"profitTop\":21,\"groupScore\":244.74,\"groupImgUrl\":\"\",\"groupProfit\":-1471.6,\"isMyGroup\":0,\"scoreTop\":19,\"groupTop\":19},{\"rightsTop\":21,\"groupId\":2120,\"groupName\":\"第17组\",\"groupRights\":-330.9,\"profitTop\":22,\"groupScore\":-371.27,\"groupImgUrl\":\"\",\"groupProfit\":-1474.7,\"isMyGroup\":0,\"scoreTop\":20,\"groupTop\":20},{\"rightsTop\":20,\"groupId\":2107,\"groupName\":\"第4组\",\"groupRights\":-79.11,\"profitTop\":20,\"groupScore\":-655.98,\"groupImgUrl\":\"\",\"groupProfit\":-1162.15,\"isMyGroup\":0,\"scoreTop\":21,\"groupTop\":21},{\"rightsTop\":22,\"groupId\":2119,\"groupName\":\"第16组\",\"groupRights\":-579.4,\"profitTop\":19,\"groupScore\":-1075.37,\"groupImgUrl\":\"\",\"groupProfit\":-811.0,\"isMyGroup\":0,\"scoreTop\":22,\"groupTop\":22}]}\n";
        new JsonParser().parseScore(text).stream().forEach(System.out::println);
    }

//    @Test
//    public void test_parseSpy() {
//        String text = "{\"hasbuy\":0,\"code\":0,\"msg\":\"\",\"busInfos\":[{\"groupRunYear\":2,\"prodLine\":\"X4_4_P1,X1_4_P1,X1_4_P1,X1_4_P1,X1_4_P1,X1_4_P1,X1_4_P1,X1_4_P1,X1_4_P1,X1_4_P1,X1_4_P1,X1_4_P1,X1_4_P1,X1_4_P1,X1_4_P1,X1_4_P1\",\"groupName\":\"第19组\",\"payable\":0,\"shorttemLoan\":100,\"receivable\":100,\"groupRunMonth\":12,\"longtermLoan\":2140,\"groupRunDay\":30,\"buyInfoMonth\":-1,\"material\":\"R1_0,R3_0,R4_0\",\"buyInfoDay\":-1,\"product\":\"P1_0,P3_3\",\"groupId\":\"298\",\"certificate\":\"S1_1,S2_1,S3_3,S4_3,S5_3,ZS1_3,ZS2_3,P1_1,P2_1,P3_1,P4_2,P5_2\",\"buyInfoYear\":-1,\"cash\":-155.35,\"worker\":\"GR1_50,GR2_50,GR3_30\",\"factory\":\"CF1_3,CF2_3,CF3_3,CF4_3\"}]}";
//        System.out.println(new JsonParser().parseSpy(text));
//    }

    @Test
    public void test_parseOrder() {
        String text = "{\"code\":0,\"orderResults\":[{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2105,\"pSysId\":\"P2\",\"pDeliveryDay\":30,\"myOrderCount\":2,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":92.0,\"pDeliveryMonth\":6,\"orderResult\":\"第2组_2\",\"pOrderNum\":\"YC27\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2107,\"pSysId\":\"P4\",\"pDeliveryDay\":1,\"myOrderCount\":7,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":171.0,\"pDeliveryMonth\":7,\"orderResult\":\"第4组_7\",\"pOrderNum\":\"YC15\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2118,\"pSysId\":\"P4\",\"pDeliveryDay\":1,\"myOrderCount\":7,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":171.0,\"pDeliveryMonth\":7,\"orderResult\":\"第15组_7\",\"pOrderNum\":\"YC15\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2116,\"pSysId\":\"P4\",\"pDeliveryDay\":1,\"myOrderCount\":6,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":171.0,\"pDeliveryMonth\":7,\"orderResult\":\"第13组_6\",\"pOrderNum\":\"YC15\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2119,\"pSysId\":\"P4\",\"pDeliveryDay\":1,\"myOrderCount\":6,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":171.0,\"pDeliveryMonth\":7,\"orderResult\":\"第16组_6\",\"pOrderNum\":\"YC15\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2121,\"pSysId\":\"P4\",\"pDeliveryDay\":1,\"myOrderCount\":6,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":171.0,\"pDeliveryMonth\":7,\"orderResult\":\"第18组_6\",\"pOrderNum\":\"YC15\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2110,\"pSysId\":\"P4\",\"pDeliveryDay\":1,\"myOrderCount\":5,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":171.0,\"pDeliveryMonth\":7,\"orderResult\":\"第7组_5\",\"pOrderNum\":\"YC15\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2120,\"pSysId\":\"P4\",\"pDeliveryDay\":1,\"myOrderCount\":4,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":171.0,\"pDeliveryMonth\":7,\"orderResult\":\"第17组_4\",\"pOrderNum\":\"YC15\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2117,\"pSysId\":\"P4\",\"pDeliveryDay\":1,\"myOrderCount\":3,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":171.0,\"pDeliveryMonth\":7,\"orderResult\":\"第14组_3\",\"pOrderNum\":\"YC15\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2108,\"pSysId\":\"P3\",\"pDeliveryDay\":1,\"myOrderCount\":6,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":120.0,\"pDeliveryMonth\":7,\"orderResult\":\"第5组_6\",\"pOrderNum\":\"YC33\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2124,\"pSysId\":\"P3\",\"pDeliveryDay\":1,\"myOrderCount\":6,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":120.0,\"pDeliveryMonth\":7,\"orderResult\":\"第21组_6\",\"pOrderNum\":\"YC33\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2122,\"pSysId\":\"P3\",\"pDeliveryDay\":1,\"myOrderCount\":4,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":120.0,\"pDeliveryMonth\":7,\"orderResult\":\"第19组_4\",\"pOrderNum\":\"YC33\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2105,\"pSysId\":\"P3\",\"pDeliveryDay\":1,\"myOrderCount\":2,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":120.0,\"pDeliveryMonth\":7,\"orderResult\":\"第2组_2\",\"pOrderNum\":\"YC33\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2117,\"pSysId\":\"P3\",\"pDeliveryDay\":1,\"myOrderCount\":1,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":120.0,\"pDeliveryMonth\":7,\"orderResult\":\"第14组_1\",\"pOrderNum\":\"YC33\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2109,\"pSysId\":\"P3\",\"pDeliveryDay\":1,\"myOrderCount\":6,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":118.0,\"pDeliveryMonth\":7,\"orderResult\":\"第6组_6\",\"pOrderNum\":\"YC34\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2113,\"pSysId\":\"P3\",\"pDeliveryDay\":1,\"myOrderCount\":6,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":118.0,\"pDeliveryMonth\":7,\"orderResult\":\"第10组_6\",\"pOrderNum\":\"YC34\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2123,\"pSysId\":\"P3\",\"pDeliveryDay\":1,\"myOrderCount\":4,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":118.0,\"pDeliveryMonth\":7,\"orderResult\":\"第20组_4\",\"pOrderNum\":\"YC34\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2112,\"pSysId\":\"P3\",\"pDeliveryDay\":1,\"myOrderCount\":3,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":103.0,\"pDeliveryMonth\":7,\"orderResult\":\"第9组_3\",\"pOrderNum\":\"YC12\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2119,\"pSysId\":\"P2\",\"pDeliveryDay\":1,\"myOrderCount\":5,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":102.0,\"pDeliveryMonth\":7,\"orderResult\":\"第16组_5\",\"pOrderNum\":\"YC5\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2112,\"pSysId\":\"P2\",\"pDeliveryDay\":1,\"myOrderCount\":3,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":102.0,\"pDeliveryMonth\":7,\"orderResult\":\"第9组_3\",\"pOrderNum\":\"YC5\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2115,\"pSysId\":\"P1\",\"pDeliveryDay\":1,\"myOrderCount\":1,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":71.0,\"pDeliveryMonth\":7,\"orderResult\":\"第12组_1\",\"pOrderNum\":\"YC2\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2124,\"pSysId\":\"P1\",\"pDeliveryDay\":1,\"myOrderCount\":2,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":65.0,\"pDeliveryMonth\":7,\"orderResult\":\"第21组_2\",\"pOrderNum\":\"YC23\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2105,\"pSysId\":\"P1\",\"pDeliveryDay\":1,\"myOrderCount\":1,\"pPaymentTerm\":30,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":65.0,\"pDeliveryMonth\":7,\"orderResult\":\"第2组_1\",\"pOrderNum\":\"YC23\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2104,\"pSysId\":\"P4\",\"pDeliveryDay\":21,\"myOrderCount\":6,\"pPaymentTerm\":26,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":167.0,\"pDeliveryMonth\":7,\"orderResult\":\"第1组_6\",\"pOrderNum\":\"YC40\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2106,\"pSysId\":\"P4\",\"pDeliveryDay\":21,\"myOrderCount\":6,\"pPaymentTerm\":26,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":167.0,\"pDeliveryMonth\":7,\"orderResult\":\"第3组_6\",\"pOrderNum\":\"YC40\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2111,\"pSysId\":\"P4\",\"pDeliveryDay\":21,\"myOrderCount\":6,\"pPaymentTerm\":26,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":167.0,\"pDeliveryMonth\":7,\"orderResult\":\"第8组_6\",\"pOrderNum\":\"YC40\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2105,\"pSysId\":\"P4\",\"pDeliveryDay\":21,\"myOrderCount\":1,\"pPaymentTerm\":26,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":167.0,\"pDeliveryMonth\":7,\"orderResult\":\"第2组_1\",\"pOrderNum\":\"YC40\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2115,\"pSysId\":\"P1\",\"pDeliveryDay\":23,\"myOrderCount\":1,\"pPaymentTerm\":26,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":58.0,\"pDeliveryMonth\":7,\"orderResult\":\"第12组_1\",\"pOrderNum\":\"YC3\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2109,\"pSysId\":\"P2\",\"pDeliveryDay\":19,\"myOrderCount\":6,\"pPaymentTerm\":22,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":90.0,\"pDeliveryMonth\":8,\"orderResult\":\"第6组_6\",\"pOrderNum\":\"YC29\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2113,\"pSysId\":\"P2\",\"pDeliveryDay\":19,\"myOrderCount\":6,\"pPaymentTerm\":22,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":90.0,\"pDeliveryMonth\":8,\"orderResult\":\"第10组_6\",\"pOrderNum\":\"YC29\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2116,\"pSysId\":\"P2\",\"pDeliveryDay\":19,\"myOrderCount\":6,\"pPaymentTerm\":22,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":90.0,\"pDeliveryMonth\":8,\"orderResult\":\"第13组_6\",\"pOrderNum\":\"YC29\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2121,\"pSysId\":\"P2\",\"pDeliveryDay\":19,\"myOrderCount\":6,\"pPaymentTerm\":22,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":90.0,\"pDeliveryMonth\":8,\"orderResult\":\"第18组_6\",\"pOrderNum\":\"YC29\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2112,\"pSysId\":\"P2\",\"pDeliveryDay\":19,\"myOrderCount\":3,\"pPaymentTerm\":22,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":90.0,\"pDeliveryMonth\":8,\"orderResult\":\"第9组_3\",\"pOrderNum\":\"YC29\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2105,\"pSysId\":\"P2\",\"pDeliveryDay\":19,\"myOrderCount\":2,\"pPaymentTerm\":22,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":90.0,\"pDeliveryMonth\":8,\"orderResult\":\"第2组_2\",\"pOrderNum\":\"YC29\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2123,\"pSysId\":\"P2\",\"pDeliveryDay\":19,\"myOrderCount\":2,\"pPaymentTerm\":22,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":90.0,\"pDeliveryMonth\":8,\"orderResult\":\"第20组_2\",\"pOrderNum\":\"YC29\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2125,\"pSysId\":\"P1\",\"pDeliveryDay\":23,\"myOrderCount\":12,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":55.0,\"pDeliveryMonth\":9,\"orderResult\":\"第22组_12\",\"pOrderNum\":\"YC1\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2110,\"pSysId\":\"P3\",\"pDeliveryDay\":29,\"myOrderCount\":5,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":91.0,\"pDeliveryMonth\":9,\"orderResult\":\"第7组_5\",\"pOrderNum\":\"YC13\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2108,\"pSysId\":\"P3\",\"pDeliveryDay\":29,\"myOrderCount\":3,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":91.0,\"pDeliveryMonth\":9,\"orderResult\":\"第5组_3\",\"pOrderNum\":\"YC13\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2115,\"pSysId\":\"P1\",\"pDeliveryDay\":10,\"myOrderCount\":2,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":52.0,\"pDeliveryMonth\":10,\"orderResult\":\"第12组_2\",\"pOrderNum\":\"YC25\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2118,\"pSysId\":\"P3\",\"pDeliveryDay\":11,\"myOrderCount\":7,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":109.0,\"pDeliveryMonth\":10,\"orderResult\":\"第15组_7\",\"pOrderNum\":\"YC36\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2104,\"pSysId\":\"P3\",\"pDeliveryDay\":11,\"myOrderCount\":6,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":109.0,\"pDeliveryMonth\":10,\"orderResult\":\"第1组_6\",\"pOrderNum\":\"YC36\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2106,\"pSysId\":\"P3\",\"pDeliveryDay\":11,\"myOrderCount\":6,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":109.0,\"pDeliveryMonth\":10,\"orderResult\":\"第3组_6\",\"pOrderNum\":\"YC36\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2113,\"pSysId\":\"P3\",\"pDeliveryDay\":11,\"myOrderCount\":6,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":109.0,\"pDeliveryMonth\":10,\"orderResult\":\"第10组_6\",\"pOrderNum\":\"YC36\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2107,\"pSysId\":\"P3\",\"pDeliveryDay\":11,\"myOrderCount\":4,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":109.0,\"pDeliveryMonth\":10,\"orderResult\":\"第4组_4\",\"pOrderNum\":\"YC36\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2122,\"pSysId\":\"P3\",\"pDeliveryDay\":11,\"myOrderCount\":4,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":109.0,\"pDeliveryMonth\":10,\"orderResult\":\"第19组_4\",\"pOrderNum\":\"YC36\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2112,\"pSysId\":\"P3\",\"pDeliveryDay\":11,\"myOrderCount\":3,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":109.0,\"pDeliveryMonth\":10,\"orderResult\":\"第9组_3\",\"pOrderNum\":\"YC36\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2105,\"pSysId\":\"P3\",\"pDeliveryDay\":11,\"myOrderCount\":2,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":109.0,\"pDeliveryMonth\":10,\"orderResult\":\"第2组_2\",\"pOrderNum\":\"YC36\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2123,\"pSysId\":\"P3\",\"pDeliveryDay\":11,\"myOrderCount\":2,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":109.0,\"pDeliveryMonth\":10,\"orderResult\":\"第20组_2\",\"pOrderNum\":\"YC36\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2119,\"pSysId\":\"P5\",\"pDeliveryDay\":12,\"myOrderCount\":7,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":141.0,\"pDeliveryMonth\":10,\"orderResult\":\"第16组_7\",\"pOrderNum\":\"YC46\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2117,\"pSysId\":\"P5\",\"pDeliveryDay\":12,\"myOrderCount\":2,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":141.0,\"pDeliveryMonth\":10,\"orderResult\":\"第14组_2\",\"pOrderNum\":\"YC46\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2124,\"pSysId\":\"P3\",\"pDeliveryDay\":17,\"myOrderCount\":8,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":111.0,\"pDeliveryMonth\":10,\"orderResult\":\"第21组_8\",\"pOrderNum\":\"YC37\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2104,\"pSysId\":\"P3\",\"pDeliveryDay\":17,\"myOrderCount\":6,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":111.0,\"pDeliveryMonth\":10,\"orderResult\":\"第1组_6\",\"pOrderNum\":\"YC37\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2106,\"pSysId\":\"P3\",\"pDeliveryDay\":17,\"myOrderCount\":6,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":111.0,\"pDeliveryMonth\":10,\"orderResult\":\"第3组_6\",\"pOrderNum\":\"YC37\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2111,\"pSysId\":\"P3\",\"pDeliveryDay\":17,\"myOrderCount\":6,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":111.0,\"pDeliveryMonth\":10,\"orderResult\":\"第8组_6\",\"pOrderNum\":\"YC37\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2122,\"pSysId\":\"P3\",\"pDeliveryDay\":17,\"myOrderCount\":4,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":111.0,\"pDeliveryMonth\":10,\"orderResult\":\"第19组_4\",\"pOrderNum\":\"YC37\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2112,\"pSysId\":\"P3\",\"pDeliveryDay\":17,\"myOrderCount\":3,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":111.0,\"pDeliveryMonth\":10,\"orderResult\":\"第9组_3\",\"pOrderNum\":\"YC37\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2105,\"pSysId\":\"P3\",\"pDeliveryDay\":17,\"myOrderCount\":2,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":111.0,\"pDeliveryMonth\":10,\"orderResult\":\"第2组_2\",\"pOrderNum\":\"YC37\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2111,\"pSysId\":\"P4\",\"pDeliveryDay\":19,\"myOrderCount\":6,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":150.0,\"pDeliveryMonth\":10,\"orderResult\":\"第8组_6\",\"pOrderNum\":\"YC41\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2105,\"pSysId\":\"P4\",\"pDeliveryDay\":19,\"myOrderCount\":2,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":150.0,\"pDeliveryMonth\":10,\"orderResult\":\"第2组_2\",\"pOrderNum\":\"YC41\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2120,\"pSysId\":\"P4\",\"pDeliveryDay\":2,\"myOrderCount\":8,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":139.0,\"pDeliveryMonth\":11,\"orderResult\":\"第17组_8\",\"pOrderNum\":\"YC16\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2118,\"pSysId\":\"P4\",\"pDeliveryDay\":2,\"myOrderCount\":7,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":139.0,\"pDeliveryMonth\":11,\"orderResult\":\"第15组_7\",\"pOrderNum\":\"YC16\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2109,\"pSysId\":\"P4\",\"pDeliveryDay\":2,\"myOrderCount\":6,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":139.0,\"pDeliveryMonth\":11,\"orderResult\":\"第6组_6\",\"pOrderNum\":\"YC16\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2116,\"pSysId\":\"P4\",\"pDeliveryDay\":2,\"myOrderCount\":6,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":139.0,\"pDeliveryMonth\":11,\"orderResult\":\"第13组_6\",\"pOrderNum\":\"YC16\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2119,\"pSysId\":\"P4\",\"pDeliveryDay\":2,\"myOrderCount\":6,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":139.0,\"pDeliveryMonth\":11,\"orderResult\":\"第16组_6\",\"pOrderNum\":\"YC16\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2121,\"pSysId\":\"P4\",\"pDeliveryDay\":2,\"myOrderCount\":6,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":139.0,\"pDeliveryMonth\":11,\"orderResult\":\"第18组_6\",\"pOrderNum\":\"YC16\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2110,\"pSysId\":\"P4\",\"pDeliveryDay\":2,\"myOrderCount\":5,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":139.0,\"pDeliveryMonth\":11,\"orderResult\":\"第7组_5\",\"pOrderNum\":\"YC16\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2111,\"pSysId\":\"P4\",\"pDeliveryDay\":2,\"myOrderCount\":4,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":139.0,\"pDeliveryMonth\":11,\"orderResult\":\"第8组_4\",\"pOrderNum\":\"YC16\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2125,\"pSysId\":\"P4\",\"pDeliveryDay\":2,\"myOrderCount\":2,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":139.0,\"pDeliveryMonth\":11,\"orderResult\":\"第22组_2\",\"pOrderNum\":\"YC16\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2107,\"pSysId\":\"P2\",\"pDeliveryDay\":22,\"myOrderCount\":7,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":70.0,\"pDeliveryMonth\":11,\"orderResult\":\"第4组_7\",\"pOrderNum\":\"YC32\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2112,\"pSysId\":\"P2\",\"pDeliveryDay\":22,\"myOrderCount\":3,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":70.0,\"pDeliveryMonth\":11,\"orderResult\":\"第9组_3\",\"pOrderNum\":\"YC32\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2105,\"pSysId\":\"P2\",\"pDeliveryDay\":22,\"myOrderCount\":2,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":70.0,\"pDeliveryMonth\":11,\"orderResult\":\"第2组_2\",\"pOrderNum\":\"YC32\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2123,\"pSysId\":\"P2\",\"pDeliveryDay\":22,\"myOrderCount\":2,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":70.0,\"pDeliveryMonth\":11,\"orderResult\":\"第20组_2\",\"pOrderNum\":\"YC32\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2113,\"pSysId\":\"P1\",\"pDeliveryDay\":3,\"myOrderCount\":4,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":55.0,\"pDeliveryMonth\":12,\"orderResult\":\"第10组_4\",\"pOrderNum\":\"YC26\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2105,\"pSysId\":\"P1\",\"pDeliveryDay\":3,\"myOrderCount\":3,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":55.0,\"pDeliveryMonth\":12,\"orderResult\":\"第2组_3\",\"pOrderNum\":\"YC26\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2107,\"pSysId\":\"P1\",\"pDeliveryDay\":3,\"myOrderCount\":3,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":55.0,\"pDeliveryMonth\":12,\"orderResult\":\"第4组_3\",\"pOrderNum\":\"YC26\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2124,\"pSysId\":\"P3\",\"pDeliveryDay\":20,\"myOrderCount\":8,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":108.0,\"pDeliveryMonth\":12,\"orderResult\":\"第21组_8\",\"pOrderNum\":\"YC35\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2104,\"pSysId\":\"P3\",\"pDeliveryDay\":20,\"myOrderCount\":6,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":108.0,\"pDeliveryMonth\":12,\"orderResult\":\"第1组_6\",\"pOrderNum\":\"YC35\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2106,\"pSysId\":\"P3\",\"pDeliveryDay\":20,\"myOrderCount\":6,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":108.0,\"pDeliveryMonth\":12,\"orderResult\":\"第3组_6\",\"pOrderNum\":\"YC35\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2111,\"pSysId\":\"P3\",\"pDeliveryDay\":20,\"myOrderCount\":6,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":108.0,\"pDeliveryMonth\":12,\"orderResult\":\"第8组_6\",\"pOrderNum\":\"YC35\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2110,\"pSysId\":\"P3\",\"pDeliveryDay\":20,\"myOrderCount\":5,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":108.0,\"pDeliveryMonth\":12,\"orderResult\":\"第7组_5\",\"pOrderNum\":\"YC35\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2122,\"pSysId\":\"P3\",\"pDeliveryDay\":20,\"myOrderCount\":4,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":108.0,\"pDeliveryMonth\":12,\"orderResult\":\"第19组_4\",\"pOrderNum\":\"YC35\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2112,\"pSysId\":\"P3\",\"pDeliveryDay\":20,\"myOrderCount\":3,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":108.0,\"pDeliveryMonth\":12,\"orderResult\":\"第9组_3\",\"pOrderNum\":\"YC35\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2105,\"pSysId\":\"P3\",\"pDeliveryDay\":20,\"myOrderCount\":2,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":108.0,\"pDeliveryMonth\":12,\"orderResult\":\"第2组_2\",\"pOrderNum\":\"YC35\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2113,\"pSysId\":\"P3\",\"pDeliveryDay\":20,\"myOrderCount\":2,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S2\",\"pPerFee\":108.0,\"pDeliveryMonth\":12,\"orderResult\":\"第10组_2\",\"pOrderNum\":\"YC35\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2116,\"pSysId\":\"P2\",\"pDeliveryDay\":20,\"myOrderCount\":6,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":82.0,\"pDeliveryMonth\":12,\"orderResult\":\"第13组_6\",\"pOrderNum\":\"YC8\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2121,\"pSysId\":\"P2\",\"pDeliveryDay\":20,\"myOrderCount\":6,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":82.0,\"pDeliveryMonth\":12,\"orderResult\":\"第18组_6\",\"pOrderNum\":\"YC8\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2120,\"pSysId\":\"P2\",\"pDeliveryDay\":20,\"myOrderCount\":4,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":82.0,\"pDeliveryMonth\":12,\"orderResult\":\"第17组_4\",\"pOrderNum\":\"YC8\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2112,\"pSysId\":\"P2\",\"pDeliveryDay\":20,\"myOrderCount\":3,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":82.0,\"pDeliveryMonth\":12,\"orderResult\":\"第9组_3\",\"pOrderNum\":\"YC8\"},{\"pOrderId\":\"\",\"pDeliveryYear\":1,\"gSysId\":2118,\"pSysId\":\"P2\",\"pDeliveryDay\":20,\"myOrderCount\":1,\"pPaymentTerm\":20,\"pISOSysId\":\"0\",\"pISOName\":\"\",\"sSysId\":\"S1\",\"pPerFee\":82.0,\"pDeliveryMonth\":12,\"orderResult\":\"第15组_1\",\"pOrderNum\":\"YC8\"}],\"msg\":\"\"}\n";
        System.out.println(new JsonParser().parseOrder(text));
    }


}
