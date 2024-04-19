package Home.DATA;

import java.util.*;

import Home.UserSit;
import lombok.Data;

public class User implements UserSit {

	public static Map<String, Integer> usermap = new HashMap<>();
	public static Set<String> userset = new HashSet<String>();
	List<String[]> matchuser = new ArrayList<>();
	
	public static Map<String,String> list = new HashMap<>();
	public static Map<String, Integer> map = new HashMap<>();

	public void setMap() {
		for(String str : this.userset) {
			//username
			String url = this.list.get(str);
			int count = this.usermap.get(str);
			this.map.put(str, count);
		}

	}

	public User() {
		list.put(user1url, user1);
		list.put(user2url, user2);
		list.put(user3url, user3);
		list.put(user4url, user4);
		list.put(user5url, user5);
		list.put(user6url, user6);
		list.put(user7url, user7);
		list.put(user8url, user8);
		list.put(user9url, user9);
		list.put(user10url, user10);
		
		
	}
}
