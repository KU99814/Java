//use "Fan" class

public class EX7_2
{
 public static void main(String args[])
  {
   //宣告兩個風扇
   Fan Fan1 = new Fan();
   Fan Fan2 = new Fan();

   Fan1.setSpeed(10); //設定速度
   Fan1.setRadius(10); //設定半徑
   Fan1.setColor("yellow"); //設定顏色
   Fan1.setTurn(true); //設定開關狀態

   Fan2.setSpeed(5); //設定速度
   Fan2.setRadius(5); //設定半徑
   Fan2.setTurn(false); //設定開關狀態

   //顯示兩個風扇裡的變數
   System.out.println("The Fan1 is "+Fan1.toString()); 
   System.out.println("The Fan2 is "+Fan2.toString());
  }
}