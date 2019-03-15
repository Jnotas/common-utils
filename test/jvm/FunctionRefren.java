package ink.nota.common.test.jvm;


public class FunctionRefren {
	    private int  id;

	    public static void main(String[] args) {
	    	FunctionRefren r1 = new FunctionRefren();
	    	FunctionRefren r2 = new FunctionRefren();
	    	r1.id = 12;
	    	r2.id = 30;
	        System.out.println("交换前的值：");
	        System.out.println("r1.id=" + r1.id);
	        System.out.println("r2.id=" + r2.id);

	        swap(r1, r2);
	        System.out.println("交换后的值：");
	        System.out.println("r1.id=" + r1.id);
	        System.out.println("r2.id=" + r2.id);
	    }

	    private static void swap(FunctionRefren	 r1, FunctionRefren r2) {
	        FunctionRefren temp;
	        temp = r1;
	        r1 = r2;
	        r2 = temp;
	        r1.id = 90;
	    }


}
