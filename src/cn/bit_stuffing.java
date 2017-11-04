package cn;
import java.util.*;
public class bit_stuffing {
	public static void main(String arg[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enater the binary message");
		String data=sc.nextLine();
		String res=new String();
		String out=new String();
		int count=0;
		
		for(int i=0;i<data.length();i++) {
			if(data.charAt(i)!='0' && data.charAt(i)!='1') {
				System.out.println("Enter only Binary number");
				return;
			}
		}
		for(int i=0;i<data.length();i++) {
			if(data.charAt(i)=='1') {
				count++;
				res = res + data.charAt(i);
			}
			else {
				count=0;
				res= res + data.charAt(i);
			}
			if(count==5) {
				res = res + '0';
				count=0;
			}
		}
		
		String trans="01111110"+res+"01111110";
		System.out.println("The message to be transfered : "+trans);
		System.out.println("Sending message....");
		count=0;
		for(int i=0;i<res.length();i++) {
			if(res.charAt(i)=='1') {
				count++;
				out = out + res.charAt(i);
			}
			else {
				out = out + res.charAt(i);
				count=0;
			}
			if(count==5) {
				i++;
                                count=0;
			}
		}
		System.out.println("Message Received... Successfully");
		System.out.println("The Destuffed message is : "+out);
	}
}
