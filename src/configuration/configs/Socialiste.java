package configuration.configs;

import acteurs.Joueur;
import acteurs.JoueurAgressif;
import acteurs.JoueurPrudent;
import configuration.Configuration;

import java.util.Random;
import java.util.Scanner;

import static main.Main.PLATEAU;
import static main.Main.players;

public class Socialiste extends Configuration {

    public Socialiste(boolean foncier){
        setPourcentageTaxes(45);
        setLimiteAntiTrust(6);
        setSubventions(900);
        setFoncier(foncier);
    }

    public void setJoueurs(){
        super.setJoueurs();
    }

    @Override
    public String toString() {
        return "La configuration actuelle est 'Socialiste'";
    }
}
