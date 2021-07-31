//球的class

public class Ball
{
 //球半徑
 private int radius = 5;

 //球的x y座標
 private int x = radius;
 private int y = radius;

 //移動的x y方向
 private int dx = 0;
 private int dy = 0;

 private int color;//球的顏色

 boolean start = false;//判斷球是否開始動作

 //constructor
 public Ball()
  {
   color = (int)(Math.random()*3+1);//隨機決定顏色
  }

 //回傳座標的X
 public int getX()
  {
   return x;
  }
 
 //設定座標的X
 public void setX(int x)
  {
   this.x = x;
  }

 //回傳座標的Y
 public int getY()
  {
   return y;
  }

 //設定座標的Y
 public void setY(int y)
  {
   this.y = y;
  }

 //回傳X位移
 public int getDx()
  {
   return dx;
  }

 //設定X位移
 public void setDx(int dx)
  {
   this.dx = dx;
  }

 //回傳Y位移
 public int getDy()
  {
   return dy;
  }

 //設定Y位移
 public void setDy(int dy)
  {
   this.dy = dy;
  }

 //回傳球半徑
 public int getRadius()
  {
   return radius;
  }

 //回傳球顏色
 public int getColor()
  {
   return color;
  }

 //回傳球是否已經開始動作
 public boolean isStart()
  {
   return start;
  }

 //讓球開始動作
 public void start()
  {
   //將位移設值
   dx = 2;
   dy = 2;
   
   start = true;//動作判斷設為true
  }
}