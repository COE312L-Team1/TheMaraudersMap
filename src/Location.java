
public class Location
{
	Person p;
	Item a, b;
	Location north, south, east, west;
	String desc;
	
	void look()
	{
		System.out.println(desc);
	}

	public Location(Person p, Item a, Item b, Location north, Location south, Location east, Location west, String desc)
	{
		this.p = p;
		this.a = a;
		this.b = b;
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		this.desc = desc;
	}

}
