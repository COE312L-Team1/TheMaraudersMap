import java.util.ArrayList;

public class Make implements Command {

	String[] synonyms = new String[]{"make","brew","prepare"};
	String[] args;
	Location curr;
	ArrayList<Polyjuice> poly; 
	ArrayList<Invisibility> invis;

	public Make(Location l, ArrayList<Polyjuice> p, ArrayList<Invisibility> i) {
		this.curr = l;
		this.poly = p;
		this.invis = i;
	}

	public Boolean isSynonym(String cmd)
	{
		for(String s:this.synonyms)
			if(cmd.equalsIgnoreCase(s))
				return true;
		return false;
	}

	public Location execute(String arg)
	{
		this.args = arg.split(" ");
		
		if(!curr.name.equals("The Potions Classroom"))
		{
			System.out.println("You are not in the Potions Classroom!");
			return curr;
		}
		
		if(!curr.isEnemyDefeated)
		{
			System.out.println("You must defeat "+ curr.p.get(0).name+" first!");
			return curr;
		}
		
		if (arg.toLowerCase().contains("polyjuice")) {
			Polyjuice p = new Polyjuice();
			p.prepareRecipe();
			System.out.println("Potion is ready!");
			poly.add(p);
			System.out.println("You now have "+poly.size()+" flasks of Polyjuice Potion!");
		}
		
		else if(arg.toLowerCase().contains("invisibility") ) {
	
			Invisibility p2 = new Invisibility();
			p2.prepareRecipe();
			System.out.println("Potion is ready!");
			invis.add(p2);
			System.out.println("You now have "+invis.size()+" flasks of Invisibility Potion!");
		}
		else
		{
			System.out.println("Cannot make that!");
		}
		return curr;
	}
}
