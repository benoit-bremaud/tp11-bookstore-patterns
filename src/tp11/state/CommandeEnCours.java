package tp11.state;

import tp11.Commande;

/**
 * State representing an order in progress.
 */
public class CommandeEnCours implements CommandeState {
    @Override
    public void next(Commande commande) {
        commande.setStatus("Expédiée");
        commande.setCurrentState(new CommandeExpediee());
    }
}