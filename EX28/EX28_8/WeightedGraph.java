//weight graph
//�[�Jmethod:
//getShortestHamiltonianCycle():�̵u���|HamiltonianCycle
//getAllHamiltonianCycle():���o�Ҧ�Hamiltonian Cycle list
//getHamiltonianCycle():���j���o�Ҧ�Hamiltonian Cycle
//allVisited():�P�_�O�_�������X 

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

 //�̵u���|HamiltonianCycle
 public List<Integer> getShortestHamiltonianCycle()
  {
   List<List<Integer>> result = getAllHamiltonianCycle();//������HamiltonianCycle
   
   //�Y�S��cycle �^��null
   if(result.size()==0)
    return null;

   int[] weight = new int[result.size()];//�Ҧ�cycle���`��
   
   //���o�Ҧ�cycle���`��
   for(int i=0;i<result.size();i++)
    {
     List<Integer> list = result.get(i);

     for(int j=0;j<list.size()-1;j++)
      {
       int u = list.get(j);//vertex1
       int v = list.get(j+1);//vertex2
       for(WeightedEdge edge:queues[u])
        {
         //��X������edge�å[�W�v��
         if(edge.v == v )
          {
           weight[i]+=edge.weight;
           break;
          }
        }        
      }
    }

   //����j�p ��X�̤p���`�v��
   int min = weight[0];
   int minIndex = 0;

   for(int i=1;i<weight.length;i++)
    {
     if(weight[i]<min)
      {
       min = weight[i];
       minIndex = i;
      }
    }

   //�^���`�v�ȳ̤p��cycle
   List<Integer> relist = result.get(minIndex);
   return relist;
  }

 //���o�Ҧ�Hamiltonian Cycle list
 public List<List<Integer>> getAllHamiltonianCycle()
  {
   int[] next = new int[getSize()];//��i vertex���U�@��vertex

   //next�����w�]��-1
   for(int i=0;i<next.length;i++)
    next[i] = -1;

   boolean[] isVisited = new boolean[getSize()];//�P�_�O�_�w���X

   List<List<Integer>> result = new ArrayList<List<Integer>>();//�^��list 
   
   getHamiltonianCycle(0,0,next,isVisited,result);//���j���o�Ҧ�Hamiltonian Cycle
   
   return result;//�^�ǵ��G
  }

 //���j���o�Ҧ�Hamiltonian Cycle
 private void getHamiltonianCycle(int start,int v,int[] next,boolean[] isVisited,
                                     List<List<Integer>> result)
  {
   isVisited[v] = true;//�ثevertex���X�]��true

   //�Y�����w���X �ˬd�O�_���Y���۳s
   if(allVisited(isVisited))
    {
     boolean clean = false;//�P�_�O�_�Y���۳s
     for(WeightedEdge edge:queues[v])
      {
       int neighbor = edge.v;
       //�Y��۳s clean�]��true ���X
       if(neighbor==start)
        {
         next[v] = start;
         clean=  true;
         break;
        } 
      }
 
     if(clean)//�۳s�����p
      { 
       int now = start;//�}�l�I
       List<Integer> list = new ArrayList<Integer>();//�s�J��list

       //�Nvertex�Ӷ��Ǧs�Jlist
       while(true)
        {
         list.add(now);
         now = next[now];

         //�^��_�I�ɸ��X
         if(now==start)
          {
           list.add(now);
           break;
          }
        }
       result.add(list);//�Ncycle�[�Jlist
      }
     isVisited[v] = false;//�N�X�ݳ]��false ���U�@�����j���ǳ�
    }
   
   else
    {
     //�̧Ǭ��F�~vertex�����j
     for(WeightedEdge edge:queues[v])
      {
       int u = edge.v;
       if(!isVisited[u])
        {
         next[v] = u;//�N�X��vertex�]���ثevertex
         getHamiltonianCycle(start,u,next,isVisited,result);
        }
       next[v] = -1;//�������j �]�^-1���U�@�����ǳ�
      }
     isVisited[v] = false;//�N�X�ݳ]��false ���U�@�����j���ǳ�
    }
  }

 //�P�_�O�_�������X
 private boolean allVisited(boolean[] isVisited)
  {
   boolean result = true;//�P�_���G

   for(int i=0;i<getSize();i++)
    result = result && isVisited[i];//�Y���ܤ֤@��false ����false 

   return result;//�^��
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