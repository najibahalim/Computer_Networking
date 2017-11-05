package cn;
import java.util.*;
class Crc{
    int[] divide(int[] divisor, int[] dividend)
    {
        int n=dividend.length;
        int[] remainder=new int[n];
        System.arraycopy(dividend, 0, remainder, 0,n);
        int start=0;
        int end=divisor.length-1;
        while(end<n)
        {
            if(remainder[start]!=0)
            {
                for(int i=start,j=0;i<=end;i++,j++)
                {
                    remainder[i]=divisor[j]^remainder[i];
                }                
            }
            start++;
            end++;
        }
        return remainder;
    }
    void calc() {
        int i;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of bits of Divisor");
        int n=sc.nextInt();
        int r=n-1;
        int divisor[]=new int[n];
        System.out.println("Enter the Divisor");
        for(i=0;i<n;i++)
            divisor[i]=sc.nextInt();
        
        System.out.println("SENDER::Enter the no of bits of Dataword");
        int m=sc.nextInt();
        int data[]=new int[m+r];
        System.out.println("Enter the Dataword");
        for(i=0;i<m;i++)
            data[i]=sc.nextInt();
 
        int rem[]=divide(divisor,data);
        i=m+r-1;
        while(i>=m)
        {
            data[i]=rem[i];
            i--;
        }
        System.out.println("CODEWORD::");
        for(int p:data)
            System.out.print(p);
        System.out.println("");
        
        System.out.println("AT RECIVER:: Enter the recieved codeword");
        for(i=0;i<m+r;i++)
            data[i]=sc.nextInt();
        rem=divide(divisor, data);
        System.out.println("Syndrome:: ");
        for(i=0;i<m+r;i++){
            System.out.print(rem[i]);
        }
        System.out.println("");
        boolean flag=true;
        for(int p:rem)
            if(p==1)
            {
                System.out.println("REJECT MESSAGE AS SYNDROME NOT EQUAL TO 0");
                flag=false;
                break;
            }
        if(flag)
            System.out.println("ACCEPT MESSAGE AS SYNDROME EQUAL TO 0");
        
    }
    public static void main(String[] args) {
        new Crc().calc();       
    }
}