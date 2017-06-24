import java.io.File;

public class CreditInquirtyTest {
	public static void main(String [] args){
		File f = new File("clients.txt");
		
		if(f.exists() && !f.isDirectory()) { 
			CreditInquiry creditInquiry=new CreditInquiry();
			creditInquiry.processRequest();
		}
		else{
			CreateTextFile createTextFile=new CreateTextFile();
			createTextFile.addRecords();
			createTextFile.closeFile();
			
		}
	
	}
}
