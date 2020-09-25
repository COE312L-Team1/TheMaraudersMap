import java.util.Random;

public class Item
{
	String name;
	String desc;
	String[] verbs;
	
	String toPast(String v) {
		
		if(v.equalsIgnoreCase("eat")) return "ate";
		if(v.equalsIgnoreCase("consume")) return "consumed";
		if(v.equalsIgnoreCase("wear")) return "wore";
		if(v.equalsIgnoreCase("read")) return "read";
		if(v.equalsIgnoreCase("write")) return "wrote with";
		if(v.equalsIgnoreCase("craft")) return "crafted";
		if(v.equalsIgnoreCase("make")) return "made";
		if(v.equalsIgnoreCase("drink")) return "drank";
		
		else return v+(v.charAt(v.length()-1)=='e'?"d":"ed");
	}
	
	Boolean use(String v)
	{
		for(int i = 0; i < this.verbs.length ; i++) {
			if(verbs[i].equalsIgnoreCase(v)) {
				System.out.println("You "+toPast(v)+" the "+this.name+"!");
				return true;
			}
		}
		System.out.println("You cannot "+v+" the "+this.name+"!");
		return false;
	}

	
	public Item(String name, String desc, String[] verbs) {
		this.name = name;
		this.desc = desc;
		this.verbs = verbs;
	}

	public Item() {};
	
}
