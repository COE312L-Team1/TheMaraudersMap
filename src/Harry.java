
public class Harry extends Person implements Runnable{

	Thread t;
	Watch watch;
	Location myLoc;
	Harry(Watch w){
		this.watch = w;
		t = new Thread(this);
	}
	public void run() {

		this.watch.t.start();
		while(true) {
			synchronized(this.myLoc) {
				if(this.myLoc.p != null && this.myLoc.p.name == "Hermione")
				{
					System.out.print("\nFound Hermione!\n> ");
					break;
				}
			}
		}
	}
}
