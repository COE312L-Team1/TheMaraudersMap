
public class Item
{
	String name;
	String desc;
	String[] verbs;
	
	String toPast(String v) {
		if(v=="eat") return "ate";
		if(v=="consume") return "consumed";
		if(v=="wear") return "wore";
		if(v=="put on") return "put on";
		else return v+"d";
	}
	
	void use(String v)
	{
		for(int i = 0; i < this.verbs.length ; i++) {
			if(verbs[i].equalsIgnoreCase(v)) {
				System.out.println("You "+v+" the "+this.name+"!");
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
