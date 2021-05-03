//Abstract Graph class

import java.util.*;

public abstract class AbstractGraph implements Graph
{
 protected Object[] vertices;//�I�}�C
 protected List<Integer>[] neighbors;//�۾F���Y�}�C

 //contructor
 //��J�}�C
 protected AbstractGraph(int[][] edges, Object[] vertices)
  {
   this.vertices = vertices;
   createAdjacencyLists(edges,vertices.length);//�N��}�C�ର�۾F���Y�}�C
  }

 //contructor
 //��Jlist
 protected AbstractGraph(List<Edge> edges, List vertices)
  {
   this.vertices = vertices.toArray();//�Nlist�ର�}�C
   createAdjacencyLists(edges,vertices.size());//�Nedge list�ର�۾F�}�C
  }

 //contructor
 //�Ӷ��ǳХXvertex
 protected AbstractGraph(List<Edge> edges,int numberOfVertices)
  {
   //�̷Ӷ��ǳЫ�vertex����
   vertices = new Integer[numberOfVertices];
   for(int i=0;i<numberOfVertices;i++)
    vertices[i] = new Integer(i);

   createAdjacencyLists(edges,numberOfVertices);//�Nedge list�ର�۾F�}�C
  }

 //contructor
 //��J��}�C
 //�Ӷ��ǳХXvertex
 protected AbstractGraph(int[][] edges, int numberOfVertices)
  {
   //�̷Ӷ��ǳЫ�vertex����
   vertices = new Integer[numberOfVertices];
   for(int i=0;i<numberOfVertices;i++)
    vertices[i] = new Integer(i);

   createAdjacencyLists(edges,numberOfVertices);//�N��}�C�ର�۾F���Y�}�C
  }

 //�ХX�۾F���Y�}�C
 //���J��}�C
 private void createAdjacencyLists(int[][] edges,int numberOfVertices)
  {
   neighbors = new LinkedList[numberOfVertices];//��vertex�ƨM�w�}�C����

   //�Ы�linked list
   for(int i=0;i<numberOfVertices;i++)
    neighbors[i] = new java.util.LinkedList<Integer>();
   
   //�̧ǥ[�J�����Y
   for(int i=0;i<edges.length;i++)
    {
     int u = edges[i][0];
     int v = edges[i][1];
     neighbors[u].add(v);
    }
  }

 //�ХX�۾F���Y�}�C
 //���Jedge list
 private void createAdjacencyLists(List<Edge> edges,int numberOfVertices)
  {
   neighbors = new LinkedList[numberOfVertices];//��vertex�ƨM�w�}�C����

   //�Ы�linked list
   for(int i=0;i<numberOfVertices;i++)
    neighbors[i] = new java.util.LinkedList<Integer>();
   
   //�̧ǥ[�J�����Y
   for(Edge edge: edges)
    neighbors[edge.u].add(edge.v);
  }

 //���o�j�p(vertex��)
 public int getSize()
  {
   return vertices.length;
  }

 //���overtex�}�C
 public Object[] getVertices()
  {
   return vertices;
  }

 //���o���windex��veertex
 public Object getVertex(int v)
  {
   return vertices[v];
  }

//���o���wvertex��index
 public int getIndex(Object vertex)
  {
   //�j��M�X
   for(int i=0;i<getSize();i++)
    {
     //�M���ۦPvertex�ɦ^��index
     if(vertex.equals(vertices[i]))
      return i;
    }

   return -1;//�S���^��-1
  }

 //���o���windex��vertex���۾F���Ylist
 public java.util.List getNeighbors(int v)
  {
   return neighbors[v];
  }

 //���o���windex��vertex�������
 public int getDegree(int v)
  {
   return neighbors[v].size();//�^�Ǭ۾F���
  }

 //���o�۾F���Y�}�C
 public int[][] getAdjacencyMatrix()
  {
   int[][] adjacencyMatrix = new int[getSize()][getSize()];//�ŧi�}�C
   
   //�j��N���۾F����i�I�M��j�I���}�C�]��1
   for(int i=0;i<neighbors.length;i++)
    for(int j=0;j<neighbors[i].size();j++)
     {
      int v = neighbors[i].get(j);
      adjacencyMatrix[i][v] = 1;
     }

   return adjacencyMatrix;//�^�ǰ}�C
  }

 //��ܬ۾F���Y�}�C
 public void printAdjacencyMatrix()
  {
   int[][] adjacencyMatrix = getAdjacencyMatrix();//�I�smethod���o�}�C
   
   //���
   for(int i=0;i<adjacencyMatrix.length;i++)
    {
     for(int j=0;j<adjacencyMatrix[0].length;j++)
      System.out.print(adjacencyMatrix[i][j]+" ");
     
     System.out.println();
    } 
  }

 //��ܳs��vertex����
 public void printEdges()
  {
   //�۾F�}�C�j��
   for(int u=0;u<neighbors.length;u++)
    {
     //�_�I
     System.out.print("Vertex "+u+": ");
     for(int j=0;j<neighbors[u].size();j++)
      {
       System.out.print("("+u+", "+neighbors[u].get(j)+") ");//���I
      }
     
     System.out.println();
    }
  }

