package configuration;

import acteurs.Joueur;
import acteurs.JoueurAgressif;
import acteurs.JoueurPrudent;

import java.util.Scanner;

import static main.Main.PLATEAU;
import static main.Main.players;

public abstract class Configuration {

    float pourcentageTaxes;
    int limiteAntiTrust;
    float subventions;
    boolean foncier;

    private int startCapital = 50000;

    private float profitPercentage = 1;

    public boolean isFoncier() {
        return foncier;
    }

    public void setFoncier(boolean foncier) {
        this.foncier = foncier;
    }

    public float getPourcentageTaxes() {
        return pourcentageTaxes;
    }

    public void setPourcentageTaxes(float pourcentageTaxes) {
        this.pourcentageTaxes = pourcentageTaxes;
    }

    public int getLimiteAntiTrust() {
        return limiteAntiTrust;
    }

    public void setLimiteAntiTrust(int limiteAntiTrust) {
        this.limiteAntiTrust = limiteAntiTrust;
    }

    public float getSubventions() {
        return subventions;
    }

    public void setSubventions(float subventions) {
        this.subventions = subventions;
    }

    public float getProfitPercentage(){
        return this.profitPercentage;
    }

    public void setProfitPercentage(float percentage){
        this.profitPercentage = percentage;
    }

    public int getStartCapital(){
        return this.startCapital;
    }



    public void setJoueurs(){
        int startCapital = this.startCapital;
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


    public abstract String toString();

}
