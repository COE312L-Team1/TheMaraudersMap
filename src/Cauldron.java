import java.util.Random;

public class Cauldron extends Item implements randomizer {

	public Cauldron(String name, String desc, String[] verbs) {
		super(name, desc, verbs);
	}
	
	public void randomDiag() {
		String[] potions = {"Felix Felicis","Polyjuice Potion","Draught of Peace","Veritaserum","Love Potion"};
		Random r = new Random();
		System.out.println("You made " + potions[r.nextInt(potions.length)] + "!");
	}
	
	public Boolean use(String v) {
		Boolean ret =super.use(v);
		if(ret) {
			this.randomDiag();
		}
		return ret;
	}
}
