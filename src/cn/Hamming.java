package cn;

import java.util.Scanner;

public class Hamming {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("SENDER::::");
        System.out.println("Enter 4-Bit Data");
        int data[]=new int[8];
        for(int i=7;i>=4;i--)
            data[i]=sc.nextInt();
        data[3]=data[4];
        data[1]=data[3]^data[5]^data[7];
        data[2]=data[3]^data[6]^data[7];
        data[4]=data[5]^data[6]^data[7];
        System.out.println("The 7-bit Hamming code is:::");
        for(int i=7;i>=1;i--)
            System.out.print(data[i]+" ");
        
        System.out.println("");
        System.out.println("");
        System.out.println("RECIEVER::::");
        System.out.println("Enter 7-bit recieved data");
        for(int i=7;i>=1;i--)
            data[i]=sc.nextInt();
        int s0=data[1]^data[3]^data[5]^data[7];
        int s1=data[2]^data[3]^data[6]^data[7];
        int s2=data[4]^data[5]^data[6]^data[7];
        int y=s0+2*s1+4*s2;
        if(y==0){
            System.out.println("No Error");
            System.out.println("DataWord Accepted- "+data[7]+" "+data[6]+" "+data[5]+" "+data[3]);
        }
        else{
             System.out.println("Error At position "+y);
             System.out.println("Invert Bit "+y);
             data[y]=(data[y]+1)%2;
            System.out.println("DataWord Accepted- "+data[7]+" "+data[6]+" "+data[5]+" "+data[3]);
        }
    }
}
