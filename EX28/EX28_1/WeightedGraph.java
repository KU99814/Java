//weight graph
//�ק�getMinimumSpanningTree()
//�s�W:
//getMinimumSpanningTreeByKruskal():MST�ϥ�kruskal's algorithm
//notSubset():�P�_�O�_�b�P�@�l��
//MSTBfs():���Xparent���Y

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
   
 //�^��minimum spinner tree(�ŭ�)
 public MST getMinimumSpanningTree()
  {
   return getMinimumSpanningTree(0);
  }

 //�^��minimum spinner tree
 //�ϥ�Prim's algorithm
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

   PriorityQueue<WeightedEdge>[] queues = deepClone(this.queues);//�ƻs�F��list�}�C

   //�j���Ҧ�vertices����J
   while(T.size() < numberOfVertices)
    {
     //��l�ثevertexc�Mmax��
     int v = -1;
     double smallestWeight = Double.MAX_VALUE;

     //�M�XT����vertex
     for(int u:T)
      {
       //�Y�۾Fqueue�䤤���w�s�b��vertex ���� 
       while(!queues[u].isEmpty() && T.contains(queues[u].peek().v))
        {
         queues[u].remove();
        }

       //�Y�w�g���� ���L
       if(queues[u].isEmpty())
        continue;

       //���̫e�ݪ�edge �]��PriorityQueue�̫e�����[�v�̤p
       WeightedEdge edge = queues[u].peek();
       
       //��ثeset�����I��� �ثe��edge�O�_�[�v�̤p
       if(edge.weight < smallestWeight)
        {
         v = edge.v;
         smallestWeight = edge.weight;
         parent[v] = u;
        }
      }

     //�Nvertex�[�Jset
     T.add(v);
     totalWeight += smallestWeight;//�[�v�ȥ[�J�`�[�v��
    }

   return new MST(startingVertex,parent,totalWeight);//�Ы�MST�æ^��
  }

 //�^��minimum spinner tree
 //�ϥ�kruskal's algorithm
 public MST getMinimumSpanningTreeByKruskal()
  {
   Set<Integer> T = new HashSet<Integer>();//MST��vertices ���X
   PriorityQueue<WeightedEdge>[] MSTQueues = new PriorityQueue[vertices.length];//MST���F�����Y
   
   //�Ы�PriorityQueue
   for(int i=0;i<MSTQueues.length;i++)
    MSTQueues[i] = new PriorityQueue<WeightedEdge>();//�Ы�queue

   //�ŧiparent vertex�}�C      
   int numberOfVertices = vertices.length;
   int[] parent = new int[numberOfVertices];

   //��l����-1
   for(int i=0;i<parent.length;i++)
    parent[i] = -1;

   int totalWeight = 0;//�`�[�v��

   PriorityQueue<WeightedEdge>[] queues = deepClone(this.queues);//�ƻs�F��list�}�C
 
   int edgeCount = 0;//MST��ƭp��
   
   //�j���Ҧ�vertices����J�Bedge�Ƶ���vertices��-1
   while(T.size()<numberOfVertices || edgeCount < numberOfVertices-1 )
    {
     int u = -1;//��l�ثe�̤j�v���䪺u�I
     double smallestWeight = Double.MAX_VALUE;//��l�ثemax��

     //��X�̤j�v�Ȫ�edge
     for(int i=0;i<queues.length;i++)
      {
       if(!queues[i].isEmpty() && queues[i].peek().weight<smallestWeight)
        {
         u = i;
         smallestWeight = queues[i].peek().weight;
        }
      }

     //���̫e�ݪ�edge �]��PriorityQueue�̫e�����[�v�̤p
     WeightedEdge edge = queues[u].poll();

     int v = edge.v;//�s�����t�@�I
    
     //�P�_u�Pv�bMST�W�O�_�s��
     if(notSubset(u,v,MSTQueues))
      {
       //�Nu�Pv��Jset
       if(!T.contains(u))
        T.add(u);
       if(!T.contains(edge.v))
        T.add(edge.v);

       WeightedEdge altEdge = new WeightedEdge(v,u,edge.weight);//�]���O�L�V�� �]��J�ϦV��edge

       //��Jedge
       MSTQueues[u].offer(edge);
       MSTQueues[v].offer(altEdge);

       queues[v].remove(altEdge);//����v���P�@edge
       totalWeight += smallestWeight;//�[�v�ȥ[�J�`�[�v��
       edgeCount++;//edge��+1
      }
    }
   
   int root = (int)T.toArray()[0];//��set���̫e��vertex��root

   MSTBfs(root,parent,MSTQueues);//���Xparent���Y

   return new MST(root,parent,totalWeight);//�Ы�MST�æ^��
  }

 //�P�_�O�_�b�P�@�l��
 private boolean notSubset(int u,int v,PriorityQueue<WeightedEdge>[] queues)
  {
   //�Ȧsvertex��queue
   java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>();
   
   boolean[] isVisited = new boolean[vertices.length];//�P�_vertex�O�_�w�M�X

   queue.offer(u);//��J���wvertex�@��root
   isVisited[u] = true;
   
   //�M�X��queue����
   while(!queue.isEmpty())
    {
     int i = queue.poll();//���Xvertex

     //�M�Xedge �ñN�����X�L��vertex�[�Jqueue
     for(WeightedEdge edge:queues[i])
      {
       int w = edge.v;
       //�Y�F�~��v �N��b�P�@�l�� �^��false
       if(w==v)
        return false;
       if(!isVisited[w])
        {
         queue.offer(w);
         isVisited[w] = true;
        }
      }
    }

   return true;
  }

 //���Xparent���Y
 private void MSTBfs(int root,int[] parent,PriorityQueue<WeightedEdge>[] queues)
  {
   //�Ȧsvertex��queue
   java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>();

   boolean[] isVisited = new boolean[vertices.length];//�P�_vertex�O�_�w�M�X

   queue.offer(root);//��J���wvertex�@��root
   isVisited[root] = true;
   
   //�M�X
   while(!queue.isEmpty())
    {
     int u = queue.poll();//���Xvertex

     //�M�X�F�~vertex �ñN�����X�L��vertex�[�Jqueue
     for(WeightedEdge edge:queues[u])
      {
       int w = edge.v;
       if(!isVisited[w])
        {
         queue.offer(w);
         parent[w] = u;
         isVisited[w] = true;
        }
      }
    }
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