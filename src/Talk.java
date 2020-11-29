
public class Talk implements Command{

	String[] synonyms = new String[]{"talk","speak","chat"};
	String[] args;
	Location curr;

	public Talk(Location l) {
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
		Boolean validPerson = false;

		for(int i = 0; i < curr.p.size(); i++)
			if(arg.toLowerCase().contains(curr.p.get(i).name.toLowerCase())) {
				curr.p.get(i).talk(curr); 
				validPerson = true;
			}

		if(!validPerson)
			System.out.println("You see no such person!"); 
		
		return curr;

	}
}
