package ink.nota.common.test.sql;

import java.util.Scanner;

public class SqlLike {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			String nextLine = scanner.nextLine();
			if(nextLine !=null) {
				repl(nextLine);
			}
			
		}
//		String test1 = "dfg%ii_df\\d";
//		String test2 = "dfg%ii_dfd";
//		test2 = test2.replaceAll("ii", "uyu");
//		System.out.println(test2);
		
//		System.out.println(repl(test1));
		
	}
	
	static String repl(String str) {
		System.out.println("befor rep str:" + str);
		str = str.replaceAll("\\\\", "\\\\\\\\\\\\\\\\");
		str = str.replaceAll("%", "\\\\%");
		str = str.replaceAll("_", "\\\\_");
		System.out.println("under rep str:" + str);
		return str;
	}

	
}
