public class EX10_2
{
 public static void main(String args[])
  {
   Person person = new Person("mark","Taipei","78965423","54684@Lona"); //宣告Person
   Student student = new Student(); //宣告Student
   Employee employee = new Employee(); //宣告Employee
   Faculty faculty = new Faculty(); //宣告Faculty
   Staff staff = new Staff(); //宣告Staff

   //顯示內部資訊
   System.out.println(person.toString());
   System.out.println(student.toString());
   System.out.println(employee.toString());
   System.out.println(faculty.toString());
   System.out.println(staff.toString());
  }
}
