package cn.edu.gxu.pojo;

import cn.edu.gxu.persist.CacheManager;
import cn.edu.gxu.stat.JsonParser;
import org.junit.Test;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.pojo
 * @date 2021/3/22 9:22
 * @Description
 */
public class TestCertificatePojo {

    @Test
    public void test_showProduct() {
        String text = "S1_1,S2_1,S3_1,S4_2,S5_2,ZS1_1,ZS2_2,P1_1,P2_1,P3_1,P4_2,P5_1";
        CertificatePojo cert = new CertificatePojo();
        cert.format(text);
        System.out.println(cert);
        System.out.println(cert.showProduct());

        String text1 = "S1_1,S2_1,S3_2,S4_2,S5_3,ZS1_2,ZS2_2,P1_1,P2_3,P3_1,P4_1,P5_2";
        cert.format(text1);
        System.out.println(cert);
        System.out.println(cert.showProduct());
    }

    @Test
    public void test_aaa() throws Exception {
        String text = "{\"hasbuy\":0,\"code\":0,\"msg\":\"\",\"busInfos\":[{\"groupRunYear\":2,\"prodLine\":\"X4_4_P1,X4_4_P1,X4_4_P1,X4_4_P1,X4_4_P3,X4_4_P3,X4_4_P3,X4_4_P3,X4_4_P2,X4_4_P2,X4_4_P2,X4_4_P2\",\"groupName\":\"第1组\",\"payable\":0,\"shorttemLoan\":10,\"receivable\":456,\"groupRunMonth\":12,\"longtermLoan\":2680,\"groupRunDay\":30,\"buyInfoMonth\":-1,\"material\":\"R1_0,R2_0,R3_0,R4_0\",\"buyInfoDay\":-1,\"product\":\"P1_0,P2_4,P3_0\",\"groupId\":\"642\",\"certificate\":\"S1_1,S2_1,S3_1,S4_3,S5_3,ZS1_1,ZS2_3,P1_1,P2_1,P3_1,P4_2,P5_3\",\"buyInfoYear\":-1,\"cash\":836.16,\"worker\":\"GR1_50,GR2_50,GR3_30\",\"factory\":\"CF1_3,CF2_3,CF3_3,CF4_1\"}]}\n";
        SpyPo spy = new JsonParser().parseSpy(text);
        CacheManager.setSpy("第1组", spy);
        CacheManager.flush();
        System.out.println(new JsonParser().parseSpy(text).certificate.domesticMarket);
    }
}
