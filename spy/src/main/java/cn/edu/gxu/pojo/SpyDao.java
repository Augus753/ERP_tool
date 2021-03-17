package cn.edu.gxu.pojo;

import cn.edu.gxu.constant.enums;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 第九空间
 * @version V1.0
 * @Package cn.edu.gxu.pojo
 * @date 2021/3/13 21:47
 * @Description 间谍
 * groupRunYear    int	年份
 * prodLine		生产线	“X3_2_P4,X3_2_P4,X3_2_P4,X4_4_P5”表示3条自动停产和1条柔线在产	“X4_4_P5,X4_1_P5”表示1条柔线在产、1条柔线在建			X3：自动		X4_4：柔线在产
 * groupName	String	组名							X4_1：柔线在建
 * payable									X4_2：柔线停产
 * shorttemLoan		短贷
 * receivable
 * groupRunMonth
 * longtermLoan		长贷
 * groupRunDay
 * buyInfoMonth
 * material		原料库	R1_0,R2_0,R3_0,R4_0
 * buyInfoDay
 * product		产品库	P2_1,P3_3,P4_2表示1个P2、3个P3、2个P4
 * groupId
 * certificate		研发	“S1_1,S2_1,S3_1,S4_3,S5_3,ZS1_3,ZS2_3,P1_3,P2_1,P3_1,P4_1,P5_1”
 * buyInfoYear			S1：本地，S2：区域		P1：3未开发，1已开发，ZS1：3未开发
 * cash		盘面资金
 * worker
 * factory		厂房	"CF1_3,CF2_3,CF3_3,CF4_1"，3租用，1未拥有
 */
public class SpyDao {
    public Integer groupRunYear;
    public ProdLine prodLine;
    public String groupName;
    public Integer shorttemLoan;
    public Integer longtermLoan;
    public String material;
    public Product product;
    public Certificate certificate;
    public Integer cash;
    public Factory factory;


    public Integer getGroupRunYear() {
        return groupRunYear;
    }

    public void setGroupRunYear(Integer groupRunYear) {
        this.groupRunYear = groupRunYear;
    }

    public ProdLine getProdLine() {
        return prodLine;
    }

    public void setProdLine(ProdLine prodLine) {
        this.prodLine = prodLine;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getShorttemLoan() {
        return shorttemLoan;
    }

    public void setShorttemLoan(Integer shorttemLoan) {
        this.shorttemLoan = shorttemLoan;
    }

    public Integer getLongtermLoan() {
        return longtermLoan;
    }

    public void setLongtermLoan(Integer longtermLoan) {
        this.longtermLoan = longtermLoan;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public void formatFactory(String factoryText) {
        String[] parts = factoryText.split(",");
        this.factory = new Factory();
        for (String part : parts) {
            String[] a = part.split("_");
            if (enums.FactoryStatus.NOT_OWNED.status == NumberUtils.toInt(a[1])) {
                this.factory.notOwnedNum += 1;
            } else if (enums.FactoryStatus.BUY.status == NumberUtils.toInt(a[1])) {
                this.factory.buyNum += 1;
            } else if (enums.FactoryStatus.RENT.status == NumberUtils.toInt(a[1])) {
                this.factory.rentNum += 1;
            }
        }
    }

    public void formatProduct(String factoryText) {
        String[] parts = factoryText.split(",");
        this.product = new Product();
        for (String part : parts) {
            String[] a = part.split("_");
            String name = StringUtils.toRootUpperCase(a[0]);
            int num = NumberUtils.toInt(a[1]);
            if (enums.Product.P1.check(name)) {
                this.product.p1Num += num;
            } else if (enums.Product.P2.check(name)) {
                this.product.p2Num += num;
            } else if (enums.Product.P3.check(name)) {
                this.product.p3Num += num;
            } else if (enums.Product.P4.check(name)) {
                this.product.p4Num += num;
            } else if (enums.Product.P5.check(name)) {
                this.product.p5Num += num;
            }
        }
    }

    public void formatProductLine(String prodLine) {
        this.prodLine = new ProdLine();
        String[] parts = prodLine.split(",");
        Map<String, Integer> detail = new HashMap<>();
        for (String part : parts) {
            String[] a = part.split("_");
//            X4_2_P2
            String productLineName = StringUtils.toRootUpperCase(a[0]);
            int status = NumberUtils.toInt(a[1]);
            String productName = StringUtils.toRootUpperCase(a[2]);
            if (enums.ProdLine.X1.name().equals(productLineName)) {
                this.prodLine.sgx++;
            } else if (enums.ProdLine.X3.name().equals(productLineName)) {
                this.prodLine.qzd++;
            } else if (enums.ProdLine.X4.name().equals(productLineName)) {
                this.prodLine.rx++;
            }
        }
    }

    public class Factory {
        public int notOwnedNum;
        public int buyNum;
        public int rentNum;

        public Factory() {
        }

        public int getNotOwnedNum() {
            return notOwnedNum;
        }

        public void setNotOwnedNum(int notOwnedNum) {
            this.notOwnedNum = notOwnedNum;
        }

        public int getBuyNum() {
            return buyNum;
        }

        public void setBuyNum(int buyNum) {
            this.buyNum = buyNum;
        }

        public int getRentNum() {
            return rentNum;
        }

        public void setRentNum(int rentNum) {
            this.rentNum = rentNum;
        }

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }
    }


    public class Product {
        public int p1Num;
        public int p2Num;
        public int p3Num;
        public int p4Num;
        public int p5Num;

        public Product() {
        }

        public int getP1Num() {
            return p1Num;
        }

        public void setP1Num(int p1Num) {
            this.p1Num = p1Num;
        }

        public int getP2Num() {
            return p2Num;
        }

        public void setP2Num(int p2Num) {
            this.p2Num = p2Num;
        }

        public int getP3Num() {
            return p3Num;
        }

        public void setP3Num(int p3Num) {
            this.p3Num = p3Num;
        }

        public int getP4Num() {
            return p4Num;
        }

        public void setP4Num(int p4Num) {
            this.p4Num = p4Num;
        }

        public int getP5Num() {
            return p5Num;
        }

        public void setP5Num(int p5Num) {
            this.p5Num = p5Num;
        }
    }

    public class ProdLine {
        public Map<String, Integer> detail;
        public int sgx;
        public int rx;
        public int qzd;

        public Map<String, Integer> getDetail() {
            return detail;
        }

        public void setDetail(Map<String, Integer> detail) {
            this.detail = detail;
        }

        public int getSgx() {
            return sgx;
        }

        public void setSgx(int sgx) {
            this.sgx = sgx;
        }

        public int getRx() {
            return rx;
        }

        public void setRx(int rx) {
            this.rx = rx;
        }

        public int getQzd() {
            return qzd;
        }

        public void setQzd(int qzd) {
            this.qzd = qzd;
        }

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
