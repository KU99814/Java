//weight 4X4 tail
//�קאּ4X4�����
//�n��X���ɮ� �ŧi�ǦC��

import java.util.*;
import java.io.*;

public class WeightedTailModel16 implements Serializable
{
 private List<Node> nodes = new ArrayList<Node>();//node�N���A �x�s���A��list
 private List<WeightedEdge> edges = new ArrayList<WeightedEdge>();//node���۳sedge list
 private WeightedGraph graph; //node�۳s��graph
 private WeightedGraph.ShortestPathTree tree;//graph���̵u���|��

 public static final int DEMINION = 4;//�C���� 
 private static int mul = DEMINION*DEMINION;//�`���
 private static int pow = (int)(Math.pow(2,mul));//2������� �N���`�@���h�֪��p

 //constructor
 public WeightedTailModel16()
  {
   createNodes();//�Ы�node
   createEdges();//�Ы�edge

   graph = new WeightedGraph(edges,nodes);//�Ы�graph
   System.out.println(pow-1);
   tree=graph.getShortestPath(pow-1);//�Ыس̵u���|��
  }

 //�Ы�node
 private void createNodes()
  {
   //��J�Ʀr �Ы�node
   for(int k = 0;k<pow;k++)
    nodes.add(new Node(k));
  }
 
 //node class
 public static class Node implements Serializable
  {
   int value;//�N���p���Ʀr
   
   //constructor
   Node(int value)
    {
     this.value = value;
    }

   //constructor
   //��J�}�C
   Node(int[][] numbers)
    {
     int p = mul-1;//����� 
     value = 0;//�N���p����

     //�q����k �q�W��U
     //�N�}�C���ƭ��H2������
     for(int i=0;i<DEMINION;i++)
      for(int j=0;j<DEMINION;j++)
       {
        value += numbers[i][j]*(int)(Math.pow(2,p));
        p--;
       }
    }
   

   //�P�_node�O�_�۵�
   public boolean equals(Object o)
    {
     //���������value���P�_
     if(value != ((Node)o).value)
      return false;

     return true;
    }

   //�Nvalue�٭쬰�}�C
   public int[][] getMatrix()
    {
     int[][] matrix = new int[DEMINION][DEMINION];//�^�ǰ}�C

     int number = value;//�ഫ����

     //�̧ǱNnumber/2���l�Ʃ�J�}�C
     for(int i=DEMINION-1;i>=0;i--)
      for(int j=DEMINION-1;j>=0;j--)
       {
        matrix[i][j] = number%2;
        number/=2;
       }

     return matrix;
    }


   //��ܸ�T
   public String toString()
    {
     StringBuilder result = new StringBuilder();//��ܦr��

     int[][] matrix = getMatrix();//node�N��}�C
     
     //�@�h�h���
     for(int i=0;i<DEMINION;i++)
      {
       for(int j=0;j<DEMINION;j++)
        result.append(matrix[i][j]+" ");   
         
       result.append("\n");
      }
     
     return result.toString();//�^�Ǧr��
    }
  }

 //�гy�۾F���Y
 private void createEdges()
  {
   //�j��M�X�Ҧ�node
   for(Node node : nodes)
    {
     int u = nodes.indexOf(node);//node������index
     int[][] matrix = node.getMatrix();//���node���p���}�C

     //�̧ǱN�}�C½�� �ñN½���᪺node�@���F�~
     for(int i=0;i<DEMINION;i++)
      {
       for(int j=0;j<DEMINION;j++)
        {
         if(matrix[i][j] == 0)
          {
           Node adjacentNode = getAdjacentNode(matrix,i,j);//½����node
           int v = nodes.indexOf(adjacentNode);//node�N��index
           int numberOfFlips = getNumberOfFlips(adjacentNode,node);//�H½�����ƥN���v��
           edges.add(new WeightedEdge(v,u,numberOfFlips));//�[�J�۾Flist
          }
        }
      }
    }
  }

 //�^�Ǭ۾Fnode
 private Node getAdjacentNode(int[][] matrix,int i,int j)
  {
   int[][] matrixOfNextNode = new int[DEMINION][DEMINION];//�۾Fnode�}�C

   //�q��node�ƻs
   for(int i1 = 0;i1<DEMINION;i1++)
    {
     for(int j1 = 0;j1<DEMINION;j1++)
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
   if(i >=0 && i<=DEMINION-1 && j>=0 && j<=DEMINION-1)
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
   int[][] matrix1 = node1.getMatrix();//�Ĥ@node
   int[][] matrix2 = node2.getMatrix();//�ĤGnode
   
   
   int count = 0;//�����t�����
   for(int i=0;i<DEMINION;i++)
    {
     for(int j=0;j<DEMINION;j++)
      {
       if(matrix1[i][j] != matrix2[i][j])
        count++;
      }
    }

   return count;//�^��
  }
}