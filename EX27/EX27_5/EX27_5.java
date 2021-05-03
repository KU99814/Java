//Find a cycle

public class EX27_5
{
 public static void main(String args[])
  {
   //測試用vertices
   String[] vertices = {"Seattle",//0
                        "San Francisco",//1
                        "Losa Angles",//2
                        "Denver",//3
                        "Kansas City",//4
                        "Chicago",//5
                        "Boston",//6
                        "New York",//7
                        "Atlanta",//8
                        "Miami",//9
                        "Dallas",//10
                        "Houston"//11
                       };
   
   //測試用edge
   int[][] edges = {{0,1},{0,3},{0,5},
                    {1,0},{1,2},{1,3},
                    {2,1},{2,3},{2,4},{2,10},
                    {3,0},{3,2},{3,4},{3,5},
                    {4,2},{4,3},{4,5},{4,7},{4,8},{4,10},
                    {5,0},{5,3},{5,4},/*{5,6},*/{5,7},
                    /*{6,5},*/{6,7},
                    {7,4},{7,5},{7,6},{7,8},
                    {8,4},{8,7},{8,9},{8,10},{8,11},
                    {9,8},{9,11},
                    {10,2},{10,4},{10,8},{10,11},
                    {11,8},{11,9},{11,10}};

   Graph graph = new UnweightedGraph(edges,vertices);

   java.util.List<Integer> cycle = graph.getACycle(10,11);//創graph object
   
   //找出指定兩點的cycle
   if(cycle==null)
    System.out.println("no cycle");//若回傳null 
   else
    {
     //若有找到 顯示形成cycle所有點
     for(int i=0;i<cycle.size();i++)
      System.out.println(graph.getVertex(cycle.get(i))+" ");
     System.out.println();
    }
  }
}