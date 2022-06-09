package acteurs;

import exceptions.AntitrustException;
import exceptions.NePeutPasPayerException;
import exceptions.PasAssezDeLiquideException;
import investissement.Investissement;

public interface StyleJoueur {
    public void actionInvestissement(Investissement investissement) throws PasAssezDeLiquideException, NePeutPasPayerException, AntitrustException;
    public void actionAntitrust();
}