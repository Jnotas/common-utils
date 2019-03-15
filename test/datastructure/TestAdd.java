package ink.nota.common.test.datastructure;

import java.util.ArrayList;

public class TestAdd {
	
	private static ArrayList<Integer> list = new ArrayList<>();
	
	static {
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
	}
	
	public static void main(String[] args) {
		String[] pp = new String[5];
		int index = 0;
		
		for (Integer a : list) {
			pp[index++] = a.toString();
		}

		for (String string : pp) {
			System.out.println(string);
		}
		
	}
	
	class User{
		//类的属性，字段
		private String name;
		
		//空参构造  java是默认空参构造，可以不用写出来. 
		public User(){}; 
		
		//有参构造 如果写了有参构造，会覆盖空参构造
		//若要通过 new User() 方式创建对象，则必须在代码中把空参构造方法也写出来
		public User(String name){
			this.name = name;
		}
		
	}
}
