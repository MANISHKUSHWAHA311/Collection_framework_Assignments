package Collection_Framwork_Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class Assignment3Q3 {
	private static final boolean Integer = false;

	public static List traverseReverse(ArrayList list) {
		List<Integer> ans=new ArrayList<Integer>();
		ListIterator<Integer>it= list.listIterator();
		
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
		for(int i=list.size()-1;i>=0;i--) {
			ans.add((java.lang.Integer) list.get(i));
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Assignment3Q3 A=new Assignment3Q3();
		ArrayList<Integer>list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(list);
		
		System.out.println("Arraylist after reversing the list using ListIterator :");
		
     	ArrayList<Integer> res= (ArrayList<java.lang.Integer>) traverseReverse(list);
     	System.out.println(res);
		
	
	
	}

}
