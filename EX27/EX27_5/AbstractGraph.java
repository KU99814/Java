//Abstract Graph class

import java.util.*;

public abstract class AbstractGraph implements Graph
{
 protected Object[] vertices;//點陣列
 protected List<Integer>[] neighbors;//相鄰關係陣列

 //contructor
 //輸入陣列
 protected AbstractGraph(int[][] edges, Object[] vertices)
  {
   this.vertices = vertices;
   createAdjacencyLists(edges,vertices.length);//將邊陣列轉為相鄰關係陣列
  }

 //contructor
 //輸入list
 protected AbstractGraph(List<Edge> edges, List vertices)
  {
   this.vertices = vertices.toArray();//將list轉為陣列
   createAdjacencyLists(edges,vertices.size());//將edge list轉為相鄰陣列
  }

 //contructor
 //照順序創出vertex
 protected AbstractGraph(List<Edge> edges,int numberOfVertices)
  {
   //依照順序創建vertex物件
   vertices = new Integer[numberOfVertices];
   for(int i=0;i<numberOfVertices;i++)
    vertices[i] = new Integer(i);

   createAdjacencyLists(edges,numberOfVertices);//將edge list轉為相鄰陣列
  }

 //contructor
 //輸入邊陣列
 //照順序創出vertex
 protected AbstractGraph(int[][] edges, int numberOfVertices)
  {
   //依照順序創建vertex物件
   vertices = new Integer[numberOfVertices];
   for(int i=0;i<numberOfVertices;i++)
    vertices[i] = new Integer(i);

   createAdjacencyLists(edges,numberOfVertices);//將邊陣列轉為相鄰關係陣列
  }

 //創出相鄰關係陣列
 //載入邊陣列
 private void createAdjacencyLists(int[][] edges,int numberOfVertices)
  {
   neighbors = new LinkedList[numberOfVertices];//依vertex數決定陣列長度

   //創建linked list
   for(int i=0;i<numberOfVertices;i++)
    neighbors[i] = new java.util.LinkedList<Integer>();
   
   //依序加入邊關係
   for(int i=0;i<edges.length;i++)
    {
     int u = edges[i][0];
     int v = edges[i][1];
     neighbors[u].add(v);
    }
  }

 //創出相鄰關係陣列
 //載入edge list
 private void createAdjacencyLists(List<Edge> edges,int numberOfVertices)
  {
   neighbors = new LinkedList[numberOfVertices];//依vertex數決定陣列長度

   //創建linked list
   for(int i=0;i<numberOfVertices;i++)
    neighbors[i] = new java.util.LinkedList<Integer>();
   
   //依序加入邊關係
   for(Edge edge: edges)
    neighbors[edge.u].add(edge.v);
  }

 //取得大小(vertex數)
 public int getSize()
  {
   return vertices.length;
  }

 //取得vertex陣列
 public Object[] getVertices()
  {
   return vertices;
  }

 //取得指定index的veertex
 public Object getVertex(int v)
  {
   return vertices[v];
  }

//取得指定vertex的index
 public int getIndex(Object vertex)
  {
   //迴圈尋訪
   for(int i=0;i<getSize();i++)
    {
     //尋找到相同vertex時回傳index
     if(vertex.equals(vertices[i]))
      return i;
    }

   return -1;//沒找到回傳-1
  }

 //取得指定index的vertex的相鄰關係list
 public java.util.List getNeighbors(int v)
  {
   return neighbors[v];
  }

 //取得指定index的vertex的分支度
 public int getDegree(int v)
  {
   return neighbors[v].size();//回傳相鄰邊數
  }

 //取得相鄰關係陣列
 public int[][] getAdjacencyMatrix()
  {
   int[][] adjacencyMatrix = new int[getSize()][getSize()];//宣告陣列
   
   //迴圈將有相鄰的第i點和第j點的陣列設為1
   for(int i=0;i<neighbors.length;i++)
    for(int j=0;j<neighbors[i].size();j++)
     {
      int v = neighbors[i].get(j);
      adjacencyMatrix[i][v] = 1;
     }

   return adjacencyMatrix;//回傳陣列
  }

 //顯示相鄰關係陣列
 public void printAdjacencyMatrix()
  {
   int[][] adjacencyMatrix = getAdjacencyMatrix();//呼叫method取得陣列
   
   //顯示
   for(int i=0;i<adjacencyMatrix.length;i++)
    {
     for(int j=0;j<adjacencyMatrix[0].length;j++)
      System.out.print(adjacencyMatrix[i][j]+" ");
     
     System.out.println();
    } 
  }

 //顯示連接vertex的邊
 public void printEdges()
  {
   //相鄰陣列迴圈
   for(int u=0;u<neighbors.length;u++)
    {
     //起點
     System.out.print("Vertex "+u+": ");
     for(int j=0;j<neighbors[u].size();j++)
      {
       System.out.print("("+u+", "+neighbors[u].get(j)+") ");//終點
      }
     
     System.out.println();
    }
  }

