import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		String s =args[0];
		write(s);
	}
	
	public static boolean write(String input){
		try {
			//construct header
			String underline ="";
			for(int i=0;i < getCurrentTimeStamp().length(); i++ )
			{
				underline +="-";
			}
			String content = underline+System.lineSeparator()+getCurrentTimeStamp()+ System.lineSeparator()+underline+System.lineSeparator()+System.lineSeparator()+ input +System.lineSeparator()+System.lineSeparator();
			
			File file = new File("/Users/Miroslav/bitspace/Journal/test.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	public static void encrypt(){
		
	}
	
	public static void decrypt(){
		
	}
	
	public static String getCurrentTimeStamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}
	
	
	
}
