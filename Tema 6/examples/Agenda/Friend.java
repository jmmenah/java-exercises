// LocalDate requires >= Java 8

import java.time.LocalDate;
import java.time.Period;

public class Friend {
	private String firstName;
	private String lastName;
	private String phone;
	private LocalDate birthDay;
	private int age;

	public Friend(String firstName, String lastName, String phone, LocalDate birthDay) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.birthDay = birthDay;
		setAge();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public int getAge() {
		return age;
	}

	private void setAge() {
		LocalDate today = LocalDate.now();
		Period p = Period.between(birthDay, today);
		age = p.getYears();
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + "(" + phone + ") " + birthDay + " => " + age + " years";
	}

}
