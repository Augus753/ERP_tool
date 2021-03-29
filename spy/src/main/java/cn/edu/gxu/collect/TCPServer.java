//package cn.edu.gxu.collect;
//
//import org.pcap4j.core.*;
//import org.pcap4j.packet.Packet;
//
//import java.net.InetAddress;
//import java.util.Arrays;
//
///**
// * @author atom.hu
// * @version V1.0
// * @Package cn.edu.gxu.collect
// * @date 2021/3/26 17:50
// * @Description https://blog.csdn.net/weixin_45208256/article/details/111797696
// */
//public class TCPServer {
//    public static void Pcap4j(InetAddress addr) {
//        {
//            //1.Pcap抓取不 了本地127的包
//            //2.本地Socket不用127网段的包无法与服务端通信
//            try {
//                PcapNetworkInterface nif = Pcaps.getDevByAddress(addr);
//                int snaplen = 64 * 1024;
//                int timeout = 50;
//                //初始化抓包器
//                PcapHandle.Builder phb = new PcapHandle.Builder(nif.getName()).snaplen(snaplen)
//                        .promiscuousMode(PcapNetworkInterface.PromiscuousMode.PROMISCUOUS).timeoutMillis(timeout)
//                        .bufferSize(1 * 1024 * 1024);
//                PcapHandle handle = phb.build();
//                /** 设置TCP过滤规则 */
//                String filter = "tcp and port 3004";//过滤条件是tcp数据包，端口号为7788
//                handle.setFilter(filter, BpfProgram.BpfCompileMode.OPTIMIZE);
//                PacketListener listener = packet -> {
//                    System.out.println(Arrays.toString(packet.getRawData()));
//
//                    {
//                        Packet payload = packet.getPayload();
//                        if (payload != null) {
////                            System.out.println(BinaryToHexString(payload.getRawData()));
////                            String hex=HexConversion.printHexString(payload.getRawData(),packet.getRawData().length);
//                        }
//
//                    }
//
//                    System.out.println("-----------------------------------------");
//                };
//
//
//                handle.loop(-1, listener);//loop里设置抓3个数据包，要无限抓设置-1
//
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    //将字节数组转换为16进制字符串
//    public static String BinaryToHexString(byte[] bytes) {
//        String hexStr = "0123456789ABCDEF";
//        String result = "";
//        String hex = "";
//        for (byte b : bytes) {
//            hex = String.valueOf(hexStr.charAt((b & 0xF0) >> 4));
//            hex += String.valueOf(hexStr.charAt(b & 0x0F));
//            result += hex + " ";
//        }
//        return result;
//    }
//
//}
