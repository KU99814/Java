//��@nine tail
//�[�JallDepth()�^�ǲ`��

import java.util.*;

public class NineTailModel
{
 private ArrayList<Node> nodes = new ArrayList<Node>();//vertices �N���p
 private ArrayList<Edge> edges = new ArrayList<Edge>();//edge �N���p���������p
 private UnweightedGraph graph;//graph
 private AbstractGraph.Tree tree;//spinner tree

 //default
 public NineTailModel()
  {
   createNodes();//�Ы�vertices 
   createEdges();//�Ы�edges

   graph = new UnweightedGraph(edges,nodes);//�ھ�node�Medge��graph

   tree=graph.bfs(511);//�Ыس̵u���|��
  }

 //�Ы�vertices
 private void createNodes()
  {
   //��J�Ʀr �Ы�node
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
     int p = 8;//2������ �q8�}�l
     value = 0;//�N���p����

     //�q����k �q�W��U
     //�N�}�C���ƭ��H2������
     for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
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
     int[][] matrix = new int[3][3];//�^�ǰ}�C

     int number = value;//�ഫ����

     //�̧ǱNnumber/2���l�Ʃ�J�}�C
     for(int i=2;i>=0;i--)
      for(int j=2;j>=0;j--)
       {
        matrix[i][j] = number%2;
        number/=2;
       }

     return matrix;//�^�ǰ}�C
    }

   //��ܸ�T
   public String toString()
    {
     StringBuilder result = new StringBuilder();//��ܦr��

     int[][] matrix = getMatrix();//node�N��}�C

     //�@�h�h���     
     for(int i=0;i<3;i++)
      {
       for(int j=0;j<3;j++)
        result.append(matrix[i][j]+" ");   
         
       result.append("\n");
      }
     
     return result.toString();
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
     for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
       {
        if(matrix[i][j] ==0)
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
   int[][] matrixOfNextNode = new int[3][3];//�^�ǰ}�C
   
   //�ƻs��}�C
   for(int i1 = 0;i1 < 3;i1++)
    for(int j1 = 0;j1 < 3;j1++)
     matrixOfNextNode[i1][j1] =matrix[i1][j1];

   //�N���w�y�Х����M�W�U���k��½��
   flipACell(matrixOfNextNode,i-1,j);
   flipACell(matrixOfNextNode,i+1,j);
   flipACell(matrixOfNextNode,i,j-1);
   flipACell(matrixOfNextNode,i,j+1);
   flipACell(matrixOfNextNode,i,j);

   //�﨤
   flipACell(matrixOfNextNode,i-1,j-1);
   flipACell(matrixOfNextNode,i-1,j+1);
   flipACell(matrixOfNextNode,i+1,j-1);
   flipACell(matrixOfNextNode,i+1,j+1);

   return new Node(matrixOfNextNode);//�^��
  }

 //½��
 private void flipACell(int[][] matrix,int i,int j)
  {
   //�Y�y�ШS���W�L�}�C
   if(i >= 0 && i<=2 && j>=0 && j<=2)
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