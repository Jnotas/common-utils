package ink.nota.common.test.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class SomeThread {
	
	
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(12);    //线程池放12个预存线程，并且最大线程数为3  使用队列  LinkedBlockingQueue
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();   //初始预存线程数为 0 最大线程数不限制  使用队列 SynchronousQueue 
		ExecutorService singlePool = Executors.newSingleThreadExecutor();	//只有一个线程  队列模式
		ExecutorService myThreadPool = new ThreadPoolExecutor(3, 12, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		//使用 LinkedBlockingQueue 队列， 如果线程数小于核心线程数，则new Thread 执行任务，如果当前线程等于核心数，则将任务放入队列，等待执行
		ExecutorService myThreadPool2 = new ThreadPoolExecutor(3, 12, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());  
		//使用 SynchronousQueue 任务不会放入队列，会直接执行（new Thread） 如果超过线程最大数，仍然会new Thread() 并且会被拒绝（超过最大线程数） 抛出RejectedExecutionException异常  表示拒绝执行
		try {
			TestExecute(threadPool, newCachedThreadPool, singlePool, myThreadPool);
			//			TestSubmit(threadPool, newCachedThreadPool, singlePool, myThreadPool);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		newCachedThreadPool.shutdown();
//		threadPool.shutdown();
	}

	private static void TestSubmit(ExecutorService threadPool, ExecutorService newCachedThreadPool,
			ExecutorService singlePool, ThreadPoolExecutor myThreadPool)
			throws InterruptedException, ExecutionException {
		poolSubmit(threadPool);
		
		Thread.sleep(5000l);
		log();
		poolSubmit(newCachedThreadPool);
		
		Thread.sleep(5000l);
		log();
		poolSubmit(singlePool);
		
		Thread.sleep(5000l);
		log();
		poolSubmit(myThreadPool);
	}

	private static void TestExecute(ExecutorService threadPool, ExecutorService newCachedThreadPool,
			ExecutorService singlePool, ExecutorService myThreadPool) throws InterruptedException {
		poolExecute(threadPool);
	
		Thread.sleep(1000l);
		log();
		poolExecute(newCachedThreadPool);
		log();
		Thread.sleep(1000l);
		poolExecute(singlePool);
		log();
		Thread.sleep(1000l);
		poolExecute(myThreadPool);

	}

	private static void log() {
		System.out.println("");
		System.out.println("----------------------");
		System.out.println("");
	}

	private static void poolExecute(ExecutorService threadPool) {
		for (int i = 0; i <100 ; i++) {
			final int x = i;
			threadPool.execute(() ->{
				System.out.println(Thread.currentThread().getName() + "__i:"+x);
			});
			
		}
	}
	
	private static void poolSubmit(ExecutorService threadPool) throws InterruptedException, ExecutionException {
		for (int i = 0; i <100 ; i++) {
			final int x = i;
			Future<String> submit = threadPool.submit(new Callable<String>() {
				public String call() throws Exception {
					Thread.sleep(10l);
					return "call return:" + Thread.currentThread().getName() + "__i:" + x;
				}
			});
			String string = submit.get();
			System.out.println(string);
			
		}
	}

	private class MyCall implements Callable<String>{

		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
