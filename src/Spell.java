
public abstract class Spell
{
	SpellEffect se;
	Spell(SpellEffect s)
	{
		this.se = s;
	
	}
	
	public void cast() {
		this.se.cast();
	}
}