import java.util.*;
public class Solution {
public static void main(String args[])
 {
 Scanner input = new Scanner(System.in);
 Stack<Integer> s = new Stack<Integer>();
 System.out.println(isIsomorphic("foo","bar"));  
}
public static boolean isIsomorphic(String s, String t) 
{
        if(s.length()!=t.length())
         return false;
        else if(s.length()==0 && t.length()==0)
         return true;
        Stack<Character> sc1 = new Stack<Character>();
        Stack<Character> sc2 = new Stack<Character>();
        String s1 = "";
        String s2 = "";
        for(int i=0;i<s.length();i++) 
    {
         char c1 = s.charAt(i);
         char c2 = t.charAt(i);
         int index1 = sc1.search(c1);
         int index2 = sc2.search(c2);
         System.out.println("1+"+index1+" "+index2);
         if(index1<0) 
      {
          sc1.push(c1);
          index1 = sc1.search(c1);
         }
         if(index2<0) 
     {
          sc2.push(c2);
          index2 = sc2.search(c2);
         }
         System.out.println("2+"+index1+" "+index2);
         s1 += (char)('A'+(index1-1));
         s2 += (char)('A'+(index2-1));
        }
      System.out.println(s1+" "+s2);
     return s1.equals(s2);
    }
}