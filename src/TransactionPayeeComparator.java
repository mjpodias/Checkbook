import java.util.Comparator;

public class TransactionPayeeComparator implements Comparator<Transaction>{
	@Override
	public int compare(Transaction t1, Transaction t2) {
        return t1.getPayee().compareToIgnoreCase(t2.getPayee());

	}
}
