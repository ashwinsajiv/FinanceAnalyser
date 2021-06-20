package financeAnalyser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import transaction.Transaction;
import utils.Tuple;

public class FinanceAnalyserHelper {
	public static Tuple<Float, Integer> Analyser(List<Transaction> transactions, String accountId, String from, String to) {
		SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		float totalAmount = (float) 0.0;
		int totalTransactions = 0;
		try {
			Date parsedFrom = parser.parse(from);
			Date parsedTo = parser.parse(to);
			// This list is to make sure that reversal happens only if a transactions has already been accounted.
			List<String> listOfTsx = new ArrayList<String>();
			for (Transaction t : transactions) {
				if(CompareDate(parser.parse(t.getCreatedAt()), parsedFrom, parsedTo) && t.getTransactionType().equals("PAYMENT")) {
					if(t.getFromAccountId().equals(accountId)) {
						totalAmount -= t.getAmount();
						totalTransactions++;
						listOfTsx.add(t.getTransactionId());
					} else if(t.getToAccountId().equals(accountId)) {
						totalAmount += t.getAmount();
						totalTransactions++;
						listOfTsx.add(t.getTransactionId());
					}
				}
				if(t.getTransactionType().equals("REVERSAL") && listOfTsx.contains(t.getRelatedTransaction())) {
					if(t.getFromAccountId().equals(accountId)) {
						totalAmount += t.getAmount();
						totalTransactions--;
					} else if(t.getToAccountId().equals(accountId)) {
						totalAmount -= t.getAmount();
						totalTransactions--;
					}
				}
			}
		} catch (ParseException e) {
			System.err.println("ParseException: " + e.getMessage());
			e.printStackTrace();
		}
		Tuple<Float, Integer> result = new Tuple<>(totalAmount, totalTransactions);
		return result;
	}

	private static boolean CompareDate(Date createdAt, Date parsedFrom, Date parsedTo) {
		if((createdAt.compareTo(parsedFrom) >= 0) && (createdAt.compareTo(parsedTo) <= 0)) {
			return true;
		}
		return false;
	}
}
