package tp11.state;

import tp11.Commande;

/**
 * State representing a newly created order.
 */
public class CommandeNouvelle implements CommandeState {
    @Override
    public void next(Commande commande) {
        commande.setStatus("En cours");
        commande.setCurrentState(new CommandeEnCours());
    }
}