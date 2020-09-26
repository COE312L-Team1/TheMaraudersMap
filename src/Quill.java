import java.util.Scanner;

public class Quill extends Item {

	static String written="";
	public Quill(String name, String desc, String[] verbs) {
		super(name, desc, verbs);
	}

	public Boolean use(String v) {
		
		Boolean ret =super.use(v);
		if(ret) {
			Scanner quillinput = new Scanner(System.in);
			if(!written.equals(""))	{ System.out.print("This is what you wrote before:\n"+written+"\n"); }
			System.out.println("> Write something with the quill below");
			written+=(quillinput.nextLine()+"\n");
			//quillinput.close();	//do not do this, bcoz this closes the main program's jin scanner too
		}
		return ret;
	}

}
