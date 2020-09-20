
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
		
		Entrance.look();
		System.out.println();
		greatHall.look();
		

	}

}
