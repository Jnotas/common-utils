package ink.nota.common.test.gc;


import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;

import ink.nota.common.test.datastructure.User;


public class MainTest {
	
	public static boolean isRun = true;
	public static void main(String[] args) throws InterruptedException {
//		String abc = new String("abc");
		
//		for (String string : args) ;
		User user = new User("小胡", 32);
		
        System.out.println(user.getClass() + "@" + user.hashCode());
        final ReferenceQueue<User> referenceQueue = new ReferenceQueue<User>();
        new Thread() {
            public void run() {
                while (isRun) {
                    Object obj = referenceQueue.poll();
                    User user2 = new User("额外挼若",32);
                    System.out.println(obj);
                    if (obj != null) {
                        try {
                            Field rereferent = Reference.class
                                    .getDeclaredField("referent");
                            rereferent.setAccessible(true);
                            Object result = rereferent.get(obj);
                            System.out.println("gc will collect："
                                    + result.getClass() + "@"
                                    + result.hashCode() + "\t"
                                    + (User) result);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        isRun = false;
                    }
                }
            }
        }.start();
        User user2 = new User("sd", 12);
        SoftReference<User> abcWeakRef = new SoftReference<User>(user, referenceQueue);
//        PhantomReference<User> abcWeakRef = new PhantomReference<User>(user, referenceQueue);
//        PhantomReference<User> abcWeakRef2 = new PhantomReference<User>(user2, referenceQueue);
        user = null;
        Thread.currentThread().sleep(3000);
        System.gc();
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        hashtable.remove("sd");
        //        isRun = false;

//        referenceTest();
        
        
        
    }

	private static void referenceTest() throws InterruptedException {
		WeakReference<User> weakReference=new WeakReference<>(new User("xiaowu", 32));

        String json = JSON.toJSONString(weakReference.get());
        System.out.println(json);
        System.out.println(weakReference.get() == null);//false

        System.gc();
        TimeUnit.SECONDS.sleep(1);//暂停一秒钟

        System.out.println(weakReference.get() == null);//true
        
        
        
        SoftReference<User> softReference = new SoftReference<>(new User("qi", 26));
        json = JSON.toJSONString(softReference.get());
        System.out.println(json);
        System.out.println(softReference.get() == null);
        System.gc();
        
        TimeUnit.SECONDS.sleep(2);
        
        System.out.println(softReference.get() == null);
        
        User user = new User("sda", 13);
        
        PhantomReference<User> phantomReference = new PhantomReference<>(user, null);
        json = JSON.toJSONString(phantomReference.get());
        System.out.println(json);
        System.out.println(phantomReference.get() == null);
        
        System.gc();
        TimeUnit.SECONDS.sleep(2);
        
        System.out.println(phantomReference.get() == null);
        
        System.out.println(user);
	}
}
