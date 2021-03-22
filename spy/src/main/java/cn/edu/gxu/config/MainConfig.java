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

//    //    贷款倍数
//    public static int loanTimes = 2;
//    public static int sgxProductTimes = 100;
//    public static int qzdProductTimes = 60;
//    public static int rxProductTimes = 48;
//    //折旧
//    public static int sgxDepreciation = 15;
//    public static int qzdDepreciation = 22;
//    public static int rxDepreciation = 30;
//    //维修费
//    public static int sgxUpKeep = 5;
//    public static int qzdUpKeep = 15;
//    public static int rxUpKeep = 20;
//    //管理费
//    public static int administration = 60;

    //    贷款利率
    public static float longLoanRate = (float) 0.1;
    public static float shortLoanRate = (float) 0.05;


    public static float DefaultTax= (float) 0.2;
}
