package Collection_Framwork_Assignment;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Assignment3Q2 {
	
	public static LinkedHashSet ordered(LinkedHashSet linkedHashSet) {     
      
        LinkedHashSet<String> result=new LinkedHashSet<String>();
        Iterator<String>it=result.iterator();
        for(int i=linkedHashSet.size()-1;i>=0;i--) {
        	result.addAll(linkedHashSet);
        }
        return result;
	}
	
	public static HashSet unordered(HashSet hashSet) {
		
		  
        HashSet<String>res=new HashSet<String>();
        Iterator<String>it1=res.iterator();
        for(String ele:res) {
        	res.add(ele);
        }
		return res;
	}

	public static void main(String[] args) {
		
		Assignment3Q2 A=new Assignment3Q2();
		
		LinkedHashSet<String> lh=new LinkedHashSet();      
        lh.add("A");    
        lh.add("B");      
        lh.add("C");     
        lh.add("D");    
        lh.add("E");
        
        LinkedHashSet<String> ans=ordered(lh);   
        // linkedHashSet is ordered
        System.out.println("Linkedlist is ordered");
        System.out.println(ans);               
        
        
        HashSet<String>hash=new HashSet<>();
        hash.add("manish");
        hash.add("gourav");
        hash.add("rahul");
        hash.add("aryan");
        hash.add("Ritik");
        
        
        
        HashSet<String> ans1=new HashSet(hash); 
        // HashSet is unordered
        System.out.println("HashSet is unorderd");
        System.out.println(ans1);               

	}

}
