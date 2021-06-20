package transaction;

public class Transaction {
	private String transactionId;
	private String fromAccountId;
	private String toAccountId;
	private String createdAt;
	private float amount;
	private String transactionType;
	private String relatedTransaction;
	public Transaction(String transactionId, String fromAccountId, String toAccountId, 
			String createdAt, float amount, String transactionType, String relatedTransaction) {
		this.setTransactionId(transactionId);
		this.setToAccountId(toAccountId);
		this.setFromAccountId(fromAccountId);
		this.setCreatedAt(createdAt);
		this.setAmount(amount);
		this.setTransactionType(transactionType);
		this.setRelatedTransaction(relatedTransaction);
	}
	/**
	 * @return the toAccountId
	 */
	public String getToAccountId() {
		return toAccountId;
	}
	/**
	 * @param toAccountId the toAccountId to set
	 */
	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}
	/**
	 * @return the fromAccountId
	 */
	public String getFromAccountId() {
		return fromAccountId;
	}
	/**
	 * @param fromAccountId the fromAccountId to set
	 */
	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}
	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}
	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	/**
	 * @return the relatedTransaction
	 */
	public String getRelatedTransaction() {
		return relatedTransaction;
	}
	/**
	 * @param relatedTransaction the relatedTransaction to set
	 */
	public void setRelatedTransaction(String relatedTransaction) {
		this.relatedTransaction = relatedTransaction;
	}
	/**
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
