//weight 4X4 tail
//修改為4X4的方格
//要輸出成檔案 宣告序列化

import java.util.*;
import java.io.*;

public class WeightedTailModel16 implements Serializable
{
 private List<Node> nodes = new ArrayList<Node>();//node代表狀態 儲存狀態的list
 private List<WeightedEdge> edges = new ArrayList<WeightedEdge>();//node的相連edge list
 private WeightedGraph graph; //node相連的graph
 private WeightedGraph.ShortestPathTree tree;//graph的最短路徑樹

 public static final int DEMINION = 4;//每邊格數 
 private static int mul = DEMINION*DEMINION;//總格數
 private static int pow = (int)(Math.pow(2,mul));//2的次方數 代表總共有多少狀況

 //constructor
 public WeightedTailModel16()
  {
   createNodes();//創建node
   createEdges();//創建edge

   graph = new WeightedGraph(edges,nodes);//創建graph
   System.out.println(pow-1);
   tree=graph.getShortestPath(pow-1);//創建最短路徑樹
  }

 //創建node
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
   
   //constructor
   Node(int value)
    {
     this.value = value;
    }

   //constructor
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


   //顯示資訊
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

 //創造相鄰關係
 private void createEdges()
  {
   //迴圈尋訪所有node
   for(Node node : nodes)
    {
     int u = nodes.indexOf(node);//node對應的index
     int[][] matrix = node.getMatrix();//表示node情況的陣列

     //依序將陣列翻面 並將翻面後的node作為鄰居
     for(int i=0;i<DEMINION;i++)
      {
       for(int j=0;j<DEMINION;j++)
        {
         if(matrix[i][j] == 0)
          {
           Node adjacentNode = getAdjacentNode(matrix,i,j);//翻面後node
           int v = nodes.indexOf(adjacentNode);//node代表index
           int numberOfFlips = getNumberOfFlips(adjacentNode,node);//以翻面次數代表權值
           edges.add(new WeightedEdge(v,u,numberOfFlips));//加入相鄰list
          }
        }
      }
    }
  }

 //回傳相鄰node
 private Node getAdjacentNode(int[][] matrix,int i,int j)
  {
   int[][] matrixOfNextNode = new int[DEMINION][DEMINION];//相鄰node陣列

   //從原node複製
   for(int i1 = 0;i1<DEMINION;i1++)
    {
     for(int j1 = 0;j1<DEMINION;j1++)
      {
       matrixOfNextNode[i1][j1] = matrix[i1][j1];
      }
    }

   //翻面
   flipACell(matrixOfNextNode,i-1,j);
   flipACell(matrixOfNextNode,i+1,j);
   flipACell(matrixOfNextNode,i,j-1);
   flipACell(matrixOfNextNode,i,j+1);
   flipACell(matrixOfNextNode,i,j);

   return new Node(matrixOfNextNode);//回傳翻面後node
  }

 //翻面
 private void flipACell(int[][] matrix,int i,int j)
  {
   //將目前格子翻為另一邊
   if(i >=0 && i<=DEMINION-1 && j>=0 && j<=DEMINION-1)
    {
     if(matrix[i][j] == 0)
      matrix[i][j] = 1;
     else
      matrix[i][j] = 0;
    }
  }

 //找出到達全為另一面的最短路徑
 public List<Node> getShortestPath(Node node)
  {
   //迭代器
   Iterator iterator = tree.pathIterator(nodes.indexOf(node));
   LinkedList list = new LinkedList();//回傳路徑list

   //將迭代器內容加入list
   while(iterator.hasNext())
    list.addFirst(iterator.next());

   return list;//回傳
  }

 //以node間的差異來決定權值
 private int getNumberOfFlips(Node node1,Node node2)
  {
   int[][] matrix1 = node1.getMatrix();//第一node
   int[][] matrix2 = node2.getMatrix();//第二node
   
   
   int count = 0;//紀錄差異格數
   for(int i=0;i<DEMINION;i++)
    {
     for(int j=0;j<DEMINION;j++)
      {
       if(matrix1[i][j] != matrix2[i][j])
        count++;
      }
    }

   return count;//回傳
  }
}