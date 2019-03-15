package ink.nota.common.test.polymorphic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

/**
 * 汽车
 * @author Frank
 *
 */
public class Car implements Cloneable,Serializable {

	private String name;  //名称
	private String color; //颜色
	private HashMap<String, Object> properties;  //配置
	private Chassis chassis;	//底盘
	@Override
	public Object clone() throws CloneNotSupportedException {
		//如果 car对象由内部成员没有实现 cloneable接口,就属于浅克隆
		
		//深克隆 所有成员变量实现cloneable接口  或者引用变量new一个对象
		Object p = super.clone();
		p = SerialazableClone();
		//序列化克隆
		return p;
	}
	private Object SerialazableClone() {
		Object cloneObject = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			//将自己序列化
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			oos.close();
			
			//反序列化
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			cloneObject = ois.readObject();
			ois.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cloneObject;
	}
}
