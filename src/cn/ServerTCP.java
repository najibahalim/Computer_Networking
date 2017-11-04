package cn;
import java.net.*;
import java.io.*;
public class ServerTCP extends Thread{
    ServerSocket ss;
    Socket s1;
    InputStreamReader i1;
    BufferedReader br1;
    
    ServerTCP(){
        try{
            ss=new ServerSocket(1200);
        s1=ss.accept();
        i1=new InputStreamReader(s1.getInputStream());
        br1=new BufferedReader(i1);
        start();    
        System.out.println("SERVER");
            ServerInner w=new ServerInner();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    public void run(){
        try{
            while(true){
                String p=br1.readLine();
                System.out.println("Msg From Client "+p);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        ServerTCP y=new ServerTCP();
    }
    class ServerInner extends Thread{
        InputStreamReader i3;
        BufferedReader br3;
        PrintWriter pw3;
        ServerInner(){
            try{
                i3=new InputStreamReader(System.in);
                br3=new BufferedReader(i3);
                pw3=new PrintWriter(s1.getOutputStream(),true);
                start();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        public void run(){
            try{
                while(true){
                    String s=br3.readLine();
                    pw3.println(s);
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
               
                
                
    }
}
