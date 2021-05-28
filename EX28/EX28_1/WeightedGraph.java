//weight graph
//修改getMinimumSpanningTree()
//新增:
//getMinimumSpanningTreeByKruskal():MST使用kruskal's algorithm
//notSubset():判斷是否在同一子集
//MSTBfs():做出parent關係

import java.util.*;

public class WeightedGraph extends AbstractGraph
{
 private PriorityQueue<WeightedEdge>[] queues;//有值的edge的鄰接關係queue

 //constructor
 //代入變數int[][],Object[]
 public WeightedGraph(int[][] edges,Object[] vertices)
  {
   super(edges,vertices);
   createQueues(edges,vertices.length);//呼叫method創建鄰接關係
  }

 //constructor
 //代入變數int[][],int
 public WeightedGraph(int[][] edges,int numberOfVertices)
  {
   super(edges,numberOfVertices);
   createQueues(edges,numberOfVertices);//呼叫method創建鄰接關係
  }

 //constructor
 //代入變數List,List
 public WeightedGraph(List<WeightedEdge> edges,List vertices)
  {
   super((List)edges,vertices);
   createQueues(edges,vertices.size());//呼叫method創建鄰接關係
  }
 
 //constructor
 //代入變數List,int 
 public WeightedGraph(List<WeightedEdge> edges,int numberOfVertices)
  {
   super((List)edges,numberOfVertices);
   createQueues(edges,numberOfVertices);//呼叫method創建鄰接關係
  }

 //創建鄰接關係 使用edge陣列
 public void createQueues(int[][] edges,int numberOfVertices)
  {
   queues = new java.util.PriorityQueue[numberOfVertices];//宣告queue陣列

   //創建queue   
   for(int i=0;i<queues.length;i++)
    queues[i] = new java.util.PriorityQueue();

   //將陣列轉換為WeightedEdge放入queue
   for(int i=0;i<edges.length;i++)
    {
     int u = edges[i][0];
     int v = edges[i][1];
     int weight = edges[i][2];
     
     queues[u].offer(new WeightedEdge(u,v,weight));
    }
  }

 //創建鄰接關係 使用edge List
 public void createQueues(List<WeightedEdge>edges,int numberOfVertices)
  {
   queues = new java.util.PriorityQueue[numberOfVertices];//宣告queue陣列

   //創建queue   
   for(int i=0;i<queues.length;i++)
    queues[i] = new java.util.PriorityQueue();

   //將List的WeightedEdge放入queue
   for(WeightedEdge edge:edges)
    {
     queues[edge.u].offer(edge);
    }
  }

 //顯示所有edge
 public void printWeightedEdges()
  {
   //將queue中的edge迴圈顯示
   for(int i=0;i<queues.length;i++)
    {
     System.out.print("Vertex "+i+": ");//第i個vertex
     for(WeightedEdge edge: queues[i])
      {
       System.out.print("("+edge.u+", "+edge.v+", "+edge.weight+") ");//vertex的邊關係
      }
     System.out.println();
    }
  }
   
 //回傳minimum spinner tree(空值)
 public MST getMinimumSpanningTree()
  {
   return getMinimumSpanningTree(0);
  }

 //回傳minimum spinner tree
 //使用Prim's algorithm
 public MST getMinimumSpanningTree(int startingVertex)
  {
   Set<Integer> T = new HashSet<Integer>();//MST的vertices 集合
   
   T.add(startingVertex);//T加入起始點

   //宣告parent vertex陣列      
   int numberOfVertices = vertices.length;
   int[] parent = new int[numberOfVertices];

   //初始全為-1
   for(int i=0;i<parent.length;i++)
    parent[i] = -1;

   int totalWeight = 0;//總加權值

   PriorityQueue<WeightedEdge>[] queues = deepClone(this.queues);//複製鄰接list陣列

   //迴圈到所有vertices都放入
   while(T.size() < numberOfVertices)
    {
     //初始目前vertexc和max值
     int v = -1;
     double smallestWeight = Double.MAX_VALUE;

     //尋訪T中的vertex
     for(int u:T)
      {
       //若相鄰queue其中有已存在的vertex 移除 
       while(!queues[u].isEmpty() && T.contains(queues[u].peek().v))
        {
         queues[u].remove();
        }

       //若已經為空 跳過
       if(queues[u].isEmpty())
        continue;

       //取最前端的edge 因為PriorityQueue最前面的加權最小
       WeightedEdge edge = queues[u].peek();
       
       //跟目前set中的點比較 目前的edge是否加權最小
       if(edge.weight < smallestWeight)
        {
         v = edge.v;
         smallestWeight = edge.weight;
         parent[v] = u;
        }
      }

     //將vertex加入set
     T.add(v);
     totalWeight += smallestWeight;//加權值加入總加權值
    }

   return new MST(startingVertex,parent,totalWeight);//創建MST並回傳
  }

