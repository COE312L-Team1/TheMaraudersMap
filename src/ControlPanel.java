
public class ControlPanel {
	Command [] cmds;
	Location curr;
	public ControlPanel(Command [] cmds, Location l) {
		this.cmds = cmds;
		this.curr = l;
	}
	public Location parse(String cmd){

		String op = cmd.split(" ")[0];
		
		for(int i = 0; i < cmds.length; i++)
		{
			if(cmds[i].isSynonym(op)) {
				return cmds[i].execute(cmd);
			}
		}
		System.out.println("I do not understand that. You could try the help command");
		return curr;
	}
}
