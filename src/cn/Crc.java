import java.util.Scanner;

/**
 * Created by amitujha on 04-11-2017.
 */
public class Crc {
     public static void main(String[] args) {
          Sender s= new Sender();
          s.setLen();
          s.setCon();
          s.divide();
          Reciver r = new Reciver();
          r.setLen(s.getLen(),s.getDiv());
          r.setCon();
          r.divide();

     }
}
class Sender{
     private int len,div;
     private int[] dataword,divisor,temp;
     Scanner sc = new Scanner(System.in);

     public int getLen() {
          return len;
     }

     public int getDiv() {
          return div;
     }

     void setLen(){
          System.out.println("enter the length of dataword");
          len = sc.nextInt();
          System.out.println("enter the length pf divisor");
          div = sc.nextInt();
          dataword = new int[len+div];
          divisor = new int[div];
          temp = new int[div];
     }
     void setCon(){
          System.out.println("enter the bits pf dataword");
          for(int i=0;i<len;i++)
               dataword[i]=sc.nextInt();
          for(int i=len;i<len+div-1;i++)
               dataword[i]=0;
          System.out.println("enter the divisor");
          for(int i=0;i<div;i++)
               divisor[i]=sc.nextInt();
          System.out.println("dividend");
          for(int i=0;i<len+div-1;i++)
               System.out.print(dataword[i]+"\t");
          System.out.println();

     }
     void divide() {
         for(int i=0;i<div;i++)
              temp[i]=dataword[i];
         for(int i=0;i<len;i++){
              if(temp[0]==1){
                   for(int j=0;j<div;j++)
                        temp[j]=xor(temp[j],divisor[j]);
                   for(int j=0;j<div;j++)
                        System.out.print(temp[j]+"\t");
                   System.out.println();
              }
              else{
                   for(int j=0;j<div;j++)
                        temp[j]=xor(temp[j],0);
                   for(int j=0;j<div;j++)
                        System.out.print(temp[j]+"\t");
                   System.out.println();
              }
              if(i==len-1)
                   break;
              for(int j=0;j<div-1;j++)
                   temp[j]=temp[j+1];
              temp[div-1]=dataword[i+div];

         }


          System.out.println("syndrome is:");
          for(int j=1; j<div;j++ )
               System.out.print(temp[j]+"\t");
          int j=1;
          for(int i=len;i<len+div-1;i++){
               dataword[i]=temp[j];
               j++;
          }
          System.out.println("codeword :");
          for(int i=0;i<dataword.length -1;i++)
               System.out.print(dataword[i]+"\t");
          System.out.println();
     }
     int xor(int a,int b){
          if(a==b)
               return 0;
          else
               return 1;
     }
}
class Reciver {
     private int len, div;
     private int[] dataword, divisor, temp;
     Scanner sc = new Scanner(System.in);

     void setLen(int len, int div) {
          this.len = len;
          this.div = div;


     }

     void setCon() {
          System.out.println("enter the codeword:");
          dataword = new int[div + len];
          divisor = new int[div];
          temp = new int[div];
          for (int i = 0; i < div + len - 1; i++)
               dataword[i] = sc.nextInt();
          System.out.println();
          System.out.println("enter the checker or divisor");
          for (int i = 0; i < div; i++)
               divisor[i] = sc.nextInt();

     }

     void divide()

     {
          for (int i = 0; i < div; i++)
               temp[i] = dataword[i];
          for (int i = 0; i < len; i++) {
               if (temp[0] == 1) {
                    for (int j = 0; j < div; j++)
                         temp[j] = xor(temp[j], divisor[j]);
                    for (int j = 0; j < div; j++)
                         System.out.print(temp[j] + "\t");
                    System.out.println();
               } else {
                    for (int j = 0; j < div; j++)
                         temp[j] = xor(temp[j], 0);
                    for (int j = 0; j < div; j++)
                         System.out.print(temp[j] + "\t");
                    System.out.println();
               }
               if (i == len - 1)
                    break;
               for (int j = 0; j < div - 1; j++)
                    temp[j] = temp[j + 1];
               temp[div - 1] = dataword[i + div];

          }
          int i;
          for (i = 1; i < div; i++)
               if (temp[i] != 0)
                    break;
          if (i != div)
               System.out.println("codeword has been rejected Error!!!");
          else
               System.out.println("codeword has been accepted");


     }

     int xor(int a, int b) {
          if (a == b)
               return 0;
          else
               return 1;
     }
}