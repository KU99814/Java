//Prove or disprove
//實驗結果兩種model並不一致

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class EX28_5
{
 public static void main(String args[])
  {
   NineTailModel model1 = new NineTailModel();//創建NineTailModel
   WeightedNineTailModel model2 = new WeightedNineTailModel();//創建WeightedNineTailModel
   
   //顯示兩種model的node深度陣列
   int[] depth1 = model1.allDepth();
   int[] depth2 = model2.allDepth();

   //顯示結果
   System.out.print("NineTailModel");
   for(int i=0;i<depth1.length;i++)
    System.out.print(depth1[i]+" ");
   System.out.println();

   System.out.print("WeightedNineTailModel");
   for(int i=0;i<depth2.length;i++)
    System.out.print(depth2[i]+" ");
   System.out.println();
  }
}