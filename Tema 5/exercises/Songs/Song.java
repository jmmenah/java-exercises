// LocalDate requires >= Java 8

import java.time.LocalDate;
import java.time.Period;

public class Song {
	private String songTitle;
	private String artist;
	private char gender;
	private LocalDate date;
	private int age;

	public Song(String songTitle, String artist, char gender, LocalDate date) {
		this.songTitle = songTitle;
		this.artist = artist;
		this.gender = gender;
		this.date = date;
		setAge();
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getAge() {
		return age;
	}

	private void setAge() {
		LocalDate today = LocalDate.now();
		Period p = Period.between(date, today);
		age = p.getYears();
	}

	@Override
	public String toString() {
		return songTitle + " - " + artist + "(" + gender + ") " + date + " => " + age + " years";
	}

}
