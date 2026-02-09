package tp11.strategy;

import tp11.Commande;
import tp11.Livre;

import java.util.List;

/**
 * Shipping strategy for Colissimo.
 */
public class FraisPortColissimoStrategy implements FraisPortStrategy {
    private final Commande contexte;

    public FraisPortColissimoStrategy(Commande contexte) {
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

        if (totalWeight <= 1.0) {
            return 3.0;
        }
        if (totalWeight <= 3.0) {
            return 5.0;
        }
        return 15.0;
    }
}