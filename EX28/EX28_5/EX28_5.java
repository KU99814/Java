//Prove or disprove
//���絲�G���model�ä��@�P

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class EX28_5
{
 public static void main(String args[])
  {
   NineTailModel model1 = new NineTailModel();//�Ы�NineTailModel
   WeightedNineTailModel model2 = new WeightedNineTailModel();//�Ы�WeightedNineTailModel
   
   //��ܨ��model��node�`�װ}�C
   int[] depth1 = model1.allDepth();
   int[] depth2 = model2.allDepth();

   //��ܵ��G
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