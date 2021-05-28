//實作nine tail
//加入allDepth()回傳深度

import java.util.*;

public class NineTailModel
{
 private ArrayList<Node> nodes = new ArrayList<Node>();//vertices 代表狀況
 private ArrayList<Edge> edges = new ArrayList<Edge>();//edge 代表狀況之間的關聯
 private UnweightedGraph graph;//graph
 private AbstractGraph.Tree tree;//spinner tree

 //default
 public NineTailModel()
  {
   createNodes();//創建vertices 
   createEdges();//創建edges

   graph = new UnweightedGraph(edges,nodes);//根據node和edge做graph

   tree=graph.bfs(511);//創建最短路徑樹
  }

 //創建vertices
 private void createNodes()
  {
   //輸入數字 創建node
   for(int k = 0;k<512;k++)
    nodes.add(new Node(k));
  }

 public int[] allDepth()
  {
   int[] depth = new int[nodes.size()];
   for(int i=0;i<nodes.size();i++)
    depth[i] = tree.depth(i);

   return depth;
  }

 //node class
 public static class Node
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
     int p = 8;//2的次方 從8開始
     value = 0;//代表狀況的值

     //從左到右 從上到下
     //將陣列的數乘以2的次方
     for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
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
     int[][] matrix = new int[3][3];//回傳陣列

     int number = value;//轉換的數

     //依序將number/2的餘數放入陣列
     for(int i=2;i>=0;i--)
      for(int j=2;j>=0;j--)
       {
        matrix[i][j] = number%2;
        number/=2;
       }

     return matrix;//回傳陣列
    }

   //顯示資訊
   public String toString()
    {
     StringBuilder result = new StringBuilder();//顯示字串

     int[][] matrix = getMatrix();//node代表陣列

     //一層層顯示     
     for(int i=0;i<3;i++)
      {
       for(int j=0;j<3;j++)
        result.append(matrix[i][j]+" ");   
         
       result.append("\n");
      }
     
     return result.toString();
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
     for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
       {
        if(matrix[i][j] ==0)
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
   int[][] matrixOfNextNode = new int[3][3];//回傳陣列
   
   //複製原陣列
   for(int i1 = 0;i1 < 3;i1++)
    for(int j1 = 0;j1 < 3;j1++)
     matrixOfNextNode[i1][j1] =matrix[i1][j1];

   //將指定座標本身和上下左右做翻轉
   flipACell(matrixOfNextNode,i-1,j);
   flipACell(matrixOfNextNode,i+1,j);
   flipACell(matrixOfNextNode,i,j-1);
   flipACell(matrixOfNextNode,i,j+1);
   flipACell(matrixOfNextNode,i,j);

   //對角
   flipACell(matrixOfNextNode,i-1,j-1);
   flipACell(matrixOfNextNode,i-1,j+1);
   flipACell(matrixOfNextNode,i+1,j-1);
   flipACell(matrixOfNextNode,i+1,j+1);

   return new Node(matrixOfNextNode);//回傳
  }

 //翻轉
 private void flipACell(int[][] matrix,int i,int j)
  {
   //若座標沒有超過陣列
   if(i >= 0 && i<=2 && j>=0 && j<=2)
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