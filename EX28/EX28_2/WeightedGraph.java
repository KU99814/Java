//weight graph
//�ק�getMinimumSpanningTree()

import java.util.*;

public class WeightedGraph extends AbstractGraph
{
 private PriorityQueue<WeightedEdge>[] queues;//���Ȫ�edge���F�����Yqueue

 //constructor
 //�N�J�ܼ�int[][],Object[]
 public WeightedGraph(int[][] edges,Object[] vertices)
  {
   super(edges,vertices);
   createQueues(edges,vertices.length);//�I�smethod�ЫؾF�����Y
  }

 //constructor
 //�N�J�ܼ�int[][],int
 public WeightedGraph(int[][] edges,int numberOfVertices)
  {
   super(edges,numberOfVertices);
   createQueues(edges,numberOfVertices);//�I�smethod�ЫؾF�����Y
  }

 //constructor
 //�N�J�ܼ�List,List
 public WeightedGraph(List<WeightedEdge> edges,List vertices)
  {
   super((List)edges,vertices);
   createQueues(edges,vertices.size());//�I�smethod�ЫؾF�����Y
  }
 
 //constructor
 //�N�J�ܼ�List,int 
 public WeightedGraph(List<WeightedEdge> edges,int numberOfVertices)
  {
   super((List)edges,numberOfVertices);
   createQueues(edges,numberOfVertices);//�I�smethod�ЫؾF�����Y
  }

 //�ЫؾF�����Y �ϥ�edge�}�C
 public void createQueues(int[][] edges,int numberOfVertices)
  {
   queues = new java.util.PriorityQueue[numberOfVertices];//�ŧiqueue�}�C

   //�Ы�queue   
   for(int i=0;i<queues.length;i++)
    queues[i] = new java.util.PriorityQueue();

   //�N�}�C�ഫ��WeightedEdge��Jqueue
   for(int i=0;i<edges.length;i++)
    {
     int u = edges[i][0];
     int v = edges[i][1];
     int weight = edges[i][2];
     
     queues[u].offer(new WeightedEdge(u,v,weight));
    }
  }

 //�ЫؾF�����Y �ϥ�edge List
 public void createQueues(List<WeightedEdge>edges,int numberOfVertices)
  {
   queues = new java.util.PriorityQueue[numberOfVertices];//�ŧiqueue�}�C

   //�Ы�queue   
   for(int i=0;i<queues.length;i++)
    queues[i] = new java.util.PriorityQueue();

   //�NList��WeightedEdge��Jqueue
   for(WeightedEdge edge:edges)
    {
     queues[edge.u].offer(edge);
    }
  }

 //��ܩҦ�edge
 public void printWeightedEdges()
  {
   //�Nqueue����edge�j�����
   for(int i=0;i<queues.length;i++)
    {
     System.out.print("Vertex "+i+": ");//��i��vertex
     for(WeightedEdge edge: queues[i])
      {
       System.out.print("("+edge.u+", "+edge.v+", "+edge.weight+") ");//vertex�������Y
      }
     System.out.println();
    }
  }

 //���o���v�Ȭ۾F���Y
 public int[][] getWeightedAdjacencyMatrix()
  {
   //�^�ǰ}�C 
   int [][] weightedAdjacencyMatrix = new int[vertices.length][vertices.length];

   //��l�ƥ����t��
   for(int i=0;i<vertices.length;i++)
    for(int j=0;j<vertices.length;j++)
     weightedAdjacencyMatrix[i][j] = -1;

   //�N�۾F���Y�ର�}�C �}�C���e�O����edge���v��
   for(int i=0;i<queues.length;i++)
    {
     for(WeightedEdge edge: queues[i])
      {
       weightedAdjacencyMatrix[edge.u][edge.v]=edge.weight;//vertex�������Y
      }
    }

   return weightedAdjacencyMatrix;
  }
   
 //�^��minimum spinner tree(�ŭ�)
 public MST getMinimumSpanningTree()
  {
   return getMinimumSpanningTree(0);
  }

