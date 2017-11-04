import java.util.Scanner;

/**
 * Created by amitujha on 04-11-2017.
 */
public class Checksum {
     public static void main(String[] args) {
          Check_send c=new Check_send();
          c.setfno();
          c.setFrame1();
          c.setFrame2();
          c.add();
          c.Checks();
          c.print();
          Check_receive r=new Check_receive();
          r.setfno(c.getFno());
          r.setFrame1();
          r.setFrame2();
          r.getCheck(c.getCheck());
          r.add();
          r.Checks();
          r.valid();

     }
}
class Check_send{

     private int[] frame1 = new int[20];
     private int[] frame2 = new int[20];
     private int[] check = new int[20];
     private int[] sum = new int[20];
     private int fno;
     Scanner sc=new Scanner(System.in);

     public int[] getCheck() {
          return check;
     }

     public int getFno() {
          return fno;
     }

     void setfno(){
          System.out.println("enter the length of frame");
          fno=sc.nextInt();

     }

     public void setFrame1() {
          System.out.println("enter the values of frame 1");

          for(int i=0;i<fno;i++)
               frame1[i]=sc.nextInt();
     }

     public void setFrame2() {
          System.out.println("enter the values of frame 1");
          for(int i=0;i<fno;i++)
               frame2[i]=sc.nextInt();

     }
     public void add(){
          int s=0,c=0;
          for(int i=0;i<fno;i++){
               s = frame1[i]+frame2[i]+c;
               if(s==1){
                    sum[i]=s;
                    c=0;
               }
               else if(s==2){
                    sum[i]=0;
                    c=1;
               }
               else if(s==3){
                    sum[i]=1;
                    c=0;
               }
               else{
                    sum[i]=0;
                    c=0;
               }
          }
     }
     public void Checks() {
          for(int i=0;i<fno;i++){
               if (sum[i] == 1) {
                    check[i]=0;
               }
               else {
                    check[i]=1;
               }
          }

     }
     public void print(){
          System.out.print("frame1:  ");
          for(int i=0;i<fno;i++){
               System.out.print(frame1[i]+"\t");
          }
          System.out.println();
          System.out.print("frame2:  ");
          for(int i=0;i<fno;i++){
               System.out.print(frame2[i]+"\t");
          }
          System.out.println();
          System.out.print("sum:  ");
          for(int i=0;i<fno;i++){
               System.out.print(sum[i]+"\t");
          }
          System.out.println();
          System.out.print("checksum:  ");
          for(int i=0;i<fno;i++){
               System.out.print(check[i]+"\t");
          }
          System.out.println();
     }
}
class Check_receive{
     private int[] frame1 = new int[20];
     private int[] frame2 = new int[20];
     private int[] check = new int[20];
     private int[] sum = new int[20];
     private int fno;
     Scanner sc=new Scanner(System.in);

     void setfno(int fno){
                    this.fno=fno;

     }

     public void setFrame1() {
          System.out.println("enter the values of frame 1");

          for(int i=0;i<fno;i++)
               frame1[i]=sc.nextInt();
     }

     public void setFrame2() {
          System.out.println("enter the values of frame 1");
          for(int i=0;i<fno;i++)
               frame2[i]=sc.nextInt();

     }
     public void getCheck(int[] check){
          this.check=check;
     }
     public void add(){
          int s=0,c=0;
          for(int i=0;i<fno;i++){
               s = frame1[i]+frame2[i]+check[i]+c;
               if(s==1){
                    sum[i]=s;
                    c=0;
               }
               else if(s==2){
                    sum[i]=0;
                    c=1;
               }
               else if(s==3){
                    sum[i]=1;
                    c=0;
               }
               else{
                    sum[i]=0;
                    c=0;
               }
          }
     }
     public void Checks() {
          for(int i=0;i<fno;i++){
               if (sum[i] == 1) {
                    check[i]=0;
               }
               else {
                    check[i]=1;
               }
          }

     }
     public void valid(){
          int i=0;
          for(i=0;i<fno;i++){
               if(check[i]==1)
                    break;
          }
          if(i==fno){
               System.out.println("frames have been accepted");
          }else{
               System.out.println("frames heave been rejected");
          }
     }
}