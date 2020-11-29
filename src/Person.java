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
		if(this.name=="Dumbledore" || this.name=="Snape" || this.name=="Hermione") {
			for(int i = 0; i < curr.items.size(); i++)
			{
				if(i == 0)
					System.out.print("You can ");

				System.out.print(curr.items.get(i).verbs[0]+" the "+curr.items.get(i).name);

				if(i != curr.items.size() - 1)
					System.out.print(" or ");

				if( i == curr.items.size() - 1)
					System.out.println(".");
			}
		}
	}

	public Person(String name, String desc, String[] dialog) {
		this.name = name;
		this.desc = desc;
		this.dialog = dialog;

	}

	public Person() {};

}
