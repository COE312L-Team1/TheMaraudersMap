import java.util.Random;

public class SortingHat extends Item {

	public SortingHat(String name, String desc, String[] verbs) {
		super(name, desc, verbs);
	}

	public void randomHouse() {
		Random r = new Random();
		String[] houses = {"GRYFFINDOR!", "HUFFLEPUFF!", "RAVENCLAW!", "SLYTHERIN!"};
		System.out.println("\t" + houses[r.nextInt(houses.length)]);
	}

	public Boolean use(String v) {
		
		Boolean ret =super.use(v);
		if(ret) {
			this.randomHouse();
		}
		return ret;
	}

}
