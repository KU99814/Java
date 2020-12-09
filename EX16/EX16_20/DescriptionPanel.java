import javax.swing.*;
import java.awt.*;

public class DescriptionPanel extends JPanel
{
 private JLabel jlblImageTitle = new JLabel();//顯示圖片
 
 private JTextArea jtaDescription = new JTextArea();//顯示文本
 
 public DescriptionPanel()
  {
   //對齊
   jlblImageTitle.setHorizontalAlignment(JLabel.CENTER);
   jlblImageTitle.setHorizontalTextPosition(JLabel.CENTER);
   jlblImageTitle.setVerticalTextPosition(JLabel.BOTTOM);

   //分行
   jtaDescription.setLineWrap(true);
   jtaDescription.setWrapStyleWord(true);

   //設為不可編輯
   jtaDescription.setEditable(false);
   
   JScrollPane scrollPane = new JScrollPane(jtaDescription);//加入滾動條
   
   //整合
   setLayout(new BorderLayout(5,5));
   add(scrollPane,BorderLayout.CENTER);
   add(jlblImageTitle,BorderLayout.WEST);
  }

 //設定標題
 public void setTitle(String title)
  {
   jlblImageTitle.setText(title);
  }

 //設定圖片
 public void setImageIcon(ImageIcon icon)
  {
   jlblImageTitle.setIcon(icon);
  }

 //設定文本
 public void setDescription(String text)
  {
   jtaDescription.setText(text);
  }
}