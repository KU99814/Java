//graph interface

public interface Graph
{
 public int getSize();//回傳vertices數量

 public Object[] getVertices();//回傳graph中的vertices

 public Object getVertex(int index);//回傳指定index的vertex

 public int getIndex(Object v);//回傳指定vertex的index

 public java.util.List getNeighbors(int v);//回傳指定vertex的鄰居

 public int getDegree(int v);//回傳指定vertex的分支度

 public int[][] getAdjacencyMatrix();//回傳鄰接矩陣

 public void printAdjacencyMatrix();//顯示鄰接矩陣

 public void printEdges();//顯示edges

 public AbstractGraph.Tree dfs(int v);//獲得深度優先搜尋樹(dfs)

 public AbstractGraph.Tree bfs(int v);//獲得廣度優先搜尋樹(dfs)
}