 //回傳minimum spinner tree
 //使用kruskal's algorithm
 public MST getMinimumSpanningTreeByKruskal()
  {
   Set<Integer> T = new HashSet<Integer>();//MST的vertices 集合
   PriorityQueue<WeightedEdge>[] MSTQueues = new PriorityQueue[vertices.length];//MST的鄰接關係
   
   //創建PriorityQueue
   for(int i=0;i<MSTQueues.length;i++)
    MSTQueues[i] = new PriorityQueue<WeightedEdge>();//創建queue

   //宣告parent vertex陣列      
   int numberOfVertices = vertices.length;
   int[] parent = new int[numberOfVertices];

   //初始全為-1
   for(int i=0;i<parent.length;i++)
    parent[i] = -1;

   int totalWeight = 0;//總加權值

   PriorityQueue<WeightedEdge>[] queues = deepClone(this.queues);//複製鄰接list陣列
 
   int edgeCount = 0;//MST邊數計數
   
   //迴圈到所有vertices都放入且edge數等於vertices數-1
   while(T.size()<numberOfVertices || edgeCount < numberOfVertices-1 )
    {
     int u = -1;//初始目前最大權值邊的u點
     double smallestWeight = Double.MAX_VALUE;//初始目前max值

     //找出最大權值的edge
     for(int i=0;i<queues.length;i++)
      {
       if(!queues[i].isEmpty() && queues[i].peek().weight<smallestWeight)
        {
         u = i;
         smallestWeight = queues[i].peek().weight;
        }
      }

     //取最前端的edge 因為PriorityQueue最前面的加權最小
     WeightedEdge edge = queues[u].poll();

     int v = edge.v;//連接的另一點
    
     //判斷u與v在MST上是否連接
     if(notSubset(u,v,MSTQueues))
      {
       //將u與v放入set
       if(!T.contains(u))
        T.add(u);
       if(!T.contains(edge.v))
        T.add(edge.v);

       WeightedEdge altEdge = new WeightedEdge(v,u,edge.weight);//因為是無向圖 也放入反向的edge

       //放入edge
       MSTQueues[u].offer(edge);
       MSTQueues[v].offer(altEdge);

       queues[v].remove(altEdge);//移除v中同一edge
       totalWeight += smallestWeight;//加權值加入總加權值
       edgeCount++;//edge數+1
      }
    }
   
   int root = (int)T.toArray()[0];//取set中最前面vertex為root

   MSTBfs(root,parent,MSTQueues);//做出parent關係

   return new MST(root,parent,totalWeight);//創建MST並回傳
  }

