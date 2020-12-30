public class test
{
 public static void main(String args[])
  {
   String[] tokens = "Java,c?c#,C++".split("[.,;:?]");

   for(int i=0;i<tokens.length;i++)
    System.out.println(tokens[i]);
  }
}