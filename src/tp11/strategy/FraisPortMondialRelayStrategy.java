package tp11.strategy;

import tp11.Commande;
import tp11.dto.LivreDTO;

import java.util.List;

/*****
 * Stratégie correspondant au mode d'expédition : Mondial Relay
 */
public class FraisPortMondialRelayStrategy implements FraisPortStrategy {
    // TODO à vous de déterminer s'il y a besoin d'attributs

    public FraisPortMondialRelayStrategy(Commande contexte) {
        // TODO
    }

    /***
     * Regles de calcul :
     * - si le poids total de la commande est inférieur ou égal à 3kg, fdp = 4€
     * - au delà de 3kg, fdp = 8€
     */
    @Override
    public double calculerFraisPort() {
        // TODO Calcul basé sur le poids des livres
        return 0 ;
    }
}
