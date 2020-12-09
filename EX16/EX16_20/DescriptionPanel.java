import javax.swing.*;
import java.awt.*;

public class DescriptionPanel extends JPanel
{
 private JLabel jlblImageTitle = new JLabel();//��ܹϤ�
 
 private JTextArea jtaDescription = new JTextArea();//��ܤ奻
 
 public DescriptionPanel()
  {
   //���
   jlblImageTitle.setHorizontalAlignment(JLabel.CENTER);
   jlblImageTitle.setHorizontalTextPosition(JLabel.CENTER);
   jlblImageTitle.setVerticalTextPosition(JLabel.BOTTOM);

   //����
   jtaDescription.setLineWrap(true);
   jtaDescription.setWrapStyleWord(true);

   //�]�����i�s��
   jtaDescription.setEditable(false);
   
   JScrollPane scrollPane = new JScrollPane(jtaDescription);//�[�J�u�ʱ�
   
   //��X
   setLayout(new BorderLayout(5,5));
   add(scrollPane,BorderLayout.CENTER);
   add(jlblImageTitle,BorderLayout.WEST);
  }

 //�]�w���D
 public void setTitle(String title)
  {
   jlblImageTitle.setText(title);
  }

 //�]�w�Ϥ�
 public void setImageIcon(ImageIcon icon)
  {
   jlblImageTitle.setIcon(icon);
  }

 //�]�w�奻
 public void setDescription(String text)
  {
   jtaDescription.setText(text);
  }
}