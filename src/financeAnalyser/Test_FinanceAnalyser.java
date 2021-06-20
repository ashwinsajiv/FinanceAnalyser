package financeAnalyser;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import transaction.Transaction;
import utils.Tuple;

class Test_FinanceAnalyser {
	
	List<Transaction> testDataComplete() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(new Transaction("TX10001", "ACC334455", "ACC778899", "20/10/2018 12:47:55", (float)25.00, "PAYMENT", ""));
		transactions.add(new Transaction("TX10002", "ACC334455", "ACC998877", "20/10/2018 17:33:43", (float)10.50, "PAYMENT", ""));
		transactions.add(new Transaction("TX10003", "ACC998877", "ACC778899", "20/10/2018 18:00:00", (float)5.00, "PAYMENT", ""));
		transactions.add(new Transaction("TX10004", "ACC334455", "ACC998877", "20/10/2018 19:45:00", (float)10.50, "REVERSAL", "TX10002"));
		transactions.add(new Transaction("TX10005", "ACC334455", "ACC778899", "21/10/2018 09:30:00", (float)7.25, "PAYMENT", ""));
		return transactions;
	}

	// Tests the example used in the coding challenge description.
	@Test
	void testAnalyserWithReversal() {
		var data = testDataComplete();
		var actual = FinanceAnalyserHelper.Analyser(data, "ACC334455", "20/10/2018 12:00:00", "20/10/2018 19:00:00");
		var expected = new Tuple<>((float)-25.000000, 1);
		assertEquals(actual.x, expected.x);
		assertEquals(actual.y, expected.y);
	}
	
	// Test for reversals that are not in the time frame.
	@Test
	void testAnalyserWithOutOfScopeReversal() {
		var data = testDataComplete();
		// Since this data is not in the time frame, the reversal should not go ahead.
		data.add(new Transaction("TX10000", "ACC334455", "ACC789789", "20/10/2018 11:59:59", (float)99.00, "PAYMENT", ""));
		data.add(new Transaction("TX10006", "ACC334455", "ACC789789", "20/10/2018 18:59:59", (float)99.00, "REVERSAL", "TX10000"));
		var actual = FinanceAnalyserHelper.Analyser(data, "ACC334455", "20/10/2018 12:00:00", "20/10/2018 19:00:00");
		var expected = new Tuple<>((float)-25.000000, 1);
		assertEquals(actual.x, expected.x);
		assertEquals(actual.y, expected.y);
	}
	
	// Tests empty input.
	@Test
	void testAnalyserWithNull() {
		boolean thrown = false;
		var data = new ArrayList<Transaction>();
		data.add(new Transaction(null, null, null, null, 0, null, null));
		try {
			FinanceAnalyserHelper.Analyser(data, "ACC334455", "20/10/2018 12:00:00", "20/10/2018 19:00:00");			
		} catch (NullPointerException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
}
