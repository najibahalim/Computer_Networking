package cn;
import java.net.*;
import java.io.*;
public class ServerUDP extends Thread{
    DatagramPacket dp2;
    DatagramSocket ds2;
    ServerUDP(){
        try{
            ds2=new DatagramSocket(1400);
            start();
            System.out.println("Server UDP");
            ServerUDPInner s1=new ServerUDPInner();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void run(){
        try{
            while(true){
                byte bs[]=new byte[1024];
                dp2=new DatagramPacket(bs, bs.length);
                ds2.receive(dp2);
                String s=new String(bs,0,bs.length);
                System.out.println("Message from Client: "+s.trim());
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        new ServerUDP();
    }
    class ServerUDPInner extends Thread{
        InputStreamReader ir;
        BufferedReader br;
        DatagramPacket dp1;
        ServerUDPInner(){
            try{
                ir=new InputStreamReader(System.in);
                br=new BufferedReader(ir);
                start();
            }
            catch(Exception e){
                System.out.println("1"+e.getMessage());
            }
        }
                public void run(){
                    try{
                        while(true){
                            String p=br.readLine();
                            byte bs2[]=p.getBytes();
                            dp1=new DatagramPacket(bs2, bs2.length, InetAddress.getLocalHost(),(1200));
                            ds2.send(dp1);
                        }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                
    }
}
