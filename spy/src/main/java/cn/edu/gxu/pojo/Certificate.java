package cn.edu.gxu.pojo;

import cn.edu.gxu.constant.enums;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.pojo
 * @date 2021/3/13 22:45
 * @Description
 */
public class Certificate {
    //本地
    public enums.CertificateStatus LocalMarket;
    //区域
    public enums.CertificateStatus regionalMarket;
    //国内
    public enums.CertificateStatus domesticMarket;
    //亚洲
    public enums.CertificateStatus asiaMarket;
    //国际
    public enums.CertificateStatus globalMarket;
    //9k
    public enums.CertificateStatus k9;
    //14k
    public enums.CertificateStatus k14;
    public enums.CertificateStatus p1;
    public enums.CertificateStatus p2;
    public enums.CertificateStatus p3;
    public enums.CertificateStatus p4;
    public enums.CertificateStatus p5;

    public enums.CertificateStatus getLocalMarket() {
        return LocalMarket;
    }

    public void setLocalMarket(enums.CertificateStatus localMarket) {
        LocalMarket = localMarket;
    }

    public enums.CertificateStatus getRegionalMarket() {
        return regionalMarket;
    }

    public void setRegionalMarket(enums.CertificateStatus regionalMarket) {
        this.regionalMarket = regionalMarket;
    }

    public enums.CertificateStatus getDomesticMarket() {
        return domesticMarket;
    }

    public void setDomesticMarket(enums.CertificateStatus domesticMarket) {
        this.domesticMarket = domesticMarket;
    }

    public enums.CertificateStatus getAsiaMarket() {
        return asiaMarket;
    }

    public void setAsiaMarket(enums.CertificateStatus asiaMarket) {
        this.asiaMarket = asiaMarket;
    }

    public enums.CertificateStatus getGlobalMarket() {
        return globalMarket;
    }

    public void setGlobalMarket(enums.CertificateStatus globalMarket) {
        this.globalMarket = globalMarket;
    }

    public enums.CertificateStatus getK9() {
        return k9;
    }

    public void setK9(enums.CertificateStatus k9) {
        this.k9 = k9;
    }

    public enums.CertificateStatus getK14() {
        return k14;
    }

    public void setK14(enums.CertificateStatus k14) {
        this.k14 = k14;
    }

    public enums.CertificateStatus getP1() {
        return p1;
    }

    public void setP1(enums.CertificateStatus p1) {
        this.p1 = p1;
    }

    public enums.CertificateStatus getP2() {
        return p2;
    }

    public void setP2(enums.CertificateStatus p2) {
        this.p2 = p2;
    }

    public enums.CertificateStatus getP3() {
        return p3;
    }

    public void setP3(enums.CertificateStatus p3) {
        this.p3 = p3;
    }

    public enums.CertificateStatus getP4() {
        return p4;
    }

    public void setP4(enums.CertificateStatus p4) {
        this.p4 = p4;
    }

    public enums.CertificateStatus getP5() {
        return p5;
    }

    public void setP5(enums.CertificateStatus p5) {
        this.p5 = p5;
    }

    //"S1_1,S2_1,S3_1,S4_1,S5_2,ZS1_2,ZS2_2,P1_3,P2_1,P3_1,P4_1,P5_1"
    public Certificate format(String text) {
        String[] parts = text.split(",");
        for (String part : parts) {
            String[] a = part.split("_");
            enums.CertificateStatus certificateStatus = enums.CertificateStatus.change(NumberUtils.toInt(a[1]));
            switch (a[0]) {
                case "S1":
                    this.LocalMarket = certificateStatus;
                    break;
                case "S2":
                    this.regionalMarket = certificateStatus;
                    break;
                case "S3":
                    this.domesticMarket = certificateStatus;
                    break;
                case "S4":
                    this.asiaMarket = certificateStatus;
                    break;
                case "S5":
                    this.globalMarket = certificateStatus;
                    break;
                case "ZS1":
                    this.k9 = certificateStatus;
                    break;
                case "ZS2":
                    this.k14 = certificateStatus;
                    break;
                case "P1":
                    this.p1 = certificateStatus;
                    break;
                case "P2":
                    this.p2 = certificateStatus;
                    break;
                case "P3":
                    this.p3 = certificateStatus;
                    break;
                case "P4":
                    this.p4 = certificateStatus;
                    break;
                case "P5":
                    this.p5 = certificateStatus;
                    break;
            }
        }
        return this;
    }

}