 //depth first search
 public Tree dfs(int v)
  {
   List<Integer> searchOrders = new ArrayList<Integer>();//���X����list
   int[] parent = new int[vertices.length];//�C��vertex��parent
   
   //parent�w�]��-1
   for(int i=0;i<parent.length;i++)
    parent[i] = -1;

   boolean[] isVisited = new boolean[vertices.length];//�P�_vertex�O�_���X�L
   
   dfs(v,parent,searchOrders,isVisited);//�I�srecursion method

   return new Tree(v,parent,searchOrders);//�Ы�tree�æ^��
  }

 //dfs helper method
 public void dfs(int v,int[] parent,List<Integer> searchOrders,boolean[] isVisited)
  {
   searchOrders.add(v);//�Nv�[�J���Xlist
   isVisited[v] = true;//���X��index�]��true
   
   //�N�۳svertex�� �����X�L��vertex�����j
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
   List<Integer> searchOrders = new ArrayList<Integer>();//���X����list
   int[] parent = new int[vertices.length];//�C��vertex��parent

   //parent�w�]��-1
   for(int i=0;i<parent.length;i++)
    parent[i] = -1;

   java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>();//�x�svertex��C
   boolean[] isVisited = new boolean[vertices.length];//�P�_�O�_�w���X
   queue.offer(v);//��J���windex�@��root

   isVisited[v] = true;
   
   //�Hqueue���i���X�S�� �i���X�P�@level���lvertex
   //�Ӥ��|���N�S��vertex�]��parent������
   while(!queue.isEmpty())
    {
     //���Xindex�é�Jlist
     int u = queue.poll();
     searchOrders.add(u);
     
     //�N�۳svertex��Jqueue
     //�P�@level�|�����X   
     for(int w:neighbors[u])
      if(!isVisited[w])
       {
        queue.offer(w);
        parent[w] = u;
        isVisited[w] = true;
       }
    }

   return new Tree(v,parent,searchOrders);//�^��spinner tree
  }

 //���o���wvertex�j����|
 public List getACycle(int u,int v)
  {
   Tree tree = bfs(u);//�Hu��root�@bfs tree

   List<Integer> searchOrder = tree.getSearchOrders();//�@bfs tree���M�X

   //�p�G�M�X���|�S��v �^��null
   if(!searchOrder.contains(v))
    return null;

   List<Integer> vlist = new ArrayList<Integer>();//bfs���HV���ڤ��l��
   List<Integer> ulist = new ArrayList<Integer>();//bfs���qV��U�����|

   //�M�X��queue
   java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>();
   
   queue.offer(v);//��Jv�}�l�M�X

   int parent =v;//���o�𤤪�v��parent

   //�}�l���W�l��v��u
   while(parent!=-1)
    {
     ulist.add(0,parent);//�Nparent��J���|
     parent = tree.getParent(parent);//���o�s��parent
    }

   //�o�Xbfs���HV���ڤ��l��
   while(!queue.isEmpty())
    {
     int n = queue.poll();//���Xvertex
     vlist.add(n);
     
     for(int w:neighbors[n])
      if(tree.getParent(w)==n)
       queue.offer(w);
    }

   List<Integer> rlist = new ArrayList<Integer>();//�^��cycle

   //�[�Ju��v���| ���]�tv
   for(int i=0;i<ulist.size()-1;i++)
    rlist.add(ulist.get(i));

   //�qv�}�l�M�Xv���l��
   //�q�M�X�I���F�~�}�l����|
   for(int i:vlist)
    {
     rlist.add(i);//�[�Jvertex

     //�M�X�F�~
     for(int j:neighbors[i])
      {
       List<Integer> path = new ArrayList<Integer>();//�F�~��u��path list

       //�p�G���bu��v���|�W ��X���|
       if(!rlist.contains(j))
        //�Y�s�b���| �^��list
        if(getPath(j,u,rlist,path))
         {
          rlist.addAll(path);
          return rlist;
         }
       }
     }

   return null;//�S�����| �^��null
  }

 //�M���I���I�����|
 //�]��cycle���|���঳�����I 
 public boolean getPath(int u,int v,List<Integer> out,List<Integer> path)
  {
   path.add(u);//�Nu�[�J���|

   List<Integer> neightbor =getNeighbors(u);//neightbor list

   //�Y�w�]�t�ؼ��I �^��true
   if(neightbor.contains(v))
    return true;

   //�M�X�F�~   
   for(int i=0;i<neightbor.size();i++)
    {
     int n = neightbor.get(i);

     //�Y���򤧫e���|�I���� �����j
     if(!out.contains(n) && !path.contains(n))
      return getPath(n,v,out,path);
     
    }

   path.remove(path.size()-1);//�Y���ű��� �����overtex
   return false;
  }

 //���oHamiltonian Path(�C�@�I���q�L�B�u�q�L�@�������|)
 public List<Integer> getHamiltonianPath(Object vertex)
  {
   return getHamiltonianPath(getIndex(vertex));//�I�shelper method
  }

