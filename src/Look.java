
public class Look implements Command {

	String[] synonyms = new String[]{"look around","look","observe","see","watch"};
	String[] args;
	Location curr;

	public Look(Location l) {
		this.curr = l;
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
		if(args.length == 1) // look at location
		{
			System.out.println("\n\t\t"+ curr.name);
			curr.look();
		}
		else	// look at item
		{
			Boolean validItem = false;
			
			for(int i = 0; i < curr.items.size(); i++)
				if(arg.toLowerCase().contains(curr.items.get(i).name.toLowerCase())) {
					System.out.println(curr.items.get(i).desc);
					validItem = true;
				}

			if(!validItem)
				System.out.println("You see no such thing!");
		}
		return curr;
	}
}
