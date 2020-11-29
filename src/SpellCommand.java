
public class SpellCommand implements Command{

	String[] synonyms = new String[]{"expelliarmus","stupefy","protego","expecto-patronum"};
	String[] args;
	Location curr;

	public SpellCommand(Location l) {
		this.curr = l;
	}

	Expelliarmus exp = new Expelliarmus();
	Stupefy stup = new Stupefy();
	Protego prot = new Protego();
	ExpectoPatronum expat = new ExpectoPatronum();

	public Location execute(String args) {

		if(args.split(" ")[0].equalsIgnoreCase(synonyms[0])) 
			this.exp.cast();
		else if(args.split(" ")[0].equalsIgnoreCase(synonyms[1])) 
			this.stup.cast();
		else if(args.split(" ")[0].equalsIgnoreCase(synonyms[2])) 
			this.prot.cast();
		else if(args.split(" ")[0].equalsIgnoreCase(synonyms[3]))
			this.expat.cast();
		
		if(curr.p.size() > 0) {
			if(curr.p.size() > 1)
				System.out.println("You defeated " + curr.p.get(1).name);
			else
				System.out.println("You defeated " + curr.p.get(0).name);
			
			curr.isEnemyDefeated = true;
		}

		return curr;
	}


	public Boolean isSynonym(String cmd)
	{
		for(String s:this.synonyms)
			if(cmd.equalsIgnoreCase(s))
				return true;
		return false;
	}

}
