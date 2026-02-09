package tp11.state;

import tp11.Commande;

/**
 * Common contract for all order states.
 */
public interface CommandeState {
    void next(Commande commande);
}