public class Student extends Person
{
 private String status; //狀態

 //建構子
 public Student()
 {
  status = "freshman";
 }

 public Student(String name,String address,String phone,String eAddress,String status)
  {
   super(name,address,phone,eAddress);
   this.status = status;
  }

 //override
 public String toString()
  {
   return "Student " + getName();
  }
}
