package tp11.strategy;

import tp11.Commande;
import tp11.dto.LivreDTO;

import java.util.List;

/*****
 * Stratégie correspondant au mode d'expédition : Colissimo
 */
public class FraisPortColissimoStrategy implements FraisPortStrategy {
    // TODO à vous de déterminer s'il y a besoin d'attributs

    public FraisPortColissimoStrategy(Commande contexte) {
        // TODO
    }

    /***
     * Regles de calcul :
     * - si le poids total de la commande est inférieur ou égal à 1kg, fdp = 3€
     * - si le poids total de la commande est compris entre 1kg et 3kg, fdp = 5€
     * - au delà de 3kg, fdp = 15€
     */
    @Override
    public double calculerFraisPort() {
        // TODO Calcul basé sur le poids des livres
        return 0 ;
    }
}
