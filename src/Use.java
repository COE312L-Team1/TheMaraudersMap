
public class Use implements Command {

	String[] synonyms = new String[]{"use","eat","consume","wear","write","drink","read"};
	String[] args;
	Location curr;

	public Use(Location l) {
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
		String cmd = args[0];

		for(int i = 0; i < curr.items.size(); i++) 
		{	
			if(arg.toLowerCase().contains(curr.items.get(i).name.toLowerCase()))
			{				
				curr.items.get(i).use(cmd);
			}
		}
		return curr;
	}
}
