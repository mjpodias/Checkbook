import java.util.Comparator;

//I didn't know what to do for the date so I left it like this. I would imagine it has something to do with re working the way I store the date by utilizing the Calander java util instead of just a string.

public class TransactionDateComparator implements Comparator<Transaction>{
	@Override
	public int compare(Transaction t1, Transaction t2) {
        return t1.getDate().compareToIgnoreCase(t2.getDate());
	}
}
