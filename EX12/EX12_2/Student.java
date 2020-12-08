public class Student extends Person implements Comparable
{
 private String major; //�D��t

 //�غc�l
 public Student()
  {
   super();
   major = "non";
  }

 public Student(Name name,String major)
  {
   super(name);
   this.major = major;
  }

 //���o�D��t
 public String getMajor()
  {
   return major;
  }

 //���
 public int compareTo(Object o)
  {
   return (super.compareTo(o)) + major.compareTo(((Student)o).getMajor());
  }

 //���o���A
 public String toString()
  {
   return super.toString() + major;
  }
}