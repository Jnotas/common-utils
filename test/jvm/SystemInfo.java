package ink.nota.common.test.jvm;

import java.util.Properties;

import com.alibaba.fastjson.JSON;

public class SystemInfo {
	public static void main(String[] args) {
		System.out.println(System.getProperty("os.name"));
		Properties properties = System.getProperties();
		System.out.println(properties);
		
		String string = JSON.toJSON(properties).toString();
		System.out.println(string);
	}

}
