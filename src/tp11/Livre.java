package tp11;

import tp11.dto.Entity;
import tp11.dto.LivreDTO;

/******************************************************************
 * Il s'agit d'une entité (voir pattern DTO), autrement dit
 * un objet complexe embarquant de la logique métier.
 * Cet objet propose une méthode toDTO() qui fournira la version légère
 * de cet objet, afin de faciliter les communications.
 *********************************************************************/
public class Livre implements Entity {
    // Liste des attributs : interdiction d'en ajouter/retirer
    private int id;
    private String titre;
    private String auteur;
    private double poids ;

    // TODO à vous d'écrire les getters/setters, le(s) constructeur(s) et tout ce dont vous aurez besoin

    public LivreDTO toDTO() {
        // TODO à écrire
        return null ;
    }
}
