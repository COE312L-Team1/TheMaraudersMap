import java.util.Random;

public class Book extends Item implements randomizer {

	public Book(String name, String desc, String[] verbs) {
		super(name, desc, verbs);
	}

	public void randomDialog() {
		Random r = new Random();
		String[] books = {"The Life and Lies of Albus Percival Wulfric Brian Dumbledore by Rita Skeeter", "Fantastic Beasts and Where to Find Them by Newton Scamander", "Muggle guide to 18th-century ballet by Myra Curio\nYou can now do ballet!"};
		System.out.println(books[r.nextInt(books.length)]);
	}

	public Boolean use(String v) {
		
		Boolean ret =super.use(v);
		if(ret) {
			this.randomDialog();
		}
		return ret;
	}

}
