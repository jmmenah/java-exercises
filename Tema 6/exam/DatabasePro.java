import java.time.LocalDate;

public class DatabasePro extends Employee{
	private String database;

	public DatabasePro(String firstName, String lastName, LocalDate birthday, double salary, String database){
		super(firstName,lastName,birthday,salary);
		this.database=database;
	}
	public String getDatabase(){
		return database;
	}
	public void setDatabase(String database){
		this.database=database;
	}
}