 //depth first search
 public Tree dfs(int v)
  {
   List<Integer> searchOrders = new ArrayList<Integer>();//走訪順序list
   int[] parent = new int[vertices.length];//每個vertex的parent
   
   //parent預設為-1
   for(int i=0;i<parent.length;i++)
    parent[i] = -1;

   boolean[] isVisited = new boolean[vertices.length];//判斷vertex是否走訪過
   
   dfs(v,parent,searchOrders,isVisited);//呼叫recursion method

   return new Tree(v,parent,searchOrders);//創建tree並回傳
  }

 //dfs helper method
 public void dfs(int v,int[] parent,List<Integer> searchOrders,boolean[] isVisited)
  {
   searchOrders.add(v);//將v加入走訪list
   isVisited[v] = true;//走訪的index設為true
   
   //將相連vertex中 未走訪過之vertex做遞迴
   for(int i:neighbors[v])
    if(!isVisited[i])
     {
      parent[i] = v;
      dfs(i,parent,searchOrders,isVisited);
     }
  }

 //breadth first search 
 public Tree bfs(int v)
  {
   List<Integer> searchOrders = new ArrayList<Integer>();//走訪順序list
   int[] parent = new int[vertices.length];//每個vertex的parent

   //parent預設為-1
   for(int i=0;i<parent.length;i++)
    parent[i] = -1;

   java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>();//儲存vertex佇列
   boolean[] isVisited = new boolean[vertices.length];//判斷是否已走訪
   queue.offer(v);//放入指定index作為root

   isVisited[v] = true;
   
   //以queue先進先出特性 可走訪同一level的子vertex
   //而不會有將兄弟vertex設為parent的情形
   while(!queue.isEmpty())
    {
     //取出index並放入list
     int u = queue.poll();
     searchOrders.add(u);
     
     //將相連vertex放入queue
     //同一level會先走訪   
     for(int w:neighbors[u])
      if(!isVisited[w])
       {
        queue.offer(w);
        parent[w] = u;
        isVisited[w] = true;
       }
    }

   return new Tree(v,parent,searchOrders);//回傳spinner tree
  }

 //取得指定vertex迴圈路徑
 public List getACycle(int u,int v)
  {
   Tree tree = bfs(u);//以u為root作bfs tree

   List<Integer> searchOrder = tree.getSearchOrders();//作bfs tree的尋訪

   //如果尋訪路徑沒有v 回傳null
   if(!searchOrder.contains(v))
    return null;

   List<Integer> vlist = new ArrayList<Integer>();//bfs中以V為根之子樹
   List<Integer> ulist = new ArrayList<Integer>();//bfs中從V到U的路徑

   //尋訪用queue
   java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>();
   
   queue.offer(v);//放入v開始尋訪

   int parent =v;//取得樹中的v的parent

   //開始往上追朔v到u
   while(parent!=-1)
    {
     ulist.add(0,parent);//將parent放入路徑
     parent = tree.getParent(parent);//取得新的parent
    }

   //得出bfs中以V為根之子樹
   while(!queue.isEmpty())
    {
     int n = queue.poll();//取出vertex
     vlist.add(n);
     
     for(int w:neighbors[n])
      if(tree.getParent(w)==n)
       queue.offer(w);
    }

   List<Integer> rlist = new ArrayList<Integer>();//回傳cycle

   //加入u到v路徑 不包含v
   for(int i=0;i<ulist.size()-1;i++)
    rlist.add(ulist.get(i));

   //從v開始尋訪v的子樹
   //從尋訪點的鄰居開始找路徑
   for(int i:vlist)
    {
     rlist.add(i);//加入vertex

     //尋訪鄰居
     for(int j:neighbors[i])
      {
       List<Integer> path = new ArrayList<Integer>();//鄰居到u的path list

       //如果不在u到v路徑上 找出路徑
       if(!rlist.contains(j))
        //若存在路徑 回傳list
        if(getPath(j,u,rlist,path))
         {
          rlist.addAll(path);
          return rlist;
         }
       }
     }

   return null;//沒有路徑 回傳null
  }

 //尋找點到點的路徑
 //因為cycle路徑不能有重複點 
 public boolean getPath(int u,int v,List<Integer> out,List<Integer> path)
  {
   path.add(u);//將u加入路徑

   List<Integer> neightbor =getNeighbors(u);//neightbor list

   //若已包含目標點 回傳true
   if(neightbor.contains(v))
    return true;

   //尋訪鄰居   
   for(int i=0;i<neightbor.size();i++)
    {
     int n = neightbor.get(i);

     //若不跟之前路徑點重覆 做遞迴
     if(!out.contains(n) && !path.contains(n))
      return getPath(n,v,out,path);
     
    }

   path.remove(path.size()-1);//若不符條件 取消這vertex
   return false;
  }

 //取得Hamiltonian Path(每一點都通過且只通過一次的路徑)
 public List<Integer> getHamiltonianPath(Object vertex)
  {
   return getHamiltonianPath(getIndex(vertex));//呼叫helper method
  }

