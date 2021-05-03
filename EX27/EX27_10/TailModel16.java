//��@ 4 X 4 tail model

import java.util.*;
import java.io.*;

public class TailModel16 implements Serializable
{
 private ArrayList<Node> nodes = new ArrayList<Node>();//vertices �N���p
 private ArrayList<Edge> edges = new ArrayList<Edge>();//edge �N���p���������p
 private UnweightedGraph graph;//graph
 private AbstractGraph.Tree tree;//spinner tree

 public static final int DEMINION = 4;//�C���� 
 private static int mul = DEMINION*DEMINION;//�`���
 private static int pow = (int)(Math.pow(2,mul));//2������� �N���`�@���h�֪��p

 //default
 public TailModel16()
  {
   createNodes();//�Ы�vertices 
   createEdges();//�Ы�edges

   graph = new UnweightedGraph(edges,nodes);//�ھ�node�Medge��graph

   tree = graph.bfs(pow-1);//�N������1�����p�@root �N��᳣̫�|��F�����p
  }

 //�Ы�vertices
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
   
   //default
   Node(int value)
    {
     this.value = value;
    }

   //default
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

   //�^�ǰ}�C
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

 //�гy�����Y
 private void createEdges()
  {
   //��node list���j��
   for(Node node:nodes)
    {
     //���onode���ǻP�N��}�C
     int u = nodes.indexOf(node);
     int[][] matrix = node.getMatrix();
     
     //�̧ǱN�}�C���Ʀr��½�� 
     for(int i=0;i<DEMINION;i++)
      for(int j=0;j<DEMINION;j++)
       {
        if(matrix[i][j] == 0)
         {
          Node adjacentNode = getAdjacentNode(matrix,i,j);//���o�F�~node
          int v = nodes.indexOf(adjacentNode);//�F�~node�blist��������
          edges.add(new Edge(v,u));//�[�J�����Y
         }
       }
    }
  }

 //���o�F�~node
 private Node getAdjacentNode(int[][] matrix,int i,int j)
  {
   int[][] matrixOfNextNode = new int[DEMINION][DEMINION];//�^�ǰ}�C
   
   //�ƻs��}�C
   for(int i1 = 0;i1 < DEMINION;i1++)
    for(int j1 = 0;j1 < DEMINION;j1++)
     matrixOfNextNode[i1][j1] =matrix[i1][j1];

   //�N���w�y�Х����M�W�U���k��½��
   flipACell(matrixOfNextNode,i-1,j);
   flipACell(matrixOfNextNode,i+1,j);
   flipACell(matrixOfNextNode,i,j-1);
   flipACell(matrixOfNextNode,i,j+1);
   flipACell(matrixOfNextNode,i,j);

   return new Node(matrixOfNextNode);//�^��
  }

 //½��
 private void flipACell(int[][] matrix,int i,int j)
  {
   //�Y�y�ШS���W�L�}�C
   if(i >= 0 && i<=DEMINION-1 && j>=0 && j<=DEMINION-1)
    {
     //½�� �N0��1 1��0
     if(matrix[i][j] ==0)
      matrix[i][j] = 1;
     else
      matrix[i][j] = 0;
    }
  }

 //����wnode���̵u���|
 public LinkedList<Node> getShortestPath(Node node)
  {
   Iterator iterator = tree.pathIterator(nodes.indexOf(node));//���N��
   LinkedList list = new LinkedList();//���|list

   //�̧ǥ[�Jlist
   while(iterator.hasNext())
    list.addFirst(iterator.next());

   return list;//�^��
  }
}