package financeAnalyser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import transaction.Transaction;

public class FinanceAnalyser {

	public static void main(String[] args) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		String path = "./files/Transactions.csv";
		String line = "";
		boolean first = true;
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((line = br.readLine()) != null) {
				// ignore the first line with headings
				if (first) {
					first = false;
					continue;
				}
				String[] values = line.split(",");
				for(int i = 0; i < values.length ; i++) {
					if(values[i].isEmpty() || values[i].isBlank() || values[i] == null) {
						throw new IOException("Invalid input");
					}
				}
				String related = values.length == 7 ? values[6] : "";
				Transaction t = new Transaction(values[0].replaceAll("\\s+",""), 
						values[1].replaceAll("\\s+",""), values[2].replaceAll("\\s+",""), 
						values[3], Float.parseFloat(values[4].replaceAll("\\s+","")), 
						values[5].replaceAll("\\s+",""), related.replaceAll("\\s+",""));
				transactions.add(t);
			}
			br.close();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter account number:");
			String accountId = scanner.nextLine();
			System.out.println("Enter from date and time:");
			String from = scanner.nextLine();
			System.out.println("Enter to date and time:");
			String to = scanner.nextLine();
			var result = FinanceAnalyserHelper.Analyser(transactions, accountId.replaceAll(" ", ""), from, to);
			
			scanner.close();
			System.out.printf("Relative balance for the period is: $%f\nNumber of transactions included is: %d", result.x, result.y);
			
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.err.println("NumberFormatException: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
