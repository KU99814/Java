//使用Math.sqrt計算平方根

public class EX5_18
{
 public static void main(String args[])
  {
   System.out.println("Number\t\tSquarRoot"); //輸出項目

   //從0到20 依序顯示平方根
   for(int i =0;i<=20;i+=2)
    {
     double SR = (int)(Math.sqrt(i)*10000);
     SR/=10000;
     System.out.println(i+"  \t\t "+SR);
    }
  }
}