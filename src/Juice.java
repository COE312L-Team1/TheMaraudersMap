
public abstract class Juice extends Item {
	
	final void prepareRecipe() {
		additems();
		Stir();
		Heat();
		Wave();
		
	}
	
	abstract void Stir();

	abstract void Wave();

	abstract void additems();

	protected void Heat() {
		System.out.println("Heating at high temperature\n");
	}
	
}
