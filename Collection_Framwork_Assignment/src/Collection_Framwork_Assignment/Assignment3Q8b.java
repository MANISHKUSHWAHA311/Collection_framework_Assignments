package Collection_Framwork_Assignment;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Assignment3Q8b {
	public static CopyOnWriteArrayList<Integer> failFast(CopyOnWriteArrayList<Integer> list){
		Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
//            System.out.println("Value: " + value);
            list.add(6);
        }
        return list;
	}
   
    public static void main(String args[]) {
    	CopyOnWriteArrayList<Integer> list=new CopyOnWriteArrayList<Integer>();
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	list.add(5);
    	
    	System.out.println(list);
    	
    	System.out.println("After failfast iterator"+failFast(list));
   
    	
    	
    }
    	
}
