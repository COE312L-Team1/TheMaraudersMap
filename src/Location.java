
public class Location
{
	String name;
	Person p;
	Item a, b;
	Location north, south, east, west;
	String desc;
	
	void look()
	{
		System.out.println(this.desc);
		//if the location has a person and/or object(s), their descriptions get printed too
		if(this.p != null) {
			System.out.println(this.p.desc);
		}
		if(this.a != null) {
			System.out.println(this.a.desc);
		}
		if(this.b != null) {
			System.out.println(this.b.desc);
		}
				
	}

	public Location(String name, String desc, Person p, Item a, Item b, Location north, Location south, Location east, Location west)
	{
		this.name = name;
		this.p = p;
		this.a = a;
		this.b = b;
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		this.desc = desc;
	}

	public Location() {};
	
}
