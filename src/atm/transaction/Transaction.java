package atm.transaction;

public class Transaction {
	
		
	private TransactionType t;
	
	public Transaction(TransactionType t) {
		this.t = t;
	}
	
	public void execute() {
		t.execute();
	}
	
	
	
}
