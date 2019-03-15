package ink.nota.common.test.datastructure;

import java.util.ArrayList;
import java.util.List;

import com.emoyc.note.common.pojo.TUser;

public class MapTest {

	public static void main(String[] args) {
		ArrayList<TUser> list = new ArrayList<>();
		
		TUser user = new TUser("name1", "value1");
		list.add(user);
		user = new TUser("name2", "vaule2");
		list.add(user);
		user = new TUser("name3", "vaule3");
		list.add(user);
		
		System.out.println(list);
		list.forEach(e->{
			System.out.println(e);
		});
	}
}
