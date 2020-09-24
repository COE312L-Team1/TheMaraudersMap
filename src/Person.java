import java.util.Random;

public class Person
{
	String name;
	String desc;
	String[] dialog;
	void talk()
	{
		Random r = new Random();
		System.out.println(this.dialog[r.nextInt(this.dialog.length)]);
		
	}
	
	public Person(String name, String desc, String[] dialog) {
		this.name = name;
		this.desc = desc;
		this.dialog = dialog;
		
	}
	
	public Person() {};
	
}
