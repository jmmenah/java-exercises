import java.time.LocalDate;

public class Programmer extends Employee{
	private String language;

	public Programmer(String firstName, String lastName, LocalDate birthday, double salary, String language){
		super(firstName,lastName,birthday,salary);
		this.language=language;
	}
	public String getLanguage(){
		return language;
	}
	public void setLanguage(String language){
		this.language=language;
	}
}