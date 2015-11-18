import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class CheckbookUI {
	
	private static String command;
	private static double amount;
	private static int id;
	private static String date;
	private static String payee;
	private static Scanner input = new Scanner(System.in);
	private static Checkbook chk;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		Checkbook chk = new Checkbook();
		
		File file = new File("transations.txt");
		FileInputStream fi = new FileInputStream(file);
		ObjectInputStream input = new ObjectInputStream(fi);
		try{
			while (true) {
				Transaction t = (Transaction)input.readObject();
				chk.transactions.add(t);
			}
		} 
		catch (EOFException ex) {
		}

		
		System.out.println("Welcome to the Checkbook Application. ");
		System.out.println();

		commandMethod(chk);
	}
	
	private static void commandMethod(Checkbook chk) throws IOException{
		
		mainMenu();
		command = input.next();
		while (command != "q"){
			switch(command){
				case "d":
					depositCase(chk);
					break;
				case "c":
					checkCase(chk);
					break;
				case "f":
					chk.findAction();
					break;
				case "p":
					chk.printAction();
					break;
				case "s":
					sortMenu();
					command = input.next();
					chk.sortAction(command);
					break;
				case "q":
				try {
					chk.quitAction();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				default: 
					System.out.println("Invalid command.");
					break;
			}
			mainMenu();
			command = input.next();
		}
	}
	
	private static void mainMenu() {
		System.out.println();
		System.out.println("Enter the following commands depending on which action you would like to perform. ");
		System.out.println("enter 'd' if you would like to make a deposit ");
		System.out.println("enter 'c' if you would like to enter a check ");
		System.out.println("enter 'f' if you would like to find a transaction by ID");
		System.out.println("enter 'p' if you would like to print the check book ");
		System.out.println("enter 's' if you would like to sort the check book ");
		System.out.println("enter 'q' if you would like to save and quit. ");
	}
	
	private static void sortMenu() {
		System.out.println();
		System.out.println("Enter the following commands depending on which action you would like to perform. ");
		System.out.println("enter 'i' if you would like to sort by ID ");
		System.out.println("enter 'd' if you would like to sort by date ");
		System.out.println("enter 'p' if you would like to sort by payee ");
		System.out.println("enter 'a' if you would like to sort by amount ");
	}
	
	private static void depositCase(Checkbook chk) {
		System.out.println("How many deposits would you like to add? ");
		int numberOfEntries = input.nextInt();
		for(int i=1; i <= numberOfEntries; i++){
			System.out.println("Entry Number " + i);
			System.out.println("Please enter amount. ");
			System.out.println("Example: 43.25");
			amount = input.nextDouble();
			System.out.println("Please enter the deposit ID number. ");
			System.out.println("Example: 1");
			id = input.nextInt();
			System.out.println("Please enter the date of the deposit. ");
			System.out.println("Example: 07/21/13");
			date = input.next();
			System.out.println("Please enter the name of the payee. ");
			System.out.println("Example: John Smith");
			payee = input.next();
			chk.addDeposit(amount, id, date, payee);
		}
	}
	
	private static void checkCase(Checkbook chk) {
		System.out.println("How many checks would you like to add? ");
		int numberOfEntries = input.nextInt();
		for(int i=1; i <= numberOfEntries; i++){
			System.out.println("Entry Number " + i);
			System.out.println("Please enter amount. ");
			System.out.println("Example: 43.25");
			amount = input.nextDouble();
			System.out.println("Please enter the check ID number. ");
			System.out.println("Example: 1");
			id = input.nextInt();
			System.out.println("Please enter the date of the check. ");
			System.out.println("Example: 07/21/13");
			date = input.next();
			System.out.println("Please enter the name of the payee. ");
			System.out.println("Example: John Smith");
			payee = input.next();
			chk.addCheck(amount, id, date, payee);
		}
	}
	
}

