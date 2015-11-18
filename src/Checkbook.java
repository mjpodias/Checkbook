import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Checkbook{
	
	private double balance = 0;
	private Transaction t;
	protected ArrayList<Transaction> transactions = new ArrayList<>();
	protected ArrayList<Integer> test = new ArrayList<Integer>();

	public Checkbook(){
		
	} 
	
	public void addDeposit(double amount, int id, String date, String payee){
		transactions.add(new Transaction("Deposit", amount, id, date, payee));
		balance += amount;
	}
	
	public void addCheck(double amount, int id, String date, String payee){
		transactions.add(new Transaction("Check", amount, id, date, payee));
		balance -= amount;
	}
	
	public void findAction() {
		
	}
	
	public void printAction(){
		System.out.println();
		System.out.println("Transactions:");
		System.out.println("-------------------------");
		for(int i=0; i<transactions.size(); i++){
			System.out.println(transactions.get(i));
		}
		System.out.println();
		System.out.println("-------------------------");
		System.out.println("$" + balance);
		System.out.println("-------------------------");
		System.out.println();
	}
	
	public void sortAction(String command){
		switch(command){
		case "i":
			sortId();
			break;
		case "d":
			sortDate();
			break;
		case "p":
			sortPayee();
			break;
		case "a":
			sortAmount();
			break;
		default: 
			System.out.println("Invalid command.");
			break;
		}
	}
	
	private void sortAmount() {
		Collections.sort(transactions, new TransactionAmountComparator());
	}

	private void sortPayee() {
		Collections.sort(transactions, new TransactionPayeeComparator());
	}

	private void sortDate() {
		Collections.sort(transactions, new TransactionDateComparator());
	}

	private void sortId() {
		Collections.sort(transactions, new TransactionIdComparator());
	}
	
	public void quitAction() throws FileNotFoundException, IOException{
		File file = new File("transations.txt");
		FileOutputStream fo = new FileOutputStream(file);
		ObjectOutputStream output = new ObjectOutputStream(fo);
		for (Transaction t: transactions){
			output.writeObject(t);
		}
		output.close();
		fo.close();
		System.exit(0);
	}	
}
