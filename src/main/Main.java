package main;

import configuration.ConfigurationManager;
import investissement.InvestissementsManager;
import plateau.Plateau;

public class Main {

    public static InvestissementsManager IM;
    public static Plateau PLATEAU;
    public static ConfigurationManager CONFIG;

    public static void main(String[] args){

        createInstances();
        CONFIG.defineConfiguration();
        IM.createInvestissements();
        PLATEAU.generatePlateau();

        System.out.println("Un plateau de " + PLATEAU.getNBCASES() + " case(s) a été généré.");

    }

    public static void createInstances(){
        IM = new InvestissementsManager();
        PLATEAU = new Plateau(40, IM);
        CONFIG = new ConfigurationManager();
    }

}