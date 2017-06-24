import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTextFile {
	Scanner input;
	public void openFile(){
		try {
			input = new Scanner(new File("clients.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("could not find file");
		}
	}
	public void readRecords(){
		
		System.out.println("This is what is in the file: ");
		AccountRecord accountRecord=new AccountRecord();
		while(input.hasNext()){
			accountRecord.setFirstName(input.next());
			accountRecord.setLastName(input.next());
			accountRecord.setAccount(input.nextInt());
			accountRecord.setBalance(input.nextDouble());
		    System.out.printf("%d %s %s %.2f %n", accountRecord.getAccount(), accountRecord.getFirstName(), accountRecord.getLastName(), accountRecord.getBalance());//writing to file
		}
		
	}
	public void closeFile(){
		if(input!=null){
			input.close();
		}
	}
}
