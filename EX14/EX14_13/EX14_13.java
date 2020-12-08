//Plotting function using abstract methods

import javax.swing.*;
import java.awt.*;

public class EX14_13 extends JFrame
{
 public EX14_13()
  {
   setLayout(new GridLayout(1,2));
   add(new Sin());
   add(new Cos());
  }

public static void main(String args[])
  {
   EX14_13 frame = new EX14_13();
   frame.setTitle("EX14_13");
   frame.setSize(600,400);
   frame.setLocationRelativeTo(null);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setVisible(true);
  }
}
 
//函數圖形class 只要mathod繼承 只實作f
class SquareX extends AbstractDrawFunction
{
 //建構子
 public SquareX()
  {}

 public double f(double x)
  {
   return x*x*0.01;
  }
}

class Sin extends AbstractDrawFunction
{
 //建構子
 public Sin()
  {}
 
 public double f(double x)
  {
   return 50*Math.sin((x/100.0)*2*Math.PI)+20;
  }
}

class Cos extends AbstractDrawFunction
{
 //建構子
 public Cos()
  {}

 public double f(double x)
  {
   return 50*Math.cos((x/100.0)*2*Math.PI)+20;
  }
}

class Tan extends AbstractDrawFunction
{
 //建構子
 public Tan()
  {}

 public double f(double x)
  {
   return 50*Math.tan((x/100.0)*2*Math.PI);
  }
}

class CosAdd5Sin extends AbstractDrawFunction
{
 //建構子
 public CosAdd5Sin()
  {}

 public double f(double x)
  {
   return (50*Math.cos((x/100.0)*2*Math.PI)) + 5*(50*Math.sin((x/100.0)*2*Math.PI));
  }
}

class FiveCosAddSin extends AbstractDrawFunction
{
 //建構子
 public FiveCosAddSin()
  {}

 public double f(double x)
  {
   return 5*(50*Math.cos((x/100.0)*2*Math.PI)) + (50*Math.sin((x/100.0)*2*Math.PI));
  }
}

class LogAddSquareX extends AbstractDrawFunction
{
 //建構子
 public LogAddSquareX()
  {}

 public double f(double x)
  {
   return Math.log(x) + x*x*0.01;
  }
}