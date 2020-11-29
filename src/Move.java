
public class Move implements Command {

	String[] synonyms = new String[]{"move","go","walk","proceed","advance"};
	String[] args;
	Location curr;

	public Move(Location l) {
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

		if (arg.toLowerCase().contains("north") && curr.north != null){ 
			curr = curr.north;	curr.enter();
		}
		else if(arg.toLowerCase().contains("south") && curr.south != null){
			curr = curr.south;	curr.enter(); 
		}
		else if(arg.toLowerCase().contains("east") && curr.east != null) {
			curr = curr.east;	curr.enter(); 
		}
		else if(arg.toLowerCase().contains("west") && curr.west != null){ 
			curr = curr.west;	curr.enter(); 
		}
		else
			System.out.println("You cannot go there!"); 
		return curr;
	}
}
