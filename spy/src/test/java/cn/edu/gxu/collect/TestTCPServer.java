//package cn.edu.gxu.collect;
//
//import org.junit.Test;
//
//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.ServerSocket;
//import java.net.Socket;
//
///**
// * @author atom.hu
// * @version V1.0
// * @Package cn.edu.gxu.collect
// * @date 2021/3/26 17:54
// * @Description
// */
//public class TestTCPServer {
//
//    @Test
//    public void test_TCPClient() throws IOException {
//        Socket socket = new Socket("39.105.139.232", 3003);
//        System.out.println("客户端连接成功");
//        socket.close();
//
//    }
//
//    @Test
//    public void test_Server() throws IOException {
////        39.105.139.232:3003
//        ServerSocket serverSocket = new ServerSocket(3003);
//        System.out.println("建立服务端");
//
//        InetAddress addr = InetAddress.getLocalHost();
//        TCPServer.Pcap4j(addr);
//
//        Socket socket = serverSocket.accept();
//        System.out.println("连接成功");
//        socket.close();
//        serverSocket.close();
//    }
//
//    @Test
//    public void test_Pcap4j() throws IOException {
//        InetAddress addr = InetAddress.getLocalHost();
//        TCPServer.Pcap4j(addr);
//    }
//}
