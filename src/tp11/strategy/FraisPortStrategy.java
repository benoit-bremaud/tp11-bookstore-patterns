package tp11.strategy;

/********************************************
 * L'utilisateur peut choisir plusieurs modes de livraison, ici représentées par des stratégies.
 * On vous demandera d'en implémenter deux :
 * - Colissimo
 * - Mondial Relay
 * Le but de chaque stratégie est de calculer les frais de port de la commande en fonction de son poids.
 * Le détail du calcul est fourni dans chaque classe d'implémentation
 */
public interface FraisPortStrategy {
    double calculerFraisPort();
}

