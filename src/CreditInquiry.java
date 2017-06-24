import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreditInquiry {
	private MenuOption accountType;
	private Scanner input;
	private final static MenuOption[] choices = { MenuOption.ZERO_BALANCE, MenuOption.CREDIT_BALANCE,
			MenuOption.DEBIT_BALANCE, MenuOption.END };

	private void readRecords() {
		try{
			AccountRecord accountRecord = new AccountRecord();
			input = new Scanner(new File("clients.txt"));
			while (input.hasNext()) {
				accountRecord.setFirstName(input.next());
				accountRecord.setLastName(input.next());
				accountRecord.setAccount(input.nextInt());
				accountRecord.setBalance(input.nextDouble());
				if (shouldDisplay(accountRecord.getBalance())) {
					System.out.printf("%s %s %d %d %n", accountRecord.getFirstName(), accountRecord.getLastName(),
							accountRecord.getBalance(), accountRecord.getAccount());
				}

			}

		}catch(NoSuchElementException e){
			System.out.println("file improperly formed.");
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found- sad :(`1");
		}finally{
			if (input != null) {
				input.close();
			}
		}
			

	}

	private boolean shouldDisplay(double balance) {
		if (accountType == MenuOption.CREDIT_BALANCE && balance < 0) {
			return true;
		}
		if (accountType == MenuOption.DEBIT_BALANCE && balance > 0) {
			return true;
		}
		if (accountType == MenuOption.ZERO_BALANCE && balance == 0) {
			return true;
		}
		return false;
	}

	public MenuOption getRequest() {
		Scanner textIn = new Scanner(System.in);
		int request = 1;
		System.out.printf("\n%s\n%s\n%s\n%s\n%s\n", "Welcome to the Credit Inquirty program",
				"1.List accounts with zero balances", "2.List accounts with credit balances",
				"3.List accounts with debit balances", "4.exit program");
		try {
			do {
				System.out.print("?: ");
				request = textIn.nextInt();
			} while (request < 1 || request > 4);
		} catch (NoSuchElementException e) {
			System.out.println("Incorrect input, plesae try again.");
		}
		return choices[request - 1]; // from the global array.
	}

	public void processRequest() {
		accountType = getRequest();
		// we are able to just write ZERO_BALANCE because the
		// return type of accountType is of the MenuOption
		// Enum Class.
		while (accountType != MenuOption.END) {
			switch (accountType) {
			case ZERO_BALANCE:
				System.out.println("Accounts with Zero Balance: ");
			case DEBIT_BALANCE:
				System.out.println("Accounts with Debit Balance");
			case CREDIT_BALANCE:
				System.out.println("Accounts with Credit Balance");
			case END:
				System.out.println("Saving and Ending program now...");

			}
			readRecords();
			accountType = getRequest();
		}

	}

}
