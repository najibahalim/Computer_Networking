package cn;
import java.util.*;
public class ShortestPath {
    char[] nodes;
    char[] path;
    int[] dist;
    boolean[] flag;
    int n;
    int g[][];   
    void accept(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of nodes ");
        n=sc.nextInt();
        g=new int[n][n];
        nodes=new char[n];
        path=new char[n];
        dist=new int[n];
        flag=new boolean[n]; 
        System.out.println("Enter the Graph Matrix");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                g[i][j]=sc.nextInt();
            nodes[i]=(char) ('A'+i);
            path[i]='x';
            dist[i]=9999;
            flag[i]=false;
        }
    }    
    void calc(){
        path[0]='A';
       dist[0]=0;
       flag[0]=true;
       int finish=1;
       for(int y=0;y<n;y++)
       {
           if(!flag[y] && dist[y]>g[0][y])
           {
               dist[y]=g[0][y];
               path[y]=nodes[0];
           }
       }
       int i=findmin();
       while(i!=-1){
           flag[i]=true;
           finish++;
           for(int y=0;y<n;y++)
           {
                if(!flag[y] && dist[y]>g[i][y]+ dist[i])
                {
                    dist[y]=g[i][y]+dist[i];
                    path[y]=nodes[i];
                }
           }
           i=findmin();          
       }
    }   
    int findmin(){
        int min=9999;
        int i=-1;
        for(int x=0;x<n;x++)
        {
            if(!flag[x])
            {
                if(dist[x]<min)
                {
                    min=dist[x];
                    i=x;
                }
            }
        }
        return i;        
    }
    void display(){       
        for(int i=0;i<n;i++)
        {
            String s=new String(" ");
            s+=nodes[i]+"-";
            System.out.print(nodes[0]+"-"+nodes[i]+":: MINCOST= "+dist[i]+" Shortest Path:: ");
            int x=i;
            while(path[x]!=nodes[0]){
                s+=(path[x]+"-");
                x=path[x]-'A';
            }
            s+=(path[0]);
            System.out.println(new StringBuffer(s).reverse());               
        }
    }
    public static void main(String[] args) {
        ShortestPath ap=new ShortestPath();
        ap.accept();
        ap.calc();
        ap.display();
    }    
}
