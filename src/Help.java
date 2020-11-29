public class Help implements Command{
	
	String[] synonyms = new String[]{"help"};
	String[] args;
	Location curr;
	
	public Help(Location l) {
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
		System.out.println("Usage:\n\tlook|observe|see|watch\tProvides short description about the location\n\t\t\t\tand characters present\n\n\tmove|go|walk|proceed|advance {north|south|east|west}\n\t\t\t\tMoves the user to a different location using\n\t\t\t\tthe direction argument\n\ttalk|speak|chat character-name\tTalk to the character present\n\t\t\t\tin current location");
		return curr;
	}


}
