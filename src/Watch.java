
public class Watch implements java.lang.Runnable {

	int i;
	Thread t;

	Watch() { 
		i = 0;
		t = new Thread(this);
	}

	@Override
	public void run() {
		this.runTimer();
	}

	public void timeLeft()
	{
		System.out.println("\n" + (180 - i) / 60 + " minutes and " + (180 - i) % 60 + " seconds left");
	}

	public void runTimer() {
		boolean timesup = false;
		while (i <= 180) {
			try {
				if (i == 60 || i == 120) {
					System.out.print("\n" + (i / 60) + " minute");
					System.out.print(((i == 120) ? "s " : " ") + "passed...\n> ");
				}
				if (i == 180 && !timesup) {
					synchronized (this) {
						timesup = true;
						System.out.print("\nTime is up! 10 seconds to hide map contents!\n> ");
						i -= 10;
					}
				} else if (i == 180 && timesup) {
					synchronized (this) {
						System.out.print("\nYOU WERE CAUGHT! Marauder’s map has been confiscated!\n> ");
					}
				}
				i++;
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				break;
			}
		}
		System.exit(0);
	}

}
