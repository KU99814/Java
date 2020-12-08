//Revising the House class

public class EX11_4 extends House
{
 public static void main(String args[])  throws CloneNotSupportedException
  {
   //宣告房屋
   House h1 = new House(1,2);
   House h2 = (House)h1.clone();
   
   //顯示何時建造
   System.out.println(h1.getWhenBuilt().toString());
   h1.setWhenBuilt(null);//將h1定為null 測試是否deep clone
   System.out.println(h2.getWhenBuilt().toString());
  }
}