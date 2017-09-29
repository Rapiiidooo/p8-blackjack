import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import java.lang.*;
import java.util.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.util.Duration;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Toggle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

//LIGNE 419 CHEMIN D'ACCES A MODIFIER


public class LoadImage extends Application 
{
	int intNbJoueurs = 1;
	int intNumJoueurs = 1;
	int scorejoueurs = 1000;
	int scoreDecre = 10;

    public void afficherTas (TasCartes jeuJoueur, Pane pane, int count, int index)
    {
    	int x = 0;
    	int y = 0;
    	if (index == 0){x = 550;y = 650;}
    	if (index == 1){x = 310;y = 550;}
    	if (index == 2){x = 810;y = 550;} 
    	if (index == 3){x = 60;y = 450;} 
    	if (index == 4){x = 1050;y = 450;}
    	int inttmp = count;
    	while(count > 0)
    	{
    		count--;
    		y+=30;
    		x+=40;
    	}
    	if(index == 0)
    	{
        	for (int i = inttmp; i < jeuJoueur.getsize(); i++, y +=30, x+=40) 
        	{
        	    Carte tmp = jeuJoueur.jeu.get(i);
        	    tmp.getImgView().setX(x);
        	    tmp.getImgView().setY(y);
        	    pane.getChildren().add(tmp.getImgView());
        	}
        }
        if(index == 1)
    	{
        	for (int i = inttmp; i < jeuJoueur.getsize(); i++, y +=30, x+=40) 
        	{
        	    Carte tmp = jeuJoueur.jeu.get(i);
        	    tmp.getImgView().setX(x);
        	    tmp.getImgView().setY(y);
        	    pane.getChildren().add(tmp.getImgView());
        	}
        }
        if(index == 2)
    	{
        	for (int i = inttmp; i < jeuJoueur.getsize(); i++, y +=30, x+=40) 
        	{
        	    Carte tmp = jeuJoueur.jeu.get(i);
        	    tmp.getImgView().setX(x);
        	    tmp.getImgView().setY(y);
        	    pane.getChildren().add(tmp.getImgView());
        	}
        }
        if(index == 3)
    	{
        	for (int i = inttmp; i < jeuJoueur.getsize(); i++, y +=30, x+=40) 
        	{
        	    Carte tmp = jeuJoueur.jeu.get(i);
        	    tmp.getImgView().setX(x);
        	    tmp.getImgView().setY(y);
        	    pane.getChildren().add(tmp.getImgView());
        	}
        }
        if(index == 4)
    	{
        	for (int i = inttmp; i < jeuJoueur.getsize(); i++, y +=30, x+=40) 
        	{
        	    Carte tmp = jeuJoueur.jeu.get(i);
        	    tmp.getImgView().setX(x);
        	    tmp.getImgView().setY(y);
        	    pane.getChildren().add(tmp.getImgView());
        	}
        }
    }
    public void resetafficherTas (TasCartes jeuJoueur, Pane pane)
    {
    	for (int i = 0; i < jeuJoueur.getsize(); i++) 
        {
        	Carte tmp = jeuJoueur.jeu.get(i);
            pane.getChildren().remove(tmp.getImgView());
        }
    }
    public void afficherTasBanque (TasCartes jeuJoueur, Pane pane)
    {
            Carte tmp = jeuJoueur.jeu.get(0);
            tmp.getImgView().setX(550);
            tmp.getImgView().setY(160);

            Image imgDosCarte = new Image("/img/doscarte.png");
            ImageView imgViewDosCarte = new ImageView(imgDosCarte);
            imgViewDosCarte.setX(590);
            imgViewDosCarte.setY(190);

            pane.getChildren().addAll(tmp.getImgView(), imgViewDosCarte);
    }

