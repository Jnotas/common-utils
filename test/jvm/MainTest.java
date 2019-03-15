package ink.nota.common.test.jvm;

import java.util.HashMap;

import ink.nota.common.test.datastructure.Result;
import ink.nota.common.test.datastructure.User;

/*
 * 
 * 值传递  引用传递
 */
public class MainTest {

	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		User user = new User("军", 18);
		
		HashMap<String,Object> data = new HashMap<>();
		data.put("o","old");
		data.put("p",45);
		data.put("u", user);
		Result<HashMap<String, Object>> result = new Result<>("001", data);
		HashMap<String,Object> d2 = new HashMap<>();
		d2.putAll(data);  	//值传递
//		d2 = data;			//引用传递
		Result<HashMap<String, Object>> result2 = new Result<>("002", d2);
		System.out.println(result);
		System.out.println(result2);
		data.put("o","nd");
		data.put("newkey", "new data");
		user.setAge(25);
		System.out.println(result);
		updateUser(user);
		System.out.println(result);
		System.out.println(result2);
		
		String a = "ab";
		a = a + "o";
		String b = "abo";
//		b = b + "o";
		a = a.intern();
		System.out.println(a);
		System.out.println(b);
		System.out.println(a == b);
		System.out.println(a.equals(b));
		User user2 = user.clone();
		user.setName("x");
		user2.setAge(30);
		System.out.println(user);
		System.out.println(user2);
	}
	
	public static User updateUser(User u) {
		u.setAge(u.getAge() + 1);
		return u;
	}
}
