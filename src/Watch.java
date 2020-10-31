
public class Watch implements java.lang.Runnable {

	int i;
	
	Watch() { i = 0; }
	
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
					synchronized (this) {
						System.out.print("\n" + (i / 60) + " minute");
						System.out.println(((i == 120) ? "s " : " ") + "passed...");
					}
				}
				if (i == 180 && !timesup) {
					synchronized (this) {
						timesup = true;
						System.out.println("\nTime is up! 10 seconds to hide map contents!");
						i -= 10;
					}
				} else if (i == 180 && timesup) {
					synchronized (this) {
						System.out.println("\nYOU WERE CAUGHT! Marauder’s map has been confiscated!");
					}
				}
				i++;
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				synchronized (this) {
					break;
				}
			}
		}
		System.exit(0);
	}

}
