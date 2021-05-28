//abstract graph class

import java.util.*;

public abstract class AbstractGraph implements Graph
{
 protected Object[] vertices;//�x�svertex
 protected List<Integer>[] neighbors;//�F��list

 //constructor
 //�ܼƥN�Jint[][],Object[]
 protected AbstractGraph(int[][] edges,Object[] vertices)
  {
   this.vertices = vertices;//�����ޥ�
   createAdjacencyLists(edges,vertices.length);//�Nedge�}�C�ର�F��list
  }

 //constructor
 //�ܼƥN�JList<Edge>,List
 protected AbstractGraph(List<Edge> edges,List vertices)
  {
   this.vertices = vertices.toArray();//vertices list�ର�}�C
   createAdjacencyLists(edges,vertices.size());//�Nedge list�ର�F��list
  }

 //constructor
 //�ܼƥN�JList<Edge>,int(vertex�ƶq)
 protected AbstractGraph(List<Edge> edges,int numberOfVertices)
  {
   vertices = new Integer[numberOfVertices];//��vertex�ƶq�ŧi�}�C

   //�̧ǳЫ�Integer
   for(int i=0;i<numberOfVertices;i++)
    vertices[i] = new Integer(i);

   createAdjacencyLists(edges,numberOfVertices);//�Nedge list�ର�F��list
  }

 //constructor
 //�ܼƥN�Jint[][],int(vertex�ƶq)
 protected AbstractGraph(int[][] edges,int numberOfVertices)
  {
   vertices = new Integer[numberOfVertices];//��vertex�ƶq�ŧi�}�C

   //�̧ǳЫ�Integer
   for(int i=0;i<numberOfVertices;i++)
    vertices[i] = new Integer(i);

   createAdjacencyLists(edges,numberOfVertices);//�Nedge�}�C�ର�F��list
  }

 //�ЫؾF��list
 //�N�Jint[][],int
 private void createAdjacencyLists(int[][] edges,int numberOfVertices)
  {
   neighbors = new LinkedList[numberOfVertices];//�̷�vertex�ƶq�إ߾F��list�}�C

   //�j��̧ǳЫ�linked list
   for(int i=0;i<numberOfVertices;i++)
    neighbors[i] = new java.util.LinkedList<Integer>();

   //�Nedge�}�C���e���list
   for(int i=0;i<edges.length;i++)
    {
     int u = edges[i][0];//�_�I
     int v = edges[i][1];//���I
     neighbors[u].add(v);//�N���Iv�[�J���u��list
    }
  }

 //�ЫؾF��list
 //�N�JList,int
 private void createAdjacencyLists(List<Edge> edges,int numberOfVertices)
  {
   neighbors = new LinkedList[numberOfVertices];//�̷�vertex�ƶq�إ߾F��list�}�C

   //�j��̧ǳЫ�linked list
   for(int i=0;i<numberOfVertices;i++)
    neighbors[i] = new java.util.LinkedList<Integer>();

   //�Nedge list���e��ܾF��list
   for(Edge edge: edges)
    {
     neighbors[edge.u].add(edge.v);//�N���Iv�[�J���u��list
    }
  }

 //�^��vertice�ƶq
 public int getSize()
  {
   return vertices.length;
  }

 //�^��vertices�}�C
 public Object[] getVertices()
  {
   return vertices;
  }

 //���o���w��vertex
 public Object getVertex(int v)
  {
   return vertices[v];
  }

 //�^�ǫ��wvertex��index
 public int getIndex(Object vertex)
  {
   //�j��M�X�Ҧ�vertices
   for(int i=0;i<getSize();i++)
    {
     //�Hequal�P�_�O�_�۵�
     if(vertices[i].equals(vertex))
      return i;//�Y�۵� �^�ǥثeindex
    }

   return -1;//�Y�S���۵� �^��-1
  }

 //�^�ǫ��wvertex���۾F���Ylist
 public java.util.List getNeighbors(int v)
  {
   return neighbors[v];
  }

 //�^�ǫ��wvertex�������
 public int getDegree(int v)
  {
   return neighbors[v].size();//����קY�Overtex���۾Fvertex��
  }

 //�^�Ǭ۾F���Y�x�}
 public int[][] getAdjacencyMatrix()
  {
   int[][] adjacencyMatrix = new int[getSize()][getSize()];//�w�q�۾F���Y�x�}

   
   //�j��M�X�F��list�}�C
   for(int i=0;i<neighbors.length;i++)
    {
     for(int j = 0;j<neighbors[i].size();j++)
      {
       //�Y�Iu(�Y�Ii)�P�Iv���۾F���Y �h�x�}[u][v] = 1 
       int v = neighbors[i].get(j);
       adjacencyMatrix[i][v] = 1;
      }
    }

   return adjacencyMatrix;//�^��
  }

