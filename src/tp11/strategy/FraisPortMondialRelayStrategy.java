package tp11.strategy;

import tp11.Commande;
import tp11.dto.LivreDTO;

import java.util.List;

/**
 * Shipping strategy for Mondial Relay.
 */
public class FraisPortMondialRelayStrategy implements FraisPortStrategy {
    private final Commande contexte;

    public FraisPortMondialRelayStrategy(Commande contexte) {
        this.contexte = contexte;
    }

    @Override
    public double calculerFraisPort() {
        List<LivreDTO> livres = contexte.toDTO().getLivres();
        double totalWeight = 0.0;

        if (livres != null) {
            for (LivreDTO livre : livres) {
                totalWeight += livre.getPoids();
            }
        }

        if (totalWeight <= 3.0) {
            return 4.0;
        }
        return 8.0;
    }
}