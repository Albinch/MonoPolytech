package configuration.configs;

import acteurs.Joueur;
import acteurs.JoueurAgressif;
import acteurs.JoueurPrudent;
import configuration.Configuration;

import java.util.Random;
import java.util.Scanner;

import static main.Main.PLATEAU;
import static main.Main.players;

public class NeoLiberal extends Configuration {

    public NeoLiberal(boolean foncier){
        setPourcentageTaxes(10);
        setLimiteAntiTrust(10);
        setSubventions(1200);
        setFoncier(foncier);
    }

    @Override
    public void setJoueurs(){
        String name = "";
        int style = -1;

        System.out.println("Définissez le pseudo du nouveau joueur.");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();

        while(!name.equalsIgnoreCase("Fin")){
            int startCapital = new Random().nextInt(5000, 50000);
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

    @Override
    public String toString() {
        return "La configuration actuelle est 'Néo Libérale'";
    }

}
