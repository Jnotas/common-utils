package ink.nota.common.test.classloader;

import java.util.concurrent.ConcurrentHashMap;

public class ClassLoaderOrder extends ClsLdParent{

	private String string;
	
	private So so1 = new So("动态成员变量");

	private static So so = new So("静态成员变量");
	
	private ClassLoaderOrder () {
		 {
			System.err.println("子类构造");
		}
	}
	
	
	{
		System.out.println("动态代码块");
	}
	
	static {
		System.out.println("静态代码块");
	}
	
	static class So {
		
		private So(){
			System.out.println("空参构造");
		}
		
		private So(String s) {
			System.out.println(s);
		}
	}
	
	
	private static void put() {
		System.out.println("静态方法");
	}
	
	public static void main(String[] args) {
		new ClassLoaderOrder();
		
		ConcurrentHashMap<Object,Object> cMap = new ConcurrentHashMap<>();
		cMap.put("sd",new ClassLoaderOrder());
		cMap.get("sd");
	}
}
