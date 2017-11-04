package cn;
import java.net.*;
import java.io.*;

public class ClientTCP extends Thread {
    Socket s;
    InputStreamReader i;
    BufferedReader br;
    PrintWriter pw;
    ClientTCP(){
        try{
            s=new Socket(InetAddress.getLocalHost(),1200);
            i=new InputStreamReader(System.in);
            br=new BufferedReader(i);
            pw=new PrintWriter(s.getOutputStream(),true);
            start();
            System.out.println("CLIENT");
            ClientInner m=new ClientInner();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void run(){
        try{
            while(true){
                String s=br.readLine();
                pw.println(s);
                if(s.equals("quit"))
                    break;
            }
        }
        catch(Exception e){
            System.out.println("2"+e.getMessage());
        }
    }
    public static void main(String[] args) {
        ClientTCP x=new ClientTCP();
    }
    class ClientInner extends Thread{
        InputStreamReader i2;
        BufferedReader br2;
        ClientInner()
        {
            try{
                i2=new InputStreamReader(s.getInputStream());
                br2=new BufferedReader(i2);
                start();
            }catch(Exception e){
               System.out.println(e.getMessage());
            }
        }
        public void run(){
            try{
                while(true){
                    String p=br2.readLine();
                    System.out.println("Msg from Server: "+p);
                     if(p.equals("quit"))
                    break;
                    
            }
        }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
    }
}
    }
