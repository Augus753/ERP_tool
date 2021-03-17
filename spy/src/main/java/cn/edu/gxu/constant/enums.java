package cn.edu.gxu.constant;

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
        X1("X1"),//手工线
        X3("X3"),//全自动
        X4("X4");//柔线
        public String line;

        ProdLine(String line) {
            this.line = line;
        }
    }

    public enum LineStatus {
        BUILD(1, "在建"),
        DISCONTINUED(2, "停产"),
        ONLINE(4, "在产");

        public Integer status;
        public String remark;

        LineStatus(Integer status, String remark) {
            this.status = status;
            this.remark = remark;
        }
    }

    public enum FactoryStatus {
        NOT_OWNED(1, "未拥有"),
        BUY(2, "购买"),
        RENT(3, "租用");

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
        YEAR_1(1, "已完成"),
        YEAR_2(2, "研发中"),
        YEAR_3(3, "未开发");

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
}
