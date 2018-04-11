import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Input {
	static Scanner scan = new Scanner (System.in);
	
	public static ArrayList<String> split(String str, String separator) {
		ArrayList<String> arraystr = new ArrayList<String>();
		Collections.addAll(arraystr, str.split(separator));
		return arraystr;
	}
	
		public static String join(ArrayList<String> array) {
		return String.join(" ", array);
	}
	
	public static void print(String str) {
		System.out.println(str);
	}
	
	public static String input(String str) {
		System.out.print(str);
		String s = scan.nextLine();
		return s;
	}
	
	public static int toInt(String value) {
		return Integer.parseInt(value);
	}
}
