package Collection_Framwork_Assignment;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;

public class Assignment3Q8a {

	public static void failFast(Map<String,String>cityCode) {
		

	     Iterator iterator = cityCode.keySet().iterator();

	     while (iterator.hasNext()) {
	         System.out.println(cityCode.get(iterator.next()));
	     }
	}
	public static void main(String[] args) {
		Map<String ,String>map=new ConcurrentHashMap<String,String>();  // if we use concurrentHashMap, we can easily modify.
		                                                                // if we use HashMap/hashSet ,we can't modify.
		map.put("Manish", "Male");
		map.put("Sanya", "Female");
		map.put("Prince", "male");
		
	     Iterator<String>it=map.keySet().iterator();
	     while (it.hasNext()) {
	    	 map.put("Riya", "Female");                                // modify the map
	    	 System.out.println(it.next());
	     }
 
	}

}
