import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EX16_20 extends JFrame
{
 //國家名稱
 private String[] flagTitles = {"Canada","China","Denmark","France","Germany",
                                "India","Norway","United Kingdom","United States of America"};
 //國旗檔名
 private ImageIcon[] flagImage = {new ImageIcon("image/ca.gif"),
                                  new ImageIcon("image/China.gif"),
                                  new ImageIcon("image/denmark.gif"),
                                  new ImageIcon("image/fr.gif"),
                                  new ImageIcon("image/germany.gif"),
                                  new ImageIcon("image/india.gif"),
                                  new ImageIcon("image/norway.gif"),
                                  new ImageIcon("image/uk.gif"),
                                  new ImageIcon("image/us.gif")};

 //文本陣列
 private String[] flagDescription = new String[9];
 private DescriptionPanel descriptionPanel = new DescriptionPanel();//宣告國家說明panel

 private JComboBox jcbo = new JComboBox(flagTitles);//下拉選單 選國旗
 
 public EX16_20()
  {
   //宣告描述陣列
   for(int i=0;i<9;i++)
    flagDescription[i] = ""; 
   try
    {
     //讀取描述文本
     for(int i=0;i<9;i++)
      {
       Scanner input = new Scanner(new File("text/description"+i+".txt"));
       while(input.hasNext())
        {
         flagDescription[i]+= input.next()+" ";
        }
      }
    }
   catch(Exception ex){}
   
   setDisplay(0);//顯示第1個文本
   
   //整合
   add(jcbo,BorderLayout.NORTH);
   add(descriptionPanel,BorderLayout.CENTER);

   //加入選單動作 選擇國家
   jcbo.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e){
     setDisplay(jcbo.getSelectedIndex());
    }
   });
  }

 public static void main(String args[])
  {
   EX16_20 frame = new EX16_20();//宣告視窗
   frame.setTitle("EX16_20");//標題
   frame.setSize(400,300);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
 
 //設定文本
 public void setDisplay(int index)
  {
   //設定要顯示的國家
   descriptionPanel.setTitle(flagTitles[index]);
   descriptionPanel.setImageIcon(flagImage[index]);
   descriptionPanel.setDescription(flagDescription[index]);
  }
}