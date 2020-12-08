//Printing four patterns using loops

public class EX4_18
{
 public static void main(String args[])
  {
   //根據指示輸出三角形排列
   System.out.print("Pattern I\n");
   
   /*1
     1 2
     1 2 3
     1 2 3 4
     1 2 3 4 5
     1 2 3 4 5 6
   */
   //r= row c = column
   for(int r = 1;r<=6;r++)
    {
     for(int c = 1;c<=r;c++)
      {
       System.out.print(c+" ");
      }
     System.out.print("\n");
    }
   
   System.out.print("\nPattern II\n");
   
   /*1 2 3 4 5 6
     1 2 3 4 5
     1 2 3 4
     1 2 3
     1 2
     1 */
   for(int r = 6;r>=1;r--)
    {
     for(int c = 1;c<=r;c++)
      {
       System.out.print(c+" ");
      }
     System.out.print("\n");
    }

   System.out.print("\nPattern III\n");

   /*
               1
             2 1
           3 2 1
         4 3 2 1
       5 4 3 2 1
     6 5 4 3 2 1
   */   
   for(int r = 1;r<=6;r++)
    {
     for(int c = 6;c>0;c--)
      {
       if(c>r)
        System.out.print("  ");
       else
        System.out.print(c+" ");
      }
     System.out.print("\n");
    }

   System.out.print("\nPattern IV\n");
   
   /*
     1 2 3 4 5 6
       1 2 3 4 5
         1 2 3 4
           1 2 3
             1 2
               1
   */

   for(int r = 1;r<=6;r++)
    {
     for(int c =1;c<=6;c++)
      {
       if(c-r<0)
        System.out.print("  ");
       else
        System.out.print((c-r+1)+" ");
      }
     System.out.print("\n");
    }
  }
}