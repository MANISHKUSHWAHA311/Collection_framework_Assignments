package Collection_Framwork_Assignment;

import java.util.Comparator;
import java.util.TreeSet;

class Person{
    private String name;
    private int height;
    private double weight;
	public Person(String name, int height, double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}

class heightComparator implements Comparator<Person>{
	public int compare(Person p1,Person p2) {
		if(p1.getWeight()==p2.getWeight()) {
			int com=Integer.compare(p1.getHeight(), p2.getHeight());
			return com;
		}
		else {
			int com2=Double.compare(p1.getWeight(), p2.getWeight());
			return com2;
		}
	}
	
}

public class Assignment3Q1 {
		public static void main(String[] args) {
			
			TreeSet<Person>tree = new TreeSet<>(new heightComparator());
			tree.add(new Person("Kamlesh",5,55));
			tree.add(new Person("Manish",6,65));
			tree.add(new Person("Veerendra",5,65));
			tree.add(new Person("Krishna",6,70));
			tree.add(new Person("Aryan",5,80));
			
			System.out.println("Sort the person According to their weights,"+"\n"+"if someone weight is "
					+ "same then Sort based upon their heights");
			
			for(Person p:tree) {
				System.out.println(p.getName()+ " "+p.getHeight()+" "+p.getWeight());
			}
}
}