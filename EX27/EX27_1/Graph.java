//Graph interface

import java.util.*;

public interface Graph
{
 public int getSize();//取得大小

 public Object[] getVertices();//取得vertex陣列

 public Object getVertex(int index);//取得指定index的vertex

 public int getIndex(Object v);//取得指定vertex的index

 public java.util.List getNeighbors(int v);//取得相連邊陣列

 public int getDegree(int v);//取得指定index vertex的相連度

 public int[][] getAdjacencyMatrix();//取得相鄰陣列

 public void printAdjacencyMatrix();//顯示相鄰陣列

 public void printEdges();//顯示所有邊

 //AbstractGraph
 public AbstractGraph.Tree dfs(int v);//取得spinner tree的depth first search(以V為root)

 public AbstractGraph.Tree bfs(int v);//取得spinner tree的breath first search(以V為root)

 public List<Integer> getHamiltonianPath(Object vertex);//取得指定index的Hamiltonian Path

 public List<Integer> getHamiltonianPath(int v);//取得指定vertex的Hamiltonian Path

}