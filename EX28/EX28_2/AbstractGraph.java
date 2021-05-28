//abstract graph class

import java.util.*;

public abstract class AbstractGraph implements Graph
{
 protected Object[] vertices;//儲存vertex
 protected List<Integer>[] neighbors;//鄰接list

 //constructor
 //變數代入int[][],Object[]
 protected AbstractGraph(int[][] edges,Object[] vertices)
  {
   this.vertices = vertices;//直接引用
   createAdjacencyLists(edges,vertices.length);//將edge陣列轉為鄰接list
  }

 //constructor
 //變數代入List<Edge>,List
 protected AbstractGraph(List<Edge> edges,List vertices)
  {
   this.vertices = vertices.toArray();//vertices list轉為陣列
   createAdjacencyLists(edges,vertices.size());//將edge list轉為鄰接list
  }

 //constructor
 //變數代入List<Edge>,int(vertex數量)
 protected AbstractGraph(List<Edge> edges,int numberOfVertices)
  {
   vertices = new Integer[numberOfVertices];//用vertex數量宣告陣列

   //依序創建Integer
   for(int i=0;i<numberOfVertices;i++)
    vertices[i] = new Integer(i);

   createAdjacencyLists(edges,numberOfVertices);//將edge list轉為鄰接list
  }

 //constructor
 //變數代入int[][],int(vertex數量)
 protected AbstractGraph(int[][] edges,int numberOfVertices)
  {
   vertices = new Integer[numberOfVertices];//用vertex數量宣告陣列

   //依序創建Integer
   for(int i=0;i<numberOfVertices;i++)
    vertices[i] = new Integer(i);

   createAdjacencyLists(edges,numberOfVertices);//將edge陣列轉為鄰接list
  }

 //創建鄰接list
 //代入int[][],int
 private void createAdjacencyLists(int[][] edges,int numberOfVertices)
  {
   neighbors = new LinkedList[numberOfVertices];//依照vertex數量建立鄰接list陣列

   //迴圈依序創建linked list
   for(int i=0;i<numberOfVertices;i++)
    neighbors[i] = new java.util.LinkedList<Integer>();

   //將edge陣列內容轉至list
   for(int i=0;i<edges.length;i++)
    {
     int u = edges[i][0];//起點
     int v = edges[i][1];//終點
     neighbors[u].add(v);//將終點v加入到第u個list
    }
  }

 //創建鄰接list
 //代入List,int
 private void createAdjacencyLists(List<Edge> edges,int numberOfVertices)
  {
   neighbors = new LinkedList[numberOfVertices];//依照vertex數量建立鄰接list陣列

   //迴圈依序創建linked list
   for(int i=0;i<numberOfVertices;i++)
    neighbors[i] = new java.util.LinkedList<Integer>();

   //將edge list內容轉至鄰接list
   for(Edge edge: edges)
    {
     neighbors[edge.u].add(edge.v);//將終點v加入到第u個list
    }
  }

 //回傳vertice數量
 public int getSize()
  {
   return vertices.length;
  }

 //回傳vertices陣列
 public Object[] getVertices()
  {
   return vertices;
  }

 //取得指定的vertex
 public Object getVertex(int v)
  {
   return vertices[v];
  }

 //回傳指定vertex的index
 public int getIndex(Object vertex)
  {
   //迴圈尋訪所有vertices
   for(int i=0;i<getSize();i++)
    {
     //以equal判斷是否相等
     if(vertices[i].equals(vertex))
      return i;//若相等 回傳目前index
    }

   return -1;//若沒有相等 回傳-1
  }

 //回傳指定vertex的相鄰關係list
 public java.util.List getNeighbors(int v)
  {
   return neighbors[v];
  }

 //回傳指定vertex的分支度
 public int getDegree(int v)
  {
   return neighbors[v].size();//分支度即是vertex的相鄰vertex數
  }

 //回傳相鄰關係矩陣
 public int[][] getAdjacencyMatrix()
  {
   int[][] adjacencyMatrix = new int[getSize()][getSize()];//定義相鄰關係矩陣

   
   //迴圈尋訪鄰接list陣列
   for(int i=0;i<neighbors.length;i++)
    {
     for(int j = 0;j<neighbors[i].size();j++)
      {
       //若點u(即點i)與點v有相鄰關係 則矩陣[u][v] = 1 
       int v = neighbors[i].get(j);
       adjacencyMatrix[i][v] = 1;
      }
    }

   return adjacencyMatrix;//回傳
  }

 //顯示相鄰關係矩陣
 public void printAdjacencyMatrix()
  {
   int[][] adjacencyMatrix = getAdjacencyMatrix();//呼叫method取得相鄰關係矩陣

   //迴圈顯示矩陣內容
   for(int i=0;i<adjacencyMatrix.length;i++)
    {
     for(int j = 0;j<adjacencyMatrix[0].length;j++)
      {
       System.out.print(adjacencyMatrix[i][j]+" ");
      }
     System.out.println();
    }
  }

