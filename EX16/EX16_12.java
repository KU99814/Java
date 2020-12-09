//Demonstrating JTextArea properties

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_12 extends JFrame
{
 JTextArea jta = new JTextArea();//文本
 
 JCheckBox wrap = new JCheckBox("Wrap");//勾選是否換行

 //點選換行方式
 JRadioButton wrapWords = new JRadioButton("Wrap Words");
 JRadioButton wrapCharacters = new JRadioButton("Wrap Characters");

 public EX16_12()
  {
   JPanel p1 = new JPanel();//顯示文字panel
   JPanel p2 = new JPanel(new FlowLayout());//操作換行
   
   //初始狀態
   jta.setLineWrap(false);
   jta.setWrapStyleWord(true);
   jta.setEditable(true);
 

   JScrollPane SJta = new JScrollPane(jta);//宣告並加入滾動條
   
   //顯示文字
   String text = "bkdjcbvkjgbfdsikjbfdskjblbfdskjbdskjfbi\n"+
                 "bifsbadikjverwivbuikfvsbushfduhfwoiarsd\n"+
                 "nbfvdskjbkjdboivehsdcoixhsgfdkjhxuawsxi\n"+
                 "bsiyadbfuidbivfsiudvhsbfvhfwsoahofshfgi\n"+
                 "nsudkfvbkufkugbasilhukjfcvkgo;aoijaiuuj\n"+
                 "nbulifvdsiogbriohfbdoihifdhoifbhdoihsdcih";
  jta.setText(text);//顯示
   
   //加入component
   p1.add(SJta);
   
   //宣告並設定框線
   Border lineBorder = new LineBorder(Color.BLACK,2);
   p2.setBorder(lineBorder);
   p2.setBorder(new TitledBorder("Wrap Options"));
   
   //點選按鈕設為一群
   ButtonGroup group = new ButtonGroup();
   group.add(wrapWords);
   group.add(wrapCharacters);

   //加入按鈕
   p2.add(wrap);
   p2.add(wrapWords);
   p2.add(wrapCharacters);

   //加入動作
   wrap.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     jta.setLineWrap(wrap.isSelected());//換行設置
    }
   });
   
   //以下兩個為換行方式切換
   wrapWords.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     jta.setWrapStyleWord(true);
    }
   });
   
   wrapCharacters.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     jta.setWrapStyleWord(false);
    }
   });
  
   //加入panel
   setLayout(new GridLayout(2,1));
   add(p1);
   add(p2);
  }

 public static void main(String args[])
  {
   EX16_12 frame = new EX16_12();//宣告視窗
   frame.pack();//調整大小
   frame.setTitle("EX16_12");//標題
   frame.setSize(300,500);//尺寸
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}