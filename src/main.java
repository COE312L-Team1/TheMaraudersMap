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

	public static void main(String[] args)
	{
		// Location params: String desc, Person p, Item a, Item b, Location north, Location south, Location east, Location west
		Location Entrance = new Location("\t\tThe Entrance\n\nYou arrive at the doors of Hogwarts. The door on the north wall leads to\r\nthe dining hall, the door to the east leads to the Potions class, and\r\nthe door to the west leads to the Library.",
							null, null, null, null, null, null, null);
		//^ all null, cuz no person, no items, and neighbor locations havent been declared yet
		
		Location greatHall = new Location("\t\tThe Great Hall\n\nYou are walking up a huge hall with a towering ceiling, lit by thousands of floating\r\ncandles. You see four long tables, one for each house, being set\r\nfor the feast.",
							 new Person("Dumbledore","In front of you, you see Professor Dumbledore, the headmaster of the Hogwarts School\r\nof Witchcraft and Wizardry. He is dressed in some fine blue robes\r\nand seems to be preparing a speech for tonight."),
							 new Item("Food","On the tables, you see all sorts of delicious food, from roast chicken to treacle tarts!"),
							 new Item("Sorting hat","At the end of the hall, on a small wooden stool, sits the legendary Sorting Hat,\r\nstill wrinkled, dirty and frayed."),
							 null, Entrance, null, null);
		//^ only neighboring location is entrance, to the south
		
		Entrance.north = greatHall;
		
		System.out.println("\"Messrs Moony, Wormtail, Padfoot and Prongs Purveyors of Aids to\r\nmagical Mischief-Makers are proud to present THE MARAUDER'S MAP”\r\nSay the magic phrase to reveal the map.");
		
		Scanner jin = new Scanner(System.in);
		
		for (int i = 1; !jin.nextLine().equals("I solemnly swear that I am up for no good"); i++)
		{
			if(i<3) { System.out.println("That's not the right magic phrase! Try again."); }
			else if(i == 3) { System.out.println("That's not the right magic phrase!\nThis is your last chance!"); }
			else{ System.out.println("YOU DO NOT KNOW THE PHRASE!\nYou cannot be allowed to see the map... Bye!"); }
		}
		
		Location curr = Entrance;
		
		curr.look();
		
		String input = jin.nextLine();
		while(!input.equals("mischief managed"))
		{
			if(input.contains("look"))
			{
				curr.look();
			}
			else if(input.contains("walk") || input.contains("go"))
			{
				if (input.contains("north") || input.contains("N"))
				{ curr = curr.north; curr.look(); }//we actually need to say "You have entered the curr.name" but we didnt make curr.name
				else if(input.contains("south") || input.contains("S"))
				{ curr = curr.south; curr.look(); }
				else if(input.contains("east") || input.contains("E"))
				{ curr = curr.east; curr.look(); }
				else if(input.contains("west") || input.contains("W"))
				{ curr = curr.west; curr.look(); }
				else
				{ System.out.println("Location does not exist on the map!"); }
			}
			else if(input.contains("talk"))
			{
				if(input.toLowerCase().contains(curr.p.name.toLowerCase()))
				{ curr.p.talk(); }
				else
				{ System.out.println("This character is not in the room...try again!"); }
			}
			else if(input.contains("use"))
			{
				if(input.toLowerCase().contains(curr.a.name.toLowerCase()))
				{ curr.a.use();; }
				if(input.toLowerCase().contains(curr.b.name.toLowerCase()))
				{ curr.b.use();; }
				else
				{ System.out.println("This item is not in the room...try again!"); }
			}
			input = jin.nextLine();
		}
		
		System.out.println("Hiding map contents...end.");
		jin.close();
	}
}

