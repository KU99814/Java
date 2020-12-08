//依成績排列學生

public class EX6_22
{
 public static void main(String args[])
  {
   char[][] answers = {
    {'A','B','A','C','C','D','E','E','A','D'},
    {'D','B','A','B','C','A','E','E','A','D'},
    {'E','D','D','A','C','B','E','E','A','D'},
    {'C','B','A','E','D','C','E','E','A','D'},
    {'A','B','D','C','C','D','E','E','A','D'},
    {'B','B','E','C','C','D','E','E','A','D'},
    {'B','B','A','C','C','D','E','E','A','D'},

    {'E','B','E','C','C','D','E','E','A','D'}};//學生的答案

   char[] key = {'D','B','D','C','C','D','A','E','A','D'}; //標準答案
   int[] correntCount = new int[answers.length]; //答對數
   int[] student = new int[answers.length]; //學生的index

   for(int i=0;i<answers.length;i++) //核對
    {
     for(int j=0;j<answers[i].length;j++) //紀錄成績
      if(answers[i][j] == key[j])
       correntCount[i]++;

     student[i] = i+1; //記錄學生index
    }

   insertionSort(correntCount,student); //排列

   for(int i=0;i<answers.length;i++)
    System.out.println("Student "+student[i]+"'s corrent count is "+correntCount[i]); //顯示
  }

 public static void insertionSort(int[] list,int[] order)
  {
   for(int i=1;i<list.length;i++) //排列
    {
     int currentElement = list[i];
     int currentOrder = order[i];
     int k;
     
     for(k=i-1;k>=0&&list[k] > currentElement;k--) //已成績來排序學生
      {
       list[k + 1] = list[k];
       order[k + 1] = order[k];
      }

     list[k+1] = currentElement;
     order[k+1] = currentOrder;
    }
  }
}
  