package tp11.strategy;

import tp11.Commande;
import tp11.Livre;

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
        List<Livre> livres = contexte.getLoadedLivres();
        if (livres.isEmpty() && contexte.hasLivreIds()) {
            throw new IllegalStateException("Books must be loaded before shipping fee calculation");
        }

        double totalWeight = 0.0;

        for (Livre livre : livres) {
            totalWeight += livre.getPoids();
        }

        if (totalWeight <= 3.0) {
            return 4.0;
        }
        return 8.0;
    }
}