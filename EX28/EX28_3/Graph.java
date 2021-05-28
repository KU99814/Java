//graph interface

public interface Graph
{
 public int getSize();//�^��vertices�ƶq

 public Object[] getVertices();//�^��graph����vertices

 public Object getVertex(int index);//�^�ǫ��windex��vertex

 public int getIndex(Object v);//�^�ǫ��wvertex��index

 public java.util.List getNeighbors(int v);//�^�ǫ��wvertex���F�~

 public int getDegree(int v);//�^�ǫ��wvertex�������

 public int[][] getAdjacencyMatrix();//�^�ǾF���x�}

 public void printAdjacencyMatrix();//��ܾF���x�}

 public void printEdges();//���edges

 public AbstractGraph.Tree dfs(int v);//��o�`���u���j�M��(dfs)

 public AbstractGraph.Tree bfs(int v);//��o�s���u���j�M��(dfs)
}
