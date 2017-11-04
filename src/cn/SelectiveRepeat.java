package cn;
import java.util.Scanner;
/**
 @author Najiba
 */
public class SelectiveRepeat {
    int size_of_buffer;
    int cs=0,cr=0;
    int ack;
    Scanner sc=new Scanner(System.in);
    int buff[];
    boolean flag[];
    int hold=0;
    boolean f=true;
    int cr0=0;
    
    SelectiveRepeat(){
        System.out.println("Enter the size of Buffer ");
        this.size_of_buffer=sc.nextInt();
        buff=new int[size_of_buffer];
        flag=new boolean[size_of_buffer];
    }
    void sendpacket(int x){
        cs=x;
        System.out.println("Packet sent with sequence no "+cs);
        cs=(cs+1)%size_of_buffer;
    }
    
    int sendAck(){
        System.out.println("Enter 1 for Positive Acknolodgement -1 For Negative else 0");
        int x=sc.nextInt();
        int b=0;

        if(x!=0)
        {
            System.out.println("Enter the Acknoledgement no");
            b=sc.nextInt();
        }
        switch (x) {
            case 1:
                return b+1;
            case -1:
                return b-2*b-1;
            default:
                return Integer.MAX_VALUE;
        }
                  
    }
    
    
    
    int updateBuffer(int n){
        int i=0;
        while(buff[i]!=n)
            i++;
        int re=i;
        int j=0;
        i=(i+1);
        while(i<size_of_buffer)
        {
            buff[j]=buff[i];
            flag[j]=true;
            i++;
        }
        while(j<size_of_buffer)
        {
            flag[j]=false;
            j++;
        }
        return re;
    }
    
   
    
    void recievePacket(int x){
        if(x==cr && hold<=size_of_buffer)
        {
            System.out.println("Packet reached Successfully");
            if(f)
            {
                flag[hold]=true;
                buff[hold]=x;
                hold=(hold+1)%size_of_buffer;
            }
            else
            {
                 f=true;
                 cr=cr0;
            }
            
        }
        else if(hold>size_of_buffer)
            System.out.println("Discard Packet! No Additional Space in Buffer. ");
        else
            System.out.println("Discard Packet!");
        
            int xx=sendAck();
            if(xx>=1 && xx<=size_of_buffer)
            {
                hold=updateBuffer(xx-1);
  
            }
                
            else if(xx<0){
                cr0=cr;
                 System.out.println("Frame "+(xx+1) +" contains error! Resend it");
                 cr=Math.abs(xx+1);
                 f=false;
                 
            }
            
            if(xx>0)
                cr=(cr+1)%size_of_buffer;
            }  
            
        
        
    
    
    void execute(){
       int x=0;
        while(x!=-1){
        System.out.println("Sender="+cs+" reciever="+cr);
        System.out.println("Enter the Sequence no of the packet to send (Press -1 to Quit!)");
        x=sc.nextInt();
        sendpacket(x);
        recievePacket(x);  
    }     
}
    public static void main(String[] args) {
        GoBackN g=new GoBackN();
        g.execute();
        
    }
}
/*OUTPUT
Enter the size of Buffer 
3
Sender=0 reciever=0
Enter the Sequence no of the packet to send (Press -1 to Quit!)
0
Packet sent with sequence no 0
Packet reached Successfully
Enter 1 for Positive Acknolodgement -1 For Negative else 0
0
Sender=1 reciever=1
Enter the Sequence no of the packet to send (Press -1 to Quit!)
1
Packet sent with sequence no 1
Packet reached Successfully
Enter 1 for Positive Acknolodgement -1 For Negative else 0
-1
Enter the Acknoledgement no
0
Frame 0 contains error! Resend it
Sender=2 reciever=0
Enter the Sequence no of the packet to send (Press -1 to Quit!)
0
Packet sent with sequence no 0
Packet reached Successfully
Enter 1 for Positive Acknolodgement -1 For Negative else 0
0
Sender=1 reciever=1
Enter the Sequence no of the packet to send (Press -1 to Quit!)
1
Packet sent with sequence no 1
Packet reached Successfully
Enter 1 for Positive Acknolodgement -1 For Negative else 0
0
Sender=2 reciever=2
Enter the Sequence no of the packet to send (Press -1 to Quit!)
2
Packet sent with sequence no 2
Packet reached Successfully
Enter 1 for Positive Acknolodgement -1 For Negative else 0
1
Enter the Acknoledgement no
2
Sender=0 reciever=0
Enter the Sequence no of the packet to send (Press -1 to Quit!)
-1
Packet sent with sequence no -1
Discard Packet!
Enter 1 for Positive Acknolodgement -1 For Negative else 0
0
BUILD SUCCESSFUL (total time: 2 minutes 23 seconds)

*/
