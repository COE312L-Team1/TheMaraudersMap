public class Hermione extends Person implements Runnable {
	
	Location MyLoc;
	Location HarryLoc;
	Thread t;

	public Hermione(String name, String desc, String[] dialog) {
		super(name, desc, dialog);
		t = new Thread(this);
	}
	@Override
	public void run() {
		while(true) {
			synchronized(this.HarryLoc) {
				if(this.MyLoc==this.HarryLoc)
				{
					System.out.print("\nHermione: Harry I am here!\n> ");
					break;
				}
			}
			
		}
	}
}
