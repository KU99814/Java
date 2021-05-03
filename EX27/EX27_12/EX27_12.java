//dynamic graphs

public class EX27_12
{
 public static void main(String[] args)
  {
   //����vertex
   String[] vertices = {"Seattle","San Francisco","Losa Angles",
                        "Denver","Kansas City","Chicago","Boston","New York",
                        "Atlanta","Miami","Dallas","Houston"};
   //����edge   
   int[][] edges = {{0,1},{0,3},{0,5},
                    {1,0},{1,2},{1,3},
                    {2,1},{2,3},{2,4},{2,10},
                    {3,0},{3,2},{3,4},{3,5},
                    {4,2},{4,3},{4,5},{4,7},{4,8},{4,10},
                    {5,0},{5,3},{5,4},{5,6},{5,7},
                    {6,5},{6,7},
                    {7,4},{7,5},{7,6},{7,8},
                    {8,4},{8,7},{8,9},{8,10},{8,11},
                    {9,8},{9,11},
                    {10,2},{10,4},{10,8},{10,11},
                    {11,8},{11,9},{11,10}};
   
   Graph graph1 = new UnweightedGraph(edges,vertices);//�Ы�graph object
   
   graph1.printAdjacencyMatrix();//��ܬ۾F���Y�}�C
   System.out.println();

   if(graph1.add("123"))//�[�Jvertex
    graph1.printAdjacencyMatrix();//���

   System.out.println();

   if(graph1.remove("Denver"))//����vertex
    graph1.printAdjacencyMatrix();//���

   System.out.println();

   if(graph1.add(new Edge(0,11)))//�[�Jedge
    graph1.printAdjacencyMatrix();//���

   System.out.println();

   if(graph1.remove(new Edge(0,1)))//����edge
    graph1.printAdjacencyMatrix();//���
  }
}