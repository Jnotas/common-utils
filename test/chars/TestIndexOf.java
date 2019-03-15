package ink.nota.common.test.chars;

import java.util.Properties;

import com.alibaba.fastjson.JSON;

public class TestIndexOf {
	public static void main(String[] args) {
		String url = "https://blog.csdn.net/ufo___/article/details/81164996";
		int indexOf = url.indexOf('/',10);
		System.err.println(indexOf);
		String substring = url.substring(0, url.indexOf('/',8) + 1);
		System.out.println(substring);

	}
	

}
