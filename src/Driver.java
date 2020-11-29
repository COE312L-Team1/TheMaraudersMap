import java.util.ArrayList;
import java.util.Scanner;

public class Driver
{
	 /*				  =====
	 * 				   MAP			N
	 * 				  =====		W	+	E
	 * 								S
	 * 				Great Hall
	 * 					^
	 * 					|
	 *Library <-->	Entrance  <-->	Potions Classroom
	 * 
	 * */
	
	static Watch watch = new Watch();
	static Hermione hermione = new Hermione("Hermione",
			"Huddled over a desk, you spot your friend, Hermione Granger, with her nose buried in a book.\nThis is where you usually find her, and if you have homework due\nthe next day, she's the person to go to!",
			new String[]{"I'm reading a very interesting book on Blast-Ended Skrewts!","It's LeviOsa, not LeviosA!","Oh, are you doing magic? Let�s see it, then.","Have you seen Crookshanks? He must be off chasing Scabbers again!","I'm not letting you copy my homework again!","Would you like to join the Society for the Protection of Elvish Welfare?"});
	
	public static void main(String[] args) throws InterruptedException
	{
		// Location params: String name, String desc, Person p, Item a, Item b, Location north, Location south, Location east, Location west
		Location Entrance = new Location("The Entrance", "You arrive at the doors of Hogwarts. The door on the north wall leads to\r\nthe dining hall, the passage to the east leads to the Potions class, and\r\nthe door to the west leads to the Library.",
							new ArrayList<Person>(), new ArrayList<Item>(), null, null, null, null);
		
		Person Dumbledore = new Person("Dumbledore",
				"In front of you, you see Professor Dumbledore, the headmaster of the Hogwarts School\r\nof Witchcraft and Wizardry. He is dressed in some fine blue robes\r\nand seems to be preparing a speech for tonight.",
				new String[]{"Hello there, young student!","Would you care for some sherbet lemons?","It does not do to dwell on dreams and forget to live!","Are you still here? Quit bothering me!","Can't you see I'm busy? Please don't disturb me!","The truth. It is a beautiful and terrible thing, and should therefore be treated with great caution.","Have you seen my hat? I could swear I left it here!","You can come to my office any time. My DumbleDoor is always open!"});
		
		Person Bellatrix = new Person("Bellatrix","You see Bellatrix Lestrange standing in the middle of the hall. She looks angry and ready for a duel!",new String[] {"You are no match for my Dark Magic skills, boy!"});
		
		ArrayList<Person> GreatHallPeople = new ArrayList<Person>();
		GreatHallPeople.add(Dumbledore);
		GreatHallPeople.add(Bellatrix);
		
		Item food = new Item("Food","On the tables, you see all sorts of delicious food, from roast chicken to treacle tarts!",new String[] {"eat","consume"});
		SortingHat hat = new SortingHat("Sorting hat","At the end of the hall, on a small wooden stool, sits the legendary Sorting Hat,\r\nstill wrinkled, dirty and frayed.",new String[] {"wear","use"});
		ArrayList<Item> GreatHallItems = new ArrayList<Item>();
		GreatHallItems.add(food);
		GreatHallItems.add(hat);
		
		Location greatHall = new Location("The Great Hall", "You are walking up a huge hall with a towering ceiling, lit by thousands of floating\r\ncandles. You see four long tables, one for each house, being set\r\nfor the feast.",
							 				GreatHallPeople, GreatHallItems, null, Entrance, null, null);
		
		Entrance.north = greatHall;
		
		Book book = new Book("Book","Nearby, you see a pile of books left by a student. Some of them seem interesting.",new String[] {"read"});
		Quill quill = new Quill("Quill","You also spot a beautiful Eagle feather quill, that looks like it cost quite a few Galleons!",new String[] {"write with","write","use"});
		ArrayList<Item> LibraryItems = new ArrayList<Item>();
		LibraryItems.add(book);
		LibraryItems.add(quill);
		
		Person Malfoy = new Person("Malfoy","You see your arch nemesis, Draco Malfoy, standing near Hermione. He seems to be up to no good.",new String[]{"Wait till my father hears this!","If brains were money, you'd be poorer than Weasley!"});
		
		ArrayList<Person> LibraryPeople = new ArrayList<Person>();
		LibraryPeople.add(hermione);
		LibraryPeople.add(Malfoy);
		Location Library = new Location("The Library", "You are in the ancient library of Hogwarts, where knowledge is abundant.\nAll around, you see hundreds of rows, thousands of shelves, filled with books\nof all kinds. From Divination to Dark Arts, there were books for every subject.",
							 				LibraryPeople, LibraryItems, null, null, Entrance, null);
		
		hermione.MyLoc = Library;
		
		Entrance.west = Library;
		
		Person Snape = new Person("Snape",
				"Standing in the corner, was the teacher you despised most, Professor Severus Snape,\nHead of Slytherin. Clad in all black robes, his cold stare was enough\nto strike fear into your heart.\nHe does not seem very happy to see you and starts attacking you!",
				new String[]{"You there, that is one ugly sweater you're wearing. 10 points from Gryffindor!","Ah, Malfoy, I see you've brought your cauldron. 100 points to Slytherin!","I can teach you how to bottle fame, brew glory, even put a stopper on death.","Why are you all so incompetant?"});
		ArrayList<Person> PotionsPeople = new ArrayList<Person>();
		PotionsPeople.add(Snape);
		
		Cauldron cauldron = new Cauldron("Cauldron","On your desk, stands the brand new pewter cauldron you bought from\nDiagon Alley last week.", new String[] {"use"});
		Potion potion = new Potion("Potion","At the back of the class, you spot a flask of some bright violet\npotion! You wonder what would happen if you were to drink it...",new String[] {"drink","use"});
		ArrayList<Item> PotionsItems = new ArrayList<Item>();
		PotionsItems.add(cauldron);
		PotionsItems.add(potion);
		
		Location Potions = new Location("The Potions Classroom", "Down the long passage, you are now in the Potions Classroom in the cold dungeons.\nAll around, you see cauldrons of bubbling potions and pickled animals in floating glass jars!",
							 				PotionsPeople, PotionsItems, null, null, null, Entrance);
		
		Entrance.east = Potions;
		
		Location curr = Entrance;
		
		Move move = new Move(curr);
		Look look = new Look(curr);
		Talk talk = new Talk(curr);
		Use use = new Use(curr);
		ArrayList<Polyjuice> poly = new ArrayList<Polyjuice>(); 
		ArrayList<Invisibility> invis = new ArrayList<Invisibility>();
		Make make = new Make(curr, poly, invis);
		Help help = new Help(curr);
		SpellCommand spellcmd = new SpellCommand(curr);
	
		Command[] cmds = new Command[] {move,look,talk,use,make,help,spellcmd};
		ControlPanel panel = new ControlPanel(cmds, curr);
		
		System.out.println("\"Messrs Moony, Wormtail, Padfoot and Prongs Purveyors of Aids to\r\nmagical Mischief-Makers are proud to present THE MARAUDER'S MAP\"\r\nSay the magic phrase to reveal the map.");
		
		Scanner jin = new Scanner(System.in);
		
//		Commented for time being to ease debugging
		for (int i = 1; !jin.nextLine().equalsIgnoreCase("I solemnly swear that I am up to no good"); i++) //
		{
			if(i<3) { System.out.println("That's not the right magic phrase! Try again."); }
			else if(i == 3) { System.out.println("That's not the right magic phrase!\nThis is your last chance!"); }
			else{ System.out.println("YOU DO NOT KNOW THE PHRASE!\nYou cannot be allowed to see the map... Bye!"); }
		}		
		
		hermione.playerLoc = curr;
		hermione.t.start();
		System.out.println("\t\t"+curr.name);
		curr.look();
		
		System.out.print("> ");
		String input = jin.nextLine();
		
		while(!input.equalsIgnoreCase("mischief managed"))
		{
			curr = panel.parse(input);
			look.curr = curr;
			use.curr = curr;
			make.curr = curr;
			talk.curr = curr;
			help.curr = curr;
			spellcmd.curr = curr;
			hermione.playerLoc = curr;
		
			System.out.print("> ");
			input = jin.nextLine();
		}
		
		System.out.println("Hiding map contents...end.");
		jin.close();
		System.exit(0);
	}
}

