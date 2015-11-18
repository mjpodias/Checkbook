import java.io.Serializable;
import java.util.Comparator;

public class Transaction implements Comparator<Transaction>, Serializable{
	private String type;
	private double amount;
	private int id;
	private String date;
	private String payee;
	
	public Transaction(String type, double amount, int id, String date, String payee) {
		this.type = type;
		this.amount = amount;
		this.id = id;
		this.date = date;
		this.payee = payee;
	}
	
	public double getAmount() {
		return amount;
	}

	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getPayee() {
		return payee;
	}


	public String toString() {
		return "Type: " + type + " | Amount: " + amount + " | ID: " + id + " | Date: " + date + " | Payee: " + payee;
	}

	public int compareTo(Transaction arg0, Transaction arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compare(Transaction arg0, Transaction arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
}