 //�^��minimum spinner tree
 //�ϥ�Prim's algorithm
 //�ϥ�adjacency matrix
 public MST getMinimumSpanningTree(int startingVertex)
  {
   Set<Integer> T = new HashSet<Integer>();//MST��vertices ���X
   
   T.add(startingVertex);//T�[�J�_�l�I

   //�ŧiparent vertex�}�C      
   int numberOfVertices = vertices.length;
   int[] parent = new int[numberOfVertices];

   //��l����-1
   for(int i=0;i<parent.length;i++)
    parent[i] = -1;

   int totalWeight = 0;//�`�[�v��

   int[][] matrix = getWeightedAdjacencyMatrix();//�۾F���Y�}�C

   //�j���Ҧ�vertices����J
   while(T.size() < numberOfVertices)
    {
     //��l�ثeu�Bv�Mmax��
     int v = -1;
     int smallU = -1;
     double smallestWeight = Double.MAX_VALUE;

     //�M�XT����vertex
     for(int u:T)
      {
       //�M�Xmatrix
       for(int i=0;i<matrix[u].length;i++)
        {
         //����v�ȬO�_�̤p��
         if(matrix[u][i]>0 && matrix[u][i] < smallestWeight)
          {
           v = i;
           smallestWeight = matrix[u][i];
           smallU = u;
          }
        }
      }
     
     //�N�ثeedge�]��-1 �R�h
     matrix[smallU][v] = -1;
     matrix[v][smallU] = -1;

     parent[v] = smallU;//�]�wparent
     //�Nvertex�[�Jset
     T.add(v);
     totalWeight += smallestWeight;//�[�v�ȥ[�J�`�[�v��
    }

   return new MST(startingVertex,parent,totalWeight);//�Ы�MST�æ^��
  }

 //�ƻs�F�����Y
 private PriorityQueue<WeightedEdge>[] deepClone(PriorityQueue<WeightedEdge>[] queues)
  {
   //�ƻs��queue�}�C
   PriorityQueue<WeightedEdge>[] copiedQueues = new PriorityQueue[queues.length];
   
   for(int i=0;i<queues.length;i++)
    {
     copiedQueues[i] = new PriorityQueue<WeightedEdge>();//�Ы�queue
     
     //�N�ӷ���Ʃ�J�ƻs��queue
     for(WeightedEdge e: queues[i])
      copiedQueues[i].add(e);
    } 

   return copiedQueues;
  }

 //minimum spinner tree
 public class MST extends Tree
  {
   private int totalWeight;//�`�v��

   //constructor   
   public MST(int root,int[] parent,int totalWeight)
    {
     super(root,parent);
     this.totalWeight = totalWeight;
    }

   //�^���`�v��
   public int getTotalWeight()
    {
     return totalWeight;
    }
  }

 //��X�_�lvertex���Lvertex���̵u���|
 //�ϥ�Dijkstra's algorithm
 public ShortestPathTree getShortestPath(int sourceVertex)
  {
   Set<Integer> T = new HashSet<Integer>();//�̵u���|��vertices ���X
   
   T.add(sourceVertex);//T�[�J�_�l�I

   //�ŧiparent vertex�}�C      
   int numberOfVertices = vertices.length;
   int[] parent = new int[numberOfVertices];

   parent[sourceVertex] = -1;//�_�l�I�Lparent �]��-1

   //�qV��C�@�I��cost
   int[] costs = new int[numberOfVertices];

   //��l�]���̤j
   for(int i=0;i<costs.length;i++)
    costs[i] = Integer.MAX_VALUE;

   costs[sourceVertex] = 0;//�_�l�Icost��0

   PriorityQueue<WeightedEdge>[] queues = deepClone(this.queues);//�ƻs���F��queue

   //�j�骽��Ҧ��I�ҴM�X
   while(T.size() < numberOfVertices)
    {
     //��l�ƥثevertexc�M�̤pcost��
     int v = -1;
     int smallestCost = Integer.MAX_VALUE;
     
     //�M�XT����vertex
     for(int u: T)
      {
       //�Y�۾F�����ťB�۾Fvertex�H�s�b��T ����edge
       while(!queues[u].isEmpty() && T.contains(queues[u].peek().v))
        {
         queues[u].remove();
        }
       
       //�Y�۾F���� ���L��U�@��vertex
       if(queues[u].isEmpty())
        continue;
       
       //���̫e�ݪ�edge �]��PriorityQueue�̫e�����[�v�̤p
       WeightedEdge e = queues[u].peek();

       //����ثe��edge�v�ȻP�ثe�I�ۥ[�O�_�ثecost�̤p
       if(costs[u] + e.weight< smallestCost)
        {
         v = e.v;
         smallestCost = costs[u] + e.weight;
         parent[v] = u;
        }
      }
     
     T.add(v);//vertex�[�JT
     costs[v] = smallestCost;//vertex cost���ثe�̤p��
    }

   return new ShortestPathTree(sourceVertex,parent,costs);//�^��
  }
 
 //�̵u���|tree
 public class ShortestPathTree extends Tree
  {
   private int[] costs;//root��U�Icost

   //costructor
   public ShortestPathTree(int source,int[] parent,int[] costs)
    {
     super(source,parent);
     this.costs = costs;
    }

   //�^�ǫ��wvertex��cost
   public int getCost(int v)
    {
     return costs[v];
    }
   
   //���tree path
   public void printAllPaths()
    {
     //�qroot���Lvertex
     System.out.println("All shortest paths from "+
                  vertices[getRoot()]+" are:");
 
     //��ܦU�Icost
     for(int i=0;i<costs.length;i++)
      {
       printPath(i);
       System.out.println("(cost: "+costs[i]+")");
      }
    }
  }
}