 //Hamiltonian Path helper method
 public List<Integer> getHamiltonianPath(int v)
  {
   int[] next = new int[getSize()];//第i vertex的下一個vertex

   //next全部預設為-1
   for(int i=0;i<next.length;i++)
    next[i] = -1;

   boolean[] isVisited = new boolean[getSize()];//判斷是否已走訪

   List<Integer> result = null;//回傳list 代表路徑

   //根據分支度重新排序相鄰關係順序
   for(int i=0;i<getSize();i++)
    reorderNeighborsBasedOnDegree(neighbors[i]);

   //判斷是否存在 Hamiltonian Path  
   if(getHamiltonianPath(v,next,isVisited))
    {
     //若存在則利用next陣列將vertex依序放入list
     result = new ArrayList<Integer>();
     int vertex = v;
     while(vertex != -1)
      {
       result.add(vertex);
       vertex = next[vertex];
      }
    }
   
   return result;//回傳
  }

 //根據分支度重新排序相鄰關係順序 由小到大
 public void reorderNeighborsBasedOnDegree(List<Integer> list)
  {
   //按照分支度大小以select sort排序
   for(int i=list.size()-1;i>=1;i--)
    {
     //預設index 0為最大
     int currentMaxDegree = getDegree(list.get(0));//預設最大分支度
     int currentMaxIndex = 0;
     
     //到i為止找出最大index 
     for(int j=1;j<=i;j++)
      {
       if(currentMaxDegree < getDegree(list.get(j)))
        {
         currentMaxDegree = getDegree(list.get(j));
         currentMaxIndex = j;
        }
      }
     
     //若最大的index不為i 交換
     if(currentMaxIndex != i)
      {
       int temp = list.get(currentMaxIndex);
       list.set(currentMaxIndex,list.get(i));
       list.set(i,temp);
      }
    }
  }

 //判斷是否全部走訪
 private boolean allVisited(boolean[] isVisited)
  {
   boolean result = true;//判斷結果

   for(int i=0;i<getSize();i++)
    result = result && isVisited[i];//若有至少一個false 必為false 

   return result;//回傳
  }

 //判斷是否存在Hamiltonian Path
 private boolean getHamiltonianPath(int v,int[] next,boolean[] isVisited)
  {
   isVisited[v] = true;//目前vertex走訪設為true
   
   //若全部已走訪 回傳true
   if(allVisited(isVisited))
    return true;

   //將鄰居vertex做下一次遞迴
   for(int i=0;i<neighbors[v].size();i++)
    {
     int u = neighbors[v].get(i);

     //若遞迴結果為true 回傳true
     if(!isVisited[u] && getHamiltonianPath(u,next,isVisited))
      {
       next[v] = u;
       return true;
      }
    }

   //若全部鄰居無結果 將目前vertex走訪設回false
   isVisited[v] = false;
   return false;//回傳false
  }

 //spinner tree
 public class Tree
  {
   private int root;//根vertex
   private int[] parent;//每個vertex的parent
   private List<Integer> searchOrders;//走訪順序

   //contructor
   //載入走訪順序list
   public Tree(int root,int[] parent,List<Integer> searchOrders)
    {
     this.root = root;
     this.parent = parent;
     this.searchOrders = searchOrders;
    }

   //contructor
   public Tree(int root,int[] parent)
    {
     this.root = root;
     this.parent = parent;
    }

   //取得root vertex
   public int getRoot()
    {
     return root;
    }

   //取得指定vertex的parent
   public int getParent(int v)
    {
     return parent[v];
    }

   //回傳走訪順序
   public List<Integer> getSearchOrders()
    {
     return searchOrders;
    }

   //走訪的vertex數量
   public int getNumberOfVerticesFound()
    {
     return searchOrders.size();
    }

   //回傳 Iterator
   public java.util.Iterator pathIterator(int v)
    {
     return new PathIterator(v);
    }

   //Iterator class
   public class PathIterator implements java.util.Iterator
    {
     private Stack<Integer> stack;//儲存stack
     
     //contructor
     public PathIterator(int v)
      {
       stack = new Stack<Integer>();//創建stack
       do{
        stack.add(v);//放入vertex
        v = parent[v];//新vertex設為parent
       }
       while(v != -1);
      }

     //判斷是否有下一個vertex
     public boolean hasNext()
      {
       return !stack.isEmpty();
      }

     //回傳目前vertex
     public Object next()
      {
       return vertices[stack.pop()];
      }

     //移除 不實作
     public void remove()
      {}
    }

   //顯示路徑 從root到v
   public void printPath(int v)
    {
     Iterator iterator = pathIterator(v);

     //root to v
     System.out.print("A path from "+vertices[root]+" to "+vertices[v]+": ");
     
     //迴圈顯示
     while(iterator.hasNext())
      {
       System.out.print(iterator.next()+" ");
      }
    }

   //顯示tree整體
   public void printTree()
    {
     System.out.println("Root is: "+vertices[root]);
     System.out.print("Edges: ");
     
     //依序顯示連接邊
     for(int i=0;i<parent.length;i++)
      {
       if(parent[i] !=-1)
        System.out.print("("+vertices[parent[i]]+", "+vertices[i]+") ");
      }
     
     System.out.println();
    }
  }   
}