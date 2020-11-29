
public interface Command
{
	Location execute(String args);
	Boolean isSynonym(String cmd);
}

