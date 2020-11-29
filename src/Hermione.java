public class Hermione extends Person implements Runnable {

	Location MyLoc;
	Location playerLoc;
	Thread t;

	public Hermione(String name, String desc, String[] dialog) {
		super(name, desc, dialog);
		t = new Thread(this);
	}
	@Override
	public void run() {
		while(true) {
			if(this.MyLoc.name.equals(this.playerLoc.name))
			{
				System.out.print("\nHermione: I am here!\n> ");
				break;
			}
			else
				System.out.print("");
		}
	}
}
