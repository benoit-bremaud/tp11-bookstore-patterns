package tp11.state;

import tp11.Commande;

/**
 * State representing a shipped order.
 */
public class CommandeExpediee implements CommandeState {
    @Override
    public void next(Commande commande) {
        commande.setStatus("Livrée");
        commande.setCurrentState(null);
    }
}