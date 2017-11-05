package cn;

import java.util.Scanner;

public class ChotaChecksum {
    int[] add(int a[],int b[]){
        int c=0;
        int x[]=new int[a.length];
        for(int i=0;i<a.length;i++)
        {
            x[i]=a[i]+b[i]+c;
            if(x[i]>1)
                c=1;
            else
                c=0;
            x[i]%=2;
        }
        return x;
    }
    
    int[] complement(int a[])
    {
        int x[]=new int[a.length];
        for(int i=0;i<a.length;i++)
            x[i]=(a[i]+1)%2;
        return x;
    }
     void calc() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of bits in a frame");
        int n=sc.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];
        int c[]=new int[n];
        int d[]=new int[n];
         System.out.println("AT SENDER:: ");
        System.out.println("Enter frame 1 sent");
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println("Enter frame 2 sent");
        for(int i=0;i<n;i++)
            b[i]=sc.nextInt();
        c=add(a,b);
        d=complement(c);
         System.out.print("Checksum = ");
         for(int i : d)
             System.out.print(i);
         System.out.println("");
         System.out.println("AT RECIEVER::");
          System.out.println("Enter frame 1 recieved");
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println("Enter frame 2 recieved");
        for(int i=0;i<n;i++)
            b[i]=sc.nextInt();
        System.out.println("Enter checksum  recieved");
        for(int i=0;i<n;i++)
            c[i]=sc.nextInt();
        d=add(a,b);
        a=add(c,d);
        b=complement(a);
        int flag=0;
        for(int i: b)
            if(i==1)
            {
                flag=1;
                break;
            }
        if(flag==0)
             System.out.println("FRAMES ACCEPTED");
        else
             System.out.println("FRAMES REJECTED AS ERROR DETECTED");
        
    }
     public static void main(String[] args) {
        ChotaChecksum a1=new ChotaChecksum();
        a1.calc();
    }
}
