package cn;
import java.util.Scanner;
public class StopNWait{
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
        int s=0;
        int r=0;
        int i=0;
        while(i<=4)
        {
            System.out.println("SENDER::");
            System.out.println("Sending Frame "+s);           
            System.out.println("");
            
            System.out.println("RECIEVER::");
            if(s!=r){
                System.out.println("Discard Frame ");
                System.out.println("Send Acknoledgement "+r);
            }
            else
            {
                System.out.println("1: Lost Or Error 2: Timeout 3:Frame Accepted");
                if(sc.nextInt()==3){
                r=(r+1)%2;
                System.out.println("Send ACK"+r);
                }
            }
                        
            System.out.println("");
            System.out.println("SENDER::");
            System.out.println("1: Recieved ACK 2: Timeout");
            if(sc.nextInt()==1)
                s=r;
               
          i++;      
        }
    }
}