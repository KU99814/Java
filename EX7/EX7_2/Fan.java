public class Fan
{
 //�H�U�T�Ӭ��@�α`�� �����t�]�w
 final static int SLOW = 1;
 final static int MEDIUM = 2;
 final static int FAST = 3;
 int speed; //���t
 boolean on; //�}��
 double radius; //�b�|
 String color;  //�C��

 Fan() //��l�ŧi
 {
  speed = SLOW;
  on = false;
  radius = 5;
  color = "blue";
 }

 int getSpeed() //�^�ǳt��
  {
   return speed;
  }

 void setSpeed(int newSpeed) //�]�w�t��
  {
   speed = newSpeed;
  }

 boolean getTurn() //�^�Ƕ}����
  {
   return on;
  }

 void setTurn(boolean turn) //�]�w�}����
  {
   on = turn;
  }

 double getRadius() //�^�ǥb�|
  {
   return radius;
  }

 void setRadius(double newRadius) //�]�w�b�|
  {
   radius = newRadius;
  }

 String getColor() //�^���C��
  {
   return color;
  }

 void setColor(String newColor) //�]�w�C��
  {
   color = newColor;
  }

 public String toString() //�^�Ǧr��
  {
   if(on) //�p�G�}���}
    {
     String s = "speed: "+speed+" radius "+radius+" "+color; //�^�ǳt�סB�b�|�B�C��
     return s;
    }
   else //�p�G��
    return "fan is off radius "+radius+" "+color;//�^�ǥb�|�B�C��
  }
} 