 //顯示edge
 public void printEdges()
  {
   //迴圈尋訪鄰接list
   for(int u=0;u<neighbors.length;u++)
    {
     System.out.print("Vertex "+u+": ");

     for(int j=0;j<neighbors[u].size();j++)
      {
       //依序顯示edge
       System.out.print("("+u+", "+neighbors[u].get(j)+") ");
      }
     
     System.out.println();
    }   
  }
 
 //深度優先搜尋樹(dfs)
 public Tree dfs(int v)
  {
   List<Integer> searchOrders = new ArrayList<Integer>();//尋訪順序list

   //vertex的parent vertex
   int[] parent = new int[vertices.length];
   
   //初始值為-1
   for(int i=0;i<parent.length;i++)
    parent[i] = -1;

   boolean[] isVisited = new boolean[vertices.length];//判斷vertex是否已尋訪

   //遞迴method
   dfs(v,parent,searchOrders,isVisited);

   return new Tree(v,parent,searchOrders);//回傳
  }

 //dfs recursive method
 private void dfs(int v,int[] parent,List<Integer> searchOrders,boolean[] isVisited)
  {
   searchOrders.add(v);//將目前vertex加入尋訪順序list
   isVisited[v] = true;//已經尋訪 設為true

   //迴圈尋訪目前vertex的鄰居
   for(int i:neighbors[v])
    {
     //若有還沒尋訪的點 
     if(!isVisited[i])
      {
       parent[i] = v;//父vertex設為目前vertex
       dfs(i,parent,searchOrders,isVisited);//遞迴
      }
    }
  }

 //廣度優先搜尋樹(bfs)
 public Tree bfs(int v)
  {
   List<Integer> searchOrders = new ArrayList<Integer>();//尋訪順序list

   //vertex的parent vertex
   int[] parent = new int[vertices.length];
   
   //初始值為-1
   for(int i=0;i<parent.length;i++)
    parent[i] = -1;

   //暫存vertex的queue
   java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>();

   boolean[] isVisited = new boolean[vertices.length];//判斷vertex是否已尋訪

   queue.offer(v);//放入指定vertex作為root
   isVisited[v] = true;
   
   while(!queue.isEmpty())
    {
     int u = queue.poll();//取出vertex
     searchOrders.add(u);//將vertex加入尋訪順序list

     //尋訪鄰居vertex 並將未拜訪過的vertex加入queue
     for(int w:neighbors[u])
      {
       if(!isVisited[w])
        {
         queue.offer(w);
         parent[w] = u;
         isVisited[w] = true;
        }
      }
    }

   return new Tree(v,parent,searchOrders);
  }

 //search tree
 public class Tree
  {
   private int root;//起始vertex
   private int[] parent;//代表父關係的陣列
   private List<Integer> searchOrders;//尋訪順序list

   //constructor
   //代入root parent searchOrder
   public Tree(int root,int[] parent,List<Integer> searchOrders)
    {
     this.root = root;
     this.parent = parent;
     this.searchOrders = searchOrders;
    }

   //constructor
   //代入root parent 
   public Tree(int root,int[] parent)
    {
     this.root = root;
     this.parent = parent;
    }

   //回傳root
   public int getRoot()
    {
     return root;
    }

   //回傳指定vertex的parent vertex
   public int getParent(int v)
    {
     return parent[v];
    }

   //回傳搜尋順序
   public List<Integer> getSearchOrders()
    {
     return searchOrders;
    }

   //回傳搜尋到的vertices數
   public int getNumberOfVerticesFound()
    {
     return searchOrders.size();
    }

   //回傳指定vertex的path iterator
   public java.util.Iterator pathIterator(int v)
    {
     return new PathIterator(v);
    }

   public class PathIterator implements java.util.Iterator
    {
     private Stack<Integer> stack;
     
     //constructor
     public PathIterator(int v)
      {
       stack = new Stack<Integer>();//定義stack
       
       //從指定vertex開始沿parent vertex來尋訪
       do{
        stack.add(v);//放入stack
        v = parent[v];//v變為parent
       }while(v !=-1);//直到沒有parent
      }   

     //回傳是否還有vertex
     public boolean hasNext()
      {
       return !stack.isEmpty();
      }

     //回傳並放出vertex
     public Object next()
      {
       return vertices[stack.pop()];
      }

     //移除 無實作
     public void remove()
      {}
    }

   //顯示root到指定vertex的路徑
   public void printPath(int v)
    {
     Iterator iterator = new PathIterator(v);
     //顯示要從root到v
     System.out.print("A path from "+vertices[root]+" to "+vertices[v]);

     //顯示路徑
     while(iterator.hasNext())
      {
       System.out.print(iterator.next()+" ");
      }
    }

   //顯示tree path
   public void printTree()
    {
     System.out.println("Root is: "+vertices[root]);
     System.out.print("Edges: ");
       
     //根據parent顯示相連關係
     for(int i=0;i<parent.length;i++)
      {
       if(parent[i] != -1)
        {
         System.out.print("("+vertices[parent[i]]+", "+vertices[i]+") ");
        }
      }
    }
  }
}