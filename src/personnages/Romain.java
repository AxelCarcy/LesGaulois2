package personnages;

public class Romain
{
	private String nom;
	private int force;
	
	
	public Romain(String nom, int force)
	{
		this.nom = nom;
		this.force = force;
	}

	public String getNom()
	{
		return nom;
	}
	
	public void parler(String texte)
	{
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}
	
	private String prendreParole()
	{
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup)
	{
		// précondition
		assert force > 0;
		int oldForce = force;
		force -= forceCoup;
		if (force > 0)
		{
			parler("Aïe");
		}
		else
		{
			parler("J'abandonne");
		}
		// post condition la force a diminuée
		assert force < oldForce;
	}
	
	public static void main(String[] args)
	{
		Romain mouludus = new Romain("Mouludus", 6);
		
		mouludus.prendreParole();
		mouludus.parler("Bonjour");
		mouludus.recevoirCoup(8);
	}

}
