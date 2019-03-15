package ink.nota.common.test.design;

public class Singleton {

	private Singleton() {};
	
	private static class OneSingleton {
		private static Singleton INSTANCE = new Singleton();
	}
	
	public static Singleton getInstance() {
		return OneSingleton.INSTANCE;
	}
	
	
	
	
}
