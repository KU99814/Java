import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class EX30_7_Client extends JFrame
{
 //�`�� �N��ŤM���Y��
 static final int ROCK = 1;
 static final int PAPER = 2;
 static final int SCISSORS = 3;

 JLabel listenLabel = new JLabel("\t\tlisten\t\t",JLabel.CENTER);//��ܲ{�b�֥X

 private int yourScore = 0;//�ۤv�o��
 private int othersScore = 0;//���o��

 private JLabel myScore = new JLabel("  0  ",JLabel.CENTER);//�ۤv�o�����
 private JLabel otherScore = new JLabel("  0  ",JLabel.CENTER);//���o�����
  
 private JTextArea jtaResult = new JTextArea("",8,25);//��ܵ��G

 private int nowNum = 1;//�{�b�X����
 private boolean isChosen = false;//�P�_�O�_���\�ǰe���
 private boolean canDo = false;//�P�_�{�b�O�_�ʧ@
 
 //radio button
 private JRadioButton jrbRock = new JRadioButton("Rock");//���Y
 private JRadioButton jrbPaper = new JRadioButton("Paper");//��
 private JRadioButton jrbScissors = new JRadioButton("Scissors");//�ŤM
 private JButton btnPlay = new JButton("Play");

 private JLabel otherPlay = new JLabel();//��ܹ�⪱�a�X����

 Socket socket;

 public EX30_7_Client()
  {
   JPanel showPanel = new JPanel(new BorderLayout());//�o����Tpanel

   JPanel listenPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));//��֥ܽX��panel

   //�]�w�ƪ��P�[�J   
   listenLabel.setFont(new Font("TimesRoman",Font.BOLD,15));
   listenLabel.setBorder(new LineBorder(Color.red,1));
   listenPanel.add(listenLabel);

   showPanel.add(listenPanel,BorderLayout.NORTH);

   //��ܹC���o����T
   //Score Label
   JPanel resultPanel = new JPanel(new BorderLayout());
   JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
   JLabel scoreLabel = new JLabel("Score",JLabel.CENTER);
   scorePanel.add(scoreLabel);

   //��ܱo��
   JPanel playerScorePanel = new JPanel(new GridLayout(2,2,5,5));
   playerScorePanel.add(new JLabel("This Player",JLabel.CENTER));
   playerScorePanel.add(new JLabel("other Player",JLabel.CENTER));
   playerScorePanel.add(myScore);//�ۤv�o��
   playerScorePanel.add(otherScore);//�L�H�o��
   
   //��J���G��T��
   resultPanel.add(scorePanel,BorderLayout.NORTH);
   resultPanel.add(playerScorePanel,BorderLayout.CENTER);

   //��J���panel
   showPanel.add(resultPanel,BorderLayout.CENTER);

   JPanel playsLabelPanel = new JPanel(new BorderLayout());//play��r��panel
   JPanel boardPanel = new JPanel(new BorderLayout());//��mtextarea
   
   playsLabelPanel.add(new JLabel("   Plays"),BorderLayout.NORTH);

   //�[�Jtextarea
   JScrollPane scrollPane = new JScrollPane(jtaResult);
   JPanel jtaPanel = new JPanel(new FlowLayout());  
   jtaPanel.add(scrollPane);

   //���spanel
   JPanel buttonPanel = new JPanel(new FlowLayout());
   JPanel radioPanel = new JPanel(new FlowLayout());//radio panel
   radioPanel.add(jrbRock);
   radioPanel.add(jrbPaper);
   radioPanel.add(jrbScissors);

   radioPanel.setBorder(new LineBorder(Color.black,1));

   //��J���s
   buttonPanel.add(radioPanel);
   buttonPanel.add(btnPlay);

   //���s���s
   ButtonGroup group = new ButtonGroup();
   group.add(jrbRock);
   group.add(jrbPaper);
   group.add(jrbScissors);

   //��ܨ�L���a��T
   JPanel otherPlayLabel = new JPanel(new FlowLayout(FlowLayout.CENTER));
   otherPlayLabel.add(otherPlay);

   //�ƪ�
   JPanel bottomPanel = new JPanel(new GridLayout(2,1));
   bottomPanel.add(buttonPanel);
   bottomPanel.add(otherPlayLabel);

   JPanel playPanel = new JPanel(new GridLayout(2,1));
   playPanel.add(jtaPanel);
   playPanel.add(bottomPanel);

   //�C���L�{panel�ƪ�
   boardPanel.add(playsLabelPanel,BorderLayout.WEST);
   boardPanel.add(playPanel,BorderLayout.CENTER);

   //frame�ƪ�
   setLayout(new BorderLayout());
   add(showPanel,BorderLayout.NORTH);
   add(boardPanel,BorderLayout.CENTER);

   jtaResult.setText("You player\tThey played\tWinner\t\t");

   //��ܥ��Y
   jrbRock.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     nowNum = 1;
    }
   });

   //��ܥ�
   jrbPaper.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     nowNum = 2;
    }
   });

   //��ܰŤM
   jrbScissors.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     nowNum = 3;
    }
   });

   //�X��
   btnPlay.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     //�P�_�O�_�i�H�ʧ@
     if(canDo)
      {
       isChosen = true;
       canDo = false;
      }
    }
   });

   new Thread(new HandleTask()).start();//����task
  }

 //�q��task
 public class HandleTask implements Runnable
  {
   //�ǰe���
   DataOutputStream toServer;
   DataInputStream fromServer;

   public HandleTask()
    {}

   public void run()
    {
     try{
      socket = new Socket("localhost",8000);//�����s�u  
      toServer = new DataOutputStream(socket.getOutputStream());
      fromServer = new DataInputStream(socket.getInputStream());
     
      while(true)
       {
        //���������
        int otherNum = fromServer.readInt();
        listenLabel.setText("\t\tcall\t\t");
        
        canDo = true;//�]���i��

        while(!isChosen)
         {}

        //�ǰe���
        isChosen = false;
        toServer.writeInt(nowNum);
        listenLabel.setText("\t\tlisten\t\t");

        compareRPS(nowNum,otherNum);//���
        otherPlay.setText("other play "+playValue(otherNum));
        canDo = false;
       }
     }
     catch(IOException ex){
      System.err.println(ex);
     }
    }
  }

 //����ӭt
 public void compareRPS(int player,int opponent)
  {
   //���G��r
   String text = "\n"+playValue(player)+"\t"+playValue(opponent)+"\t";

   if(player==ROCK)
    {
     switch(opponent)
      {
       case ROCK:     text+="no winner\t";
                      break;
       case PAPER:    text+="they won\t";
                      othersScore++;
                      break;
       case SCISSORS: text+="you won\t";
                      yourScore++;
                      break;
      }
    }
   else if(player==PAPER)
    {
     switch(opponent)
      {
       case ROCK:     text+="you won\t";
                      yourScore++;
                      break;
       case PAPER:    text+="no winner\t";
                      break;
       case SCISSORS: text+="they won\t";
                      othersScore++;
                      break;
      }
    }
    else
    {
     switch(opponent)
      {
       case ROCK:     text+="they won\t";
                      othersScore++;
                      break;
       case PAPER:    text+="you won\t";
                      yourScore++;
                      break;
       case SCISSORS: text+="no winner\t";
                      break;
      }     
    }

   //��ܱo��
   myScore.setText("  "+yourScore+"  ");
   otherScore.setText("  "+othersScore+"  ");

   jtaResult.setText(jtaResult.getText()+text);//��ܵ��G
  }

 //��ܲq����r
 public String playValue(int num)
  {
   String ret;
   switch(num)
    {
     case ROCK:ret = "Rock";break;
     case PAPER:ret = "Paper";break;
     case SCISSORS: ret = "Scissors";break;
     default:ret = "";
    }

   return ret;
  }

 public static void main(String args[])
  {
   EX30_7_Client frame = new EX30_7_Client();

   frame.setTitle("EX30_7_Client");//�W��
   frame.setSize(500,500);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}