    public void afficherTasBanqueFini (TasCartes jeuJoueur, Pane pane)
    {
    	int x = 550;
    	int y = 160;

    	for (int i = 0; i < jeuJoueur.getsize(); i++) 
        {
        	Carte tmp = jeuJoueur.jeu.get(i);
            pane.getChildren().remove(tmp.getImgView());
        }
        for (int i = 0; i < jeuJoueur.getsize(); i++, y +=30, x+=40) 
        {
                Carte tmp2 = jeuJoueur.jeu.get(i);
                tmp2.getImgView().setX(x);
                tmp2.getImgView().setY(y);
                pane.getChildren().add(tmp2.getImgView());
        }
    }

	public static void main(String[] args)
	{
		Application.launch(args);
	}
	@Override
	public void start (Stage stage) 
	{
        // Mise en place du jeu :

        TasCartes jeu = new TasCartes();
        jeu = TasCartes.creerJeu52CartesImg();
        final TasCartes jeufinal = jeu;
        jeu.battreLesCartes();
        
        ArrayList<TasCartes> jeuBanquePrincipal = new ArrayList<TasCartes>(1);
        ArrayList<TasCartes> jeuJoueurs = new ArrayList<TasCartes>(1);
        TasCartes jeuBanque = new TasCartes();
        TasCartes jeuJ1 = new TasCartes();
        TasCartes jeuJ2 = new TasCartes();
        TasCartes jeuJ3 = new TasCartes();
        TasCartes jeuJ4 = new TasCartes();
        TasCartes jeuJ5 = new TasCartes();

        jeuBanquePrincipal.add(jeuBanque);
        /*jeuJoueurs.add(jeuJ1);
        jeuJoueurs.add(jeuJ2);
        jeuJoueurs.add(jeuJ3);
        jeuJoueurs.add(jeuJ4);
        jeuJoueurs.add(jeuJ5);*/

        // Déclaration des objets graphique :
        int witdh = 1200;
        int height = 1000;
        Group root = new Group();
        Pane pane = new Pane();
        Pane paneCarteBanque = new Pane();
        Pane paneCarteJoueur = new Pane();
        paneCarteBanque.setVisible(false);
        paneCarteJoueur.setVisible(false);


        // Pane Banque :
        pane.setPrefSize(300,300);
        Circle circle = new Circle(100,Color.BLUE);
        pane.getChildren().addAll(circle);
        pane.setVisible(false);
        pane.setLayoutX(witdh/2);
        pane.setLayoutY(200);


		// RadioBouton :

		// Pane :

		Pane panerb1 = new Pane();
		Pane panerb2 = new Pane();
		Pane panerb3 = new Pane();
		Pane panerb4 = new Pane();
		Pane panerb5 = new Pane();

		Pane panerb6 = new Pane();
		Pane panerb7 = new Pane();
		Pane panerb8 = new Pane();
		Pane panerb9 = new Pane();
        
        panerb1.setPrefSize(50,50);
        panerb1.setVisible(true);
        panerb1.setLayoutX(500);
        panerb1.setLayoutY(450);

        panerb2.setPrefSize(50,50);
        panerb2.setVisible(true);
        panerb2.setLayoutX(550);
        panerb2.setLayoutY(450);

        panerb3.setPrefSize(50,50);
        panerb3.setVisible(true);
        panerb3.setLayoutX(600);
        panerb3.setLayoutY(450);

        panerb4.setPrefSize(50,50);
        panerb4.setVisible(true);
        panerb4.setLayoutX(650);
        panerb4.setLayoutY(450);

        panerb5.setPrefSize(50,50);
        panerb5.setVisible(true);
        panerb5.setLayoutX(700);
        panerb5.setLayoutY(450);

        panerb6.setPrefSize(50,50);
        panerb6.setVisible(true);
        panerb6.setLayoutX(1000);
        panerb6.setLayoutY(300);

        panerb7.setPrefSize(50,50);
        panerb7.setVisible(true);
        panerb7.setLayoutX(1050);
        panerb7.setLayoutY(300);

        panerb8.setPrefSize(50,50);
        panerb8.setVisible(true);
        panerb8.setLayoutX(1100);
        panerb8.setLayoutY(300);

        panerb9.setPrefSize(50,50);
        panerb9.setVisible(true);
        panerb9.setLayoutX(1150);
        panerb9.setLayoutY(300);


		ToggleGroup groupb = new ToggleGroup();
		ToggleGroup groupb2 = new ToggleGroup();

		RadioButton rb1 = new RadioButton("1");
		RadioButton rb2 = new RadioButton("2");
		RadioButton rb3 = new RadioButton("3");
		RadioButton rb4 = new RadioButton("4");
		RadioButton rb5 = new RadioButton("5");

		RadioButton rb6 = new RadioButton("10");
		RadioButton rb7 = new RadioButton("20");
		RadioButton rb8 = new RadioButton("50");
		RadioButton rb9 = new RadioButton("100");

		rb1.setToggleGroup(groupb);
    	rb1.setSelected(true);
    	rb2.setToggleGroup(groupb);
    	rb3.setToggleGroup(groupb);
    	rb4.setToggleGroup(groupb);
    	rb5.setToggleGroup(groupb);

    	rb6.setToggleGroup(groupb2);
    	rb6.setSelected(true);
    	rb7.setToggleGroup(groupb2);
    	rb8.setToggleGroup(groupb2);
    	rb9.setToggleGroup(groupb2);

    	panerb1.getChildren().add(rb1);
    	panerb2.getChildren().add(rb2);
    	panerb3.getChildren().add(rb3);
    	panerb4.getChildren().add(rb4);
    	panerb5.getChildren().add(rb5);

    	panerb6.getChildren().add(rb6);
    	panerb7.getChildren().add(rb7);
    	panerb8.getChildren().add(rb8);
    	panerb9.getChildren().add(rb9);

    	groupb.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle,Toggle new_toggle)
            {
                if (new_toggle.equals(rb1))
                    intNbJoueurs = 1;
                else if (new_toggle.equals(rb2))
                	intNbJoueurs = 2;
                else if (new_toggle.equals(rb3))
                	intNbJoueurs = 3;
                else if (new_toggle.equals(rb4))
                	intNbJoueurs = 4;
                else
                	intNbJoueurs = 5;
            }
        });

        groupb2.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle,Toggle new_toggle)
            {
                if (new_toggle.equals(rb6))
                    scoreDecre = 10;
                else if (new_toggle.equals(rb7))
                	scoreDecre = 20;
                else if (new_toggle.equals(rb8))
                	scoreDecre = 50;
                else
                	scoreDecre = 100;
            }
        });

        //LABEL :

        // Label Titre :
        Label lblTitle = new Label("Black Jack");
        lblTitle.setTextFill(Color.BLUE);
        lblTitle.setStyle("-fx-font: 150 ComicSansMS;");
        lblTitle.setLayoutX(300);
        lblTitle.setLayoutY(50);

        // Label Loose :
        Label lblLoose = new Label(" Vous avez perdu...\n21 points dépassés");
        lblLoose.setTextFill(Color.RED);
        lblLoose.setStyle("-fx-font: 50 ComicSansMS;");
        lblLoose.setLayoutX(410);
        lblLoose.setLayoutY(360);
        lblLoose.setVisible(false);

        // Label LooseByBanque :
        Label lblLooseByBanque = new Label("Perdu...\nLa banque a été plus forte !");
        lblLooseByBanque.setTextFill(Color.RED);
        lblLooseByBanque.setStyle("-fx-font: 50 ComicSansMS;");
        lblLooseByBanque.setLayoutX(410);
        lblLooseByBanque.setLayoutY(360);
        lblLooseByBanque.setVisible(false);

        // Label win :
        Label lblWin = new Label(" Vous avez gagnez !! :)\n");
        lblWin.setTextFill(Color.BLUE);
        lblWin.setStyle("-fx-font: 50 ComicSansMS;");
        lblWin.setLayoutX(410);
        lblWin.setLayoutY(400);
        lblWin.setVisible(false);

        // Label Score :
        Label lblScore = new Label();
        lblScore.setTextFill(Color.BLUE);
        lblScore.setStyle("-fx-font: 34 ComicSansMS;");
        lblScore.setLayoutX(540);
        lblScore.setLayoutY(500);
        lblScore.setVisible(false);

        // Label NbJoueurs :
        Label lblNbJoueurs = new Label("Nombre de Joueurs :");
        lblNbJoueurs.setTextFill(Color.ORANGE);
        lblNbJoueurs.setStyle("-fx-font: 34 ComicSansMS;");
        lblNbJoueurs.setLayoutX(450);
        lblNbJoueurs.setLayoutY(400);
        lblNbJoueurs.setVisible(true);

        // Label NumJoueurs :
        Label lblNumJoueurs = new Label();
        lblNumJoueurs.setTextFill(Color.PURPLE);
        lblNumJoueurs.setStyle("-fx-font: 40 ComicSansMS;");
        lblNumJoueurs.setLayoutX(1020);
        lblNumJoueurs.setLayoutY(200);
        lblNumJoueurs.setVisible(false);

        // Label ScoreJoueurs :
        Label lblScoreJoueurs = new Label();
        lblScoreJoueurs.setText("" + scorejoueurs);
        lblScoreJoueurs.setTextFill(Color.BLACK);
        lblScoreJoueurs.setStyle("-fx-font: 34 ComicSansMS;");
        lblScoreJoueurs.setLayoutX(560);
        lblScoreJoueurs.setLayoutY(600);
        lblScoreJoueurs.setVisible(true);

        // Label Mise :
        Label lblMise = new Label("Mise :");
        lblMise.setTextFill(Color.PINK);
        lblMise.setStyle("-fx-font: 34 ComicSansMS;");
        lblMise.setLayoutX(900);
        lblMise.setLayoutY(280);
        lblMise.setVisible(true);

        // Label Perdu :
        Label lblPerdu = new Label("VOUS AVEZ PERDU");
        lblPerdu.setTextFill(Color.LIGHTBLUE);
        lblPerdu.setStyle("-fx-font: 50 ComicSansMS;");
        lblPerdu.setLayoutX(400);
        lblPerdu.setLayoutY(400);
        lblPerdu.setVisible(false);


        Scene scene = new Scene(root, witdh, height, Color.GREEN);
        // Centre la scene au milieu de l'ecran suivant la taille de l'écran. >> //Scene scene = new Scene(StackPaneBuilder.create().children(root).build(), Color.GREEN);

        // Instaciation des sons :

        final File file = new File("sons/carte.mp3");  
		final Media media = new Media(file.toURI().toString());
		final MediaPlayer mediaPlayer = new MediaPlayer(media); 

		final File file2 = new File("sons/applau.mp3");  
		final Media media2 = new Media(file2.toURI().toString());
		final MediaPlayer mediaPlayer2 = new MediaPlayer(media2); 


        // Decors graphique :

        Circle cercle = new Circle();
        cercle.setCenterX(110);
        cercle.setCenterY(height/2);
        cercle.setRadius(100);
        cercle.setFill(Color.LIGHTGREEN);
        cercle.setStroke(Color.GREEN);
        cercle.setStrokeWidth(5);
        Circle cercle2 = new Circle();
        cercle2.setCenterX(350);
        cercle2.setCenterY(height/2+100);
        cercle2.setRadius(100);
        cercle2.setFill(Color.LIGHTGREEN);
        cercle2.setStroke(Color.GREEN);
        cercle2.setStrokeWidth(5);
        Circle cercle3 = new Circle();
        cercle3.setCenterX(witdh/2);
        cercle3.setCenterY(height/2+200);
        cercle3.setRadius(100);
        cercle3.setFill(Color.LIGHTGREEN);
        cercle3.setStroke(Color.GREEN);
        cercle3.setStrokeWidth(5);
        Circle cercle4 = new Circle();
        cercle4.setCenterX(witdh-350);
        cercle4.setCenterY(height/2+100);
        cercle4.setRadius(100);
        cercle4.setFill(Color.LIGHTGREEN);
        cercle4.setStroke(Color.GREEN);
        cercle4.setStrokeWidth(5);
        Circle cercle5 = new Circle();
        cercle5.setCenterX(witdh-110);
        cercle5.setCenterY(height/2);
        cercle5.setRadius(100);
        cercle5.setFill(Color.LIGHTGREEN);
        cercle5.setStroke(Color.GREEN);
        cercle5.setStrokeWidth(5);

        Image imgTasCartes = new Image("/img/tascartes.png");
        ImageView imgViewTasCartes = new ImageView(imgTasCartes);
        imgViewTasCartes.setX(100);
        imgViewTasCartes.setY(100);

    	CarteQuiBouge dosCarteMv = new CarteQuiBouge(150, 150, 600, 700);
    	dosCarteMv.getImageView().setX(100);
    	dosCarteMv.getImageView().setY(100);

    	CarteQuiBouge dosCarteMv2 = new CarteQuiBouge(150, 150, 580, 200);
    	dosCarteMv2.getImageView().setX(100);
    	dosCarteMv2.getImageView().setY(100);

    	CarteQuiBouge dosCarteMv3 = new CarteQuiBouge(15, 150, 310, 550);
    	dosCarteMv3.getImageView().setX(100);
    	dosCarteMv3.getImageView().setY(100);

    	CarteQuiBouge dosCarteMv4 = new CarteQuiBouge(150, 150, 810, 550);
    	dosCarteMv4.getImageView().setX(100);
    	dosCarteMv4.getImageView().setY(100);

    	CarteQuiBouge dosCarteMv5 = new CarteQuiBouge(150, 150, 60, 450);
    	dosCarteMv5.getImageView().setX(100);
    	dosCarteMv5.getImageView().setY(100);

    	CarteQuiBouge dosCarteMv6 = new CarteQuiBouge(150, 150, 1050, 450);
    	dosCarteMv6.getImageView().setX(100);
    	dosCarteMv6.getImageView().setY(100);


        // Differents bouton :

        Button btnNewCard = new Button();
        Button btnDone = new Button();
        Button btnJouer = new Button();
        Button btnNewGame = new Button();

        btnJouer.setLayoutX(witdh/2-95);
        btnJouer.setLayoutY(height/2-200);
        btnJouer.setText("Jouer");
        btnJouer.setStyle("-fx-font: 50 arial;");
        btnJouer.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent event) 
            {
            	if(scorejoueurs < scoreDecre)
            	{
            		lblPerdu.setVisible(true);
            		lblTitle.setVisible(true);
                	lblNbJoueurs.setVisible(false);
                	lblScoreJoueurs.setVisible(false);
                	lblMise.setVisible(false);
                	btnJouer.setVisible(false);
                	pane.setVisible(false);
                	btnNewCard.setVisible(false);
                	btnDone.setVisible(false);
                	lblLoose.setVisible(false);
                	lblLooseByBanque.setVisible(false);
                	lblWin.setVisible(false);
                	lblScore.setVisible(false);
                	lblNumJoueurs.setVisible(false);
                	btnNewGame.setVisible(false);
                	paneCarteBanque.setVisible(false);
                	paneCarteJoueur.setVisible(false);
                	panerb1.setVisible(false);
                	panerb2.setVisible(false);
                	panerb3.setVisible(false);
                	panerb4.setVisible(false);
                	panerb5.setVisible(false);
                	panerb6.setVisible(false);
                	panerb7.setVisible(false);
                	panerb8.setVisible(false);
                	panerb9.setVisible(false);
            	}
            	else
            	{
	
            		jeuJoueurs.clear();
            		for(int i = 1; i <= intNbJoueurs; i++)
            		{
            			if(i == 5)
            				jeuJoueurs.add(jeuJ5);
            			if(i == 4)
            				jeuJoueurs.add(jeuJ4);
						if(i == 3)
							jeuJoueurs.add(jeuJ3);
						if(i == 2)
							jeuJoueurs.add(jeuJ2);
						if(i == 1)
							jeuJoueurs.add(jeuJ1);
        			}
	
        			jeufinal.distribuerLesCartes(jeuBanquePrincipal, 2);
        			jeufinal.distribuerLesCartes(jeuJoueurs, 2);
	
            		//Set des cartes à jouer.
        			afficherTasBanque(jeuBanquePrincipal.get(0), paneCarteBanque);
        			for(int i = 0; i < intNbJoueurs; i++)
        			{
        				mediaPlayer.play();
        				afficherTas(jeuJoueurs.get(i), paneCarteJoueur, 0, i);
        			}
	
        			scorejoueurs -= scoreDecre;
	
        			lblNumJoueurs.setText("Joueur : " + intNumJoueurs);
        			lblScoreJoueurs.setText("" + scorejoueurs);
	
                	lblTitle.setVisible(false);
                	lblNbJoueurs.setVisible(false);
                	lblNumJoueurs.setVisible(true);
                	lblScoreJoueurs.setVisible(true);
                	lblMise.setVisible(false);
                	btnJouer.setVisible(false);
                	pane.setVisible(true);
                	btnNewCard.setVisible(true);
                	btnDone.setVisible(true);
                	panerb1.setVisible(false);
                	panerb2.setVisible(false);
                	panerb3.setVisible(false);
                	panerb4.setVisible(false);
                	panerb5.setVisible(false);
                	panerb6.setVisible(false);
                	panerb7.setVisible(false);
                	panerb8.setVisible(false);
                	panerb9.setVisible(false);
	
	
                	runLater(new Duration(400.0), () -> {
                	paneCarteJoueur.setVisible(true);
                	dosCarteMv.getImageView().setVisible(false);
            		dosCarteMv2.getImageView().setVisible(true);
            		dosCarteMv2.go();
            		});
            		runLater(new Duration(800.0), () -> {
            		paneCarteBanque.setVisible(true);
            		dosCarteMv2.getImageView().setVisible(false);
            		});
	
	
                	dosCarteMv.getImageView().setVisible(true);
                	dosCarteMv.go();
            	}
            }
        });


        btnDone.setLayoutX(witdh-300);
        btnDone.setLayoutY(200);
        btnDone.setText("Servi");
        btnDone.setStyle("-fx-font: 30 arial;");
        btnDone.setVisible(false);
        btnDone.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent event) 
            {
				resetafficherTas(jeufinal, paneCarteBanque);

                int valTasJ = jeuJoueurs.get(0).getValeurTas();
            	int valTasB = jeuBanquePrincipal.get(0).getValeurTas();
            	
            	for(; valTasB < valTasJ;)
            	{
            		afficherTasBanqueFini(jeuBanquePrincipal.get(0), paneCarteBanque);
            		jeufinal.distribuerLesCartes(jeuBanquePrincipal, 1);

            		valTasB = jeuBanquePrincipal.get(0).getValeurTas();
            	}

            	afficherTasBanqueFini(jeuBanquePrincipal.get(0), paneCarteBanque);

            	lblNumJoueurs.setVisible(false);
            	btnDone.setVisible(false);
            	btnNewCard.setVisible(false);
            	btnNewGame.setVisible(true);

            	if(valTasB >= valTasJ && valTasB < 22)
            	{
            		lblLooseByBanque.setVisible(true);
                    lblScore.setText("Banque : " + jeuBanquePrincipal.get(0).getValeurTas() + "\n  Vous : " + jeuJoueurs.get(0).getValeurTas());
                    lblScore.setVisible(true);
            	}
            	else
            	{
            		scorejoueurs += 2 * scoreDecre;
            		lblWin.setVisible(true);
                    lblScore.setText("Banque : " + jeuBanquePrincipal.get(0).getValeurTas() + "\n  Vous : " + jeuJoueurs.get(0).getValeurTas());
                    lblScore.setVisible(true);
                    mediaPlayer2.play();
            	}
            }
        });

        btnNewGame.setLayoutX(witdh-350);
        btnNewGame.setLayoutY(300);
        btnNewGame.setText("Nouvelle Partie");
        btnNewGame.setStyle("-fx-font: 30 arial;");
        btnNewGame.setVisible(false);
        btnNewGame.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent event) 
            {
				resetafficherTas(jeufinal, paneCarteJoueur);
				resetafficherTas(jeufinal, paneCarteBanque);

				for(int i = 0; i < intNbJoueurs; i++)
        		{
					jeuJoueurs.get(i).redistribTas(jeufinal);
				}
                jeuBanquePrincipal.get(0).redistribTas(jeufinal);

                paneCarteBanque.getChildren().clear();
                paneCarteJoueur.getChildren().clear();

                lblTitle.setVisible(true);
                lblNbJoueurs.setVisible(true);
                lblScoreJoueurs.setVisible(false);
                lblMise.setVisible(true);
                btnJouer.setVisible(true);
                pane.setVisible(false);
                btnNewCard.setVisible(false);
                btnDone.setVisible(false);
                lblLoose.setVisible(false);
                lblLooseByBanque.setVisible(false);
                lblWin.setVisible(false);
                lblScore.setVisible(false);
                lblNumJoueurs.setVisible(false);
                btnNewGame.setVisible(false);
                paneCarteBanque.setVisible(false);
                paneCarteJoueur.setVisible(false);
                panerb1.setVisible(true);
                panerb2.setVisible(true);
                panerb3.setVisible(true);
                panerb4.setVisible(true);
                panerb5.setVisible(true);
                panerb6.setVisible(true);
                panerb7.setVisible(true);
                panerb8.setVisible(true);
                panerb9.setVisible(true);
            }
        });

        btnNewCard.setLayoutX(witdh-300);
        btnNewCard.setLayoutY(100);
        btnNewCard.setText("Nouvelle carte");
        btnNewCard.setStyle("-fx-font: 30 arial;");
        btnNewCard.setVisible(false);
        btnNewCard.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent event) 
            {
                jeufinal.distribuerLesCartes(jeuJoueurs, 1);
                System.out.println(jeuJoueurs);
                System.out.println(jeuJoueurs.get(0).getValeurTas());
                int valTas = jeuJoueurs.get(0).getValeurTas();
                if(valTas > 21)
                {
                        btnNewCard.setVisible(false);
                        btnDone.setVisible(false);
                        lblLoose.setVisible(true);
                        btnNewGame.setVisible(true);
                        lblScore.setText("Banque : " + jeuBanquePrincipal.get(0).getValeurTas() + "\n  Vous : " + jeuJoueurs.get(0).getValeurTas());
                    	lblScore.setVisible(true);
                    	afficherTasBanqueFini(jeuBanquePrincipal.get(0), paneCarteBanque);
                }
                for(int i = 0; i < intNbJoueurs; i++)
        		{
                	afficherTas(jeuJoueurs.get(0), paneCarteJoueur, jeuJoueurs.get(0).getsize() - 1, i);
                }

            }
        });


        // Configuration de la scene :

        root.getChildren().addAll(cercle, cercle2, cercle3, cercle4, cercle5);
        root.getChildren().addAll(imgViewTasCartes, dosCarteMv.getImageView(), dosCarteMv2.getImageView());
        root.getChildren().addAll(dosCarteMv3.getImageView(), dosCarteMv4.getImageView(), dosCarteMv5.getImageView(), dosCarteMv6.getImageView());
        root.getChildren().addAll(lblTitle, lblLoose, lblWin, lblLooseByBanque, lblScore, lblNbJoueurs, lblNumJoueurs, lblScoreJoueurs, lblMise, lblPerdu);
        root.getChildren().addAll(pane, paneCarteBanque, paneCarteJoueur, panerb1, panerb2, panerb3, panerb4, panerb5);
        root.getChildren().addAll(panerb6, panerb7, panerb8, panerb9);
        root.getChildren().addAll(btnJouer, btnNewCard, btnDone, btnNewGame);

        stage.setTitle("Black Jack Fx");
        stage.setScene(scene);
        stage.show();
	}


	//************************************************************************************************************
	//Fonction provenant du site : http://tomasmikula.github.io/blog/2014/06/04/timers-in-javafx-and-reactfx.html
	private Timeline runLater(Duration delay, Runnable action) 
	{
        Timeline timeline = new Timeline(new KeyFrame(delay, ae -> action.run()));
        timeline.play();
        return timeline;
    }
    //************************************************************************************************************
}