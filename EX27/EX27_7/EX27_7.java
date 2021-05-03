//getting bipartite set

public class EX27_7
{
 public static void main(String args[])
  {
   //����vertices
   String[] vertices = {"Seattle","San Francisco","Losa Angles",
                        "Denver","Kansas City","Chicago","Boston","New York",
                        "Atlanta","Miami","Dallas","Houston"};
   //����edge(�D�G��)
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
   
 /*bipartite*/  /*int[][] edges = {{0,1},
                    {1,0},{1,2},
                    {2,1},{2,3},
                    {3,2},{3,4},
                    {4,3},{4,5},
                    {5,4},{5,6},
                    {6,5},{6,7},
                    {7,6},{7,8},
                    {8,7},{8,9},
                    {9,8},{9,10},
                    {10,9},{10,11},
                    {11,10}};*/

   Graph graph = new UnweightedGraph(edges,vertices);//�Ы�graph

   java.util.List<java.util.List<Integer>> list = graph.isBipartite();//���o�G���ϿW�߶�

   //�Y�D�G����
   if(list==null)
    System.out.print("no bipartite");

   //�Y�O�G����
   else
    {
     //���X��W�߶�
     java.util.List<Integer> list1 = list.get(0);
     java.util.List<Integer> list2 = list.get(1);

     //�̧���ܿW�߶�vertex
     for(int i=0;i<list1.size();i++)
      System.out.print(vertices[list1.get(i)]+" ");
     System.out.println();

     for(int i=0;i<list2.size();i++)
      System.out.print(vertices[list2.get(i)]+" ");
    }
  }
}