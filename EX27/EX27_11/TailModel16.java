//實作 4 X 4 tail model

import java.util.*;
import java.io.*;

public class TailModel16 implements Serializable
{
 private ArrayList<Node> nodes = new ArrayList<Node>();//vertices 代表狀況
 private ArrayList<Edge> edges = new ArrayList<Edge>();//edge 代表狀況之間的關聯
 private UnweightedGraph graph;//graph
 private AbstractGraph.Tree tree;//spinner tree

 public static final int DEMINION = 4;//每邊格數 
 private static int mul = DEMINION*DEMINION;//總格數
 private static int pow = (int)(Math.pow(2,mul));//2的次方數 代表總共有多少狀況

 //default
 public TailModel16()
  {
   createNodes();//創建vertices 
   createEdges();//創建edges

   graph = new UnweightedGraph(edges,nodes);//根據node和edge做graph

   tree = graph.bfs(pow-1);//將全部為1的狀況作root 代表最後都會到達此狀況
  }

 //創建vertices
 private void createNodes()
  {
   //輸入數字 創建node
   for(int k = 0;k<pow;k++)
    nodes.add(new Node(k));
  }

 //node class
 public static class Node implements Serializable
  {
   int value;//代表狀況的數字
   
   //default
   Node(int value)
    {
     this.value = value;
    }

   //default
   //輸入陣列
   Node(int[][] numbers)
    {
     int p = mul-1;//次方數 
     value = 0;//代表狀況的值

     //從左到右 從上到下
     //將陣列的數乘以2的次方
     for(int i=0;i<DEMINION;i++)
      for(int j=0;j<DEMINION;j++)
       {
        value += numbers[i][j]*(int)(Math.pow(2,p));
        p--;
       }
    }
   
   //判斷node是否相等
   public boolean equals(Object o)
    {
     //比較內部的value做判斷
     if(value != ((Node)o).value)
      return false;

     return true;
    }

   //將value還原為陣列
   public int[][] getMatrix()
    {
     int[][] matrix = new int[DEMINION][DEMINION];//回傳陣列

     int number = value;//轉換的數

     //依序將number/2的餘數放入陣列
     for(int i=DEMINION-1;i>=0;i--)
      for(int j=DEMINION-1;j>=0;j--)
       {
        matrix[i][j] = number%2;
        number/=2;
       }

     return matrix;
    }

   //回傳陣列
   public String toString()
    {
     StringBuilder result = new StringBuilder();//顯示字串

     int[][] matrix = getMatrix();//node代表陣列
     
     //一層層顯示
     for(int i=0;i<DEMINION;i++)
      {
       for(int j=0;j<DEMINION;j++)
        result.append(matrix[i][j]+" ");   
         
       result.append("\n");
      }
     
     return result.toString();//回傳字串
    }
  }

 //創造邊關係
 private void createEdges()
  {
   //對node list做迴圈
   for(Node node:nodes)
    {
     //取得node順序與代表陣列
     int u = nodes.indexOf(node);
     int[][] matrix = node.getMatrix();
     
     //依序將陣列中數字做翻面 
     for(int i=0;i<DEMINION;i++)
      for(int j=0;j<DEMINION;j++)
       {
        if(matrix[i][j] == 0)
         {
          Node adjacentNode = getAdjacentNode(matrix,i,j);//取得鄰居node
          int v = nodes.indexOf(adjacentNode);//鄰居node在list中的順序
          edges.add(new Edge(v,u));//加入邊關係
         }
       }
    }
  }

 //取得鄰居node
 private Node getAdjacentNode(int[][] matrix,int i,int j)
  {
   int[][] matrixOfNextNode = new int[DEMINION][DEMINION];//回傳陣列
   
   //複製原陣列
   for(int i1 = 0;i1 < DEMINION;i1++)
    for(int j1 = 0;j1 < DEMINION;j1++)
     matrixOfNextNode[i1][j1] =matrix[i1][j1];

   //將指定座標本身和上下左右做翻轉
   flipACell(matrixOfNextNode,i-1,j);
   flipACell(matrixOfNextNode,i+1,j);
   flipACell(matrixOfNextNode,i,j-1);
   flipACell(matrixOfNextNode,i,j+1);
   flipACell(matrixOfNextNode,i,j);

   return new Node(matrixOfNextNode);//回傳
  }

 //翻轉
 private void flipACell(int[][] matrix,int i,int j)
  {
   //若座標沒有超過陣列
   if(i >= 0 && i<=DEMINION-1 && j>=0 && j<=DEMINION-1)
    {
     //翻轉 將0變1 1變0
     if(matrix[i][j] ==0)
      matrix[i][j] = 1;
     else
      matrix[i][j] = 0;
    }
  }

 //到指定node的最短路徑
 public LinkedList<Node> getShortestPath(Node node)
  {
   Iterator iterator = tree.pathIterator(nodes.indexOf(node));//迭代器
   LinkedList list = new LinkedList();//路徑list

   //依序加入list
   while(iterator.hasNext())
    list.addFirst(iterator.next());

   return list;//回傳
  }
}