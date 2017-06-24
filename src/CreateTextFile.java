
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class CreateTextFile {
	Formatter output;

	CreateTextFile() {
		try {
			output = new Formatter("clients.txt");
		} catch (FileNotFoundException e) {
			System.out.println("The File was not found.");
		}

	}

	public void addRecords(){
		AccountRecord record=new AccountRecord();
		Scanner scan = new Scanner(System.in);
		String exit = "";
		System.out.println("Please enter the first name, last name, account number, and balance. \nIf ou wish to exit, then please type EXIT after you enter the balance.");
		System.out.print("First name: ");
		while(!exit.equals("yes")){
			exit = "";
			record.setFirstName(scan.next());
			System.out.print("Last name: ");
			record.setLastName(scan.next());
			System.out.print("Account Number: ");
			record.setAccount(scan.nextInt());
			System.out.print("Account Balance: ");
			record.setBalance(scan.nextDouble());
			System.out.print("Would you like to exit?: ");
			exit=scan.next();
			if(!exit.equals("yes")){
				System.out.println("first name: ");
			}
			
			
			
			
			if(record.getAccount()>0){
				output.format("%d %s %s %.2f %n", record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance());//writing to file
			}
			else{
				System.out.println("Account number must be greater than 0.");
			}
		}
		
	}
	public void closeFile(){
		if(output!=null){
			output.close();
		}
	}
	
}
