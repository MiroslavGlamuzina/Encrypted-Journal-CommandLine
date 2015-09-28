import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		// String s = args[0];
		// write(s);
		if (args[0].equals(new String("-d"))) {
			decrypt();
		} else if (args[0].equals(new String("-e"))) {
			encrypt();
		} else {
			writeEncrypted(args[0]);
		}
	}

	public static boolean writeEncrypted(String input) {
		try {
			// construct header
			String underline = "";
			for (int i = 0; i < getCurrentTimeStamp().length(); i++) {
				underline += "-";
			}
			String content = underline + System.lineSeparator()
					+ getCurrentTimeStamp() + System.lineSeparator()
					+ underline + System.lineSeparator()
					+ System.lineSeparator() + input + System.lineSeparator()
					+ System.lineSeparator();
			String encrypted = "";
			for (int i = 0; i < content.length(); i++) {
				encrypted += String.valueOf((int) content.charAt(i)) + " ";
			}
			File file = new File("/Users/Miroslav/bitspace/Journal/test.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(encrypted);
			bw.close();
			System.out.println("Done");
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	public static boolean writeDecrypted(String input) {
		try {
			// construct header
			String underline = "";
			for (int i = 0; i < getCurrentTimeStamp().length(); i++) {
				underline += "-";
			}
			String content = underline + System.lineSeparator()
					+ getCurrentTimeStamp() + System.lineSeparator()
					+ underline + System.lineSeparator()
					+ System.lineSeparator() + input + System.lineSeparator()
					+ System.lineSeparator();
			
			File file = new File("/Users/Miroslav/bitspace/Journal/test.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
			System.out.println("Done");
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	public static void encrypt() {
		String encrypted = "";
		try (BufferedReader br = new BufferedReader(new FileReader(
				"/Users/Miroslav/bitspace/Journal/test.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					encrypted += String.valueOf((int) line.charAt(i)) + " ";
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeEncrypted(encrypted);
	}

	public static void decrypt() {
		String decrypted = "";
		try (BufferedReader br = new BufferedReader(new FileReader(
				"/Users/Miroslav/bitspace/Journal/test.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] words = line.split(" ");
				int[] numbers = new int[words.length];
				for (int i = 0; i < words.length; i++) {
					numbers[i] = Integer.valueOf(words[i]);
					decrypted += String.valueOf(Character.toChars(numbers[i]));
					System.out.println(String.valueOf(Character
							.toChars(numbers[i])));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeDecrypted(decrypted);
	}

	public static String getCurrentTimeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
				.format(new Date());
	}

}
