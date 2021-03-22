package cn.edu.gxu.pojo;

import cn.edu.gxu.constant.enums;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.pojo
 * @date 2021/3/22 9:22
 * @Description
 */
public class TestCertificate {

    @Test
    public void test_showProduct() {
        Certificate cert = new Certificate();
        cert.p1 = enums.CertificateStatus.YEAR_1;
        cert.p2 = enums.CertificateStatus.YEAR_2;
        cert.p3 = enums.CertificateStatus.YEAR_3;
        cert.p4 = enums.CertificateStatus.YEAR_1;

//        System.out.println(cert.p1);
        System.out.println(cert.showProduct());
    }
}
