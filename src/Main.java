import configuration.ConfigurationManager;
import investissement.InvestissementsManager;
import plateau.Plateau;

public  class Main {

    private static InvestissementsManager im;
    private static Plateau plateau;
    private static ConfigurationManager config;

    public static void main(String[] args){

        createInstances();
        config.defineConfiguration();
        im.createInvestissements();
        plateau.generatePlateau();

        System.out.println(plateau.toString());

    }

    public static void createInstances(){
        im = new InvestissementsManager();
        plateau = new Plateau(40, im);
        config = new ConfigurationManager();
    }

}