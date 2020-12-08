//The Course class

public class EX9_9
{
 public static void main(String args[])
  {
   Course course = new Course("Math"); //�ŧi�@��Course

   //�s�W�ǥ�
   course.addStudent("Sam");
   course.addStudent("John");
   course.addStudent("Honk");

   //�����@�Ӿǥ�
   course.dropStudent("Honk");
   
   String[] students = course.getStudents();
   for(int i=0;i<course.getNumberOfStudents();i++) //���
    System.out.println(students[i]);
  }
}

//�ҵ{class
class Course
{
 private String courseName; //�ҵ{�m�W
 private String[] students = new String[16]; //�ǥ�
 private int numberOfStudents = 0; //�ǥͤH��

 //�غc�l
 public Course(String courseName)
  {
   this.courseName = courseName;
  }

 public void addStudent(String student) //�s�W�ǥ�
  {
   if(numberOfStudents ==students.length)//�Y�}�C�Ӥp �[�j����
    {
     String[] newStudent = new String[numberOfStudents*2+1]; //�зs�}�C
     for(int i=0;i<numberOfStudents;i++) //�N�ǥͲ��J�s�}�C
      newStudent[i] = students[i];
     students = newStudent;//���V�s�}�C
    }

   students[numberOfStudents] = student; //�N�s�ǥͥ[�J�}�C
   numberOfStudents++;//�W�[�ǥͼ�
  }

 public String[] getStudents() //�^�ǾǥͰ}�C
  {
   return students;
  }

 public int getNumberOfStudents() //�^�Ǿǥͼ�
  {
   return numberOfStudents;
  }

 public String getCourseName() //�^�ǽҵ{�W��
  {
   return courseName;
  }

 public void dropStudent(String student) //�����ǥ�
  {
   //�Ф@�Ӵ�֪��s�}�C
   numberOfStudents--;
   String[] newStudent = new String[numberOfStudents];
   //�N�n�����H�~���[�J�s�}�C
   int j = 0;
   for(int i=0;i<numberOfStudents+1;i++) 
    {
     if(!students[i].equals(student))
      {
       newStudent[j] = students[i];
       j++;
      }
    }

   students = newStudent;//���V�s�}�C
  }
 
 public void clear() //�M��
  {
   students = new String[16];
  }
}