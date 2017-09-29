import java.lang.*;
import java.util.*;

public class TasCartes
{
	public ArrayList <Carte> jeu;
	private boolean carteAs = false;

	public TasCartes ()
	{
		this.jeu = new ArrayList <Carte>();
	}

	public void addCarte (Carte c)
	{
		this.jeu.add(c);
	}

	public static TasCartes creerJeu52Cartes (boolean asCarteMax)
	{
		TasCartes jeu52 = new TasCartes();
		for (int c = 0; c < 4; c++) 
		{
			int r = 0;
			if (!asCarteMax)
				jeu52.addCarte (new Carte(c,r));
			else
				jeu52.addCarte (new Carte(c,r,13));
			for (r = 1; r < 13; r++) 
			{
				jeu52.addCarte (new Carte (c, r));	
			}
		}
		return jeu52;
	}

	public static TasCartes creerJeu52CartesImg ()
	{
		TasCartes jeu52 = new TasCartes();
		for (int c = 0; c < 4; c++) 
		{
			for (int r = 0; r < 13; r++) 
			{
				String strImg = "/img/" + c + "_" + r + ".png";
				jeu52.addCarte (new Carte (c, r, strImg));	
			}
		}
		return jeu52;
	}

	public void battreLesCartes ()
	{
		Collections.shuffle(this.jeu);
	}

	public void distribuerLesCartes (ArrayList<TasCartes> jeuJoueurs, int nbCartes)
	{
		int nbJoueurs = jeuJoueurs.size();

		ListIterator <TasCartes> it = jeuJoueurs.listIterator();
		for(int j = 0; j < nbJoueurs; j++)
		{
			for (int i = 0; i < nbCartes; i++)
			{
				Carte c = jeu.get(i);
					if(it.hasNext())
					{
						it.next().jeu.add(c);
					}
					else
					{
						it = jeuJoueurs.listIterator(0);
						it.next().jeu.add(c);
					}
				jeu.remove(i);
			}
		}
	}
	public void resetTasCartes52 ()
	{
		this.jeu.clear();
	}

	public void redistribTas (TasCartes tasCartes)
	{
		for (int i = 0; i < this.jeu.size(); i++)
		{
			Carte tmp = this.jeu.get(i);
			if (tasCartes.getJeu().contains(tmp) == false)
			{
				tasCartes.addCarte(tmp);
			}
		}
		this.jeu.clear();
	}

	public int getsize () {return this.jeu.size();}
	public int getValeurTas ()
	{
		int r = 0;

		for (int i = 0; i < this.jeu.size(); i++)
		{
			r += this.jeu.get(i).getForce();
			if (this.jeu.get(i).getForce() == 0)
			{
				if(r < 11)
					r += 11;
				else if(r >= 11)
					r += 1;
			}	
		}
		return r;
	}
	public boolean getCarteAs () {return this.carteAs;}
	public ArrayList <Carte> getJeu () {return this.jeu;}

	@Override
	public String toString ()
	{
		return jeu.toString();
	}


}