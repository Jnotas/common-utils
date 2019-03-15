package ink.nota.common.test.classloader;
//package 指定文件所在位置在test包下

import ink.nota.common.test.interfaces.SimpleInfo;

public class TestClass extends Thread implements SimpleInfo{
    public String name;        //公共属性，可以被子类集成使用
    private Integer age;    //私有属性，不能被子类使用
    public static final String classInfo = "TestClassInfo";  //final 修饰属性，不可被修改
    public static ThreadLocal<Long> scyThread = new ThreadLocal<>();
    
    @Override
    public String outInfo() {        //实现 SimpleInfo 接口 所以必须实现Simple 接口的outInfo方法
        return Thread.currentThread().getName()+" Hello -> " + scyThread.get();
    }
    
    //private 私有 说明 setAge是私有方法，只有对象自己才能调用
    private void setAge(Integer age) {
        this.age = age;
    }
    
    //空参构造 即 new TestClass();实现创建对象的构造方法
    public TestClass() {        
        
    }
    //有参构造
    public TestClass(String name) {
        this.name = name;
    }
    //有参构造
    public TestClass(String name,Integer age) {
        this.name = name;
        this.age = age;
    }
    //继承 Thread 类  重写 run() 方法
    @Override
    public void run () {
        setName(name);
        scyThread.set(age.longValue());
        System.out.println(outInfo()); //打印调用outInfo()方法的返回值
    }
    
    //公共静态方法 谁都可以调用
    public static void sayHello() {
        System.out.println("Hello World");
    }
    
    //main 方法，程序启动的开始
    public static void main(String[] args) {
        //静态方法
        TestClass.sayHello();
        for(int i = 0; i < 5; i++) {
            //有参构造创建TestClass对象
        	//TestClass继承Thread,拥有Thread线程属性，所以创建的对象是线程对象
            TestClass thread = new TestClass("CreatThread"+i,i);
            //调用Thread 的start() 方法启动线程
            thread.start();
        }
    }
    
    
}