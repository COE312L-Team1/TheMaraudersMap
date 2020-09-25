import java.util.Random;

public class Potion extends Item{

	public Potion(String name, String desc, String[] verbs) {
		super(name, desc, verbs);
	}

	public void randomEffect() {
		String[] effects = {"You turned into a giant toad!","Your hair became bright orange!","Your thumbs begin to shrink!","You start vomiting uncontrollably!","Your nose triples in size!","You statr havn astrok"};

		Random r = new Random();
		System.out.println(effects[r.nextInt(effects.length)]);
	}

	public Boolean use(String v) {
		Boolean ret =super.use(v);
		if(ret) {
			this.randomEffect();
		}
		return ret;
	}
}
