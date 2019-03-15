package ink.nota.common.test.datastructure;

import java.util.ArrayList;
import java.util.List;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class B {

	private int num1 = 10;
	private static int num2 = 20;
	private static final int num3 = 30;
	private static int bnum4 = 40;

	
	private boolean isFlag;
	
	
	

	public boolean isFlag() {
		return isFlag;
	}

	public void setFlag(boolean isFlag) {
		this.isFlag = isFlag;
	}

	//User 类
    static class User{
        private Integer age;
        private String name;
        public Integer getAge() {
            return age;
        }
        public void setAge(Integer age) {
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "User [age=" + age + ", name=" + name + "]";
        }
        
    }
    
    public static void main(String[] args) {
    	// new 一个User对象
        User user = new User();
        user.setAge(1);
        user.setName("xiaojun");
        
        //对象转json字符串
        String jsonString = JSON.toJSONString(user);
        System.out.println("对象转json字符串:\t" + jsonString);
        //对象转json
        user.setAge(2);
        JSONObject jsonObject = (JSONObject)JSON.toJSON(user);
        System.out.println("对象转json:\t" + jsonObject);
        
        //json字符串转对象
        User parseObject = JSON.parseObject(jsonString, User.class);
        System.out.println("json字符串转对象:\t" + parseObject);
        
        //json对象转对象
        User javaObject = JSON.toJavaObject(jsonObject, User.class);
        System.out.println("json对象转对象:\t" + javaObject);
        
        User user2 = new User();
        user2.setAge(9);
        user2.setName("xiaochen");
        ArrayList<User> users = new ArrayList<>();
        users.add(user2);
        users.add(user);
        System.out.println("list 转json============\t");
        System.out.println("准备转json的list:\t" + users);
        
        //list 转json
        String jsonString2 = JSON.toJSONString(users);
        System.out.println("list转json:\t" + jsonString2);
        
        //json 转list
        List<User> parseArray = JSON.parseArray(jsonString2, User.class);
        System.out.println("json转list:\t" + parseArray);
    }
	
}
