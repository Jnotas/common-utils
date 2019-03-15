package ink.nota.common.test.nio;

public class TimeClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int port = 1234;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				// 采用默认值
			}
		}
		for (int i = 0; i < 10; i++) {
			new Thread(new TimeClientHandle("127.0.0.1", port, "msg" + i), "TimeClient-001").start();
		}
	}

}