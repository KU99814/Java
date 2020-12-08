public class Employee extends Person
{
 private String office; //辦公室
 private int salary; //薪資
 private MyDate date_hired; //聘請日期

 //建構子
 public Employee()
  {
   office = "KU";
   salary = 100;
   date_hired = new MyDate(1,1,1);
  }

 public Employee(String name,String address,String phone,String eAddress,
                 String office,int salary,MyDate date_hired)
  {
   super(name,address,phone,eAddress);
   this.office = office;
   this.salary = salary;
   this.date_hired = date_hired;
  }

 public String toString()
  {
   return "Employee " + getName();
  }
}