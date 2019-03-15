package ink.nota.common.test.chars;

public class CharTest {
	
	public static void main(String[] args) {
		
		
		int value = 0;
		char[] chart = {'0','0','4','8'};
		
		int inta = 2;
		for (int i=0;i < 4; i++) {
			value = (value << 4) + chart[i] - '0';
		}
		char s = (char)inta;
		
		System.out.println(s);
		
		System.out.println((char)value);
		
		
	}

}
