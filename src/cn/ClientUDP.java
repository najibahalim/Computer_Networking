
package cn;

import java.net.*;
import  java.io.*;
public class ClientUDP extends Thread{
    DatagramPacket dp1;
    DatagramSocket ds1;
    InputStreamReader ir;
    BufferedReader br1;
    ClientUDP(){
        try{
            ir=new InputStreamReader(System.in);
            br1=new BufferedReader(ir);
            ds1=new DatagramSocket(1200);
            start();
            System.out.println("Client UDP");
            ClientInner cl=new ClientInner();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void run(){
        try{
            while(true){
                String p=br1.readLine();
                byte b[]=p.getBytes();
                dp1=new DatagramPacket(b, b.length, InetAddress.getLocalHost(),(1400));
                ds1.send(dp1);
            }
                
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        new ClientUDP();
    }
    class ClientInner extends Thread{
        DatagramPacket dp2;
        ClientInner(){
            start();
        }
        public void run(){
            try{
                while(true){
                    byte b2[]=new byte[1024];
                    dp2=new DatagramPacket(b2,b2.length);
                    ds1.receive(dp2);
                    String p=new String(b2,0,b2.length);
                    System.out.println("Message from Server: "+p.trim());
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
