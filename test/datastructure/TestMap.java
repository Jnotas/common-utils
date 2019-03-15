package ink.nota.common.test.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestMap {

	
	/**
	 * HashMap 的key 判断是否为同一个键(key)  通过 equals 方法 和 hashCode 方法判断 所以如果要修改实现 可以通过重写hashCode 和 equals方法
	 * @author sensetime
	 *
	 */
	 private static class Person{
	        int idCard;
	        String name;

	        public Person(int idCard, String name) {
	            this.idCard = idCard;
	            this.name = name;
	        }
	        @Override
	        public boolean equals(Object o) {
	            if (this == o) {
	                return true;
	            }
	            if (o == null || getClass() != o.getClass()){
	                return false;
	            }
	            Person person = (Person) o;
	            //两个对象是否等值，通过idCard来确定
	            return this.idCard == person.idCard;
	        }
//	        public int hashCode() {
//	        	return new Integer(this.idCard).hashCode();
//	        }

	    }
	 
	    public static void main(String []args) throws Exception{
	        HashMap<Person,String> map = new HashMap<Person, String>();
	        Person person = new Person(1234,"乔峰");
	        //put到hashmap中去
	        map.put(person,"天龙八部");
	        //get取出，从逻辑上讲应该能输出“天龙八部”
	        System.out.println("结果:"+map.get(new Person(1234,"萧峰")));
	        
	        Thread thread = new Thread();
	        thread.start();
	        thread.join();
	        thread.getId();
	        thread.getName();
	        thread.run();
	        thread.setContextClassLoader(null);
	        thread.setName("s");
	        thread.wait();
	        thread.destroy();
	        
	        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
//	        new ThreadPoolExecutor(0, 5, keepAliveTime, unit, workQueue) ;       
	    }
	    
//	public static void main(String[] args) {
//		
//		Map<Object,String> hashMap = new HashMap<>();
//		hashMap.put("is", "ok");
//		hashMap.put("verry", "good");
//		
//		System.out.println(hashMap.toString());
//		String string ;
//		
//	}
	
}
