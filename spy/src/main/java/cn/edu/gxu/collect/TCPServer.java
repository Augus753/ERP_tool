package cn.edu.gxu.collect;

import org.pcap4j.core.*;

import java.net.InetAddress;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.collect
 * @date 2021/3/26 17:50
 * @Description https://blog.csdn.net/weixin_45208256/article/details/111797696
 */
public class TCPServer {
    public static void Pcap4j(InetAddress addr) {
        {
            //1.Pcap抓取不 了本地127的包
            //2.本地Socket不用127网段的包无法与服务端通信
            try {
                PcapNetworkInterface nif = Pcaps.getDevByAddress(addr);
                int snaplen = 64 * 1024;
                int timeout = 50;
                //初始化抓包器
                PcapHandle.Builder phb = new PcapHandle.Builder(nif.getName()).snaplen(snaplen)
                        .promiscuousMode(PcapNetworkInterface.PromiscuousMode.PROMISCUOUS).timeoutMillis(timeout)
                        .bufferSize(1 * 1024 * 1024);
                PcapHandle handle = phb.build();
                /** 设置TCP过滤规则 */
                String filter = "tcp and port 7788";//过滤条件是tcp数据包，端口号为7788
                handle.setFilter(filter, BpfProgram.BpfCompileMode.OPTIMIZE);
                PacketListener listener = new PacketListener() {
                    @Override
                    public void gotPacket(org.pcap4j.packet.Packet packet) {
                        System.out.println(packet);
                        System.out.println("-----------------------------------------");
                    }

                };
                handle.loop(3, listener);//loop里设置抓3个数据包，要无限抓设置-1
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
