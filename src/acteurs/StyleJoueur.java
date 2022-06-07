package acteurs;

import exceptions.NePeutPasPayerException;
import exceptions.PasAssezDeLiquideException;
import investissement.Investissement;

public interface StyleJoueur {
    public void actionInvestissement(Investissement investissement) throws PasAssezDeLiquideException, NePeutPasPayerException;
    public void actionAntitrust();
}