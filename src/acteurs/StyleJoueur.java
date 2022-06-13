package acteurs;

import exceptions.AntitrustException;
import exceptions.JeuException;
import exceptions.NePeutPasPayerException;
import exceptions.PasAssezDeLiquideException;
import investissement.Investissement;

public interface StyleJoueur {
    public void actionInvestissement(Investissement investissement) throws JeuException;
    public void actionAntitrust();
}