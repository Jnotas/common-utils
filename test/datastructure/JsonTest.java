package ink.nota.common.test.datastructure;

import com.alibaba.fastjson.JSON;
import com.emoyc.note.common.pojo.TUser;

public class JsonTest {
	
	public static void main(String[] args) {
		
		TUser user = new TUser();
		user.setName("aa");
		user.setValue("4");
		
		Object json = JSON.toJSON(user);
		System.out.println(json);
		user.setName(null);
		System.out.println(user);
		System.out.println(JSON.toJSON(user));
		String aString = "{\"name\":\"aa\"}";
		TUser parseObject = JSON.parseObject(aString, TUser.class);
		System.out.println(parseObject);
		System.out.println(JSON.toJSON(new TUser()).toString());
		
		String code = "\"23232\"";
		System.out.println(JSON.toJSON(code));
	}

}
