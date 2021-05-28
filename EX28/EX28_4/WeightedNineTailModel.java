//weight nine tail
//weight�קאּ3��

import java.util.*;

public class WeightedNineTailModel
{
 private List<Node> nodes = new ArrayList<Node>();//node�N���A �x�s���A��list
 private List<WeightedEdge> edges = new ArrayList<WeightedEdge>();//node���۳sedge list
 private WeightedGraph graph; //node�۳s��graph
 private WeightedGraph.Tree tree;//graph���̵u���|��

 //constructor
 public WeightedNineTailModel()
  {
   createNodes();//�Ы�node
   createEdges();//�Ы�edge

   graph = new WeightedGraph(edges,nodes);//�Ы�graph

   tree=graph.getShortestPath(511);//�Ыس̵u���|��
  }

 //�Ы�node
 private void createNodes()
  {
   //�j��Ы�2^9-1��node
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
   int[][] matrix = new int[3][3];//�o��node�N�����p
   
   //constructor
   //�N�J�ƦC
   Node(int ...numbers)
    {
     int k=0;//�ĴX�Ӽ�
     
     //�Nnumber��J�}�C��
     for(int i=0;i<3;i++)
      {
       for(int j=0;j<3;j++)
        {
         matrix[i][j] = numbers[k++];
        }
      }
    }

   //constructor
   //�N�J�}�C
   Node(int[][] numbers)
    {
     this.matrix = numbers;
    }

   //�P�_�O�_�۵�
   public boolean equals(Object o)
    {
     int[][] anotherMatrix = ((Node)o).matrix;//���node���}�C
     
     //�v�Ӥ��
     for(int i=0;i<3;i++)
      {
       for(int j=0;j<3;j++)
        {
         if(matrix[i][j] != anotherMatrix[i][j])
          return false;//�Y���۵� �^��false
        }
      }
     
     return true;//�۵��^��true
    }

   //��ܸ�T
   public String toString()
    {
     StringBuilder result = new StringBuilder();//�^�Ǧr��

     //�[�J�}�C��T
     for(int i=0;i<3;i++)
      {
       for(int j=0;j<3;j++)
        {
         result.append(matrix[i][j] + " ");
        }
       result.append("\n");
      }

     //�^��
     return result.toString();
    }
  }

 //�гy�۾F���Y
 private void createEdges()
  {
   //�j��M�X�Ҧ�node
   for(Node node : nodes)
    {
     int u = nodes.indexOf(node);//node������index
     int[][] matrix = node.matrix;//���node���p���}�C

     //�̧ǱN�}�C½�� �ñN½���᪺node�@���F�~
     for(int i=0;i<3;i++)
      {
       for(int j=0;j<3;j++)
        {
         if(matrix[i][j] == 0)
          {
           Node adjacentNode = getAdjacentNode(matrix,i,j);//½����node
           int v = nodes.indexOf(adjacentNode);//node�N��index
           int numberOfFlips = getNumberOfFlips(adjacentNode,node);//�H½�����ƥN���v��
           edges.add(new WeightedEdge(v,u,numberOfFlips*3));//�[�J�۾Flist
          }
        }
      }
    }
  }

 //�^�Ǭ۾Fnode
 private Node getAdjacentNode(int[][] matrix,int i,int j)
  {
   int[][] matrixOfNextNode = new int[3][3];//�۾Fnode�}�C

   //�q��node�ƻs
   for(int i1 = 0;i1<3;i1++)
    {
     for(int j1 = 0;j1<3;j1++)
      {
       matrixOfNextNode[i1][j1] = matrix[i1][j1];
      }
    }

   //½��
   flipACell(matrixOfNextNode,i-1,j);
   flipACell(matrixOfNextNode,i+1,j);
   flipACell(matrixOfNextNode,i,j-1);
   flipACell(matrixOfNextNode,i,j+1);
   flipACell(matrixOfNextNode,i,j);

   return new Node(matrixOfNextNode);//�^��½����node
  }

 //½��
 private void flipACell(int[][] matrix,int i,int j)
  {
   //�N�ثe��l½���t�@��
   if(i >=0 && i<=2 && j>=0 && j<=2)
    {
     if(matrix[i][j] == 0)
      matrix[i][j] = 1;
     else
      matrix[i][j] = 0;
    }
  }

 //��X��F�����t�@�����̵u���|
 public List<Node> getShortestPath(Node node)
  {
   //���N��
   Iterator iterator = tree.pathIterator(nodes.indexOf(node));
   LinkedList list = new LinkedList();//�^�Ǹ��|list

   //�N���N�����e�[�Jlist
   while(iterator.hasNext())
    list.addFirst(iterator.next());

   return list;//�^��
  }

 //�Hnode�����t���ӨM�w�v��
 private int getNumberOfFlips(Node node1,Node node2)
  {
   int[][] matrix1 = node1.matrix;//�Ĥ@node
   int[][] matrix2 = node2.matrix;//�ĤGnode
   
   
   int count = 0;//�����t�����
   for(int i=0;i<3;i++)
    {
     for(int j=0;j<3;j++)
      {
       if(matrix1[i][j] != matrix2[i][j])
        count++;
      }
    }

   return count;//�^��
  }
}