 //��ܬ۾F���Y�x�}
 public void printAdjacencyMatrix()
  {
   int[][] adjacencyMatrix = getAdjacencyMatrix();//�I�smethod���o�۾F���Y�x�}

   //�j����ܯx�}���e
   for(int i=0;i<adjacencyMatrix.length;i++)
    {
     for(int j = 0;j<adjacencyMatrix[0].length;j++)
      {
       System.out.print(adjacencyMatrix[i][j]+" ");
      }
     System.out.println();
    }
  }

 //���edge
 public void printEdges()
  {
   //�j��M�X�F��list
   for(int u=0;u<neighbors.length;u++)
    {
     System.out.print("Vertex "+u+": ");

     for(int j=0;j<neighbors[u].size();j++)
      {
       //�̧����edge
       System.out.print("("+u+", "+neighbors[u].get(j)+") ");
      }
     
     System.out.println();
    }   
  }
 
 //�`���u���j�M��(dfs)
 public Tree dfs(int v)
  {
   List<Integer> searchOrders = new ArrayList<Integer>();//�M�X����list

   //vertex��parent vertex
   int[] parent = new int[vertices.length];
   
   //��l�Ȭ�-1
   for(int i=0;i<parent.length;i++)
    parent[i] = -1;

   boolean[] isVisited = new boolean[vertices.length];//�P�_vertex�O�_�w�M�X

   //���jmethod
   dfs(v,parent,searchOrders,isVisited);

   return new Tree(v,parent,searchOrders);//�^��
  }

 //dfs recursive method
 private void dfs(int v,int[] parent,List<Integer> searchOrders,boolean[] isVisited)
  {
   searchOrders.add(v);//�N�ثevertex�[�J�M�X����list
   isVisited[v] = true;//�w�g�M�X �]��true

   //�j��M�X�ثevertex���F�~
   for(int i:neighbors[v])
    {
     //�Y���٨S�M�X���I 
     if(!isVisited[i])
      {
       parent[i] = v;//��vertex�]���ثevertex
       dfs(i,parent,searchOrders,isVisited);//���j
      }
    }
  }

 //�s���u���j�M��(bfs)
 public Tree bfs(int v)
  {
   List<Integer> searchOrders = new ArrayList<Integer>();//�M�X����list

   //vertex��parent vertex
   int[] parent = new int[vertices.length];
   
   //��l�Ȭ�-1
   for(int i=0;i<parent.length;i++)
    parent[i] = -1;

   //�Ȧsvertex��queue
   java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>();

   boolean[] isVisited = new boolean[vertices.length];//�P�_vertex�O�_�w�M�X

   queue.offer(v);//��J���wvertex�@��root
   isVisited[v] = true;
   
   while(!queue.isEmpty())
    {
     int u = queue.poll();//���Xvertex
     searchOrders.add(u);//�Nvertex�[�J�M�X����list

     //�M�X�F�~vertex �ñN�����X�L��vertex�[�Jqueue
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
   private int root;//�_�lvertex
   private int[] parent;//�N������Y���}�C
   private List<Integer> searchOrders;//�M�X����list

   //constructor
   //�N�Jroot parent searchOrder
   public Tree(int root,int[] parent,List<Integer> searchOrders)
    {
     this.root = root;
     this.parent = parent;
     this.searchOrders = searchOrders;
    }

   //constructor
   //�N�Jroot parent 
   public Tree(int root,int[] parent)
    {
     this.root = root;
     this.parent = parent;
    }

   //�^��root
   public int getRoot()
    {
     return root;
    }

   //�^�ǫ��wvertex��parent vertex
   public int getParent(int v)
    {
     return parent[v];
    }

   //�^�Ƿj�M����
   public List<Integer> getSearchOrders()
    {
     return searchOrders;
    }

   //�^�Ƿj�M�쪺vertices��
   public int getNumberOfVerticesFound()
    {
     return searchOrders.size();
    }

   //�^�ǫ��wvertex��path iterator
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
       stack = new Stack<Integer>();//�w�qstack
       
       //�q���wvertex�}�l�uparent vertex�ӴM�X
       do{
        stack.add(v);//��Jstack
        v = parent[v];//v�ܬ�parent
       }while(v !=-1);//����S��parent
      }   

     //�^�ǬO�_�٦�vertex
     public boolean hasNext()
      {
       return !stack.isEmpty();
      }

     //�^�Ǩé�Xvertex
     public Object next()
      {
       return vertices[stack.pop()];
      }

     //���� �L��@
     public void remove()
      {}
    }

   //���root����wvertex�����|
   public void printPath(int v)
    {
     Iterator iterator = new PathIterator(v);
     //��ܭn�qroot��v
     System.out.print("A path from "+vertices[root]+" to "+vertices[v]);

     //��ܸ��|
     while(iterator.hasNext())
      {
       System.out.print(iterator.next()+" ");
      }
    }

   //���tree path
   public void printTree()
    {
     System.out.println("Root is: "+vertices[root]);
     System.out.print("Edges: ");
       
     //�ھ�parent��ܬ۳s���Y
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