package cn.edu.gxu.config;

import cn.edu.gxu.constant.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.config
 * @date 2021/3/20 16:34
 * @Description
 */
public class MainConfig {

    public static final String[] GROUP_NAME = new String[]{
            "第1组",
            "第2组",
            "第3组",
            "第4组",
            "第5组",
            "第6组",
            "第7组",
            "第8组",
            "第9组",
            "第10组",
            "第11组",
            "第12组",
            "第13组",
            "第14组",
            "第15组",
            "第16组",
            "第17组",
            "第18组",
            "第19组",
            "第20组",
            "第21组",
            "第22组",
            "第23组",
            "第24组",
            "第25组"
    };

    public static final String[] MONTH_NAME = new String[]{
            "1，2",
            "3，4",
            "5，6",
            "7，8",
            "9，10",
            "11，12"
    };

    public static final String[] RUN_YEAR = new String[]{
            "第一年",
            "第二年",
            "第三年",
            "第四年",
            "第五年",
            "第六年",
    };

    //最好用注解反射
    public static Map<enums.Product, enums.CertificateStatus> CERT_MAP = new HashMap();

}