 //判斷是否在同一子集
 private boolean notSubset(int u,int v,PriorityQueue<WeightedEdge>[] queues)
  {
   //暫存vertex的queue
   java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>();
   
   boolean[] isVisited = new boolean[vertices.length];//判斷vertex是否已尋訪

   queue.offer(u);//放入指定vertex作為root
   isVisited[u] = true;
   
   //尋訪到queue為空
   while(!queue.isEmpty())
    {
     int i = queue.poll();//取出vertex

     //尋訪edge 並將未拜訪過的vertex加入queue
     for(WeightedEdge edge:queues[i])
      {
       int w = edge.v;
       //若鄰居有v 代表在同一子集 回傳false
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

 //做出parent關係
 private void MSTBfs(int root,int[] parent,PriorityQueue<WeightedEdge>[] queues)
  {
   //暫存vertex的queue
   java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>();

   boolean[] isVisited = new boolean[vertices.length];//判斷vertex是否已尋訪

   queue.offer(root);//放入指定vertex作為root
   isVisited[root] = true;
   
   //尋訪
   while(!queue.isEmpty())
    {
     int u = queue.poll();//取出vertex

     //尋訪鄰居vertex 並將未拜訪過的vertex加入queue
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

 //複製鄰接關係
 private PriorityQueue<WeightedEdge>[] deepClone(PriorityQueue<WeightedEdge>[] queues)
  {
   //複製的queue陣列
   PriorityQueue<WeightedEdge>[] copiedQueues = new PriorityQueue[queues.length];
   
   for(int i=0;i<queues.length;i++)
    {
     copiedQueues[i] = new PriorityQueue<WeightedEdge>();//創建queue
     
     //將來源資料放入複製的queue
     for(WeightedEdge e: queues[i])
      copiedQueues[i].add(e);
    } 

   return copiedQueues;
  }

 //minimum spinner tree
 public class MST extends Tree
  {
   private int totalWeight;//總權值

   //constructor   
   public MST(int root,int[] parent,int totalWeight)
    {
     super(root,parent);
     this.totalWeight = totalWeight;
    }

   //回傳總權值
   public int getTotalWeight()
    {
     return totalWeight;
    }
  }

 //找出起始vertex到其他vertex的最短路徑
 //使用Dijkstra's algorithm
 public ShortestPathTree getShortestPath(int sourceVertex)
  {
   Set<Integer> T = new HashSet<Integer>();//最短路徑的vertices 集合
   
   T.add(sourceVertex);//T加入起始點

   //宣告parent vertex陣列      
   int numberOfVertices = vertices.length;
   int[] parent = new int[numberOfVertices];

   parent[sourceVertex] = -1;//起始點無parent 設為-1

   //從V到每一點的cost
   int[] costs = new int[numberOfVertices];

   //初始設為最大
   for(int i=0;i<costs.length;i++)
    costs[i] = Integer.MAX_VALUE;

   costs[sourceVertex] = 0;//起始點cost為0

   PriorityQueue<WeightedEdge>[] queues = deepClone(this.queues);//複製的鄰接queue

   //迴圈直到所有點皆尋訪
   while(T.size() < numberOfVertices)
    {
     //初始化目前vertexc和最小cost值
     int v = -1;
     int smallestCost = Integer.MAX_VALUE;
     
     //尋訪T內的vertex
     for(int u: T)
      {
       //若相鄰不為空且相鄰vertex以存在於T 移除edge
       while(!queues[u].isEmpty() && T.contains(queues[u].peek().v))
        {
         queues[u].remove();
        }
       
       //若相鄰為空 跳過到下一個vertex
       if(queues[u].isEmpty())
        continue;
       
       //取最前端的edge 因為PriorityQueue最前面的加權最小
       WeightedEdge e = queues[u].peek();

       //比較目前的edge權值與目前點相加是否目前cost最小
       if(costs[u] + e.weight< smallestCost)
        {
         v = e.v;
         smallestCost = costs[u] + e.weight;
         parent[v] = u;
        }
      }
     
     T.add(v);//vertex加入T
     costs[v] = smallestCost;//vertex cost為目前最小值
    }

   return new ShortestPathTree(sourceVertex,parent,costs);//回傳
  }
 
 //最短路徑tree
 public class ShortestPathTree extends Tree
  {
   private int[] costs;//root到各點cost

   //costructor
   public ShortestPathTree(int source,int[] parent,int[] costs)
    {
     super(source,parent);
     this.costs = costs;
    }

   //回傳指定vertex的cost
   public int getCost(int v)
    {
     return costs[v];
    }
   
   //顯示tree path
   public void printAllPaths()
    {
     //從root到其他vertex
     System.out.println("All shortest paths from "+
                  vertices[getRoot()]+" are:");
 
     //顯示各點cost
     for(int i=0;i<costs.length;i++)
      {
       printPath(i);
       System.out.println("(cost: "+costs[i]+")");
      }
    }
  }
}