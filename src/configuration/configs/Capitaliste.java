package configuration.configs;

import acteurs.JoueurAgressif;
import configuration.Configuration;

import java.util.Scanner;

import static main.Main.players;
import static main.Main.PLATEAU;

public class Capitaliste extends Configuration {

    public Capitaliste(boolean foncier){
        setPourcentageTaxes(45);
        setLimiteAntiTrust(7);
        setSubventions(2000);
        setFoncier(foncier);
    }

    @Override
    public void setJoueurs(){
        int startCapital = this.getStartCapital();
        String name = "";

        System.out.println("Définissez le pseudo du nouveau joueur.");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();

        while(!name.equalsIgnoreCase("Fin")){
            players.add(new JoueurAgressif(startCapital, name, PLATEAU.CASES.get(0)));

            System.out.println("Définissez le pseudo du nouveau joueur. \nSi vous avez terminé, entrez 'Fin'.\n");
            name = sc.nextLine();
        }
    }

    public void setProfitPercentage(){
        super.setProfitPercentage(1.7F);
    }

    @Override
    public String toString() {
        return "La configuration actuelle est 'Capitaliste'";
    }

}
