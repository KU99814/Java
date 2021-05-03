//knight tour model

import java.util.*;

public class KnightTourModel
{
 private ArrayList<Edge> edges = new ArrayList<Edge>();//edge關係
 private UnweightedGraph graph;//以騎士步伐將位置相連結的graph
 int num = 6;//一行的格數

 //default
 public KnightTourModel()
  {
   createEdges();//創造邊關係
   
   graph = new UnweightedGraph(edges,num*num);//創建graph object
  }

 //找出Hamiltonian Cycle
 public List<Integer> getHamiltonianCycle()
  {
   //呼叫graph的method
   return graph.getHamiltonianCycle();
  }

 //找出Hamiltonian Path
 public List<Integer> getHamiltonianPath(int v)
  {
   //呼叫graph的method
   return graph.getHamiltonianPath(v);
  }

 //將圖以騎士步伐來相連
 public void createEdges()
  {
   //尋訪每一vertex並將下一步的格子作為鄰居相連
   for(int i=0;i<num;i++)//行
    for(int j=0;j<num;j++)//列
     {
      int u=i*num+j;//目前的格子
      
      //判斷個方向走法是否有下一步 建立邊關係
      if(i-1 >= 0 && j-2 >= 0)
       {
        int v1 = (i-1)*num+(j-2);
        edges.add(new Edge(u,v1));
       }
    
      if(i-2 >= 0 && j-1 >= 0)
       {
        int v2 = (i-2)*num+(j-1);
        edges.add(new Edge(u,v2));
       }
    
      if(i-2 >= 0 && j+1 <= num-1)
       {
        int v3 = (i-2)*num+(j+1);
        edges.add(new Edge(u,v3));
       }   
      
      if(i-1 >= 0 && j+2 <= num-1)
       {
        int v4 = (i-1)*num+(j+2);
        edges.add(new Edge(u,v4));
       }
      
      if(i+1 <= num-1 && j+2 <= num-1)
       {
        int v5 = (i+1)*num+(j+2);
        edges.add(new Edge(u,v5));
       }
      
      if(i+2 <= num-1 && j+1 <= num-1)
       {
        int v6 = (i+2)*num+(j+1);
        edges.add(new Edge(u,v6));
       }   
   
      if(i+2 <= num-1 && j-1 >= 0)
       {
        int v7 = (i+2)*num+(j-1);
        edges.add(new Edge(u,v7));
       } 
    
      if(i+1 <= num-1 && j-2 >= 0)
       {
        int v8 = (i+1)*num+(j-2);
        edges.add(new Edge(u,v8));
       }
     }
  }
}