package configuration;

import configuration.configs.*;

import java.util.Random;
import java.util.Scanner;

public class ConfigurationManager {

    Configuration currentConfig;

    public ConfigurationManager(){

    }

    public void defineConfiguration(){

        int config;

        System.out.println("Avant de commencer à jouer, vous devez choisir une configuration parmis les suivantes : ");
        System.out.println("1 - Capitaliste");
        System.out.println("2 - Europe (Configurable)");
        System.out.println("3 - Néo Libéral");
        System.out.println("4 - Progressiste");
        System.out.println("5 - Socialiste");

        Scanner sc = new Scanner(System.in);
        config = sc.nextInt();
        boolean foncier = ((new Random().nextInt(2)) == 1) ? true : false;

        if(config < 1 || config > 5){
            System.out.println("Cette configuration n'existe pas.");
            defineConfiguration();
            return;
        }

        switch(config){
            case 1:
                this.currentConfig = new Capitaliste(foncier);
                break;
            case 2:
                System.out.println("Quel pourcentage de taxes souhaitez-vous appliquer ? (0-100)");
                float pourcentageTaxes = sc.nextFloat();
                System.out.println("Quelle limite antitrust souhaitez-vous fixer ? (0-50)");
                int limiteAntitrust = sc.nextInt();
                System.out.println("Quel sera le montant des subventions ? (0-10000)");
                float subventions = sc.nextFloat();

                this.currentConfig = new Europe(pourcentageTaxes, limiteAntitrust, subventions, foncier);

                break;
            case 3:
                this.currentConfig = new NeoLiberal(foncier);
                break;
            case 4:
                this.currentConfig = new Progressiste(foncier);
                break;
            case 5:
                this.currentConfig = new Socialiste(foncier);
                break;
            default:
                break;
        }

        System.out.println(this.getCurrentConfig().toString());

    }

    public Configuration getCurrentConfig(){
        return this.currentConfig;
    }

}
