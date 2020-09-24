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
	 *Library <-->	Entrance  <-->	Potions
	 * 
	 * */
	
	public static Location curr;
	
	public static void process(String cmd) {
		
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
			curr.look();
		}
		else if(type==2) {
			if (cmd.toLowerCase().contains("north") && curr.north != null)
			{ curr = curr.north; System.out.println("You have entered the "+curr.name); }
			else if(cmd.toLowerCase().contains("south") && curr.south != null)
			{ curr = curr.south; System.out.println("You have entered the "+curr.name); }
			else if(cmd.toLowerCase().contains("east") && curr.east != null)
			{ curr = curr.east; System.out.println("You have entered the "+curr.name); }
			else if(cmd.toLowerCase().contains("west") && curr.west != null)
			{ curr = curr.west; System.out.println("You have entered the "+curr.name); }
			else
			{ System.out.println("You cannot "+verb+" there!"); }
		}
		else if(type==3) {
			if(curr.p != null && cmd.toLowerCase().contains(curr.p.name.toLowerCase()))
			{ curr.p.talk(); }
			else
			{ System.out.println("You see no such person!"); }
		}
		else if(cmd.toLowerCase().contains(curr.a.name.toLowerCase()) || cmd.toLowerCase().contains(curr.b.name.toLowerCase())) { //use item
			
			for(int i=0;cmd.charAt(i)!=' ';i++) {verb+=cmd.charAt(i);}
			
			if(curr.a != null && cmd.toLowerCase().contains(curr.a.name.toLowerCase()))
			{ curr.a.use(verb); }
			else if(curr.b != null && cmd.toLowerCase().contains(curr.b.name.toLowerCase()))
			{ curr.b.use(verb); }
			else
			{ System.out.println("You see no such thing!"); }
		}
		else
		{
			System.out.println("I do not understand that. You could try the help command"); //need to add help command
		}
	}
	
	public static void main(String[] args)
	{
		// Location params: String name, String desc, Person p, Item a, Item b, Location north, Location south, Location east, Location west
		Location Entrance = new Location("The Entrance", "You arrive at the doors of Hogwarts. The door on the north wall leads to\r\nthe dining hall, the door to the east leads to the Potions class, and\r\nthe door to the west leads to the Library.",
							null, null, null, null, null, null, null);
		
		Person Dumbledore = new Person("Dumbledore",
				"In front of you, you see Professor Dumbledore, the headmaster of the Hogwarts School\r\nof Witchcraft and Wizardry. He is dressed in some fine blue robes\r\nand seems to be preparing a speech for tonight.",
				new String[]{"Hello there, young student!","Would you care for some sherbet lemons?","It does not do to dwell on dreams and forget to live!","Are you still here? Quit bothering me!","Can't you see I'm busy? Please don't disturb me!","The truth. It is a beautiful and terrible thing, and should therefore be treated with great caution.","Have you seen my hat? I could swear I left it here!","You can come to my office any time. My DumbleDoor is always open!"});
		
		Item food = new Item("Food","On the tables, you see all sorts of delicious food, from roast chicken to treacle tarts!",new String[] {"eat","consume"});
		Item hat = new Item("Sorting hat","At the end of the hall, on a small wooden stool, sits the legendary Sorting Hat,\r\nstill wrinkled, dirty and frayed.",new String[] {"wear","use"});
		Location greatHall = new Location("The Great Hall", "You are walking up a huge hall with a towering ceiling, lit by thousands of floating\r\ncandles. You see four long tables, one for each house, being set\r\nfor the feast.",
							 				Dumbledore, food, hat, null, Entrance, null, null);
		
		Entrance.north = greatHall;
		
		Person Hermoine = new Person("Hermoine",
				"desc",
				new String[]{"dialog1","dialog2"});
		
		Item book = new Item("Book","desc",new String[] {"read"});
		Item quill = new Item("Quill","desc",new String[] {"write","use"});
		Location Library = new Location("The Library", "desc",
							 				Hermoine, book, quill, null, null, null, Entrance);
		
		Entrance.east = Library;
		
		Person Snape = new Person("Snape",
				"desc",
				new String[]{"dialog1","dialog2"});
		
		Item cauldron = new Item("Cauldron","desc",new String[] {"craft","make","use"});
		Item potion = new Item("Potion","desc",new String[] {"drink","use"});
		Location Potions = new Location("The Potions Classroom", "desc",
							 				Snape, cauldron, potion, null, null, Entrance, null);
		
		Entrance.west = Potions;
		
		System.out.println("\"Messrs Moony, Wormtail, Padfoot and Prongs Purveyors of Aids to\r\nmagical Mischief-Makers are proud to present THE MARAUDER'S MAP\"\r\nSay the magic phrase to reveal the map.");
		
		Scanner jin = new Scanner(System.in);
		
//		Commented for time being to ease debugging
//		for (int i = 1; !jin.nextLine().equalsIgnoreCase("I solemnly swear that I am up to no good"); i++)
//		{
//			if(i<3) { System.out.println("That's not the right magic phrase! Try again."); }
//			else if(i == 3) { System.out.println("That's not the right magic phrase!\nThis is your last chance!"); }
//			else{ System.out.println("YOU DO NOT KNOW THE PHRASE!\nYou cannot be allowed to see the map... Bye!"); }
//		}
		
		curr = Entrance;
		System.out.println("\t\t"+curr.name);
		curr.look();
		
		System.out.print("> ");
		String input = jin.nextLine();
		
		while(!input.equalsIgnoreCase("mischief managed"))
		{
			process(input);
			System.out.print("> ");
			input = jin.nextLine();
		}
		
		System.out.println("Hiding map contents...end.");
		jin.close();
	}
}

