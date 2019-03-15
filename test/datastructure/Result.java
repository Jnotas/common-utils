package ink.nota.common.test.datastructure;

public class Result<T> {
	private String code;
	private T data;
	
	public Result() {
	}

	public Result(String code,T data) {
		this.code = code;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", data=" + data + "]";
	}
	
	
}
