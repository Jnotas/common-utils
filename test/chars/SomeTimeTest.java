package ink.nota.common.test.chars;

import java.util.UUID;


@SuppressWarnings("all")
public class SomeTimeTest {
	
	public static void main(String[] args) {
		String token = UUID.randomUUID().toString();
		System.out.println(token);
		String replaceAll = token.replaceAll("-", "");
		System.out.println(replaceAll +":"+ replaceAll.length());
		Long a = 0L;
		System.out.println(a);
//		test1();
	}

	private static void test1() {
		char p = '1';
		switch (p) {
		case '1':
			System.out.println(1);
			break;
		default:
			System.out.println("null");
			break;
		}
	}

}
