public class Fan
{
 //以下三個為共用常數 為風速設定
 final static int SLOW = 1;
 final static int MEDIUM = 2;
 final static int FAST = 3;
 int speed; //風速
 boolean on; //開關
 double radius; //半徑
 String color;  //顏色

 Fan() //初始宣告
 {
  speed = SLOW;
  on = false;
  radius = 5;
  color = "blue";
 }

 int getSpeed() //回傳速度
  {
   return speed;
  }

 void setSpeed(int newSpeed) //設定速度
  {
   speed = newSpeed;
  }

 boolean getTurn() //回傳開或關
  {
   return on;
  }

 void setTurn(boolean turn) //設定開或關
  {
   on = turn;
  }

 double getRadius() //回傳半徑
  {
   return radius;
  }

 void setRadius(double newRadius) //設定半徑
  {
   radius = newRadius;
  }

 String getColor() //回傳顏色
  {
   return color;
  }

 void setColor(String newColor) //設定顏色
  {
   color = newColor;
  }

 public String toString() //回傳字串
  {
   if(on) //如果開關開
    {
     String s = "speed: "+speed+" radius "+radius+" "+color; //回傳速度、半徑、顏色
     return s;
    }
   else //如果關
    return "fan is off radius "+radius+" "+color;//回傳半徑、顏色
  }
} 