 //Hamiltonian Path helper method
 public List<Integer> getHamiltonianPath(int v)
  {
   int[] next = new int[getSize()];//��i vertex���U�@��vertex

   //next�����w�]��-1
   for(int i=0;i<next.length;i++)
    next[i] = -1;

   boolean[] isVisited = new boolean[getSize()];//�P�_�O�_�w���X

   List<Integer> result = null;//�^��list �N����|

   //�ھڤ���׭��s�ƧǬ۾F���Y����
   for(int i=0;i<getSize();i++)
    reorderNeighborsBasedOnDegree(neighbors[i]);

   //�P�_�O�_�s�b Hamiltonian Path  
   if(getHamiltonianPath(v,next,isVisited))
    {
     //�Y�s�b�h�Q��next�}�C�Nvertex�̧ǩ�Jlist
     result = new ArrayList<Integer>();
     int vertex = v;
     while(vertex != -1)
      {
       result.add(vertex);
       vertex = next[vertex];
      }
    }
   
   return result;//�^��
  }

 //�ھڤ���׭��s�ƧǬ۾F���Y���� �Ѥp��j
 public void reorderNeighborsBasedOnDegree(List<Integer> list)
  {
   //���Ӥ���פj�p�Hselect sort�Ƨ�
   for(int i=list.size()-1;i>=1;i--)
    {
     //�w�]index 0���̤j
     int currentMaxDegree = getDegree(list.get(0));//�w�]�̤j�����
     int currentMaxIndex = 0;
     
     //��i�����X�̤jindex 
     for(int j=1;j<=i;j++)
      {
       if(currentMaxDegree < getDegree(list.get(j)))
        {
         currentMaxDegree = getDegree(list.get(j));
         currentMaxIndex = j;
        }
      }
     
     //�Y�̤j��index����i �洫
     if(currentMaxIndex != i)
      {
       int temp = list.get(currentMaxIndex);
       list.set(currentMaxIndex,list.get(i));
       list.set(i,temp);
      }
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

 //�P�_�O�_�s�bHamiltonian Path
 private boolean getHamiltonianPath(int v,int[] next,boolean[] isVisited)
  {
   isVisited[v] = true;//�ثevertex���X�]��true
   
   //�Y�����w���X �^��true
   if(allVisited(isVisited))
    return true;

   //�N�F�~vertex���U�@�����j
   for(int i=0;i<neighbors[v].size();i++)
    {
     int u = neighbors[v].get(i);

     //�Y���j���G��true �^��true
     if(!isVisited[u] && getHamiltonianPath(u,next,isVisited))
      {
       next[v] = u;
       return true;
      }
    }

   //�Y�����F�~�L���G �N�ثevertex���X�]�^false
   isVisited[v] = false;
   return false;//�^��false
  }

 //spinner tree
 public class Tree
  {
   private int root;//��vertex
   private int[] parent;//�C��vertex��parent
   private List<Integer> searchOrders;//���X����

   //contructor
   //���J���X����list
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

   //���oroot vertex
   public int getRoot()
    {
     return root;
    }

   //���o���wvertex��parent
   public int getParent(int v)
    {
     return parent[v];
    }

   //�^�Ǩ��X����
   public List<Integer> getSearchOrders()
    {
     return searchOrders;
    }

   //���X��vertex�ƶq
   public int getNumberOfVerticesFound()
    {
     return searchOrders.size();
    }

   //�^�� Iterator
   public java.util.Iterator pathIterator(int v)
    {
     return new PathIterator(v);
    }

   //Iterator class
   public class PathIterator implements java.util.Iterator
    {
     private Stack<Integer> stack;//�x�sstack
     
     //contructor
     public PathIterator(int v)
      {
       stack = new Stack<Integer>();//�Ы�stack
       do{
        stack.add(v);//��Jvertex
        v = parent[v];//�svertex�]��parent
       }
       while(v != -1);
      }

     //�P�_�O�_���U�@��vertex
     public boolean hasNext()
      {
       return !stack.isEmpty();
      }

     //�^�ǥثevertex
     public Object next()
      {
       return vertices[stack.pop()];
      }

     //���� ����@
     public void remove()
      {}
    }

   //��ܸ��| �qroot��v
   public void printPath(int v)
    {
     Iterator iterator = pathIterator(v);

     //root to v
     System.out.print("A path from "+vertices[root]+" to "+vertices[v]+": ");
     
     //�j�����
     while(iterator.hasNext())
      {
       System.out.print(iterator.next()+" ");
      }
    }

   //���tree����
   public void printTree()
    {
     System.out.println("Root is: "+vertices[root]);
     System.out.print("Edges: ");
     
     //�̧���ܳs����
     for(int i=0;i<parent.length;i++)
      {
       if(parent[i] !=-1)
        System.out.print("("+vertices[parent[i]]+", "+vertices[i]+") ");
      }
     
     System.out.println();
    }
  }   
}