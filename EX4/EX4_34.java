//rock,scissor,paper

import java.util.Scanner;

public class EX4_34
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   int comWin = 0; //�q��Ĺ����
   int useWin = 0; //���aĹ����
   
   while(true)
    {
     int com = (int)(Math.random()*3);//�H������0~2 �N��ŤM���Y��

     System.out.print("Enter a number of 0 for rock,1 for scissor and 2 for paper: ");
     int use = input.nextInt(); //��J�ϥΪ̥X��
     
     //��ӭt
     int race = com - use;//���G

     System.out.println("com:"+com+" use:"+use);//����X��

     if(race==-1 || race == 2)
      {
       System.out.println("com win"); 
       comWin++;
      }

     else if(race ==1 || race == -2)
      {
       System.out.println("user win"); 
       useWin++;
      }     

     if(comWin == 2 || useWin == 2)//���H��ӴN���X
      break;
    }
   //��ܳӭt
   if(comWin == 2)
    System.out.print("the winner is computer");
   else if(useWin == 2)
    System.out.print("the winner is user");
  }
}
