package tp11.state;

import tp11.Commande;

/******************************************
 * Interface commune à tous les états
 * Un état ici se contente de modifier
 * sa commande (son contexte)
 * en modifiant le currentState de celle-ci
 * en plaçant une instance du nouvel état
 * et en modifiant son status
 */
public interface CommandeState {
    void next(Commande commande);
}