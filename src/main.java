import java.util.Scanner;

public class main
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
	
	public static Location curr;
	
	public static void process(String cmd, Location entrance) {
		
		String[] look = new String[] {"look","observe","see","watch"};
		String[] movement = new String[]{"move","go","walk","proceed","advance"};
		String[] talk = new String[] {"talk","speak","chat"};
		
		int type=-1;
		String verb = "";
		
		for(String m:look) {
			if(cmd.toLowerCase().contains(m)) {
				type=1;
				verb=m;
				break;
			}
		}

		for(String m:movement) {
			if(cmd.toLowerCase().contains(m)) {
				type=2;
				verb=m;
				break;
			}
		}

		for(String m:talk) {
			if(cmd.toLowerCase().contains(m)) {
				type=3;
				verb=m;
				break;
			}
		}
		
		if(type==1) {
			System.out.println("\n\t\t"+curr.name);
			curr.look();
		}
		else if(type==2) {
			if (cmd.toLowerCase().contains("north") && curr.north != null)
			{ curr = curr.north;	curr.enter(); }
			else if(cmd.toLowerCase().contains("south") && curr.south != null)
			{ curr = curr.south;	curr.enter(); }
			else if(cmd.toLowerCase().contains("east") && curr.east != null)
			{ curr = curr.east;	curr.enter(); }
			else if(cmd.toLowerCase().contains("west") && curr.west != null)
			{ curr = curr.west;	curr.enter(); }
			else
			{ System.out.println("You cannot "+verb+" there!"); }
		}
		else if(type==3) {
			if(curr.p != null && cmd.toLowerCase().contains(curr.p.name.toLowerCase()))
			{ curr.p.talk(curr); }
			else
			{ System.out.println("You see no such person!"); }
		}
		else if((curr.a!=null && cmd.toLowerCase().contains(curr.a.name.toLowerCase())) || (curr.b!=null && cmd.toLowerCase().contains(curr.b.name.toLowerCase()))) { //use item
			
			for(int i=0;cmd.charAt(i)!=' ';i++) {verb+=cmd.charAt(i);}
			
			if(curr.a != null && cmd.toLowerCase().contains(curr.a.name.toLowerCase()))
			{ curr.a.use(verb); }
			else if(curr.b != null && cmd.toLowerCase().contains(curr.b.name.toLowerCase()))
			{ curr.b.use(verb); }
			else
			{ System.out.println("You see no such thing!"); }
		}
		else if(cmd.toLowerCase().contains("apparate")) {
			if(cmd.toLowerCase().contains("entrance")) {
				curr = entrance;	curr.enter();
			}
			else if(cmd.toLowerCase().contains("hall")) {
				curr = entrance.north;	curr.enter();
			}
			else if(cmd.toLowerCase().contains("library")) {
				curr = entrance.west;	curr.enter();
			}
			else if(cmd.toLowerCase().contains("potions")) {
				curr = entrance.east;	curr.enter();
			}
			else {
				System.out.println("There is no such location on the map!");
			}
		}
		else if(cmd.toLowerCase().equals("help")) {
			System.out.println("This is the help message.");
		}
		else
		{
			System.out.println("I do not understand that. You could try the help command"); //need to add help command
		}
	}
	
	public static void main(String[] args)
	{
		// Location params: String name, String desc, Person p, Item a, Item b, Location north, Location south, Location east, Location west
		Location Entrance = new Location("The Entrance", "You arrive at the doors of Hogwarts. The door on the north wall leads to\r\nthe dining hall, the passage to the east leads to the Potions class, and\r\nthe door to the west leads to the Library.",
							null, null, null, null, null, null, null);
		
		Person Dumbledore = new Person("Dumbledore",
				"In front of you, you see Professor Dumbledore, the headmaster of the Hogwarts School\r\nof Witchcraft and Wizardry. He is dressed in some fine blue robes\r\nand seems to be preparing a speech for tonight.",
				new String[]{"Hello there, young student!","Would you care for some sherbet lemons?","It does not do to dwell on dreams and forget to live!","Are you still here? Quit bothering me!","Can't you see I'm busy? Please don't disturb me!","The truth. It is a beautiful and terrible thing, and should therefore be treated with great caution.","Have you seen my hat? I could swear I left it here!","You can come to my office any time. My DumbleDoor is always open!"});
		
		Item food = new Item("Food","On the tables, you see all sorts of delicious food, from roast chicken to treacle tarts!",new String[] {"eat","consume"});
		SortingHat hat = new SortingHat("Sorting hat","At the end of the hall, on a small wooden stool, sits the legendary Sorting Hat,\r\nstill wrinkled, dirty and frayed.",new String[] {"wear","use"});
		Location greatHall = new Location("The Great Hall", "You are walking up a huge hall with a towering ceiling, lit by thousands of floating\r\ncandles. You see four long tables, one for each house, being set\r\nfor the feast.",
							 				Dumbledore, food, hat, null, Entrance, null, null);
		
		Entrance.north = greatHall;
		
		Person Hermione = new Person("Hermione",
				"Huddled over a desk, you spot your friend, Hermione Granger, with her nose buried in a book.\nThis is where you usually find her, and if you have homework due\nthe next day, she's the person to go to!",
				new String[]{"I'm reading a very interesting book on Blast-Ended Skrewts!","It's LeviOsa, not LeviosA!","Oh, are you doing magic? Let’s see it, then.","Have you seen Crookshanks? He must be off chasing Scabbers again!","I'm not letting you copy my homework again!","Would you like to join the Society for the Protection of Elvish Welfare?"});
		
		Book book = new Book("Book","Nearby, you see a pile of books left by a student. Some of them seem interesting.",new String[] {"read"});
		Quill quill = new Quill("Quill","You also spot a beautiful Eagle feather quill, that looks like it cost quite a few Galleons!",new String[] {"write with","write","use"});
		Location Library = new Location("The Library", "You are in the ancient library of Hogwarts, where knowledge is abundant.\nAll around, you see hundreds of rows, thousands of shelves, filled with books\nof all kinds. From Divination to Dark Arts, there were books for every subject.",
							 				Hermione, book, quill, null, null, Entrance, null);
		
		Entrance.west = Library;
		
		Person Snape = new Person("Snape",
				"Standing in the corner, was the teacher you despised most, Professor Severus Snape,\nHead of Slytherin. Clad in all black robes, his cold stare was enough\nto strike fear into your heart.",
				new String[]{"You there, that is one ugly sweater you're wearing. 10 points from Gryffindor!","Ah, Malfoy, I see you've brought your cauldron. 100 points to Slytherin!","I can teach you how to bottle fame, brew glory, even put a stopper on death.","Why are you all so incompetant?"});
		
		Cauldron cauldron = new Cauldron("Cauldron","On your desk, stands the brand new pewter cauldron you bought from\nDiagon Alley last week.", new String[] {"use"});
		Potion potion = new Potion("Potion","At the back of the class, you spot a flask of some bright violet\npotion! You wonder what would happen if you were to drink it...",new String[] {"drink","use"});
		Location Potions = new Location("The Potions Classroom", "Down the long passage, you are now in the Potions Classroom in the cold dungeons.\nAll around, you see cauldrons of bubbling potions and pickled animals in floating glass jars!",
							 				Snape, cauldron, potion, null, null, null, Entrance);
		
		Entrance.east = Potions;
		
		System.out.println("\"Messrs Moony, Wormtail, Padfoot and Prongs Purveyors of Aids to\r\nmagical Mischief-Makers are proud to present THE MARAUDER'S MAP\"\r\nSay the magic phrase to reveal the map.");
		
		Scanner jin = new Scanner(System.in);
		
//		Commented for time being to ease debugging
		for (int i = 1; !jin.nextLine().equalsIgnoreCase("I solemnly swear that I am up to no good"); i++)
		{
			if(i<3) { System.out.println("That's not the right magic phrase! Try again."); }
			else if(i == 3) { System.out.println("That's not the right magic phrase!\nThis is your last chance!"); }
			else{ System.out.println("YOU DO NOT KNOW THE PHRASE!\nYou cannot be allowed to see the map... Bye!"); }
		}
		
		curr = Entrance;
		System.out.println("\t\t"+curr.name);
		curr.look();
		
		System.out.print("> ");
		String input = jin.nextLine();
		
		while(!input.equalsIgnoreCase("mischief managed"))
		{
			process(input, Entrance);
			System.out.print("> ");
			input = jin.nextLine();
		}
		
		System.out.println("Hiding map contents...end.");
		jin.close();
	}
}

