package cn.edu.gxu.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.constant
 * @date 2021/3/18 15:42
 * @Description
 */
public class Constant {
    //最大展示的广告排名
    public static final int MAX_AD_NUM = 20;
    //最大展示的经营结果排名
    public static final int MAX_SCORE_NUM = 25;
    //间谍预览中显示的最小产品数
    public static final int MIN_PRODUCT_NUM = 3;

    //P1成本
    public static final int P1_COST = 20;
    //P2成本
    public static final int P2_COST = 30;
    //P3成本
    public static final int P3_COST = 40;
    //P4成本
    public static final int P4_COST = 50;
    //P5成本
    public static final int P5_COST = 60;

    public static int getCost(String productName) {
        if (StringUtils.isBlank(productName)) return 0;
        productName = productName.toUpperCase();
        if (enums.Product.P1.product.equals(productName)) {
            return P1_COST;
        } else if (enums.Product.P2.product.equals(productName)) {
            return P2_COST;
        } else if (enums.Product.P3.product.equals(productName)) {
            return P3_COST;
        } else if (enums.Product.P4.product.equals(productName)) {
            return P4_COST;
        } else if (enums.Product.P5.product.equals(productName)) {
            return P5_COST;
        }
        return 0;
    }

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



    //    贷款利率
    public static float longLoanRate = (float) 0.1;
    public static float shortLoanRate = (float) 0.05;

    //所得税率
    public static float DefaultTax = (float) 0.2;
}
