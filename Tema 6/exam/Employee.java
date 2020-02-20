import java.time.LocalDate;
import java.time.Period;

public class Employee {
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private int age;
	private double salary;

	public Employee (String firstName, String lastName, LocalDate birthday, double salary){
		this.firstName=firstName;
		this.lastName=lastName;
		this.birthday=birthday;
		this.salary=salary;
		setAge();
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public LocalDate getBirthday(){
		return birthday;
	}
	public int getAge(){
		return age;
	}
	private void setAge(){
		LocalDate currentDate=LocalDate.now();
		age=Period.between(birthday, currentDate).getYears();
	}
	public double getSalary(){
		return salary;
	}
	public void setSalary(double salary){
		this.salary=salary;
	}
	public String toString(){
		return (firstName+" "+lastName+"("+birthday+") "+age+" years, "+salary+"€");
	}
}