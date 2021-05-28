//weight nine tail
//weight修改為3倍

import java.util.*;

public class WeightedNineTailModel
{
 private List<Node> nodes = new ArrayList<Node>();//node代表狀態 儲存狀態的list
 private List<WeightedEdge> edges = new ArrayList<WeightedEdge>();//node的相連edge list
 private WeightedGraph graph; //node相連的graph
 private WeightedGraph.Tree tree;//graph的最短路徑樹

 //constructor
 public WeightedNineTailModel()
  {
   createNodes();//創建node
   createEdges();//創建edge

   graph = new WeightedGraph(edges,nodes);//創建graph

   tree=graph.getShortestPath(511);//創建最短路徑樹
  }

 //創建node
 private void createNodes()
  {
   //迴圈創建2^9-1個node
   for(int k1=0;k1<=1;k1++){
    for(int k2=0;k2<=1;k2++){
     for(int k3=0;k3<=1;k3++){
      for(int k4=0;k4<=1;k4++){
       for(int k5=0;k5<=1;k5++){
        for(int k6=0;k6<=1;k6++){
         for(int k7=0;k7<=1;k7++){
          for(int k8=0;k8<=1;k8++){
           for(int k9=0;k9<=1;k9++){
            nodes.add(new Node(k1,k2,k3,k4,k5,k6,k7,k8,k9));
           }
          }
         }
        }
       }
      }
     }
    }
   }
  }
 
 //node class
 public static class Node
  {
   int[][] matrix = new int[3][3];//這個node代表的狀況
   
   //constructor
   //代入數列
   Node(int ...numbers)
    {
     int k=0;//第幾個數
     
     //將number放入陣列中
     for(int i=0;i<3;i++)
      {
       for(int j=0;j<3;j++)
        {
         matrix[i][j] = numbers[k++];
        }
      }
    }

   //constructor
   //代入陣列
   Node(int[][] numbers)
    {
     this.matrix = numbers;
    }

   //判斷是否相等
   public boolean equals(Object o)
    {
     int[][] anotherMatrix = ((Node)o).matrix;//比較node的陣列
     
     //逐個比較
     for(int i=0;i<3;i++)
      {
       for(int j=0;j<3;j++)
        {
         if(matrix[i][j] != anotherMatrix[i][j])
          return false;//若不相等 回傳false
        }
      }
     
     return true;//相等回傳true
    }

   //顯示資訊
   public String toString()
    {
     StringBuilder result = new StringBuilder();//回傳字串

     //加入陣列資訊
     for(int i=0;i<3;i++)
      {
       for(int j=0;j<3;j++)
        {
         result.append(matrix[i][j] + " ");
        }
       result.append("\n");
      }

     //回傳
     return result.toString();
    }
  }

 //創造相鄰關係
 private void createEdges()
  {
   //迴圈尋訪所有node
   for(Node node : nodes)
    {
     int u = nodes.indexOf(node);//node對應的index
     int[][] matrix = node.matrix;//表示node情況的陣列

     //依序將陣列翻面 並將翻面後的node作為鄰居
     for(int i=0;i<3;i++)
      {
       for(int j=0;j<3;j++)
        {
         if(matrix[i][j] == 0)
          {
           Node adjacentNode = getAdjacentNode(matrix,i,j);//翻面後node
           int v = nodes.indexOf(adjacentNode);//node代表index
           int numberOfFlips = getNumberOfFlips(adjacentNode,node);//以翻面次數代表權值
           edges.add(new WeightedEdge(v,u,numberOfFlips*3));//加入相鄰list
          }
        }
      }
    }
  }

 //回傳相鄰node
 private Node getAdjacentNode(int[][] matrix,int i,int j)
  {
   int[][] matrixOfNextNode = new int[3][3];//相鄰node陣列

   //從原node複製
   for(int i1 = 0;i1<3;i1++)
    {
     for(int j1 = 0;j1<3;j1++)
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
   if(i >=0 && i<=2 && j>=0 && j<=2)
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
   int[][] matrix1 = node1.matrix;//第一node
   int[][] matrix2 = node2.matrix;//第二node
   
   
   int count = 0;//紀錄差異格數
   for(int i=0;i<3;i++)
    {
     for(int j=0;j<3;j++)
      {
       if(matrix1[i][j] != matrix2[i][j])
        count++;
      }
    }

   return count;//回傳
  }
}