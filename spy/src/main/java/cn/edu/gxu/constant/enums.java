package cn.edu.gxu.constant;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.constant
 * @date 2021/3/13 22:28
 * @Description
 */
public class enums {

    public enum Product {
        P1("P1"),
        P2("P2"),
        P3("P3"),
        P4("P4"),
        P5("P5");
        public String product;

        Product(String product) {
            this.product = product;
        }

        public boolean check(String productName) {
            return product.equals(productName);
        }

        public static Product exchange(String product) {
            for (Product p : Product.values()) {
                if (p.product.equals(product)) return p;
            }
            return P1;
        }
    }

    public enum Material {
        R1("R1"),
        R2("R2"),
        R3("R3"),
        R4("R4"),
        R5("R5");
        public String material;

        Material(String material) {
            this.material = material;
        }
    }

    public enum ProdLine {
        SGX_X1("X1", "手工线"),//手工线
        QZD_X3("X3", "全自动"),//全自动
        RX_X4("X4", "柔线");//柔线
        public String line;
        public String name;

        ProdLine(String line, String name) {
            this.line = line;
            this.name = name;
        }

        public static ProdLine getByLine(String line) {
            for (ProdLine prodLine : ProdLine.values()) {
                if (prodLine.line.equals(line))
                    return prodLine;
            }
            return QZD_X3;
        }
    }

    public enums.CertificateStatus LocalMarket;
    //区域
    public enums.CertificateStatus regionalMarket;
    //国内
    public enums.CertificateStatus domesticMarket;
    //亚洲
    public enums.CertificateStatus asiaMarket;
    //国际
    public enums.CertificateStatus globalMarket;


    public enum Market {
        LOCAL_MARKET_1("S1", "本地"),
        REGIONAL_MARKET_2("S2", "区域"),
        DOMESTIC_MARKET_3("S3", "国内"),
        ASIA_MARKET_4("S4", "亚洲"),
        GLOBAL_MARKET_5("S5", "国际");

        public String sSysId;
        public String marketName;

        Market(String sSysId, String marketName) {
            this.sSysId = sSysId;
            this.marketName = marketName;
        }

        public static Market exchange(String sSysId) {
            for (Market m : Market.values()) {
                if (m.sSysId.equals(sSysId)) {
                    return m;
                }
            }
            return LOCAL_MARKET_1;
        }

    }

    public enum LineStatus {
        BUILD_1(1, "在建"),
        DISCONTINUED_2(2, "停产"),
        ONLINE_4(4, "在产");

        public Integer status;
        public String remark;

        LineStatus(Integer status, String remark) {
            this.status = status;
            this.remark = remark;
        }

        public static LineStatus getByStatus(Integer status) {
            for (LineStatus lineStatus : LineStatus.values()) {
                if (lineStatus.status.equals(status)) {
                    return lineStatus;
                }
            }
            return ONLINE_4;
        }
    }

    public enum FactoryStatus {
        NOT_OWNED_1(1, "未拥有"),
        BUY_2(2, "购买"),
        RENT_3(3, "租用");

        public int status;
        public String remark;

        FactoryStatus(int status, String remark) {
            this.status = status;
            this.remark = remark;
        }
    }

    public enum GroupRunYear {
        YEAR_1(1, "第一年"),
        YEAR_2(2, "第二年"),
        YEAR_3(3, "第三年"),
        YEAR_4(4, "第四年"),
        YEAR_5(5, "第五年"),
        YEAR_6(6, "第六年");

        public Integer year;
        public String yearText;

        GroupRunYear(Integer year, String yearText) {
            this.year = year;
            this.yearText = yearText;
        }
    }

    public enum CertificateStatus {
        COMPLETE_1(1, "已完成"),
        RESEARCH_2(2, "研发中"),
        UN_RESEARCH_3(3, "未开发");
        public Integer status;
        public String remark;

        CertificateStatus(Integer status, String remark) {
            this.status = status;
            this.remark = remark;
        }

        public static CertificateStatus change(int status) {
            for (CertificateStatus certificateStatus : CertificateStatus.values()) {
                if (status == certificateStatus.status) {
                    return certificateStatus;
                }
            }
            return null;
        }

    }

    public enum SpyType {
        SCORE(1),//年度经营结果
        RESULT(2);//每个对手间谍

        public int type;

        SpyType(int type) {
            this.type = type;
        }
    }

}
