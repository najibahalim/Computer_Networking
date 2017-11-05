package cn;	
import java.util.*;
public class GoBack {
    int window;
    int no;
    void calc()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no of Sequence numbers: ");
        no=sc.nextInt();
        System.out.print("Please enter the Window Size: "); 
        int start=0;
        window = sc.nextInt();
        int end=window-1;
        System.out.println("SENDER:::");
	while(true){
            transmit(start,window);
            System.out.println("RECIEVER:::");
            System.out.println("Enter 1 for any lost or damaged frame recieved  ELSE enter 0 to send Positive Acknoledegement");
            int p=sc.nextInt();
            if(p==1)
            {
                System.out.println("Enter the sequence no For negative Acknoledgement");
                p=sc.nextInt();
                start=p;
                end=(start+window-1)%no;
                System.out.println("SENDER:::");
                System.out.println("NEGATIVE ACKNOLEDGEMENT RECIEVED; WINDOW SLIDED TO POSITION "+start);
                continue;
            }
            
            start=(end+1)%no;
            end=(start+window-1)%no;
            System.out.println("SENDER:::");
            System.out.println("POSITIVE ACKNOLEDGEMENT RECIEVED; WINDOW SLIDED TO POSITION "+start);
            System.out.println("Press 1 to continue transmission Else press 0");
            if(sc.nextInt()!=1)
                break;
        }
	
    }
    void transmit(int start,int n){
        for(int i=0;i<n;i++)
        {
            System.out.println("Frame "+start+" Transmitted");
            start++;
            start=start%no;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        new GoBack().calc();
    }
    
    

}

