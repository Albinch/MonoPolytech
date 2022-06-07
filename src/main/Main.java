package main;

import acteurs.Acteur;
import acteurs.Joueur;
import acteurs.JoueurAgressif;
import acteurs.JoueurPrudent;
import configuration.ConfigurationManager;
import investissement.InvestissementsManager;
import plateau.Plateau;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static InvestissementsManager IM;
    public static Plateau PLATEAU;
    public static ConfigurationManager CONFIG;

    public static boolean running = true;
    public static int round = 1;
    public static ArrayList<Joueur> players = new ArrayList<Joueur>();

    public static void main(String[] args){

        createInstances();
        CONFIG.defineConfiguration();
        IM.createInvestissements();
        PLATEAU.generatePlateau();
        definePlayers();

        gameLoop();
    }

    public static void createInstances(){
        IM = new InvestissementsManager();
        PLATEAU = new Plateau(40, IM);
        CONFIG = new ConfigurationManager();
    }

    public static void definePlayers(){

        int startCapital = 5000;
        String name = "";
        int style = -1;

        System.out.println("Définissez le pseudo du nouveau joueur.");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();

        while(!name.equalsIgnoreCase("Fin")){
            System.out.println("Ensuite, définissez le style de joueur de " + name + ".");
            System.out.println("- Agressif (1)");
            System.out.println("- Prudent (2)");
            style = Integer.parseInt(sc.nextLine());

            Joueur j;
            if(style == 1){
                j = new JoueurAgressif(startCapital, name, PLATEAU.CASES.get(0));
            }else{
                j = new JoueurPrudent(startCapital, name, PLATEAU.CASES.get(0));
            }

            players.add(j);

            System.out.println("Définissez le pseudo du nouveau joueur. \nSi vous avez terminé, entrez 'Fin'.\n");
            name = sc.nextLine();
        }

    }

    public static void gameLoop(){

        while(running && players.size() > 1){
            System.out.println("==============================");
            System.out.println("     Tour n°" + round + "      ");
            System.out.println(" ");

            for(int i = 0; i < players.size(); i++){
                Joueur joueur = players.get(i);
                System.out.println("-> " + joueur.toString());
                int valeurDe = joueur.jouer();
                System.out.println("Valeur du dé : " + valeurDe);
                System.out.println("Nouvelle case : " + joueur.getCurrentCase().toString());
                joueur.getCurrentCase().actionCase(joueur);
                System.out.println("\n");
            }

            round++;
        }

        System.out.println("Le joueur " + players.get(0).getNom() + " a gagné la partie !");

    }

}