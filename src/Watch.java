
public class Watch implements java.lang.Runnable {

	@Override
	public void run() 
	{
		this.runTimer();
	}

	public void runTimer() 
	{
		int i = 180;
		boolean timesup = false;
		while (i > 0) 
		{
			try 
			{
				if (i == 60 || i == 120) {
					synchronized (this)
					{
					System.out.print("" + (i / 60) + " minute");
					System.out.println((i / 120 == 1) ? " " : "s " + "passed");
					i--;
					}
				}
				if(i == 0 && !timesup)
				{
					synchronized (this)
					{
					timesup = true;
					System.out.println("Time is up! 10 seconds to hide map contents!");
					i += 10;
					}
				}
				else if (timesup)
				{
					synchronized (this)
					{
					System.out.println("YOU WERE CAUGHT! Marauder’s map has been confiscated!");
					}
				}
				Thread.sleep(1000L);
			}
			catch (InterruptedException e) {
				synchronized (this)
				{
				System.out.println(e.getMessage());
				}
			}
		}
		System.exit(0);
	}

}
