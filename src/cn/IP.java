import java.util.*;
public class ip {
	public static void main(String arg[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the ip address");
		String ip=sc.nextLine();
		String[] div= ip.split("\\.");
		int c1=Integer.parseInt(div[0]);
		//System.out.println(c1);
		char cs='X';
		if(c1>=0 && c1<=127) {
			cs='A';
		}
		else if(c1>=128 && c1<=191) {
			cs='B';
		}
		else if(c1>=192 && c1<=223) {
			cs='C';
		}
		else if(c1>=224 && c1<=239) {
			cs='D';
		}
		else if(c1>=240 && c1<=255) {
			cs='E';
		}
		String m;
		switch(cs) {
			case 'A' :{
				m="255.0.0.0";
				break;
			}
			case 'B' :{
				m="255.255.0.0";
				break;
			}
			case 'C' :{
				m="255.255.255.0";
				break;
			}
			case 'D' :{
				m="Multicasting";
				break;
			}
			case 'E' :{
				m="Future Use";
				break;
			}
			default:m="invalid";
				break;
			}
		System.out.println("class :: "+cs +"\nsubnet:: "+m);
	}
}