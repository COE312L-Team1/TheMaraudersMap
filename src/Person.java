import java.util.Random;

public class Person
{
	String name;
	String desc;
	String[] dialog;
	void talk(Location curr)
	{
		Random r = new Random();
		System.out.println("\""+this.dialog[r.nextInt(this.dialog.length)]+"\"");
		System.out.println("You can "+curr.a.verbs[0]+" the "+curr.a.name+" or " + curr.b.verbs[0] + " the " + curr.b.name +".");
	}
	
	public Person(String name, String desc, String[] dialog) {
		this.name = name;
		this.desc = desc;
		this.dialog = dialog;
		
	}
	
	public Person() {};
	
}
