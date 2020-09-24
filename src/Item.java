import java.util.Random;

public class Item
{
	String name;
	String desc;
	String[] verbs;
	
	String toPast(String v) {
		
		if(v.equalsIgnoreCase("use")) return "used";
		
		if(v.equalsIgnoreCase("eat")) return "ate";
		if(v.equalsIgnoreCase("consume")) return "consumed";
		if(v.equalsIgnoreCase("wear")) return "wore";
		if(v.equalsIgnoreCase("read")) return "read";
		if(v.equalsIgnoreCase("write")) return "wrote";
		if(v.equalsIgnoreCase("craft")) return "crafted";
		if(v.equalsIgnoreCase("make")) return "made";
		if(v.equalsIgnoreCase("drink")) return "drank";
		
		else return v+"d";
	}
	
	void use(String v)
	{
		for(int i = 0; i < this.verbs.length ; i++) {
			if(verbs[i].equalsIgnoreCase(v)) {
				System.out.println("You "+toPast(v)+" the "+this.name+"!");

				if(this.name.equals("Sorting hat")) { 
					Random r = new Random();
					String[] houses = {"Gryffindor!", "Hufflepuff!", "Ravenclaw!", "Slytherin!"};
					System.out.println(houses[r.nextInt(houses.length)]);
				}
				
				return;
			}
		}
		System.out.println("You cannot "+v+" the "+this.name+"!");
	}

	
	public Item(String name, String desc, String[] verbs) {
		this.name = name;
		this.desc = desc;
		this.verbs = verbs;
	}

	public Item() {};
	
}
