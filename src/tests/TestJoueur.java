package tests;

import acteurs.Acteur;
import acteurs.Joueur;
import acteurs.JoueurAgressif;
import exceptions.NePeutPasPayerException;
import exceptions.PasAssezDeLiquideException;
import investissement.Investissement;
import investissement.InvestissementsManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import plateau.cases.Repos;
import plateau.Plateau;
import static plateau.Plateau.ETAT;

public class TestJoueur {

    Joueur joueur;

    @Before
    public void setUp(){
        joueur = new JoueurAgressif(5000, "Clément", new Repos(0));
    }

    @Test
    public void testAcheter() throws PasAssezDeLiquideException {
        Investissement i = new Investissement("Tour Eiffel", 1000, 0.5F, ETAT);
        joueur.acheter(i);
        Assert.assertEquals(4000, joueur.getLiquide(), 0);
        Assert.assertEquals(0, ETAT.getInvestissements().size(), 0);
    }

    @Test(expected = PasAssezDeLiquideException.class)
    public void testAcheter2() throws PasAssezDeLiquideException{
        Investissement i = new Investissement("Tour Eiffel", 10000, 0.5F, ETAT);
        joueur.acheter(i);
    }

    @Test
    public void testVendre() throws PasAssezDeLiquideException{
        Investissement i1 = new Investissement("Tour Eiffel", 1000, 0.5F, ETAT);
        Investissement i2 = new Investissement("Tour Eiffel", 1000, 0.5F, ETAT);
        Investissement i3 = new Investissement("Tour Eiffel", 1000, 0.5F, ETAT);

        joueur.acheter(i1);
        joueur.acheter(i2);
        joueur.acheter(i3);

        joueur.vendre(i1);
        Assert.assertEquals(2, joueur.getInvestissements().size(), 0);
        Assert.assertEquals(3000, joueur.getLiquide(), 0);
        Assert.assertEquals(1, ETAT.getInvestissements().size(), 0);
    }

    @Test
    public void testPayerBFP() throws PasAssezDeLiquideException, NePeutPasPayerException {
        Investissement i = new Investissement("Tour Eiffel", 1000, 0.5F, ETAT);

        joueur.acheter(i);
        joueur.payerBFP(true, 50);

        Assert.assertEquals(3500, joueur.getLiquide(), 0);
    }

    @Test(expected = PasAssezDeLiquideException.class)
    public void testPayerBFP2() throws PasAssezDeLiquideException, NePeutPasPayerException {
        Investissement i = new Investissement("Tour Eiffel", 4900, 0.5F, ETAT);

        joueur.acheter(i);
        joueur.payerBFP(true, 50);
    }

    @Test
    public void testPayerBFP3() throws PasAssezDeLiquideException, NePeutPasPayerException {
        Investissement i = new Investissement("Tour Eiffel", 1000, 0.5F, ETAT);

        joueur.acheter(i);
        joueur.payerBFP(false, 50);

        Assert.assertEquals(1500, joueur.getLiquide(), 0);
    }

    @Test(expected = PasAssezDeLiquideException.class)
    public void testPayerBFP4() throws PasAssezDeLiquideException, NePeutPasPayerException {
        Investissement i = new Investissement("Tour Eiffel", 4900, 0.5F, ETAT);

        joueur.acheter(i);
        joueur.payerBFP(false, 50);
    }

    @Test
    public void testRecevoirSubvention(){
        joueur.recevoirSubvention(1000);
        Assert.assertEquals(6000, joueur.getLiquide(), 0);
    }

    @Test
    public void testPayer() throws PasAssezDeLiquideException, NePeutPasPayerException{
        Investissement i = new Investissement("Tour Eiffel", 1000, 0.5F, ETAT);
        Joueur j2 = new JoueurAgressif(5000, "Wesley", new Repos(0));

        joueur.payer(j2, i);
        Assert.assertEquals(4500, joueur.getLiquide(), 0);
        Assert.assertEquals(5500, j2.getLiquide(), 0);
    }

    @Test(expected = PasAssezDeLiquideException.class)
    public void testPayer2() throws PasAssezDeLiquideException, NePeutPasPayerException{
        Investissement i = new Investissement("Tour Eiffel", 6000, 1, ETAT);
        Joueur j2 = new JoueurAgressif(5000, "Wesley", new Repos(0));

        joueur.payer(j2, i);
    }
}
