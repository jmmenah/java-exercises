/*
*1.- Write a program Hobby.java that prompts the user for his name and his favorite hobby. Then prints the output identical as shown below. (6 points)
*
*Here is an example dialogue with the user:
*
*/*/*/*/*/*/*/*/*/
*|| Your Hobby! ||
*\*\*\*\*\*\*\*\*\
*
*Please type your name: Fulanito de Tal
*Please type your Hobby: Pop music
*
*    Hello Fulanito de Tal!
*    Your Hobby is "Pop music"
*
*Here is another example dialogue with the user:
*
*/*/*/*/*/*/*/*/*/
*|| Your Hobby! ||
*\*\*\*\*\*\*\*\*\
*
*Please type your name: John Doe        
*Please type your Hobby: Dancing Samba
*
*    Hello John Doe!
*    Your Hobby is "Dancing Samba"
*
*Please type your name: John Doe        
*Please type your Hobby: Dancing Samba
*
*    Hello John Doe!
*    Your Hobby is "Dancing Samba"
**/
import java.util.Scanner;
public class Hobby {
	public static void main (String[]args) {
		Scanner console = new Scanner(System.in);
		System.out.println();
		System.out.println("/*/*/*/*/*/*/*/*/");
		System.out.println("|| Your Hobby! ||");
		System.out.println("\\*\\*\\*\\*\\*\\*\\*\\*\\");
		System.out.println();

		System.out.print("Please type your name: ");
		String name = console.nextLine();

		System.out.print("Please type your Hobby: ");
		String hobby = console.nextLine();

		System.out.println("	Hello " + name);
		System.out.println("	Your Hobby is \"" + hobby + "\"");
	}
}
