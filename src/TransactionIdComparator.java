import java.util.Comparator;

public class TransactionIdComparator implements Comparator<Transaction>{
	@Override
	public int compare(Transaction t1, Transaction t2) {
        return t1.getId() - t2.getId(); // Ascending

	}
}
