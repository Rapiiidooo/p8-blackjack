/* Classe representant une carte a jouer traditionnelle ... */
import java.lang.*;
import java.util.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Carte
{
	static public final String [] COULEURS = {"Pique", "Coeur","Carreau","Trefle"};
	static public final String [] NOMS = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi"};

	private int rang;
	private int force;
	private int couleur;
	private ImageView imgView;

	public Carte (int couleur, int rang)
	{
		this.couleur = couleur;
		this.rang = rang;
		this.force = rang;
	}
	public Carte (int couleur, int rang, int force)
	{
		this.couleur = couleur;
		this.rang = rang;
		this.force = force;
	}
	public Carte (int couleur, int rang, String addImg)
	{
		this.couleur = couleur;
		this.rang = rang;
		this.force = rang;
		Image img = new Image(addImg);
		this.imgView = new ImageView(img);
	}


	public String getNomCouleur () {return COULEURS[couleur];}
	public String getNomCarte () {return NOMS[rang];}

	public int getCouleur () {return this.couleur;}
	public int getForce () 
	{
		int r = 0;
		if(this.force >=  9)
			r = 10;
		if(this.force == 0)
			r = 0;
		if(this.force < 9 && this.force > 0)
			r = this.force + 1;
		return r;
	}
	public int getRang () {return this.rang;}
	public ImageView getImgView () {return this.imgView;}


	@Override
	public String toString ()
	{
		return NOMS[rang] + " de " + COULEURS[couleur] + "";
	}
}