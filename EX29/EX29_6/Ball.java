//�y��class

public class Ball
{
 //�y�b�|
 private int radius = 5;

 //�y��x y�y��
 private int x = radius;
 private int y = radius;

 //���ʪ�x y��V
 private int dx = 0;
 private int dy = 0;

 private int color;//�y���C��

 boolean start = false;//�P�_�y�O�_�}�l�ʧ@

 //constructor
 public Ball()
  {
   color = (int)(Math.random()*3+1);//�H���M�w�C��
  }

 //�^�Ǯy�Ъ�X
 public int getX()
  {
   return x;
  }
 
 //�]�w�y�Ъ�X
 public void setX(int x)
  {
   this.x = x;
  }

 //�^�Ǯy�Ъ�Y
 public int getY()
  {
   return y;
  }

 //�]�w�y�Ъ�Y
 public void setY(int y)
  {
   this.y = y;
  }

 //�^��X�첾
 public int getDx()
  {
   return dx;
  }

 //�]�wX�첾
 public void setDx(int dx)
  {
   this.dx = dx;
  }

 //�^��Y�첾
 public int getDy()
  {
   return dy;
  }

 //�]�wY�첾
 public void setDy(int dy)
  {
   this.dy = dy;
  }

 //�^�ǲy�b�|
 public int getRadius()
  {
   return radius;
  }

 //�^�ǲy�C��
 public int getColor()
  {
   return color;
  }

 //�^�ǲy�O�_�w�g�}�l�ʧ@
 public boolean isStart()
  {
   return start;
  }

 //���y�}�l�ʧ@
 public void start()
  {
   //�N�첾�]��
   dx = 2;
   dy = 2;
   
   start = true;//�ʧ@�P�_�]��true
  }
}