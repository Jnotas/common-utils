package ink.nota.common.test.chars;

import java.util.Scanner;

public class JungleTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		char[] question = { 0x8bf7, 0x95ee, 0x4f60, 0x662f, 0x0070, 0x0069, 0x0067, 0x5417, 0x003f, 0x000d, 0x000a,
				0x56de, 0x7b54, 0x0022, 0x662f, 0x0022, 0x6216, 0x8005, 0x0022, 0x4e0d, 0x662f, 0x0022, 0x002e };
		char[] answer = { 0x0059, 0x006f, 0x0075, 0x0020, 0x0061, 0x0072, 0x0065, 0x0020, 0x006e, 0x006f, 0x0020,
				0x0072, 0x0075, 0x006c, 0x0065, 0x0073, 0x002c, 0x006d, 0x0061, 0x0079, 0x0062, 0x0065, 0x0020, 0x0079,
				0x006f, 0x0075, 0x0020, 0x0063, 0x0061, 0x006e, 0x0020, 0x0062, 0x0065, 0x0020, 0x0061, 0x0020, 0x0067,
				0x006f, 0x006f, 0x0064, 0x0020, 0x7a0b, 0x5e8f, 0x733f, 0x0021 };
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.err.println(question);
			char[] charArray = scanner.nextLine().trim().toCharArray();

			if (charArray.length < 1) {
				System.err.println("输入为空,请重新输入");
				continue;
			}
			int flag = 0;
			System.out.println(0+charArray[0]);
			for (char c1 : charArray) {
				flag += c1;
			}
			if (!(0x92 == flag && charArray[0] == 0x6a) 
					&& charArray[0] != 0x6eda 
					&& charArray[0] != 0x35 
					&& charArray[0] != 0x54ed) {
				if (0x662f == flag && charArray.length == 1) {
					System.out.println("You are brave man!\r\nSystem exit");
					System.exit(0);
				} else {
					if (0xb43c == flag && charArray.length == 2 && 0x4e0d == charArray[0]) {
						System.out.println(answer);
					} else {
						System.err.println("输入错误");
					}
				}

			} else {
				System.out.println("ok exit!");
				System.exit(0);
			}
		}
	}
	
	public static String to0x(String str) {
		String s = Integer.toHexString(7);
		return null;
	}
}
