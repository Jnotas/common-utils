package ink.nota.common.test.classloader;

public class ClsLdParent {
	private Sp sp = new Sp("父类动态成员变量");
	
	private static Sp sp1 = new Sp("父类静态成员变量");
	
	public ClsLdParent() {
		{
			System.err.println("父类构造");
		}
		
	}
	{
		new Sp("父类动态代码块");
	}
	
	static {
		new Sp("父类静态代码块");
	}
	
	
	static class Sp{
		
		private Sp(String string) {
			System.out.println(string);
		}
	}

}
