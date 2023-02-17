package Collection_Framwork_Assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Employee{
	private String name;
	private int id;
	
	Employee(String name,int id){
		this.name=name;
		this.id=id;
	}
	
	public int getId() {
		return id;
	}
	
	public String toString() {
		String newline = System.lineSeparator();
		return newline+"Employee Name : "+ this.name +" , id = "+ this.id+" ";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if(this==null || getClass()!=obj.getClass()) {
			return false;
		}
		Employee E=(Employee) obj;
		return id==E.id && Objects.equals(name, E.name);
	}
	
}

public class Assignment3Q5 {

	public static void main(String[] args) {
		
		
		
		Employee emp1=new Employee("Manish",1);
		Employee emp2=new Employee("gourav",2);
		Employee emp3=new Employee("aryan",3);
		
		Map<Employee,String>map=new Hashtable<Employee,String>();
		map.put(emp1, "Employee 1");
		map.put(emp2, "Employee 2");
		map.put(emp3, "Employee 3");
		
		System.out.println(map+"\n");
	
		
		System.out.println("Using get and pull method");
		System.out.println(map.get(emp1));
		System.out.println(map.get(emp2));
		System.out.println(map.get(emp3));
		
		System.out.println("\n");
		
		System.out.println("using equals and hashcode method");
		
		System.out.println(emp1.hashCode());

		System.out.println(emp1.equals(emp3));
		

		
		
		
		
        
	}

}
