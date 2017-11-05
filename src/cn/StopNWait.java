package cn;

import java.util.Scanner;

public class StopNWait{
    Scanner sc=new Scanner(System.in);
    class Sender{
        int no1;
        void sendFrame(){
            System.out.println("Frame "+no1+" Transmitted");
        }
        void recieveAck(int x){
            no1=(no1+1)%2;
            if(x!=no1)
                Discard(x);
            else{
                System.out.println("Acknolegdement "+x+" Recieved");
                sendFrame();
            }
               
        }
        void Timeout(){
            sendFrame();
        }
        void Discard(int x){
            System.out.println("Acknoledgement "+x+" Discarded");
            no1=(no1+1)%2;
        }
        
    }
  
    class Reciever{
        int no2;
        void recieveFrame(int x){
            if(x!=no2)
                disacard(x);
            System.out.println("Press 1 if No error in Frame Else 0");
            if(sc.nextInt()==1){
                System.out.println("Frame "+x+" Recieved");
                sendAck();
            }
                
        }
        void sendAck(){
            no2=(no2+1)%2;
            System.out.println("Acknoledgement sent= "+no2);
        }
        void disacard(int x){
            System.out.println("Frame "+x+ " Discarded");
        }
    }
    void calc(){
        Sender s=new Sender();
        Reciever r=new Reciever();
        int t=0;
        while(t<=4){
            System.out.println("SENDER::");
        s.sendFrame();
        
        System.out.println("RECIEVER::");
        System.out.println("Press 1 if Frame Arrived..Else press 0");
        if(sc.nextInt()==1)
            r.recieveFrame(s.no1);
        else
            s.Timeout();
        
        System.out.println("SENDER::");
        System.out.println("Press 1 if Acknoledgement Arrived..Else press 0");
        if(sc.nextInt()==1)
            s.recieveAck(r.no2);
        else
            s.Timeout();
        t++;
        }
        
        
           
    }
    public static void main(String[] args) {
        new StopNWait().calc();
    }
}