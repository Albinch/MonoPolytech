import investissement.InvestissementsManager;
import plateau.Plateau;

public  class Main {

    private static InvestissementsManager im;
    private static Plateau plateau;

    public static void main(String[] args){

        createInstances();


        System.out.println("Hello");

    }

    public static void createInstances(){
        im = new InvestissementsManager();
        plateau = new Plateau(40);
    }

}