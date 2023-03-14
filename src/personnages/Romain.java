package personnages;

public class Romain
{
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	
	
	public Romain(String nom, int force)
	{
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
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
	
	public void sEquiper(Equipement equip)
	{
		switch(nbEquipement)
		{
		case 0:
			if (equip == Equipement.CASQUE)
			{
				equipements[0] = Equipement.CASQUE;
				System.out.println("Le soldat " + nom + " s'équipe avec un casque. ");
			}
			else
			{
				equipements[1] = Equipement.BOUCLIER;
				System.out.println("Le soldat " + nom + " s'équipe avec un bouclier. ");
			}
			nbEquipement += 1;
			break;

		case 1:
			if (equip == Equipement.CASQUE)
			{
				if (equipements[0] == Equipement.CASQUE)
				{
					System.out.println("Le soldat " + nom + " possède déjà un casque !");
				}
				else
				{
					equipements[0] = Equipement.CASQUE;
					System.out.println("Le soldat " + nom + " s'équipe d'un casque. ");
					nbEquipement += 1;
				}
			}
			else if (equip == Equipement.BOUCLIER)
			{
				if (equipements[1] == Equipement.BOUCLIER)
				{
					System.out.println("Le soldat " + nom + " possède déjà un bouclier !");
				}
				else
				{
					equipements[1] = Equipement.BOUCLIER;
					System.out.println("Le soldat " + nom + " s'équipe avec un bouclier. ");
					nbEquipement += 1;
				}
			}
			break;


		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;


		default:
			System.out.println("Erreur nbEquipement");
			break;
		}

	}
	
	public static void main(String[] args)
	{
		Romain mouludus = new Romain("Mouludus", 6);
		
		mouludus.prendreParole();
		mouludus.parler("Bonjour");
		mouludus.recevoirCoup(8);
		
		mouludus.sEquiper(Equipement.CASQUE);
		mouludus.sEquiper(Equipement.CASQUE);
		mouludus.sEquiper(Equipement.BOUCLIER);
		mouludus.sEquiper(Equipement.CASQUE);
	}

}
